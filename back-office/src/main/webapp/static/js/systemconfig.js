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

function addGroup() {
    var emptyData = {configGroups: [{name: "", text: "", order: 0, keys: []}]};
    var html = template("template-config-group", emptyData);
    $('#system-config-groups').append(html);
    console.log(html);
}

function addConfigKey(ctrl) {
    var html = template("template-config-key", {});
    $(ctrl).closest('.systemConfig').find('.control-group:last').after(html);
}