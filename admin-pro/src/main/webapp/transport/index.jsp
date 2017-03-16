<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html lang="en" ng-app='app'>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>欢迎进入34物流ERP系统</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <!--[if !IE]> -->
    <link rel="stylesheet" href="assets/css/pace.css"/>

    <script data-pace-options='{ "ajax": true, "document": true, "eventLag": false, "elements": false }'
            src="assets/js/pace.js"></script>

    <!-- <![endif]-->

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="assets/css/bootstrap.css"/>
    <link rel="stylesheet" href="assets/css/font-awesome.css"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="assets/css/ace-fonts.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="assets/css/ace-part2.css" class="ace-main-stylesheet"/>
    <![endif]-->

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="assets/css/ace-ie.css"/>
    <![endif]-->
    <!--<script src="vendor/jquery/jquery-1.8.3.min.js"></script>-->
    <script src="vendor/jquery/jquery.2.1.1min.js"></script>
    <!-- ace settings handler -->
    <script src="assets/js/ace-extra.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="assets/js/html5shiv.js"></script>
    <script src="assets/js/respond.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
<shiro:authenticated>
<body class="no-skin">
<!-- #section:basics/navbar.layout -->

<div id="navbar" class="navbar navbar-default">
    <script type="text/javascript">
        try {
            ace.settings.check('navbar', 'fixed')
        } catch (e) {
        }
    </script>

    <div class="navbar-container" id="navbar-container">
        <!-- #section:basics/sidebar.mobile.toggle -->
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <!-- /section:basics/sidebar.mobile.toggle -->
        <div class="navbar-header pull-left">
            <!-- #section:basics/navbar.layout.brand -->
            <a href="#" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    34物流后台管理中心
                </small>
            </a>

            <!-- /section:basics/navbar.layout.brand -->

            <!-- #section:basics/navbar.toggle -->

            <!-- /section:basics/navbar.toggle -->
        </div>

        <!-- #section:basics/navbar.dropdown -->
        <div class="navbar-buttons navbar-header pull-right" role="navigation" ng-controller="HeadController">
            <ul class="nav ace-nav" >
                <!-- #section:basics/navbar.user_menu -->
                <li class="light-blue">
                    <a data-toggle="dropdown" href="" class="dropdown-toggle">
                        <img class="nav-user-photo" src="assets/avatars/user.jpg" alt="Jason's Photo"/>
								<span class="user-info" >
									<small>欢迎,</small>
									{{clientName}}
                                   <%-- {{menulist}}--%>
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a ng-click="userInfo()" data-toggle="modal" data-target="#doShow" role="button">
                                <i class="ace-icon fa fa-user"></i>
                                用户信息
                            </a>
                        </li>
                        <li>
                            <a href="/logout">
                                <i class="ace-icon fa fa-power-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
                <!-- /section:basics/navbar.user_menu -->
            </ul>
            <div  id="doShow" class="modal fade" abindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header no-padding">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">我的账户信息</h4>
                        </div>
                        <div class="modal-body no-padding">
                            <form name="recipeForm" class="form-horizontal">
                                <table class="table table-bordered table-striped formLayout m0">
                                    <tr>
                                        <td>用户名</td>
                                        <td>{{user.username}}</td>
                                    </tr>
                                    <tr>
                                        <td>账号</td>
                                        <td>{{user.mobile}}</td>
                                    </tr>
                                    <tr>
                                        <td>所属网点</td>
                                        <td>{{user.networkName}}</td>
                                    </tr>
                                    <tr>
                                        <td>入职日期</td>
                                        <td>{{user.createTime | date:'yyyy-MM-dd hh:mm:ss'}}</td>
                                    </tr>
                                </table>
                            </form>
                        </div>

                    </div>
                </div>

            </div>

        <!-- /section:basics/navbar.dropdown -->
    </div><!-- /.navbar-container -->
</div>

</div><!-- /.modal-content -->


