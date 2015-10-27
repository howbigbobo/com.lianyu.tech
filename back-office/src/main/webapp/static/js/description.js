function getType() {
    return $('#description-type').val();
}

function descriptionId(id) {
    if (id) $('#description-id').val(id);
    return $('#description-id').val();
}

function descriptionMessage(msg) {
    $('#description-message').text(msg);
}

function saveDescription() {
    var data = $('#description-form').formData();
    data.id = descriptionId();
    data.type = getType();

    descriptionMessage("");
    post("description/save", data, function (id) {
        descriptionId(id);
        descriptionMessage("保存成功");
        if (!data.id && id) {
            location.href = globalRootUrl + "description/" + getType() + "/edit/" + id;
        }
    });

    return false;
}