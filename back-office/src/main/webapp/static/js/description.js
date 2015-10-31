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

        listItems();
    }
});

function listItems() {
    postJson('description/item/list/' + descriptionId(), {}, function (response) {
        if (response && response.items && response.items.length > 0) {
            addExistItem(response);
        }
        else {
            newItemContainer();
        }
    });
}

function saveItem(ctrl) {
    var form = $(ctrl).closest(".description-item");
    var data = form.formData();
    post('description/item/update', data, function () {
        $.alert('保存成功');
    });
}

function updateItemOrder(ctrl, order) {
    var parent = $(ctrl).closest('.description-item');
    var swap = order > 0 ? parent.next('.description-item') : parent.prev('.description-item');
    if (swap.length == 0) return;

    var currentOrder = formOrder(parent) + (order > 0 ? 1 : -1);
    var swapOrder = formOrder(swap) + (order > 0 ? -1 : 1);
    formOrder(parent, currentOrder);
    formOrder(swap, swapOrder);
    var itemId = formItemId(parent);
    var itemSwapId = formItemId(swap);
    var itemUpdated = itemId ? false : true;
    var swapUpdated = itemSwapId ? false : true;
    if (!itemUpdated) {
        ajaxUpdateOrder(itemId, currentOrder, function () {
            itemUpdated = true;
            if (itemUpdated && swapUpdated) updatePosition();
        });
    }
    if (!swapUpdated) {
        ajaxUpdateOrder(itemSwapId, swapOrder, function () {
            swapUpdated = true;
            if (itemUpdated && swapUpdated) updatePosition();
        });
    }
}

function ajaxUpdateOrder(id, order, succee) {
    post('description/item/' + id + '/order/' + order, {}, succee);
}

function deleteItem(ctrl) {
    var parent = $(ctrl).closest('.description-item');
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

        initInputFile(form);
    }
}

function initInputFile(form) {
    var saveButton = $(form).find('.item-save');
    var inputFiles = $(form).find('input[type=file][name=image]');
    inputFiles.uniform();
    inputFiles.fileupload({
        dataType: 'json',
        add: function (e, data) {
            data.context = saveButton.removeAttr("onclick").click(function () {
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
            console.log(data.result);
            data.context.closest('.description-item').remove();
            addExistItem(data.result);
        }
    });
}

function addExistItem(responseList) {
    var html = templateItemCompiler(responseList);
    $('#description-item-container').append(html);
    updatePosition();
    initInputFile($('#description-item-container'));
}

function updatePosition() {
    var container = $('#description-item-container');
    var forms = container.find(".description-item");
    forms.sort(function (f1, f2) {
        var order1 = formOrder(f1);
        var order2 = formOrder(f2);
        return order1 - order2;
    });
    for (var i = 0; i < forms.length; i++) {
        container.append(forms[i]);
    }
}

function formOrder(form, order) {
    if (typeof order === "undefined") return parseInt($(form).find('input[name=displayOrder]').val() || 0);
    $(form).find('input[name=displayOrder]').val(order);
    return order;
}

function formItemId(form) {
    return parseInt($(form).find('input[name=id]').val() || 0);
}

function saveAllItem() {
    $.alert('还没实现  (⊙﹏⊙)b');
}