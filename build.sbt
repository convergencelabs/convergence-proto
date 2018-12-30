scalaVersion := "2.12.6"
organization := "io.convergence"

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

publishTo := {
  val nexus = "https://nexus.dev.int.convergencelabs.tech/repository/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "maven-convergence-snapshots")
  else
    Some("releases"  at nexus + "maven-convergence-releases")
}
