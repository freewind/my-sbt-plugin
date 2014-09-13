my sbt plugin
=============

sbt 0.13.x has a `AutoPlugin` feature, I want to create a simple sbt plugin with it.

But, the document is buggy, I can't find working examples, so this one is still not working now.

When you run `./sbt` on this project, it will show some errors:

```
[info] Done updating.
[info] Compiling 2 Scala sources to /private/tmp/sbttest/myplugin/project/target/scala-2.10/sbt-0.13/classes...
/private/tmp/sbttest/myplugin/build.sbt:0: error: '.' expected but eof found.
import _root_.sbt.plugins.IvyPlugin, _root_.sbt.plugins.JvmPlugin, _root_.sbt.plugins.CorePlugin, _root_.sbt.plugins.JUnitXmlReportPlugin, MySbtPlugin
```

I can't resolve it, help!
