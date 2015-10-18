$(document).ajaxError(function (event, req, setting, msg) {
    console.log(event);
    console.log(req);
    console.log(setting);
    console.log(msg);
});

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