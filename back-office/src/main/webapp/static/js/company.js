function saveCompanyInfo() {
    var data = $('#company_form').formData();
    post('company/save', data, function (id) {
        $('#company_id').val(id);
        $.alert('保存成功');
    });
}
