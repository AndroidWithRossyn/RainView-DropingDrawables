package com.banrossyn.hbl.rainview.customview



import android.content.Context
import android.graphics.Bitmap
import android.graphics.Point
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.banrossyn.hbl.rainview.R

import java.util.Random

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.subscriptions.CompositeSubscription;

import java.util.concurrent.TimeUnit

class EmojiRainLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        var EMOJI_STANDARD_SIZE: Int = 0
        const val RELATIVE_DROP_DURATION_OFFSET = 0.25F
        const val DEFAULT_PER = 6
        const val DEFAULT_DURATION = 8000
        const val DEFAULT_DROP_DURATION = 2400
        const val DEFAULT_DROP_FREQUENCY = 500
    }

    private lateinit var mSubscriptions: CompositeSubscription
    private var mWindowHeight: Int = 0
    private var mEmojiPer: Int = DEFAULT_PER
    private var mDuration: Int = DEFAULT_DURATION
    private var mDropAverageDuration: Int = DEFAULT_DROP_DURATION
    private var mDropFrequency: Int = DEFAULT_DROP_FREQUENCY
    private lateinit var mEmojis: MutableList<Drawable>
    private lateinit var mEmojiPool: androidx.core.util.Pools.SynchronizedPool<ImageView>

    init {
        EMOJI_STANDARD_SIZE = dip2px(36f)
        if (!isInEditMode) init(context, attrs)
    }

    var per: Int
        get() = mEmojiPer
        set(value) { mEmojiPer = value }

    var duration: Int
        get() = mDuration
        set(value) { mDuration = value }

    var dropDuration: Int
        get() = mDropAverageDuration
        set(value) { mDropAverageDuration = value }

    var dropFrequency: Int
        get() = mDropFrequency
        set(value) { mDropFrequency = value }

    fun addEmoji(emoji: Bitmap) {
        mEmojis.add(BitmapDrawable(resources, emoji))
    }

    fun addEmoji(emoji: Drawable) {
        mEmojis.add(emoji)
    }

    fun addEmoji(@DrawableRes resId: Int) {
        mEmojis.add(ContextCompat.getDrawable(context, resId)!!)
    }

    fun clearEmojis() {
        mEmojis.clear()
    }

    fun stopDropping() {
        mSubscriptions.clear()
    }

    fun startDropping() {
        initEmojisPool()

        Randoms.setSeed(7)
        mWindowHeight = getWindowHeight()
        val subscription = Observable.interval(mDropFrequency.toLong(), TimeUnit.MILLISECONDS)
            .take((mDuration / mDropFrequency).toInt())
            .flatMap { Observable.range(0, mEmojiPer) }
            .map { mEmojiPool.acquire() }
            .filter { it != null }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { emoji -> startDropAnimationForSingleEmoji(emoji!!) },
                { it.printStackTrace() }
            )
        mSubscriptions.add(subscription)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        val ta = context.obtainStyledAttributes(attrs, R.styleable.EmojiRainLayout)

        mSubscriptions = CompositeSubscription()
        mEmojis = mutableListOf()
        mEmojiPer = ta.getInteger(R.styleable.EmojiRainLayout_per, DEFAULT_PER)
        mDuration = ta.getInteger(R.styleable.EmojiRainLayout_duration, DEFAULT_DURATION)
        mDropAverageDuration = ta.getInteger(R.styleable.EmojiRainLayout_dropDuration, DEFAULT_DROP_DURATION)
        mDropFrequency = ta.getInteger(R.styleable.EmojiRainLayout_dropFrequency, DEFAULT_DROP_FREQUENCY)

        ta.recycle()
    }

    private fun startDropAnimationForSingleEmoji(emoji: ImageView) {
        val translateAnimation = TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, Randoms.floatAround(0f, 5f),
            Animation.RELATIVE_TO_PARENT, 0f,
            Animation.ABSOLUTE, mWindowHeight.toFloat()
        )
        translateAnimation.duration = (mDropAverageDuration * Randoms.floatAround(1f, RELATIVE_DROP_DURATION_OFFSET)).toLong()
        translateAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}
            override fun onAnimationEnd(animation: Animation) {
                mEmojiPool.release(emoji)
            }
            override fun onAnimationRepeat(animation: Animation) {}
        })
        emoji.startAnimation(translateAnimation)
    }

    private fun getWindowHeight(): Int {
        val windowManager = context.applicationContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val point = Point()
        windowManager.defaultDisplay.getSize(point)
        return point.y
    }

    private fun initEmojisPool() {
        val emojiTypeCount = mEmojis.size
        require(emojiTypeCount > 0) { "There are no emojis" }

        clearDirtyEmojisInPool()
        val expectedMaxEmojiCountInScreen = ((1 + RELATIVE_DROP_DURATION_OFFSET) *
                mEmojiPer *
                mDropAverageDuration /
                mDropFrequency.toFloat()).toInt()
        mEmojiPool = androidx.core.util.Pools.SynchronizedPool(expectedMaxEmojiCountInScreen)
        for (i in 0 until expectedMaxEmojiCountInScreen) {
            val emoji = generateEmoji(mEmojis[i % emojiTypeCount])
            addView(emoji)
            mEmojiPool.release(emoji)
        }
    }

    private fun generateEmoji(emojiDrawable: Drawable): ImageView {
        val emoji = ImageView(context)
        emoji.setImageDrawable(emojiDrawable)
        val width = (EMOJI_STANDARD_SIZE * (1.0 + Randoms.positiveGaussian())).toInt()
        val height = (EMOJI_STANDARD_SIZE * (1.0 + Randoms.positiveGaussian())).toInt()
        val params = LayoutParams(width, height)
        params.startToStart = LayoutParams.PARENT_ID
        params.endToEnd = LayoutParams.PARENT_ID
        params.topToTop = LayoutParams.PARENT_ID
        params.horizontalBias = Randoms.floatStandard()
        params.topMargin = -height
        emoji.layoutParams = params
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            emoji.elevation = 100f
        }
        return emoji
    }

    private fun clearDirtyEmojisInPool() {
        if (::mEmojiPool.isInitialized) {
            var dirtyEmoji: ImageView?
            while (mEmojiPool.acquire().also { dirtyEmoji = it } != null) {
                removeView(dirtyEmoji)
            }
        }
    }

    private fun dip2px(dp: Float): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            context.resources.displayMetrics
        ).toInt()
    }
}


object Randoms {
    private val random : Random = Random()

    fun setSeed(seed : Long) {
        random.setSeed(seed)
    }

    fun floatStandard() : Float {
        return random.nextFloat()
    }

    fun floatAround(mean : Float, delta : Float) : Float {
        return floatInRange(mean - delta, mean + delta)
    }

    fun floatInRange(left : Float, right : Float) : Float {
        return left + (right - left)*random.nextFloat()
    }

    fun positiveGaussian() : Double {
        return Math.abs(random.nextGaussian())
    }
}