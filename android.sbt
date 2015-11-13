androidBuild

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

// Predefined as IceCreamSandwich (4.0), nothing stops you from going below
minSdkVersion := "14"

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

targetSdkVersion := "23"

versionCode := Some( 0 )

versionName := Some( "0.0.0" )
