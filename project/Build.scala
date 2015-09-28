import sbt._

object Codeforces extends Build {

  import App.BuildSettings._

  lazy val root = baseProject("questions", ".")
    .aggregate(round321Div2, round322Div2, misc)


  lazy val round321Div2 = baseProject("codeforces-round321div2", "codeforces/round321div2")
  lazy val round322Div2 = baseProject("codeforces-round322div2", "codeforces/round322div2")
  lazy val misc = baseProject("misc", "misc")

  def baseProject(name: String, filePath: String) = Project(name, file(filePath)).settings(moduleSettings: _*)


}