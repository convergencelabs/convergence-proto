scalaVersion := "2.12.6"
organization := "io.convergence"

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

publishTo := {
  val nexus = "https://nexus.dev.int.convergencelabs.tech/repository/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "maven-convergence-snapshots")
  else
    Some("releases"  at nexus + "maven-convergence-releases")
}
