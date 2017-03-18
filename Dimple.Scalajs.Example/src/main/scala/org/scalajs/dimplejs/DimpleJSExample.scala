package org.scalajs.dimplejs

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport
class DimpleJSExample extends js.JSApp {

  @JSExport
  def main(): Unit = {
    new BarChart().visualize()
    new DataFromFile().visualize()
  }
}
