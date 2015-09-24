androidBuild

// Prevent common com.android.builder.packaging.DuplicateFileException.
// Add further file names if you experience the exception after adding new dependencies
packagingOptions in Android := PackagingOptions(
    excludes =
        "META-INF/LICENSE" ::
        "META-INF/LICENSE.txt" ::
        "META-INF/NOTICE" ::
        "META-INF/NOTICE.txt" ::
        Nil
)

// Predefined as IceCreamSandwich (4.0), nothing stops you from going below
minSdkVersion in Android := "14"

// Shortcut: allows you to execute "sbt packageRelease" instead of "sbt android:packageRelease"
packageRelease <<= packageRelease in Android

platformTarget in Android := "android-23"

proguardCache in Android ++=
    "android.support" ::
    "play" ::
    Nil

proguardOptions in Android ++=
    "-keepattributes EnclosingMethod,InnerClasses,Signature" ::
    "-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry" ::
    "-dontwarn javax.xml.bind.DatatypeConverter" ::
    "-dontnote org.joda.time.DateTimeZone" ::
    "-dontnote scala.concurrent.stm.impl.STMImpl$" ::
    Nil

// Shortcut: allows you to execute "sbt run" instead of "sbt android:run"
run <<= run in Android

targetSdkVersion in Android := "23"

versionCode in Android := Some( 0 )

versionName in Android := Some( "0.0.0" )