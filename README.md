# Android

## Getting Started

### Major libraries

- Kotlin
- Android Architecture Components (ViewModel, LiveData, Room)
- Dagger2
- Retrofit
- RxJava
- Moshi and Kotshi
- Glide

### Naming rules

#### XMLs
http://standards.mediarain.com/android/java

<a href="https://jeroenmols.com/blog/2016/03/07/resourcenaming/">
<img src="https://jeroenmols.com/img/blog/resourcenaming/resourcenaming_cheatsheet.png" width="65%">
</a>

#### Colors

Examples.. 
```xml
<color name="white">#FFFFFF</color>
<color name="white_20">#33FFFFFF</color>
<color name="black_50">#80000000</color>
<color name="matterhorn">#555555</color>
<color name="neon_blue">#6447FF</color>
```
http://www.htmlcsscolor.com/

## Update gem's versions for Danger

```
$ brew update
$ brew install rbenv ruby-build
$ rbenv install -l
$ rbenv install {targetVerion}
$ rbenv global {targetVersion}
$ rbenv exec gem install bundler
$ rbenv exec bundle update
```

