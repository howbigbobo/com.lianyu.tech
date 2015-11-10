function saveSystemConfig(ctrl) {
    var $ctrl = $(ctrl);
    var data = $ctrl.closest('form.systemConfig').formData();

    var list = [];
    for (var k in data) {
        list.push({key: k, value: data[k]});
    }
    var obj = {keyValues: list};
    post('config/save', data, function () {
        $.alert('保存成功');
    });
}