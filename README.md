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




Elevate your Android app to the next level with our state-of-the-art solutions! Contact us today and let’s create something extraordinary!

<div align="start">
  
<a href="mailto:banrossyn@gmail.com"><img src="https://img.shields.io/badge/Gmail-EA4335.svg?logo=Gmail&logoColor=white"></a>
[![Instagram](https://img.shields.io/badge/Instagram-%23E4405F.svg?logo=Instagram&logoColor=white)](https://instagram.com/rohitraj.khorwal) [![LinkedIn](https://img.shields.io/badge/LinkedIn-%230077B5.svg?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/rohitrajkhorwal/) [![Medium](https://img.shields.io/badge/Medium-12100E?logo=medium&logoColor=white)](https://medium.com/@rohitrajkhorwal) 
<a href="https://t.me/banrossyn" target="_blank"><img src="https://img.shields.io/badge/Telegram-26A5E4.svg?logo=Telegram&logoColor=white"></a>
<a href="https://wa.me/+919694260426/" target="_blank"><img src="https://img.shields.io/badge/WhatsApp-25D366.svg?logo=WhatsApp&logoColor=white">
</div>


---

`Note:` Please review our [Code of Conduct](./CODE_OF_CONDUCT.md) before using this project.
# Find this Repository useful? ❤️

Support it by joining stargazers for this repository. ⭐

Also, [follow me on GitHub](https://github.com/AndroidWithRossyn/) for my next creations! 🤩

<p align="left">
<a href="https://github.com/AndroidWithRossyn?tab=repositories&sort=stargazers"><img alt="All Repositories" title="All Repositories" src="https://custom-icon-badges.demolab.com/badge/-Click%20Here%20For%20All%20My%20Repos-1F222E?style=for-the-badge&logoColor=white&logo=repo"/></a>
  
</p>


## ☕ Fuel My Code

<div align="center">
  <a href="https://www.paypal.com/paypalme/banrossyn">
    <img src="https://img.shields.io/badge/Support_My_Work-00457C?style=for-the-badge&logo=paypal&logoColor=white" alt="PayPal"/>
  </a>
   <a href="https://github.com/AndroidWithRossyn/AndroidWithRossyn/blob/main/donate/upi_scan.jpg?raw=true">
    <img src="https://img.shields.io/badge/Support_via_UPI-4CAF50?style=for-the-badge&logo=google-pay&logoColor=white" alt="UPI"/>
  </a>
  <p><i>Your support transforms caffeine into code! ✨</i></p>
  
  <table>
    <tr>
      <td>🚀 Faster Updates</td>
      <td>🔍 Better Documentation</td>
      <td>🛠️ More Features</td>
    </tr>
  </table>
  
  <details>
    <summary><b>Why Support?</b></summary>
    <p>Every contribution helps me dedicate more time to creating high-quality open source Code. Your support directly translates to better software for everyone!</p>
  </details>
</div>



## License

```
Copyright: 
~ Rossyn
~ Rohitraj Khorwal

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
  <img src="https://capsule-render.vercel.app/api?type=waving&color=gradient&height=60&section=footer"/>
</p>








