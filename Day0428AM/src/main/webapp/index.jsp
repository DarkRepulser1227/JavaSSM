<html>
<head>
    <script src="js/echart/jquery.min.js"></script>
    <script src="js/echart/echarts-all.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                var mychart=echarts.init($("#main"));
                mychart.showLoading();
            });
        });
    </script>
</head>
<body>
    <div id="main"></div><br/>
    <button id="btn">加载图表</button>
</body>
</html>
