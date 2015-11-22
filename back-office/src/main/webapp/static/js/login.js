function login() {
    var data = $('#login-form').formData();
    if (!data.name) {
        $.alert("请输入用户名");
        return;
    }
    if (!data.pwd) {
        $.alert("请输入密码");
        return;
    }
    if (!data.verifyCode) {
        $.alert("请输入验证码");
        return;
    }

    post("login", data, function () {
        location.href = globalRootUrl;
    });
}

function updateCode(img) {
    $(img).attr('src', globalRootUrl + "verify/code?r=" + (new Date().getTime()));
}