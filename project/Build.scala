import android.Keys._
import sbt._
import sbt.Keys._

object	Build
extends	android.AutoBuild
{
	lazy val main = Project( "hello-scala", file( "." ) )
		.settings(
			// Enforce Java 7 compilation (in case you have the JDK 8 installed)
			javacOptions ++= Seq( "-source", "1.7", "-target", "1.7" ),
			libraryDependencies ++= Seq(
				"com.android.support" % "support-v4" % "22.1.1",
				"com.android.support" % "appcompat-v7" % "22.1.1",
				"com.android.support" % "cardview-v7" % "22.1.1",
				"com.android.support" % "gridlayout-v7" % "22.1.1",
				"com.android.support" % "recyclerview-v7" % "22.1.1"
			),
			name := "HelloScala",
			scalacOptions ++= Seq(
				// Print detailed deprecation warnings to the console (Note that you can not use @SuppressWarnings in Scala)
				"-deprecation",
				// Print detailed feature warnings to the console
				"-feature"
			),
			// Don't upgrade to 2.12.x as it requires Java 8 which does not work with Android
			scalaVersion := "2.11.6"
		)
		.settings(
			minSdkVersion in Android := "14",
			packageRelease <<= packageRelease in Android,
			proguardCache in Android ++= Seq(),
			proguardOptions in Android ++= Seq(),
			run <<= run in Android,
			targetSdkVersion in Android := "22",
			versionCode in Android := Some( 0 ),
			versionName in Android := Some( "0.0.0" )
		)
}