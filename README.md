<h2 align="center">RainLayout Kotlin</h2>

Give a surprise to your users on Christmas Day by dropping emojis!

<p align="center">
    <a href="">
      <img src="https://github.com/user-attachments/assets/74d5e315-d5f0-4e16-8c37-2da525e73fc6" width="1000" />
    </a>
  </p>
  

--- 
How to use the RainLayout:

RainLayout is a custom Android view that creates a delightful emoji rain effect on your screen.

Add EmojiRainLayout to your layout XML:
```xml
<com.youpackage.EmojiRainLayout
    android:id="@+id/emojiRainLayout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

In your Activity or Fragment:

```kotlin
val emojiRainLayout: EmojiRainLayout = findViewById(R.id.emojiRainLayout)

// Add emojis
emojiRainLayout.addEmoji(R.drawable.emoji_heart)
emojiRainLayout.addEmoji(R.drawable.emoji_smile)

// Customize (optional)
emojiRainLayout.per = 10 // Number of emojis per drop
emojiRainLayout.duration = 5000 // Total duration in milliseconds
emojiRainLayout.dropDuration = 2000 // Duration of each emoji's fall
emojiRainLayout.dropFrequency = 300 // Time between emoji drops

// Start the rain
emojiRainLayout.startDropping()

// Stop the rain (when needed)
emojiRainLayout.stopDropping()
```

### Customization

- `per`: Number of drawable per drop cycle
- `duration`: Total duration of the rain effect
- `dropDuration`: Duration of each drawable's falling animation
- `dropFrequency`: Time interval between drawable drops

Enjoy the rain Effact in your app! 🎉

#### Config

- per
    - How many emojis will dropping in each flow, default 6
- duration
    - The total duration of the animation, default 8000ms
- dropDuration
    - The average dropping duration for a specific emoji, default 2400ms
- dropFrequency
    - The interval between two flows, default 500ms

Config in layout. `EmojiRainLayout` inherits from `ConstraintLayout`. 


---- 



### Find this Repository useful? ❤️
Support it by joining stargazers for this repository. ⭐

Also, [follow me on GitHub](https://github.com/AndroidWithRossyn/) for my next creations! 🤩


### License
```
Copyright 2024 Rossyn

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```


<p align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=60&width=1980&section=footer"/>
</p>





