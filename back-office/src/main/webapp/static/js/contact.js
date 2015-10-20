function edit(contactId) {
    if (!contactId) return;
    getJson('contact/' + contactId, {}, function (contact) {
        openModal({title: "编辑联系方式", contact: contact});
    });
}

function add() {
    openModal({title: "添加联系方式", contact: {}});
}

function openModal(obj) {
    var html = template('template-contact-edit', obj);
    $('#modal-contact-edit-container').html(html);
    $('#modal-contact-edit').modal();
}

function save() {
    var data = $('#contact_form').formData();
    post('contact/save', data, function () {
        $('#modal-contact-edit').modal('hide');
        $.alert('保存成功', function () {
            location.reload();
        });
    });
}

function deleteContact(contactId) {
    if (!contactId) return;
    $.confirm("确定删除这个联系方式吗？", function () {
        post('contact/delete/' + contactId, {}, function () {
            $.alert('删除成功', function () {
                location.reload();
            });
        });
    });
}