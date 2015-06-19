import android.Keys._
import sbt._
import sbt.Keys._

object	Build
extends	android.AutoBuild
{
	val main = Project( "hello-scala", file( "." ) )
		// **************
		// *** Basics ***
		// **************
		.settings(
			// Enforce Java 7 compilation (in case you have the JDK 8 installed)
			javacOptions ++= (
				"-source" :: "1.7" ::
				"-target" :: "1.7" ::
				Nil
			),
			libraryDependencies ++= (
				"com.android.support" % "appcompat-v7" % "22.2.0" ::
				"com.android.support" % "cardview-v7" % "22.2.0" ::
				"com.android.support" % "design" % "22.2.0" ::
				"com.android.support" % "gridlayout-v7" % "22.2.0" ::
				"com.android.support" % "recyclerview-v7" % "22.2.0" ::
				"com.android.support" % "support-v4" % "22.2.0" ::
				"com.typesafe.play" %% "play-json" % "2.3.9" ::
				Nil
			),
			name := "HelloScala",
			scalacOptions ++= (
				// Print detailed deprecation warnings to the console
				"-deprecation" ::
				// Print detailed feature warnings to the console
				"-feature" ::
				Nil
			),
			// Don't upgrade to 2.12.x as it requires Java 8 which does not work with Android (but this might
			// be resolvable with "retrolamda")
			scalaVersion := "2.11.6"
		)
		// ************
		// *** Test ***
		// ************
		.settings(
			fork in Test := true,
			libraryDependencies ++= (
				"com.geteit" %% "robotest" % "0.10" % "test" :: 
				"org.scalatest" %% "scalatest" % "2.2.5" % "test" ::
				Nil
			),
			resolvers ++= (
				( "RoboTest" at "https://raw.github.com/zbsz/mvn-repo/master/releases/" ) ::
				Resolver.sonatypeRepo( "snapshots" ) ::
				Nil
			)
		)
		// ***************
		// *** Android ***
		// ***************
		.settings(
			// Prevent common com.android.builder.packaging.DuplicateFileException.
			// Add further file names if you experience the exception after adding new dependencies
			apkbuildExcludes in Android ++= (
				"META-INF/LICENSE" ::
				"META-INF/LICENSE.txt" ::
				"META-INF/NOTICE" ::
				"META-INF/NOTICE.txt" ::
				Nil
			),
			// Predefined as IceCreamSandwich (4.0), nothing stops you from going below
			minSdkVersion in Android := "14",
			// Shortcut: allows you to execute "sbt packageRelease" instead of "sbt android:packageRelease"
			packageRelease <<= packageRelease in Android,
			platformTarget in Android := "android-22",
			proguardCache in Android ++= (
				"android.support" ::
				"play" ::
				Nil
			),
			proguardOptions in Android ++= (
				"-keepattributes EnclosingMethod,InnerClasses,Signature" ::
				"-dontwarn org.w3c.dom.bootstrap.DOMImplementationRegistry" ::
				"-dontwarn javax.xml.bind.DatatypeConverter" ::
				"-dontnote org.joda.time.DateTimeZone" ::
				"-dontnote scala.concurrent.stm.impl.STMImpl$" ::
				Nil
			),
			// Shortcut: allows you to execute "sbt run" instead of "sbt android:run"
			run <<= run in Android,
			targetSdkVersion in Android := "22",
			// Disable transitive dependencies of aar and apklib libraries. This is not generally necessary, but
			// helps getting around some unpleasant corner cases
			transitiveAndroidLibs in Android := false,
			versionCode in Android := Some( 0 ),
			versionName in Android := Some( "0.0.0" )
		)
}