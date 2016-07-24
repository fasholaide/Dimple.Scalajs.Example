package org.scalajs.dimplejs

import org.scala.dimplejs.{PlotLine, Chart, Dimple, PlotBar}
import org.singlespaced.d3js.d3

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport
class DimpleJSExample extends js.JSApp {

  @JSExport
  def main(): Unit = {
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

    val callback: js.Function1[js.Array[js.Dictionary[String]], Unit] = (tsvData: js.Array[js.Dictionary[String]]) => {
      val svg = Dimple.newSvg("#lineContainer", 590, 400)
      val filteredData = Dimple.filterData(tsvData, "Owner", js.Array("Aperture", "Black Mesa"))
      val myChart = new Chart(svg, filteredData)
      myChart.setBounds(60, 30, 505, 305)
      val x = myChart.addCategoryAxis("x", "Month")
      x.addOrderRule("Date")
      myChart.addMeasureAxis("y", "Unit Sales")
      val s = myChart.addSeries(plotFunction = PlotLine)
      myChart.draw()
      ()
    }
    d3.tsv("./data/example_data.tsv", callback)
  }
}
