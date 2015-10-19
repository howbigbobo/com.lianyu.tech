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

}

function deleteAddress(addressId) {
    if (!addressId) return;
}