import sbt._

object Codeforces extends Build {

  import App.BuildSettings._

  lazy val root = baseProject("codeforces", ".").aggregate(round321Div2)

  lazy val round321Div2 = baseProject("round321div2", "codeforces/round321div2")

  def baseProject(name: String, filePath: String) = Project(name, file(filePath)).settings(moduleSettings: _*)


}