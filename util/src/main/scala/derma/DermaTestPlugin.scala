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