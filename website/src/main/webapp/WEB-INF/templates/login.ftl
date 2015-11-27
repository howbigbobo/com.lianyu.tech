<!DOCTYPE html>
<html lang="en">
<head>
    <title>网站预览登录</title>
    <script>
        var globalRootUrl = "<@url value='/'/>";
    </script>
    <style type="text/css">
        body {
            font-size: 20px;
            line-height: 20px;
        }

        fieldset {
            border: none;
        }

        .container-fluid-full {
            margin: 150px auto;
            text-align: center;
        }

        .input-prepend {
            padding-top: 10px;
        }

        input {
            height: 20px;
        }

        button {
            margin-top: 20px;
            width: 75px;
            height: 35px;
        }
    </style>
</head>

<body>
<div class="container-fluid-full">
    <h2>预览登录</h2>

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
                <button type="submit" onclick="login();">登录</button>
            </div>
            <div class="clearfix"></div>
        </fieldset>
    </div>
</div>
<@js src="jquery-1.9.1.min.js"/>
<@js src="jquery.dialog.js"/>
<@js src="ajax.common.js"/>
<@js src="jquery.formdata.js"/>
<@js src="login.js"/>
</body>
</html>
