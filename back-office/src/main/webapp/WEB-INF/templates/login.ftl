<!DOCTYPE html>
<html lang="en">
<head>

    <#include "./master/head.ftl"/>

    <style type="text/css">
        body {
            background: url("<@url value= '/static/img/bg-login.jpg' />") !important;
        }
    </style>

</head>

<body>
<div class="container-fluid-full">
    <div class="row-fluid">

        <div class="row-fluid">
            <div class="login-box">

                <h2>登录</h2>

                <div class="form-horizontal" id="login-form">
                    <fieldset>
                        <div class="input-prepend" title="Username">
                            <span class="add-on"><i class="halflings-icon user"></i></span>
                            <input class="input-large span10" name="name" id="username" type="text" placeholder="用户名"/>
                        </div>
                        <div class="clearfix"></div>

                        <div class="input-prepend" title="Password">
                            <span class="add-on"><i class="halflings-icon lock"></i></span>
                            <input class="input-large span10" name="pwd" id="password" type="password" placeholder="密码"/>
                        </div>
                        <div class="clearfix"></div>
                        <div class="input-prepend" title="verify-code-image">
                            <img src="<@url value='/verify/code'/>?r=${.now?long}" onclick="updateCode(this);" alt="验证码"/>
                        </div>
                        <div class="clearfix"></div>
                        <div class="input-prepend" title="verify-code">
                            <span class="add-on"><i class="halflings-icon"></i></span>
                            <input class="input-large span10" name="verifyCode" id="verifyCode" type="text" placeholder="验证码"/>
                        </div>

                        <div class="clearfix"></div>

                        <div class="button-login">
                            <button type="submit" class="btn btn-primary" onclick="login();">登录</button>
                        </div>
                        <div class="clearfix"></div>
                </div>
                <hr>
            </div>
            <!--/span-->
        </div>
        <!--/row-->


    </div>
    <!--/.fluid-container-->

</div>
<!--/fluid-row-->

<!-- start: JavaScript-->

<#include "./master/js.ftl"/>
<@js src="login.js"/>
</body>
</html>
