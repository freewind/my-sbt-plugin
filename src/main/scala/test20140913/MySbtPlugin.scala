// It must be inside a package, can't be a top level object
//package test20140913

import sbt._

// This object must be as normal scala files, not a sbt config code
// it can be put in normal scala files location, e.g. `project/` or `src/main/scala/`
// should NOT inside `project`
object MySbtPlugin extends AutoPlugin {

  // content inside `autoImport` will be merged into sbt config
  object autoImport {
    lazy val hello = taskKey[Unit]("hello task from my plugin")
  }

  import autoImport._

  // Notice:
  // This line is very important to control if this plugin is auto enabled
  //
  // 1. allRequirements: Auto enabled if requirements are present
  //    With `allRequirements`, we just need to `addSbtPlugin(...)` in `project/plugins.sbt` of projects which is using this plugin,
  //    don't need to do anything in `build.sbt` or `Build.scala`
  //
  // 2. noTrigger: must be manually enabled
  //    If `noTrigger` is used, we have to enabled it like this in the projects using this plugin:
  //    {{{
  //      lazy val root = (project in file(".")).enablePlugins(test20140913.MySbtPlugin)
  //    }}}
  override def trigger = allRequirements

  // This plugins requires JvmPlugin. If it doesn't require anything, can give it a `Nil`, or not override it
  override def requires = plugins.JvmPlugin

  val helloSetting = hello := println("Hello from my plugin")

  override def projectSettings = Seq(
    helloSetting
  )

}
