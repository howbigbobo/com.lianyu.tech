$(function () {
    initDescription();
});

function initDescription() {
    var url = $('#list-url').val();
    var type = $('#description-type').val();
    postPage($("#description-pagination"), url, {type: type}, function (response) {
        var html = template('template-description-list', response);
        $('#description-list').html(html);
    });
}