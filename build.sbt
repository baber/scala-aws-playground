organization := "com.bk"
scalaVersion := "2.11.11"
name := "scala-aws-playground"


libraryDependencies ++= Seq(
  "com.amazonaws" % "aws-java-sdk" % "1.11.216",
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
