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


/**************** item ************************************/

var templateItemCompiler = null;
$(function () {
    if ($('#template-description-item-edit').length > 0) {
        templateItemCompiler = template.compile(document.getElementById("template-description-item-edit").innerHTML);

        newItemContainer();
    }
});

function saveItem(ctrl) {

}

function updateItemOrder(ctrl, order) {
    var parent = $(ctrl).parents('.description-item');
}

function deleteItem(ctrl) {
    var parent = $(ctrl).parents('.description-item');
    var id = parent.find('input[type=hidden][name=id]').val();
    if (id) {
        $.confirm("确认删除吗？", function () {
            post('description/item/delete/' + id, {}, function () {
                parent.remove();
            });
        });
    } else {
        parent.remove();
    }
}

function newItemContainer() {
    if (templateItemCompiler != null) {
        var maxOrder = -1;
        $('#description-item-container').find('.description-item input[name=displayOrder]').each(function (i, e) {
            var o = $(e).val() || 0;
            maxOrder = maxOrder > o ? maxOrder : o;
        });
        maxOrder++;

        var res = {items: [{descriptionId: descriptionId(), displayOrder: maxOrder}]};
        var html = templateItemCompiler(res);

        $('#description-item-container').append(html);

        var form = $('#description-item-container').find(".description-item:last");
        var saveButton = form.find('.item-save');
        var inputFile = form.find('input[type=file][name=image]');
        inputFile.uniform();
        inputFile.fileupload({
            dataType: 'json',
            add: function (e, data) {
                data.context = saveButton.click(function () {
                    data.context = $('<span/>').text('Uploading...').replaceAll($(this));
                    data.submit();
                });
            },
            progress: function (e, data) {
                var progress = parseInt(data.loaded / data.total * 100, 10);
                $('.bar').css('width', progress + '%');
            },
            done: function (e, data) {
                data.context.text('Upload finished.');
                //$.each(data.result.files, function (index, file) {
                //    $('<p/>').text(file.name).appendTo($('#image-container'));
                //});
            }
        });
    }
}