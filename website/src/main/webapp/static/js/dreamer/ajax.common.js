$(document).ajaxError(function (event, req, setting, msg) {
    if (typeof console != undefined && console && console.log) {
        console.log(event);
        console.log(req);
        console.log(setting);
        console.log(msg);
    }
});

function getJson(url, data, success) {
    $.ajax({
        url: globalRootUrl + appendRandom(url),
        type: 'get',
        data: JSON.stringify(data || {}),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
            if (success) success(response);
        }
    });
}

function appendRandom(url) {
    var r = "r=" + Math.random();
    if (url.lastIndexOf('?') > 0) {
        return url + "&" + r;
    }
    return url + "?" + r;
}

function postJson(url, data, success, withGlobal) {
    $.ajax({
        url: !!withGlobal ? url : globalRootUrl + url,
        type: 'post',
        data: JSON.stringify(data || {}),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
            if (success) success(response);
        }
    });
}

function post(url, data, success) {
    $.ajax({
        url: globalRootUrl + url,
        type: 'post',
        data: JSON.stringify(data || {}),
        contentType: "application/json",
        success: function (response) {
            if (success) success(response);
        }
    });
}

function postPage(url, data, success) {
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        param: JSON.stringify(data || {}),
        success: function (response) {
            if (success) success(response);
        }
    });
}