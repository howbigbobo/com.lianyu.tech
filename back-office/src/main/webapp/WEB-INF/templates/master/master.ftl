<!DOCTYPE html>
<html>
<head>
    <!-- start: Meta -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta charset="utf-8">
    <title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
    <meta name="description" content="Bootstrap Metro Dashboard">
    <meta name="author" content="lianyuchuanmei">
    <meta name="keyword"
          content="">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <@css id="bootstrap-style" href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <@css href="bootstrap-responsive.min.css" rel="stylesheet"type="text/css"/>
    <@css id="base-style" href="style.css" rel="stylesheet" type="text/css"/>
    <@css id="base-style-responsive" href="style-responsive.css" rel="stylesheet"type="text/css"/>
    <!-- end: CSS -->


    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <@js src="plugin/html5shiv.min.js"/>
    <@css id="ie-style" href="ie.css" rel="stylesheet" type="text/css"/>
    <![endif]-->

    <!--[if IE 9]>
    <@css id="ie9style" href="ie9.css" rel="stylesheet"/>
    <![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="<@url value='/static/img/favicon.ico'/>">
    <!-- end: Favicon -->
    <script type="text/javascript">
        globalRootUrl = "<@url value='/' />";
    </script>
</head>

<body>
<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse"
               data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="index.html"><span>Metro</span></a>

            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">
                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="halflings-icon white user"></i> Dennis Ji
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-title">
                                <span>Account Settings</span>
                            </li>
                            <li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
                            <li><a href="login.html"><i class="halflings-icon off"></i> Logout</a></li>
                        </ul>
                    </li>
                    <!-- end: User Dropdown -->
                </ul>
            </div>
            <!-- end: Header Menu -->

        </div>
    </div>
</div>
<!-- start: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li>
                        <a href="<@url value='/'/>">
                            <i class="icon-bar-chart"></i>
                            <span class="hidden-tablet"> 首页</span>
                        </a>
                    </li>
                    <li>
                        <a href="<@url value='/company'/>">
                            <i class="icon-tasks"></i>
                            <span class="hidden-tablet"> 公司信息</span>
                        </a>
                    </li>
                    <li>
                        <a href="<@url value='/address'/>">
                            <i class="icon-tasks"></i>
                            <span class="hidden-tablet"> 地址信息</span>
                        </a>
                    </li>
                    <li>
                        <a href="<@url value='/contact'/>">
                            <i class="icon-tasks"></i>
                            <span class="hidden-tablet"> 联系方式</span>
                        </a>
                    </li>
                    <li><a href="file-manager.html"><i class="icon-folder-open"></i><span class="hidden-tablet"> File Manager</span></a>
                    </li>
                    <li><a href="login.html"><i class="icon-lock"></i><span class="hidden-tablet"> Login Page</span></a>
                    </li>
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>

                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10">
            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="<@url value='/'/>">Home</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">Dashboard</a></li>
            </ul>

            <@body/>
            <!--/row-->
        </div>
        <!--/.fluid-container-->

        <!-- end: Content -->
    </div>
    <!--/#content.span10-->
</div>
<!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<div class="clearfix"></div>

<footer>

    <p>
        <span style="text-align:left;float:left">&copy; ${.now?string("yyyy")} <a
                href="javascript:void(0);" alt="">版权所有</a></span>
    </p>

</footer>

<!-- start: JavaScript-->

<@js src="plugin/jquery-1.9.1.min.js"/>
<@js src="plugin/jquery-migrate-1.0.0.min.js"/>

<@js src="plugin/jquery-ui-1.10.0.custom.min.js"/>

<@js src="plugin/jquery.ui.touch-punch.js"/>

<@js src="plugin/modernizr.js"/>

<@js src="plugin/bootstrap.min.js"/>

<@js src="plugin/jquery.cookie.js"/>

<@js src="plugin/fullcalendar.min.js"/>

<@js src="plugin/jquery.dataTables.min.js"/>

<@js src="plugin/excanvas.js"/>
<@js src="plugin/jquery.flot.js"/>
<@js src="plugin/jquery.flot.pie.js"/>
<@js src="plugin/jquery.flot.stack.js"/>
<@js src="plugin/jquery.flot.resize.min.js"/>

<@js src="plugin/jquery.chosen.min.js"/>

<@js src="plugin/jquery.uniform.min.js"/>

<@js src="plugin/jquery.cleditor.min.js"/>

<@js src="plugin/jquery.noty.js"/>

<@js src="plugin/jquery.elfinder.min.js"/>

<@js src="plugin/jquery.raty.min.js"/>

<@js src="plugin/jquery.iphone.toggle.js"/>

<@js src="plugin/jquery.uploadify-3.1.min.js"/>

<@js src="plugin/jquery.gritter.min.js"/>

<@js src="plugin/jquery.imagesloaded.js"/>

<@js src="plugin/jquery.masonry.min.js"/>

<@js src="plugin/jquery.knob.modified.js"/>

<@js src="plugin/jquery.sparkline.min.js"/>

<@js src="plugin/counter.js"/>

<@js src="plugin/retina.js"/>

<@js src="plugin/custom.js"/>
<!-- end: JavaScript-->
<@js src="plugin/template.js"/>
<@js src="plugin/template-helper.js"/>

<@js src="jquery.formdata.js"/>
<@js src="jquery.dialog.js"/>
<@js src="ajax.common.js"/>
</body>
</html>
