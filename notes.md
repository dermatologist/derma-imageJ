## Create new module called **util**
## Create new package **derma**
## Class extends 
## Imports

## DermaTestPlugin.scala
,,,
package derma

/**
 * Hello world September 15, 2015
 */
import ij._
import ij.plugin._
import ij.process.{ColorProcessor, ImageProcessor}

class DermaTestPlugin extends PlugIn {

  def run(arg: String): Unit = {
    IJ.showMessage("DermaTestPlugin", "Hello World")
  }

}
,,,


## build.SBT
'''
 
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
    
'''
## plugins.sbt
'''

logLevel := Level.Warn

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

addSbtPlugin("net.sf.ij-plugins" % "sbt-imagej" % "2.0.0") 

'''
## plugins.config in Resources
'''

Plugins>Derma>Generic, "Derma Test", derma.DermaTestPlugin

'''
## Steps in IDEA
- Start IDEA
- Select "Import Project" and load the example/build.sbt. This will let you edit and build the project.
- To run ImageJ with the custom plugin you need to invoke ijPrepareRun tasks before running ImageJ.
- Click Run > Edit Configurations
- Add new application configuration, call it for instance, ImageJ
- Set main class to ij.ImageJ
- Set "Working directory" to **util/sandbox**
- Click on "+" under "Before lunch", select "SBT", in the combo box type ijPrepareRun, hit Enter (it is important), then click on OK.
- Now you can run the new configuration. It will build the project, call SBT to package and copy JARs, then run ImageJ with new plugins installed.
