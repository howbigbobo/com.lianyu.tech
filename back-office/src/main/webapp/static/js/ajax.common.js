$(document).ajaxError(function (event, req, setting, msg) {
    console.log(event);
    console.log(req);
    console.log(setting);
    console.log(msg);
    alert('ajax error');
});

function getJson(url, data, success) {
    $.ajax({
        url: globalRootUrl + appendRadon(url),
        type: 'get',
        data: JSON.stringify(data || {}),
        contentType: "application/json",
        dataType: "json",
        success: function (response) {
            if (success) success(response);
        }
    });
}

function appendRadon(url) {
    var r = "r=" + Math.random();
    if (url.lastIndexOf('?') > 0) {
        return url + "&" + r;
    }
    return url + "?" + r;
}

function postJson(url, data, success) {
    $.ajax({
        url: globalRootUrl + url,
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