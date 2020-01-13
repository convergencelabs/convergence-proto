organization := "com.convergencelabs"
organizationName := "Convergence Labs, Inc."
organizationHomepage := Some(url("http://convergencelabs.com"))

name := "Convergence Protocol Scala Bindings"
normalizedName := "convergence-proto-scala"

description := "Convergence Protocol Scala Bindings"
homepage := Some(url("https://convergence.io"))

licenses += "Apache 2.0" -> url("http://www.apache.org/licenses/")

scmInfo := Some(
  ScmInfo(
    url("https://github.com/convergencelabs/convergence-proto"),
        "scm:git@github.com:convergencelabs/convergence-proto.git"
  )
)

developers := List(
  Developer(
    id    = "mmacfadden",
    name  = "Michael MacFadden",
    email = "michael@convergencelabs.com",
    url   = url("https://convergencelabs.com")
  )
)

scalaVersion := "2.12.10"

// Protocol Buffer Configuration
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

PB.targets in Compile := Seq(
  scalapb.gen(flatPackage = true) -> (sourceManaged in Compile).value
)
