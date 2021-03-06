name := "scala-android-study"

import android.Keys._
android.Plugin.androidBuild
javacOptions ++= Seq("-source", "1.7", "-target", "1.7")
scalaVersion := "2.11.7"
scalacOptions in Compile += "-feature"

proguardCache in Android ++= Seq("org.scaloid")

proguardOptions in Android ++= Seq("-dontobfuscate", "-dontoptimize", "-keepattributes Signature", "-printseeds target/seeds.txt", "-printusage target/usage.txt"
  , "-dontwarn scala.collection.**"
  , "-dontwarn org.scaloid.**"
)

libraryDependencies += "org.scaloid" %% "scaloid" % "4.0"

run <<= run in Android
install <<= install in Android

retrolambdaEnable in Android := false
