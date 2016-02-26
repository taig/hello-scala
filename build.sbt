androidBuild

fork in Test := true

// Enforce Java 7 compilation (in case you have the JDK 8 installed)
javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "appcompat-v7" % "23.2.0" ::
    "com.android.support" % "cardview-v7" % "23.2.0" ::
    "com.android.support" % "design" % "23.2.0" ::
    "com.android.support" % "gridlayout-v7" % "23.2.0" ::
    "com.android.support" % "recyclerview-v7" % "23.2.0" ::
    "com.android.support" % "support-v4" % "23.2.0" ::
    // Version 2.4.x requires Java 8
    "com.typesafe.play" %% "play-json" % "2.3.10" ::
    "com.geteit" %% "robotest" % "0.12" % "test" ::
    "org.scalatest" %% "scalatest" % "2.2.5" % "test" ::
    Nil

name := "HelloScala"

// Predefined as IceCreamSandwich (4.0), nothing stops you from going below
minSdkVersion := "14"

// Prevent common com.android.builder.packaging.DuplicateFileException.
// Add further file names if you experience the exception after adding new dependencies
packagingOptions := PackagingOptions(
    excludes =
        "META-INF/LICENSE" ::
        "META-INF/LICENSE.txt" ::
        "META-INF/NOTICE" ::
        "META-INF/NOTICE.txt" ::
        Nil
)

platformTarget := "android-23"

proguardCache ++=
    "android.support" ::
    "play" ::
    Nil

proguardOptions ++=
    "-keepattributes EnclosingMethod,InnerClasses,Signature" ::
    "-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry" ::
    "-dontwarn javax.xml.bind.DatatypeConverter" ::
    "-dontnote org.joda.time.DateTimeZone" ::
    "-dontnote scala.concurrent.stm.impl.STMImpl$" ::
    Nil

// Shortcut: allows you to execute "sbt run" instead of "sbt android:run"
run <<= run in Android

scalacOptions ++=
    // Print detailed deprecation warnings to the console
    "-deprecation" ::
    // Print detailed feature warnings to the console
    "-feature" ::
    Nil

// Don't upgrade to 2.12.x as it requires Java 8 which does not work with Android (but this might
// be resolvable with "retrolamda")
scalaVersion := "2.11.7"

targetSdkVersion := "23"

versionCode := Some( 0 )

versionName := Some( "0.0.0" )