<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try {
            ace.settings.check('main-container', 'fixed')
        } catch (e) {
        }
    </script>

    <!-- #section:basics/sidebar -->
    <div id="sidebar" class="sidebar responsive">
        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'fixed')
            } catch (e) {
            }
        </script>

        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>

                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>

                <!-- #section:basics/sidebar.layout.shortcuts -->
                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>

                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>

                <!-- /section:basics/sidebar.layout.shortcuts -->
            </div>

            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div><!-- /.sidebar-shortcuts -->


        <ul class="nav nav-list" ng-controller="SkyController">
            <li class="" >
                <a data-url="page/index" href="#page/index">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> 首页 </span>
                </a>

                <b class="arrow"></b>
            </li>
            <li class="" ng-repeat="x in getmeun.flist">
                <a href="#/branchNetwork" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text" ng-bind="x.name">

							</span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="" ng-repeat="s in x.pidlist">
                        <a href="{{s.url}}" data-url="page/typography">
                            <i class="menu-icon fa fa-caret-right"></i>

                               <span class="menu-text" ng-bind="s.name">

							</span>
                        </a>

                        <b class="arrow"></b>
                    </li>


                </ul>
            </li>
        </ul>


        <!-- #section:basics/sidebar.layout.minimize -->
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left"
               data-icon2="ace-icon fa fa-angle-double-right">123</i>
        </div>

        <!-- /section:basics/sidebar.layout.minimize -->
        <script type="text/javascript">
            try {
                ace.settings.check('sidebar', 'collapsed')
            } catch (e) {
            }
        </script>
    </div>

    <!-- /section:basics/sidebar -->
    <div class="main-content">
        <div class="main-content-inner">
            <!-- #section:basics/content.breadcrumbs -->
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try {
                        ace.settings.check('breadcrumbs', 'fixed')
                    } catch (e) {
                    }
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#page/index">首页</a>
                    </li>
                </ul><!-- /.breadcrumb -->

                <!-- #section:basics/content.searchbox -->
                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input"
                                           id="nav-search-input" autocomplete="off"/>
									<i class="ace-icon fa fa-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- /.nav-search -->

                <!-- /section:basics/content.searchbox -->
            </div>

            <!-- /section:basics/content.breadcrumbs -->
            <div class="page-content">
                <!-- #section:settings.box -->
                <div class="ace-settings-container" id="ace-settings-container">
                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                        <i class="ace-icon fa fa-cog bigger-130"></i>
                    </div>

                    <div class="ace-settings-box clearfix" id="ace-settings-box">
                        <div class="pull-left width-50">
                            <!-- #section:settings.skins -->
                            <div class="ace-settings-item">
                                <div class="pull-left">
                                    <select id="skin-colorpicker" class="hide">
                                        <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                    </select>
                                </div>
                                <span>选择主题</span>
                            </div>

                            <!-- /section:settings.skins -->

                            <!-- #section:settings.navbar -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar"/>
                                <label class="lbl" for="ace-settings-navbar"> 固定导航条 </label>
                            </div>

                            <!-- /section:settings.navbar -->

                            <!-- #section:settings.sidebar -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar"/>
                                <label class="lbl" for="ace-settings-sidebar"> 固定工具条 </label>
                            </div>

                            <!-- /section:settings.sidebar -->

                            <!-- #section:settings.breadcrumbs -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs"/>
                                <label class="lbl" for="ace-settings-breadcrumbs"> 固定面包屑</label>
                            </div>

                            <!-- /section:settings.breadcrumbs -->

                            <!-- #section:settings.rtl -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl"/>
                                <label class="lbl" for="ace-settings-rtl"> 平行调转 </label>

                            </div>

                            <!-- /section:settings.rtl -->

                            <!-- #section:settings.container -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container"/>
                                <label class="lbl" for="ace-settings-add-container">
                                    小页面
                                </label>
                            </div>

                            <!-- /section:settings.container -->
                        </div><!-- /.pull-left -->

                        <div class="pull-left width-50">
                            <!-- #section:basics/sidebar.options -->
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover"/>
                                <label class="lbl" for="ace-settings-hover"> 子菜单选择 </label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact"/>
                                <label class="lbl" for="ace-settings-compact"> 收起菜单 </label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight"/>
                                <label class="lbl" for="ace-settings-highlight"> 高亮选中 </label>
                            </div>

                            <!-- /section:basics/sidebar.options -->
                        </div><!-- /.pull-left -->
                    </div><!-- /.ace-settings-box -->
                </div><!-- /.ace-settings-container -->

                <!-- /section:settings.box -->
                <!-- <div class="page-content-area" data-ajax-content="true" ng-view> -->
                <div class="page-content-area" ng-view>
                    <div butterbar class="text-center" style="margin-top: 20%;">
                        <h1>Loading...</h1>
                        <small>（加载中）</small>
                    </div>
                </div><!-- /.page-content-area -->
            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->

    <div class="footer">
        <div class="footer-inner">
            <!-- #section:basics/footer -->
            <!--<div class="footer-content">
                <span class="bigger-120">
                    <span class="blue bolder">Ace</span>
                    Application &copy; 2013-2014
                </span>

                &nbsp; &nbsp;
                <span class="action-buttons">
                    <a href="#">
                        <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                    </a>

                    <a href="#">
                        <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                    </a>
                </span>
            </div>-->

            <!-- /section:basics/footer -->
        </div>
    </div>

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
</shiro:authenticated>
<!-- basic scripts -->


