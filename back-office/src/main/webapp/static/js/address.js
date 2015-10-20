function edit(addressId) {
    if (!addressId) return;
    getJson('address/' + addressId, {}, function (address) {
        openModal({title: "编辑地址", address: address});
    });
}

function add() {
    openModal({title: "添加新地址", address: {}});
}

function openModal(obj) {
    var html = template('template-address-edit', obj);
    $('#modal-address-edit-container').html(html);
    $('#modal-address-edit').modal();
}

function save() {
    var data = $('#address_form').formData();
    post('address/save', data, function () {
        $('#modal-address-edit').modal('hide');
        $.alert('保存成功', function () {
            location.reload();
        });
    });
}

function deleteAddress(addressId) {
    if (!addressId) return;
    $.confirm("确定删除这个地址吗？", function () {
        post('address/delete/' + addressId, {}, function () {
            $.alert('删除成功', function () {
                location.reload();
            });
        });
    });
}