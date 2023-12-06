$(document).ready(function () {
  lineChart();
  donutChart();
  pieChart();
  $(window).resize(function () {
    window.lineChart.redraw();
    window.donutChart.redraw();
    window.pieChart.redraw();
  });
});
function lineChart() {

  var orders = document.getElementsByClassName("orders");
  var profits = document.getElementsByClassName("profits");

  var estimatedOrder = document.getElementById('estimatedOrder');
  var estimatedProft = document.getElementById('estimatedProfit');

  console.log(orders);
  window.lineChart = Morris.Line({
    element: "line-chart",
    data: [ // Years, Profit, Orders
      { y: "2017", a: parseInt(profits[0].value), b: parseInt(orders[0].value) },
      { y: "2018", a: parseInt(profits[1].value), b: parseInt(orders[1].value) },
      { y: "2019", a: parseInt(profits[2].value), b: parseInt(orders[2].value) },
      { y: "2020", a: parseInt(profits[3].value), b: parseInt(orders[3].value) },
      { y: "2021", a: parseInt(profits[4].value), b: parseInt(orders[4].value) },
      { y: "2022", a: parseInt(profits[5].value), b: parseInt(orders[5].value) },
      { y: "2023", a: parseInt(profits[6].value), b: parseInt(orders[6].value) },
      { y: "2024", a: parseInt(estimatedProft.value), b: parseInt(estimatedOrder.value) },
    ],
    xkey: "y",
    ykeys: ["a", "b"],
    labels: ["Profit", "Orders"],
    lineColors: ["#009688", "#cdc6c6"],
    lineWidth: "3px",
    resize: true,
    redraw: true,
  });
}
function donutChart() {

  // get the values from here
  var pendingOrders = document.getElementById("pendingOrders").value;
  var completedOrders = document.getElementById("completedOrders").value;
  window.donutChart = Morris.Donut({
    element: "donut-chart",
    data: [
      { label: "Orders Completed", value: completedOrders },
      { label: "Pending Orders", value: pendingOrders },

    ],
    backgroundColor: "#f2f5fa",
    labelColor: "#009688",
    colors: ["#0BA462", "#39B580", "#67C69D", "#95D7BB"],
    resize: true,
    redraw: true,
  });
}
function pieChart() {
  var paper = Raphael("pie-chart");
  paper.piechart(100, 100, 90, [18.373, 18.686, 2.867, 23.991, 9.592, 0.213], {
    legend: [
      "Windows/Windows Live",
      "Server/Tools",
      "Online Services",
      "Business",
      "Entertainment/Devices",
      "Unallocated/Other",
    ],
  });
}