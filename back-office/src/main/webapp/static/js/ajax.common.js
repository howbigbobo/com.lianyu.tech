$(document).ajaxError(function (e) {
    alert(e);
});

function post(url, data, success) {
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