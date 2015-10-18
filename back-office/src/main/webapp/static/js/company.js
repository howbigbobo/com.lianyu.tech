function saveCompanyInfo() {
    var data = $('#company_form').formData();
    post('company/save', data);
}
