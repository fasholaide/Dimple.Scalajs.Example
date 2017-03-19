package org.scalajs.dimplejs

import org.scala.dimplejs.{Chart, Dimple, PlotBar}
import scala.scalajs.js

class BarChart {

  def visualize(): Unit = {
    val svg = Dimple.newSvg("#barContainer", 590, 400)
    val literalData = js.Array(
      js.Dynamic.literal(Company = "Google", Awesomeness = "2000"),
      js.Dynamic.literal(Company = "Twitter", Awesomeness = "4000"),
      js.Dynamic.literal(Company = "Facebook", Awesomeness = "2500"),
      js.Dynamic.literal(Company = "Microsoft", Awesomeness = "1100"),
      js.Dynamic.literal(Company = "Intel", Awesomeness = "3500")
    )
    val chart = new Chart(svg, literalData)
    chart.addCategoryAxis("x", "Company")
    chart.addMeasureAxis("y", "Awesomeness")
    chart.addSeries(null, PlotBar)
    chart.draw()
  }
}
