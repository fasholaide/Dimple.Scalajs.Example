package org.scalajs.dimplejs

import org.scala.dimplejs._
import org.singlespaced.d3js.d3
import scala.scalajs.js

class DataFromFile {

  def visualize(): Unit = {

    //Create the CallBack Function For D3
    val callback: js.Function1[js.Array[js.Dictionary[String]], Unit]
    = (tsvData: js.Array[js.Dictionary[String]]) => {

      //Create the SVG using Dimple
      val svg = Dimple.newSvg("#lineContainer", 590, 400)

      //Filter out the unneeded data from the file.
      val filteredData = Dimple.filterData(tsvData, "Owner", js.Array("Aperture", "Black Mesa"))

      //Create the Chart where the SVG should be displayed
      val chart = new Chart(svg, filteredData)

      //Set the Bounds of the Chart
      chart.setBounds(60, 30, 505, 305)

      //Create the X-Axis on the Chart
      val x = chart.addCategoryAxis("x", "Month")
      x.addOrderRule("Date")

      //Create the y-axis of the Chart
      chart.addMeasureAxis("y", "Unit Sales")

      //Set the Plot Function of the Chart
      chart.addSeries(plotFunction = PlotBar)

      //Create the Color Object for the Chart
      val color = new Color(fill = "#333333", opacity = 0.2F)
      chart.defaultColors = js.Array(color)

      //Call the draw funsction to draw the Chart
      chart.draw()

      //Return a dummy Unit
      ()
    }
    d3.tsv("./data/example_data.tsv", callback)
  }
}