import sbt._

trait AppResolvers {
  val typesafeReleaseRepo = "Typesafe Release Repository" at "http://repo.typesafe.com/typesafe/releases/"

  val scalaToolsRepo = "Scala Tools Repository" at "https://oss.sonatype.org/content/groups/scala-tools/"
  
  val depResolvers = Seq(typesafeReleaseRepo, scalaToolsRepo)

}
