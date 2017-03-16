<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="en" ng-app="login">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>3456-登录</title>

		<meta name="description" content="User login page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="/transport/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="/transport/assets/css/font-awesome.css" />

		<!-- text fonts -->
		<link rel="stylesheet" href="/transport/assets/css/ace-fonts.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="/transport/assets/css/ace.css" />

		<!--[if lte IE 9]>
		<link rel="stylesheet" href="/transport/assets/css/ace-part2.css"/>
		<![endif]-->
		<link rel="stylesheet" href="/transport/assets/css/ace-rtl.css" />
		<!--[if lte IE 9]>
		<link rel="stylesheet" href="/transport/assets/css/ace-ie.css"/>
		<![endif]-->
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="/transport/assets/js/jquery.js"></script>
		<script src="/transport/assets/js/html5shiv.js"></script>
		<script src="/transport/assets/js/respond.js"></script>
		<![endif]-->
	</head>

	<body class="login-layout">
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container" style="margin-top: 6%;">
							<div class="center">
								<h1>
									<i class="ace-icon fa fa-leaf green"></i>
									<span class="red">3456</span>
									<span class="white" id="id-text2">物流管理</span>
								</h1>
								<h4 class="blue" id="id-company-text">&copy;思泉科技有限公司</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main" ng-controller="LoginController">
											<h4 class="header blue lighter bigger">
												<i class="ace-icon fa fa-coffee green"></i>
												用户登录
											</h4>

											<div class="space-6"></div>

											<form ng-submit="login()">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" class="form-control" placeholder="账号"ng-model="user.username" required />
															<i class="ace-icon fa fa-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" class="form-control" placeholder="密码" ng-model="user.password" required />
															<i class="ace-icon fa fa-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> 自动登录</span>
														</label>

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="ace-icon fa fa-key"></i>
															<span class="bigger-110">登录</span>
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>
											<div class="social-or-login center" ng-show="erreMsm">
												<span class="bigger-110" ng-bind="erreMsm"></span>
											</div>
										</div><!-- /.widget-main -->
									</div><!-- /.widget-body -->
								</div><!-- /.login-box -->
							</div><!-- /.position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div><!-- /.main-content -->
		</div><!-- /.main-container -->

		<!-- basic scripts -->

		<!--[if !IE]> -->
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/transport/assets/js/jquery.js'>"+"<"+"/script>");
		</script>

		<!-- <![endif]-->

		<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='/transport/assets/js/jquery1x.js'>"+"<"+"/script>");
</script>
<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='/transport/assets/js/jquery.mobile.custom.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->
		<script type="text/javascript">
			$('body').attr('class', 'login-layout blur-login');
			$('#id-text2').attr('class', 'white');
			$('#id-company-text').attr('class', 'light-blue');

			/*e.preventDefault();*/

			/*jQuery(function($) {
			 $(document).on('click', '.toolbar a[data-target]', function(e) {
				e.preventDefault();
				var target = $(this).data('target');
				$('.widget-box.visible').removeClass('visible');//hide others
				$(target).addClass('visible');//show target
			 });
			});*/

		</script>

		<script src="/transport/vendor/angular.js"></script>

		<!-- RestAngular-->
		<script src="/transport/vendor/angular/extend/restangular.js"></script>
		<!--<script src="vendor/angular/extend/lodash.compat.js"></script>-->
		<script src="/transport/vendor/angular/extend/underscore-min.js"></script>

		<!--Cookie-->
		<script src="/transport/vendor/angular/angular-cookies/angular-cookies.js"></script>
		<script src="/transport/app/modules/login/login.js"></script>
		<script src="/transport/app/modules/login/config/route.js"></script>

		<script src="/transport/app/modules/login/services/login.js"></script>
		<script src="/transport/app/modules/login/controllers/logincontroller.js"></script>

	</body>
</html>
