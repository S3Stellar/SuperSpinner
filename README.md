# SuperSpinner
<p>Your cool loading spinner, customize it with your icon !</b></p>
	
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/S3Stellar/SuperSpinner/blob/master/LICENSE) &nbsp;&nbsp;&nbsp;&nbsp;
![JitPack](https://img.shields.io/jitpack/v/github/S3Stellar/SuperSpinner)

<div>
  <p align="center">Built with ❤︎ by
	  <a href="https://github.com/S3Stellar">Naor Farag</a></p>
</div>


## 💻 Installation
Add this in your app's build.gradle file (Project & module):
```gradle
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
	
	
dependencies {
	implementation 'com.github.S3Stellar:SuperSpinner:0.1.1'
}
```
## ❔ Usage
**Basic Usage**
</br>
Minimum SDk version required:23

Easily drop this in your activity's xml to start using the loading spinner!

``` 
 	<com.example.myspinninglib.SuperSpinner
        android:id="@+id/progressBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

```
Simple usage of show the loading spinner with quote every button click (for 3s)
```java
	List<String> quotesList;
	    SuperSpinner superSpinner;

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnTap = findViewById(R.id.button);

		quotesList = new ArrayList<>();
		quotesList.add("Hi");
		quotesList.add("Happy New Year");
		quotesList.add("Hope you have a good day");
		quotesList.add("Merry Christmas");

		superSpinner = findViewById(R.id.progressBar);
		superSpinner.setIcon(R.drawable.myafekaicon);
		superSpinner.setLoadingQuotes(quotesList);

		btnTap.setOnClickListener(v -> {
		    superSpinner.showSpin();
		    new Handler(Looper.myLooper()).postDelayed(
			    () -> superSpinner.stopSpin(), 3000);
		});
	    }
```


## 🎨 Customization and Attributes

You can programatically customize the progress bar using the following methods:
<table>
    <th>Method Name</th>
    <th>Description</th>
    <th>Usage</th>
		<tr>
			<td>setIcon(int r)</td>
			<td>Let you set your own icon as the spinning logo.</td>
			<td>superSpinner.setIcon(R.drawable.myicon);</td>
		</tr>
		<tr>
			<td>setIcon(Drawable d)</td>
			<td>Let you set your own icon as the spinning logo.</td>
			<td>superSpinner.setIcon(ContextCompat.getDrawable(context, R.drawable.myicon));</td>
		</tr>
		<tr>
			<td>setSpinDegree(int d)</td>
			<td>Let you see the rotation degree your icon will make (rather use 360*N nums)</td>
			<td>superSpinner.setSpinDegree(1080);</td>
		</tr>
		<tr>
			<td>setLoadingText(String s)</td>
			<td>Let you set text under the super spinner</td>
			<td>superSpinner.setLoadingText("Loading . .  .");</td>
		</tr>
		<tr>
			<td>setLoadingQuotes(ArrayList<String> ql)</td>
			<td>Let you pass list of quotes to show randomly under the spinner</td>
			<td>superSpinner.setLoadingQuotes(quotesList);</td>
		</tr>
		<tr>
			<td>showSpin()</td>
			<td>Shows your super spinner.</td>
			<td>superSpinner.show();</td>
		</tr>
		<tr>
			<td>stopSpin()</td>
			<td>Hides your super spinner.</td>
			<td>superSpinner.stop();</td>
		</tr>
	</table>
	
# 📃 License

    Copyright 2020 Naor Farag

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

### If you like the library, please click on the ★ Star button at the top 😊
