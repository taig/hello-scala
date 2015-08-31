// Enforce Java 7 compilation (in case you have the JDK 8 installed)
javacOptions ++=
    "-source" :: "1.7" ::
    "-target" :: "1.7" ::
    Nil

libraryDependencies ++=
    "com.android.support" % "appcompat-v7" % "23.0.0" ::
    "com.android.support" % "cardview-v7" % "23.0.0" ::
    "com.android.support" % "design" % "23.0.0" ::
    "com.android.support" % "gridlayout-v7" % "23.0.0" ::
    "com.android.support" % "recyclerview-v7" % "23.0.0" ::
    "com.android.support" % "support-v4" % "23.0.0" ::
    // Version 2.4.x requires Java 8
    "com.typesafe.play" %% "play-json" % "2.3.10" ::
    Nil

name := "HelloScala"

scalacOptions ++=
    // Print detailed deprecation warnings to the console
    "-deprecation" ::
    // Print detailed feature warnings to the console
    "-feature" ::
    Nil

// Don't upgrade to 2.12.x as it requires Java 8 which does not work with Android (but this might
// be resolvable with "retrolamda")
scalaVersion := "2.11.7"