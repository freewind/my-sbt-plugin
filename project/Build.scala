import sbt._

object MySbtPluginBuild extends Build {

  lazy val root = project.in(file("."))

  root.enablePlugins(MySbtPlugin)

}