<!-- basic scripts -->

<!--[if !IE]> -->
<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery.js'>" + "<" + "/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='assets/js/jquery1x.js'>" + "<" + "/script>");
</script>
<![endif]-->
<script type="text/javascript">
    if ('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.js'>" + "<" + "/script>");
</script>
<script src="assets/js/bootstrap.js"></script>

<!-- ace scripts -->
<script src="assets/js/ace/elements.scroller.js"></script>
<script src="assets/js/ace/elements.colorpicker.js"></script>
<script src="assets/js/ace/elements.fileinput.js"></script>
<script src="assets/js/ace/elements.typeahead.js"></script>
<script src="assets/js/ace/elements.wysiwyg.js"></script>
<script src="assets/js/ace/elements.spinner.js"></script>
<script src="assets/js/ace/elements.treeview.js"></script>
<script src="assets/js/ace/elements.wizard.js"></script>
<script src="assets/js/ace/elements.aside.js"></script>
<script src="assets/js/ace/ace.js"></script>
<!--<script src="assets/js/ace/ace.ajax-content.js"></script>-->
<script src="assets/js/ace/ace.touch-drag.js"></script>
<script src="assets/js/ace/ace.sidebar.js"></script>
<script src="assets/js/ace/ace.sidebar-scroll-1.js"></script>
<script src="assets/js/ace/ace.submenu-hover.js"></script>
<script src="assets/js/ace/ace.widget-box.js"></script>
<script src="assets/js/ace/ace.settings.js"></script>
<script src="assets/js/ace/ace.settings-rtl.js"></script>
<script src="assets/js/ace/ace.settings-skin.js"></script>
<script src="assets/js/ace/ace.widget-on-reload.js"></script>
<script src="assets/js/ace/ace.searchbox-autocomplete.js"></script>

<!--		statistics View			-->
<script src="vendor/echars/echarts.js"></script>
<script src="vendor/echars/echarts.min.js"></script>

<!-- AngulerJs -->
<script src="vendor/angular/extend/angular.js"></script>

<!-- AngulerJs bootstrap -->
<script src="vendor/angular/angular-animate/angular-animate.js"></script>
<script src="vendor/angular/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="vendor/angular/angular-sanitize/angular-sanitize.js"></script>

<!-- RestAngular-->
<script src="vendor/angular/extend/restangular.js"></script>
<script src="vendor/angular/extend/underscore-min.js"></script>
<script src="vendor/angular/angular-resource/angular-resource.min.js"></script>
<script src="vendor/angular/angular-fileserver/FileSaver.js"></script>
<script src="vendor/angular/angular-fileserver/Blob.js"></script>

<!-- route -->
<script src="vendor/angular/extend/angular-route.min.js"></script>

<!-- App -->
<script src="app/app.js"></script>
<script src="app/config/router.js"></script>
<script src="app/config/restangular.js"></script>
<script src="app/config/clientservice.js"></script>
<script src="app/directives/baidu-map.js"></script>
<script src="app/controllers/head.js"></script>
<script src="app/controllers/menus.js"></script>
<script src="app/controllers/index.js"></script>
<script src="app/controllers/transportorder.js"></script>

</body>
</html>
