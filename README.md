# MultiProgressBar
<p>A progress bar library for Android that provides <b>customized progress bars.</b></p>
	
[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://github.com/S3Stellar/SuperSpinner/blob/master/LICENSE) &nbsp;&nbsp;&nbsp;&nbsp;
![JitPack](https://img.shields.io/jitpack/v/github/S3Stellar/SuperSpinner)

<div>
  <p align="center">Built with ❤︎ by
	  <a href="https://github.com/S3Stellar">Naor Farag</a></p>
</div>


## 💻 Installation
Add this in your app's build.gradle file (Project & module):
```groovy
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
	        implementation 'com.github.S3Stellar:SuperSpinner:Tag'
	}
```
## ❔ Usage
**Basic Usage**
</br>
Minimum SDk version required:23

Put the following at the bottom of your activity layout xml file. Probably inside a parent Relative Layout tag.

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
**Description**

<table>
    <th>Attribute Name</th>
    <th>Default Value</th>
    <th>Description</th>
	<tr>
		<td>app:barType </td>
		<td>bouncy_balls</td>
		<td>Defines the design of progress bar. All the available designs are mentioned below.</td>
	</tr>
		<tr>
		<td>app:text </td>
		<td>Please wait...</td>
		<td>The text you want to show below the progress bar.</td>
	</tr>
		<tr>
		<td> app:textSize </td>
		<td>16sp</td>
		<td>The size of text you want.</td>
	</tr>
		<tr>
		<td>app:enlarge </td>
		<td>2</td>
		<td>This can range from 1 to 10 and enalrges the size of the progress bar.</td>
	</tr>
		<tr>
		<td>app:androidtextColor </td>
		<td>BLACK</td>
		<td>This is the color of the text.</td>
	</tr>
	</table>
	


## 🎨 Customization and Attributes

You can programatically customize the progress bar using the following methods:
<table>
    <th>Method Name</th>
    <th>Description</th>
    <th>Usage</th>
		<tr>
			<td>setScaleType()</td>
			<td>To set the scale type of progress bar. Default is centerInside.</td>
			<td>myProgBar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);</td>
		</tr>
		<tr>
			<td>setProgressVector()</td>
			<td>To set the design of progress bar. All the available designs are mentioned above.</td>
			<td>myProgBar.setProgressVector(getDrawable(R.drawable.bouncy_balls));</td>
		</tr>
		<tr>
			<td>enlarge()</td>
			<td>This can range from 1 to 10 and enalrges the size of the progress bar.</td>
			<td>myProgBar.enlarge(4);</td>
		</tr>
		<tr>
			<td>setTextMsg()</td>
			<td>The text you want to show below the progress bar.</td>
			<td>myProgBar.setTextMsg("Loading");</td>
		</tr>
		<tr>
			<td>setTextColor()</td>
			<td>This sets the color of the text below the progress bar.</td>
			<td>myProgBar.setTextColor(getColor(R.color.colorPrimary));</td>
		</tr>
		<tr>
			<td>setTextSize()</td>
			<td>This sets the size of the text below the progress bar.</td>
			<td>myProgBar.setTextSize(24);</td>
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
