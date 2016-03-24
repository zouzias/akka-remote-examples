
organization := "org.zouzias"
name := "HelloRemote"

version := "1.0"

scalaVersion := "2.11.7"
val akkaV = "2.4.2"

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")


resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
   "com.typesafe.akka" %% "akka-actor" % akkaV,
   "com.typesafe.akka" %% "akka-remote" % akkaV
)
