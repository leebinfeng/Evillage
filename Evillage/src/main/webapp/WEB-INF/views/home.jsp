<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="民兴村 电子村务">
<meta name="author" content="华南农业大学">
<link rel="icon" href="assets/images/logo.gif">

<title>民兴村电子村务平台</title>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet"
	href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">

<link rel="stylesheet" href="assets/css/app.css">
</head>

<body>
	<!-- NAVBAR -->
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top"
				role="navigation">
				<div class="container">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle Navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>

						<img alt="Brand" src="assets/images/logo.gif" class="navbar-brand">

						<a class="navbar-brand" href="#"> 民兴村电子村务 </a>
					</div>
					<div id="navbar" class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li class="active"><a href="#">首页</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-haspopup="true"
								aria-expanded="false">公共服务 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li role="separator" class="divider"></li>
									<li class="dropdown-header">日常服务</li>
									<li><a href="certificate">户籍证明</a></li>
									<li><a href="construction">报建申请</a></li>
									<li><a href="medicare">医保管理</a></li>
									<li><a href="land-contract">土地登记</a></li>
									<li role="separator" class="divider"></li>
									<li class="dropdown-header">其他服务</li>
									<li><a href="proposal">建议监督</a></li>
									<li><a href="mediation">调解申请</a></li>
								</ul></li>
							<li><a href="#about">公共信息</a></li>
							<li><a href="#about">农业服务</a></li>
							<li><a href="#contact">民兴论坛</a></li>
							<li><a href="#">走进民兴</a></li>
							<li><a href="#">关于</a></li>
						</ul>
						<ul class="nav navbar-nav navbar-right">
							<li><a href="#">注册</a></li>
							<li><a>|</a></li>
							<li><a href="#">登录</a></li>
						</ul>
					</div>
				</div>
			</nav>

		</div>
	</div>

	<!-- Carousel -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide"
					src="assets/images/background_1.jpg;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="First slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>今日头条</h1>

						<p>
							Note: If you're viewing this page via a
							<code>file://</code>
							URL, the "next" and "previous" Glyphicon buttons on the left and
							right might not load/display properly due to web browser security
							rules.
						</p>

						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">进入头条</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="assets/images/background_2.jpg;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Second slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>村委反馈</h1>

						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>

						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">查看详细</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="assets/images/background_3.jpg;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Third slide">

				<div class="container">
					<div class="carousel-caption">
						<h1>最新通知</h1>

						<p>Cras justo odio, dapibus ac facilisis in, egestas eget
							quam. Donec id elit non mi porta gravida at eget metus. Nullam id
							dolor id nibh ultricies vehicula ut id elit.</p>

						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">查看详细</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-rounded"
					src="assets/images/reservation.jpg;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Generic placeholder image" width="140" height="140">

				<h2>预约服务</h2>

				<p>
					村民在登录系统之后进行服务预约,<br>可以预约的服务包括户籍证明办理和报建申请
				</p>

				<p>
					<a class="btn btn-default" href="#" role="button">我要预约 &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->

			<div class="col-lg-4">
				<img class="img-rounded"
					src="assets/images/public-info.jpg;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Generic placeholder image" width="140" height="140">

				<h2>村务公开</h2>

				<p>
					村民可以查看村委定期公布的各类信息,<br>如有疑问,可以通过电话/网络/现场三种方式向村委反映
				</p>

				<p>
					<a class="btn btn-default" href="#" role="button">我要查看 &raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->

			<div class="col-lg-4">
				<img class="img-polaroid"
					src="assets/images/weather.png;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
					alt="Generic placeholder image" width="140" height="140">

				<h2>农业服务</h2>

				<p>
					村民可以获取我们提供的农业服务,主要包括<br>天气预报,农业信息服务,农业专家服务,数据统计等
				</p>

				<p>
					<a class="btn btn-default" href="#" role="button">我要服务 &raquo;</a>
				</p>
			</div>

			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->

		<!-- START THE FEATURETTES -->

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					民兴论坛 <span class="text-muted">民兴人的网络社区</span>
				</h2>
				<p class="lead">
					在这里,你可以发布帖子,也可以回复他人的帖子,享受无边际的交流;<br>在这里,你可以对村里的公共事务进行投票,享受作为主人的权利.
				</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					src="assets/images/social_network.jpg"
					alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 col-md-push-5">
				<h2 class="featurette-heading">
					热点新闻 <span class="text-muted">民兴之眼</span>
				</h2>
				<p class="lead">
					从西方到东方,从全国到广东,从广州到南沙,新闻热点资讯,一手新鲜.<br>让村民们足不出户,看遍全球.
				</p>
			</div>
			<div class="col-md-5 col-md-pull-7">
				<img class="featurette-image img-responsive center-block"
					src="assets/images/news.jpg" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					数据统计 <span class="text-muted">各项数据汇总</span>
				</h2>
				<p class="lead">Donec ullamcorper nulla non metus auctor
					fringilla. Vestibulum id ligula porta felis euismod semper.
					Praesent commodo cursus magna, vel scelerisque nisl consectetur.
					Fusce dapibus, tellus ac cursus commodo.</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block"
					src="assets/images/statistics.jpg" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->


		<!-- FOOTER -->
		<footer>
			<p class="pull-right">
				<a href="#">回到顶部</a>
			</p>
			<p>
				SCAU Copyright &copy; 2015 华南农业大学. All rights reserved &middot; <a
					href="#">隐私</a> &middot; <a href="#">条款</a>
			</p>
		</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
