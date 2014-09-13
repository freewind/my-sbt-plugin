import sbt._

object MySbtPlugin extends AutoPlugin {

  object autoImport {
    lazy val hello = taskKey[Unit]("hello task from my plugin")
  }

  import autoImport._

  val helloSetting = hello := println("Hello from my plugin")

  override def projectSettings = Seq(
    helloSetting
  )

}
