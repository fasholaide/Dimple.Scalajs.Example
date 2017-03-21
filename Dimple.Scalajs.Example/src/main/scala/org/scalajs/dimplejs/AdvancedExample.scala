package org.scalajs.dimplejs

import org.scala.dimplejs._
import org.singlespaced.d3js.d3
import scala.scalajs.js


class AdvancedExample {
  def visualize(): Unit = {
    val callback: js.Function1[js.Array[js.Dictionary[String]], Unit]
    = (tsvData: js.Array[js.Dictionary[String]]) => {

      //Create the SVG using Dimple
      val svg = Dimple.newSvg("#circleContainer", 590, 400)
      val chart = new Chart(svg, tsvData)
      chart.setBounds(60, 30, 495, 330)

      val xAxis = chart.addMeasureAxis("x", "Distribution")
      val yAxis = chart.addMeasureAxis("y", "Price")
      val segments = chart.addMeasureAxis("p", "Unit Sales")
      val size = chart.addMeasureAxis("z", "Sales Value")
      val ring = chart.addSeries(js.Array("Price Tier", "Channel"), plotFunction = PlotPie)
      val pie = chart.addSeries(js.Array("Price Tier", "Owner"), plotFunction = PlotPie)

      // Zoom in the axis bounds
      xAxis.overrideMin = 40
      xAxis.overrideMax = 70
      yAxis.overrideMax = 150

      // Set the maximum radius for the bubbles
      ring.radius = 75
      pie.radius = 75

      // Create fixed 10px ring with a 5px
      // margin (negative sizes are calculated inwards)
      ring.innerRadius = "-10px"
      pie.outerRadius = "-15px"

      // Draw averages for the pie and ring
      ring.aggregate = AggregateMethod.avg _
      pie.aggregate = AggregateMethod.avg _

      //Animate by Date
      val storyBoard = new StoryBoard(chart, "Date")
      chart.storyboard = storyBoard

      chart.draw()
      ()
    }
    d3.tsv("./data/example_data.tsv", callback)
  }
}
