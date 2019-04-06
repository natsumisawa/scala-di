name := """di-sample"""
organization := "com.example"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.1" % Test

lazy val hello = taskKey[Unit]("say hello to you")

lazy val root = (project in file("."))
  .settings(
    hello := {println("hello!")}
  )
  .enablePlugins(PlayScala)