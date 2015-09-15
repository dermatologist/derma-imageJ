name := "util"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies += "net.imagej" % "ij" % "1.49k"

fork := true

// Enable and customize `sbt-imagej` plugin
lazy val util = (project in file(".")).
  enablePlugins(SbtImageJ).settings(
    //ijRuntimeSubDir := "sandbox").settings(
    //ijPluginsSubDir := "ij-plugins").settings(
    ijCleanBeforePrepareRun := true).settings(
    ijExclusions += """nativelibs4java\S*""").settings(
    // Instruct `clean` to delete created plugins subdirectory created by `ijRun`/`ijPrepareRun`.
    cleanFiles += ijPluginsDir.value
  )