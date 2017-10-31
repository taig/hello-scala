enablePlugins( AndroidApp )

fork in Test := true

// Enforce Java 7 compilation (in case you have the JDK 8 installed)
javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "io.taig" %% "communicator" % "3.3.0-RC2" ::
    "com.android.support" % "appcompat-v7" % "25.3.1" ::
    "com.android.support" % "cardview-v7" % "25.3.1" ::
    "com.android.support" % "design" % "25.3.1" ::
    "com.android.support" % "gridlayout-v7" % "25.3.1" ::
    "com.android.support" % "recyclerview-v7" % "25.3.1" ::
    "com.android.support" % "support-v4" % "25.3.1" ::
    "com.google.code.findbugs" % "jsr305" % "3.0.2" % "compile" ::
    "com.geteit" %% "robotest" % "0.12" % "test" ::
    "org.scalatest" %% "scalatest" % "3.0.3" % "test" ::
    Nil

name := "hello-scala"

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

platformTarget := "android-26"

proguardCache ++=
    "android.support" ::
    Nil

proguardOptions ++=
    "-keepattributes EnclosingMethod,InnerClasses,Signature" ::
    "-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry" ::
    "-dontwarn javax.xml.bind.DatatypeConverter" ::
    "-dontnote org.joda.time.DateTimeZone" ::
    "-dontnote scala.concurrent.stm.impl.STMImpl$" ::
    "-dontnote okhttp3.internal.**" ::
    "-dontwarn io.circe.generic.util.macros.**" ::
    "-dontwarn monix.execution.internals.**" ::
    "-dontnote monix.execution.internals.**" ::
    "-dontwarn okio.**" ::
    "-dontwarn org.jctools.**" ::
    "-dontwarn org.slf4j.**" ::
    Nil

// Shortcut: allows you to execute "sbt run" instead of "sbt android:run"
run := ( run in Android ).evaluated

scalacOptions ++=
    // Print detailed deprecation warnings to the console
    "-deprecation" ::
    // Print detailed feature warnings to the console
    "-feature" ::
    Nil

// Don't upgrade to 2.12.x as it requires Java 8 which does not work with Android
scalaVersion := "2.11.11"

targetSdkVersion := "26"

versionCode := Some( 0 )

versionName := Some( "0.0.0" )