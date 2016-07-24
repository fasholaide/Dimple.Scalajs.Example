enablePlugins(ScalaJSPlugin)

name := "Scalatags"

version := "1.0"

scalaVersion := "2.11.8"

persistLauncher in Compile := true

persistLauncher in Test := false

// http://mvnrepository.com/artifact/com.scalatags/scalatags_2.10
libraryDependencies ++= Seq(
"com.scalatags" % "scalatags_2.10" % "0.1.4",
"org.scala-js" %%% "scalajs-dom" % "0.9.0",
"org.singlespaced" %%% "scalajs-d3" % "0.3.3",
"org.dimple.scalajs" % "dimple-scalajs_sjs0.6_2.11" % "0.1-SNAPSHOT"
)

resolvers += Resolver.mavenLocal

scalaJSUseRhino in Global := false

mainClass in Compile := Some("org.scalajs.dimplejs.DimpleJSExample")