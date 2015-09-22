import App.Dependencies
import sbt.Keys._
import sbt._

trait AppBuildSettings {
  import App.Resolvers._

  Keys.fork in Test := false
  val buildOrganization = "me.karpenko.codeforce"
  val buildScalaVersion = "2.11.7"
  val jdkVersion = settingKey[String]("")

  val buildSettings = Seq(
    organization := buildOrganization,
    jdkVersion := "1.8",
    scalacOptions += s"-target:jvm-${jdkVersion.value}",
    javacOptions ++=
      Seq("-source", jdkVersion.value, "-target", jdkVersion.value),
    javaOptions += "-Xmx2G",
    javaOptions += "-XX:MaxMetaspaceSize=1g",
    scalaVersion := buildScalaVersion,
    crossPaths := false,
    crossScalaVersions := Seq(buildScalaVersion),
    parallelExecution in Test := false,
    checksums in update := Nil,
    resolvers := depResolvers,
    allDependencies ~= Dependencies.logging,
    allDependencies ~= Dependencies.tests,
    allDependencies ~= Dependencies.withSources
  )

  val moduleSettings = buildSettings

}