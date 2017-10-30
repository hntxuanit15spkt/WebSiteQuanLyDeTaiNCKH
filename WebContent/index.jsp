<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Website quản lý đăng ký đề tài nghiên cứu khoa học</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	
addEventListener("load", function() { 
	setTimeout(hideURLbar, 0); }, false); 
	function hideURLbar(){ 
		window.scrollTo(0,1); 
		} 








</script>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<%-- <c:set var="root" value="${pageContext.request.contextPath}" />
<link href="${root}/css/style.css" rel='stylesheet' type='text/css' /> --%>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--js-->
<script src="js/jquery-2.1.1.min.js"></script>
<!--icons-css-->
<link href="css/font-awesome.css" rel="stylesheet" />
<!--Google Fonts-->
<link href='//fonts.googleapis.com/css?family=Carrois+Gothic'
	rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Work+Sans:400,500,600'
	rel='stylesheet' type='text/css' />
<!--static chart-->
<script src="js/Chart.min.js"></script>
<!--//charts-->
<!-- geo chart -->
<script src="//cdn.jsdelivr.net/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<script>
	window.modernizr
			|| document
					.write('<script src="lib/modernizr/modernizr-custom.js"><\/script>')
</script>
<!--<script src="lib/html5shiv/html5shiv.js"></script>-->
<!-- Chartinator  -->
<script src="js/chartinator.js"></script>
<script type="text/javascript">
	jQuery(function($) {

		var chart3 = $('#geoChart').chartinator(
				{
					tableSel : '.geoChart',

					columns : [ {
						role : 'tooltip',
						type : 'string'
					} ],

					colIndexes : [ 2 ],

					rows : [ [ 'China - 2015' ], [ 'Colombia - 2015' ],
							[ 'France - 2015' ], [ 'Italy - 2015' ],
							[ 'Japan - 2015' ], [ 'Kazakhstan - 2015' ],
							[ 'Mexico - 2015' ], [ 'Poland - 2015' ],
							[ 'Russia - 2015' ], [ 'Spain - 2015' ],
							[ 'Tanzania - 2015' ], [ 'Turkey - 2015' ] ],

					ignoreCol : [ 2 ],

					chartType : 'GeoChart',

					chartAspectRatio : 1.5,

					chartZoom : 1.75,

					chartOffset : [ -12, 0 ],

					chartOptions : {

						width : null,

						backgroundColor : '#fff',

						datalessRegionColor : '#F5F5F5',

						region : 'world',

						resolution : 'countries',

						legend : 'none',

						colorAxis : {

							colors : [ '#679CCA', '#337AB7' ]
						},
						tooltip : {

							trigger : 'focus',

							isHtml : true
						}
					}

				});
	});
</script>
<!--geo chart-->

<!--skycons-icons-->
<script src="js/skycons.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<%-- <jsp:include page="banner.jsp"></jsp:include> --%>
	<jsp:include page="menu.jsp"></jsp:include>
	<jsp:include page="content.jsp"></jsp:include>
	<jsp:include page="footer.jsp"></jsp:include>
	<script>
		$(document).ready(function() {
			var navoffeset = $(".header-main").offset().top;
			$(window).scroll(function() {
				var scrollpos = $(window).scrollTop();
				if (scrollpos >= navoffeset) {
					$(".header-main").addClass("fixed");
				} else {
					$(".header-main").removeClass("fixed");
				}
			});

		});
	</script>
	<script>
		var toggle = true;
		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
						}, 400);
					}
					toggle = !toggle;
				});
	</script>
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	<div class="clearfix"></div>
</body>
</html>