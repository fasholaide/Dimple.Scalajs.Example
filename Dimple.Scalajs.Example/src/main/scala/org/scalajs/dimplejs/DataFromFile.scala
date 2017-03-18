package org.scalajs.dimplejs

import org.scala.dimplejs.{Chart, Dimple, PlotLine}
import org.singlespaced.d3js.d3
import scala.scalajs.js

class DataFromFile {

  def visualize(): Unit = {
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
