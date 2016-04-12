# Install JDK #

Oracle의 JDK또는 openjdk를 설치한다. 다음 3가지 방법 중 하나 만을 선택한다.

**install java to 32bit ubuntu machine (추천)**

  1. http://www.oracle.com/technetwork/java/javase/downloads/index.html에서 jdk-7u25-linux-i586.tar.gz를 다운받는다.
    * [link](http://163.152.113.76/jdk-7u25-linux-i586.tar.gz)
  1. tar -zxvf jdk-7u25-linux-i586.tar.gz
  1. sudo mv jdk1.7.0\_25/ /usr/local
  1. symbolic link를 생성한다.
```
sudo ln -s /usr/local/jdk1.7.0_25/bin/java /usr/bin/java
sudo ln -s /usr/local/jdk1.7.0_25/bin/javac /usr/bin/javac
```

**install java to 64bit fedora machine**

  1. /usr/bin/java, /usr/bin/javac를 제거한다.
```
rm /usr/bin/java
rm /usr/bin/javac
```
  1. http://www.oracle.com/technetwork/java/javase/downloads/index.html에서 jdk-7u25-linux-x64.rpm를 다운받는다.
  1. 다운받은 rpm을 설치한다. (마우스 우클릭)
  1. /usr/bin에 java와 javac파일이 생성되었는지 확인한다
```
ls -al /usr/bin/java*
```
  1. java와 javac파일이 생성되지 않았다면 다음명령어를 통해 symbolic link를 생성한다.
```
ln -s /usr/java/default/bin/java /usr/bin/java
ln -s /usr/java/default/bin/javac /usr/bin/javac
```

**install openjdk**

  1. sudo apt-get install openjdk-6-jdk

# Install ADT Bundle #

  1. http://developer.android.com/sdk/index.html에서 ADT Bundle for linux (32bit or 64bit)를 다운로드 받는다.
    * [link](http://163.152.113.76/adt-bundle-linux-x86-20130729.zip)
  1. extract eclipse

# Install Android SDK and create AVD #

  1. run eclipse
  1. download android
    1. click Android SDK Manager
    1. check SDK Platform and ARM EABIv7a System Image of Android 4.1.6 (API16)
    1. click Install packages
  1. restart
  1. create android virtual device
    1. click Android Virtual Device Manager
    1. click New and fill blank entry
      1. target: Android 4.1.2 - API level 16
  1. start avd

# 한글설정 #

  * Ubuntu에서 한글을 쓰려면
    1. [nabi설정](http://leechwin.tistory.com/38)
  * AVD에서 한글을 쓰려면
    1. AVD option에서 hardware keyword 체크제거
    1. [구글키보드](http://ws.withcat.net/gifted/20130831/google_0.82.zip) 다운로드
    1. 압축해제
    1. adt-bundle-linux-x86-???/sdk/platform-tools/adb install google\_0.82.apk
    1. AVD에 들아가서 설치된 한글 키보드를 사용하기로 설정 변경