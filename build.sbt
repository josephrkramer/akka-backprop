name := "Akka Back Propegation"
 
version := "0.1"
 
scalaVersion := "2.10.2"
 
scalacOptions += "-deprecation"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test" 

libraryDependencies +=
  "com.typesafe.akka" %% "akka-actor" % "2.2.0"

libraryDependencies +=
  "com.typesafe.akka" %% "akka-testkit" % "2.2.0"
