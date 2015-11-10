<@master template="master/master">
<#list configGroups as group>
    <div class="row-fluid sortable ui-sortable">
        <div class="box span12">
            <div class="box-header" data-original-title="">
                <h2><i class="halflings-icon edit"></i><span class="break"></span>${group.name!}</h2>

                <div class="box-icon">
                    <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                </div>
            </div>
            <div class="box-content" style="display: block;">
                <form class="form-horizontal systemConfig" group="${group.group}">
                    <fieldset>
                        <#list group.keys as key>
                            <div class="control-group success">
                                <label class="control-label">${key.name}</label>

                                <div class="controls">
                                    <input type="text" name="${key.fullKey}" class="large" value="${(config.get(key.fullKey))!}">
                                </div>
                            </div>
                        </#list>
                        <div class="form-actions">
                            <button type="button" class="btn btn-primary" onclick="saveSystemConfig(this); return false;"> &nbsp;保 &nbsp;&nbsp;存&nbsp;&nbsp;</button>
                            <label class="label-warning" class="message"></label>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
        <!--/span-->
    </div>
</#list>
</@master>
<@js src = "systemconfig.js"/>