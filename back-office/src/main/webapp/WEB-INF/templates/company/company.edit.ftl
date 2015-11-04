<@master template="master/master">
<div class="row-fluid sortable" pageName="company-edit">
    <div class="box span12">
        <div class="box-content">
            <form class="form-horizontal" id="company_form">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label" for="company_name">公司名称</label>

                        <div class="controls">
                            <input type="hidden" id="company_id" name="id" value="${(company.id)!}">
                            <input type="text" class="input-large" id="company_name" name="name" value="${(company.name)!}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="company_slogan">公司理念</label>

                        <div class="controls">
                            <input type="text" class="input-large" id="company_slogan" name="slogan" value="${(company.slogan)!}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="company_leadDescription">引导语(简要描述)</label>

                        <div class="controls">
                            <input type="text" class="input-large" id="company_leadDescription" name="leadDescription" value="${(company.leadDescription)!}">
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="company_description">公司描述</label>

                        <div class="controls">
                            <textarea id="company_description" name="description" class="input-large" rows="3">${(company.description)!}</textarea>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="company_logo_url">图标url</label>

                        <div class="controls">
                            <input type="text" class="input-large" id="company_logo_url" name="logoUrl" value="${(company.logoUrl)!}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="company_domain">域名地址</label>

                        <div class="controls">
                            <input type="text" class="input-large" id="company_domain" name="domain" value="${(company.domain)!}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary" onclick="saveCompanyInfo();return false;">保存
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <!--/span-->

</div><!--/row-->
</@master>
<@js src = "company.js"/>