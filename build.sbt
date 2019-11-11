name := "convergence-proto"
description := "Convergence Protocol Scala Bindings"
homepage := Some(url("https://convergence.io"))

organization := "com.convergencelabs"
organizationName := "Convergence Labs, Inc."
organizationHomepage := Some(url("http://convergencelabs.com"))

licenses += "Apache 2.0" -> url("http://www.apache.org/licenses/")

scalaVersion := "2.12.10"

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

PB.targets in Compile := Seq(
  scalapb.gen(flatPackage = true) -> (sourceManaged in Compile).value
)

publishTo := {
  val nexus = "https://nexus.dev.convergencelabs.tech/repository/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "maven-convergence-snapshots")
  else
    Some("releases"  at nexus + "maven-convergence-releases")
}
