# Dimple.Scalajs.Example
A Sample Application with Dimple.Scalajs. This application constructs both a bar chart and a line chart.
To run this application, run `sbt fastOptJS`. This will create new js files for you in the target/scala-2.11. Of utmost importance are the scalatags-launcher.js, scalatags.jsdeps.js, and scalatags-fastopt.js files. 
These files should be added to the html file like this:
```javascript
<script type="text/javascript" src="./target/scala-2.11/scalatags-jsdeps.js"></script>
<script type="text/javascript" src="./target/scala-2.11/scalatags-fastopt.js"></script>
<script type="text/javascript" src="./target/scala-2.11/scalatags-launcher.js"></script>
```
Sample lines of code to draw a bar chart is as follows:
```scala
    //Create a new SVG Object to hang the drawing. Equivalent to the dimple.newsvg function
    val svg = Dimple.newSvg("#barContainer", 590, 400) 
    //A Sample Data
    val literalData = js.Array(
      js.Dynamic.literal(Company = "Google", Awesomeness = "2000"),
      js.Dynamic.literal(Company = "Twitter", Awesomeness = "4000"),
      js.Dynamic.literal(Company = "Facebook", Awesomeness = "2500"),
      js.Dynamic.literal(Company = "Microsoft", Awesomeness = "1100"),
      js.Dynamic.literal(Company = "Intel", Awesomeness = "3500")
    )
    //Create a new Chart Object. Equivalent to the dimple.chart object
    val chart = new Chart(svg, literalData)
    chart.addCategoryAxis("x", "Company")
    chart.addMeasureAxis("y", "Awesomeness")
    //The plotfunction used is the plot.bar option.
    chart.addSeries(null, PlotBar)
    //Draw and See.
    chart.draw()
  ```

![Alt text](/Dimple.Scalajs.Example/Dimple.Scalajs.ExampleBar.scrnSht.png?raw=true "Bar Chart")

Play with this!
Ahoy!
