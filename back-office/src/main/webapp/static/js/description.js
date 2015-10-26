$(function () {
    initDescription();
});

function getType() {
    return $('#description-type').val();
}

function initDescription() {
    var url = $('#list-url').val();
    var type = getType();
    postPage($("#description-pagination"), url, {type: type}, function (response) {
        var html = template('template-description-list', response);
        $('#description-list').html(html);
    });
}

function detail(id) {
    if (!id) return;
    location.href = globalRootUrl + "description/" + getType() + "/" + id;
}

function edit(id) {
    if (!id) return;
    location.href = globalRootUrl + "description/" + getType() + "/edit/" + id;
}

function deleteDescription(id) {
    if (!id) return;
    post("description/" + getType() + "delete", {}, function () {
        initDescription();
    });
}

function add() {
    location.href = globalRootUrl + "description/" + getType() + "/add";
}