
import sbt.{ExclusionRule, ModuleID, _}

trait AppDependencies {

  import App.BuildSettings._
  import App.Versions._

  val scalaReflect = "org.scala-lang" % "scala-reflect" % buildScalaVersion
  val scalaParserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.3"

  val specs2TestsRaw = Seq(
    "org.specs2" %% "specs2-core" % specs2Ver,
    "org.specs2" %% "specs2-scalacheck" % specs2Ver,
    "org.specs2" %% "specs2-matcher" % specs2Ver,
    "org.specs2" %% "specs2-mock" % specs2Ver
  )
  private val specs2Tests = specs2TestsRaw.map(_ % "test")


  def logging(allDependencies: Seq[ModuleID]): Seq[ModuleID] = {
    Seq(
      "org.slf4j" % "slf4j-api" % "1.7.7"
      , "org.slf4j" % "jul-to-slf4j" % "1.7.7"
      , "net.logstash.logback" % "logstash-logback-encoder" % "4.0"
      , "org.slf4j" % "jcl-over-slf4j" % "1.7.7" % Runtime
      , "org.slf4j" % "log4j-over-slf4j" % "1.7.7" % Runtime
    ) ++
      allDependencies.map(
        _.exclude("commons-logging", "commons-logging")
          .exclude("log4j", "log4j")
          .exclude("org.slf4j", "slf4j-log4j12")
          .exclude("org.slf4j", "slf4j-jcl")
          .exclude("org.slf4j", "slf4j-jdk14")
          .excludeAll(ExclusionRule("org.slf4j", "jcl-over-slf4j", configurations = Compile.name :: Nil))
          .excludeAll(ExclusionRule("ch.qos.logback", "logback-classic", configurations = Compile.name :: Nil))
          .excludeAll(ExclusionRule("ch.qos.logback", "logback-core", configurations = Compile.name :: Nil))
      )
  }

  def tests(allDependencies: Seq[ModuleID]): Seq[ModuleID] = specs2Tests ++ allDependencies

  def withSources(allDependencies: Seq[ModuleID]): Seq[ModuleID] = {
    val (withoutSourcesDeps, withSourcesDeps) =
      allDependencies.partition(_.name.contains("play"))
    withSourcesDeps.map(_ withSources() withJavadoc()) ++ withoutSourcesDeps
  }


}
