my sbt plugin
=============

sbt 0.13.x has a `AutoPlugin` feature, I want to create a simple sbt plugin with it.

I met a lot of issues, but finally, it works. You can see the detail comments inside file `MySbtPlugin` to get the idea.

PS: the sbt version I'm using is `0.13.5`

## load error

If I define the plugin without a package(e.g. top level object), with sbt 0.13.5, it will report this error when running `sbt`:
 
```
[info] Done updating.
[info] Compiling 2 Scala sources to /private/tmp/sbttest/myplugin/project/target/scala-2.10/sbt-0.13/classes...
/private/tmp/sbttest/myplugin/build.sbt:0: error: '.' expected but eof found.
import _root_.sbt.plugins.IvyPlugin, _root_.sbt.plugins.JvmPlugin, _root_.sbt.plugins.CorePlugin, _root_.sbt.plugins.JUnitXmlReportPlugin, MySbtPlugin
```

To fix it, just give it a package.

PS: This issue is fixed in `sbt 0.13.6`, but it requires the plugin and the project uses this plugin are all build with `sbt 0.13.6`

## auto enabled

In `MySbtPlugin`, if:

```
override def trigger = allRequirements
```

It will be auto enabled. 

If is:

```
override def trigger = noTrigger
```

We have to manually enabled it by:

```
lazy val root = (project in file(".")).enablePlugins(MySbtPlugin)
```

in the projects which use this plugin.

## Important 

When you trying your plugin under development, you'd better run this before try new modified plugin:

```
rm -rf target
rm -rf project/target
// rm other targets if need
```

Then run:

```
sbt
plugins  // to check installed plugins
```

Without `rm` part, you may have a lot of strange troubles.


