<@master template="master/master">
<div id="system-config-groups">

</div>
<div>
    <a href="javascript:;" onclick="addGroup();" class="btn btn-info">添加配置组</a>
</div>
<script type="text/html" id="template-config-group">
    {{each configGroups as group}}
    <div class="row-fluid sortable ui-sortable">
        <div class="box span12">
            <div class="box-header" data-original-title="">
                <h2><i class="halflings-icon edit"></i><span class="break"></span>{{group.text}}</h2>

                <div class="box-icon">
                    <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                </div>
            </div>
            <div class="box-content" style="display: block;">
                <form class="form-horizontal systemConfig" group="{{group.name}}">
                    <fieldset>
                        <div class="control-group">
                            <div class="controls">
                                <label class="control-label">英文名称</label>
                                <label class="control-label">中文显示</label>
                                <label class="control-label">顺序</label>
                            </div>
                        </div>
                        <div class="control-group error">
                            <div class="controls">
                                配置组：
                                {{if group.name}}
                                <input type="hidden" name="group-name" value="{{group.name}}">
                                <label class="control-label">{{group.name}}</label>
                                {{else}}
                                <input type="text" name="group-name" value="">
                                {{/if}}
                                <input type="text" name="group-text" value="{{group.text}}">
                                <input type="text" name="group-order" value="{{group.order}}">
                            </div>
                        </div>
                        {{each group.keys as key}}
                        <div class="control-group success">
                            <div class="controls ">
                                配置项：
                                <input type="hidden" name="key-name" value="{{key.name}}">
                                <label class="control-label">{{key.name}}</label>
                                <input type="text" name="key-text" value="{{key.text}}">
                                <input type="text" name="key-order" value="{{key.order}}">
                            </div>
                        </div>
                        {{/each}}
                        <div class="form-actions">
                            <a href="javascript:;" class="warning" onclick="addConfigKey(this);">添加配置项</a>
                            <button type="button" class="btn btn-primary" onclick="saveSystemConfigText(this); return false;"> &nbsp;保 &nbsp;&nbsp;存&nbsp;&nbsp;</button>
                            <label class="label-warning" class="message"></label>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
    {{/each}}
</script>
<script type="text/html" id="template-config-key">
    <div class="control-group success">
        <div class="controls ">
            配置项：
            <input type="text" name="key-name" value="">
            <input type="text" name="key-text" value="">
            <input type="text" name="key-order" value="0">
        </div>
    </div>
</script>

</@master>
<@js src = "systemconfig.js"/>