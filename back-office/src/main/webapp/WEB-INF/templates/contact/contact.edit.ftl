<script type="text/html" id="template-contact-edit">
    <div class="modal hide fade" id="modal-contact-edit">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h3>{{title}}</h3>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" id="contact_form">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label" for="contactType">联系类型</label>

                        <div class="controls">
                            <input type="hidden" id="contactId" name="id" value="{{contact.id}}">
                            <input type="hidden" id="companyId" name="companyId" value="{{contact.companyId}}">
                            <select id="contactType" name="type">
                                <#list contactTypes as cType>
                                    <option value="${cType}"
                                            {{if contact.type=='${cType}'}}selected="selected"{{/if}}>${cType}
                                    </option>
                                </#list>
                            </select>
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="contactValue">联系方式</label>

                        <div class="controls">
                            <input type="text" id="contactValue" name="value" value="{{contact.value}}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="contactDisplayOrder">显示顺序</label>

                        <div class="controls">
                            <input type="number" id="contactDisplayOrder" name="displayOrder"
                                   value="{{contact.displayOrder}}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                </fieldset>
        </div>
        </form>
        <div class="modal-footer">
            <a href="javascript:;" class="btn" data-dismiss="modal">取消</a>
            <a href="javascript:;" class="btn btn-primary" onclick="save();">保存</a>
        </div>
    </div>
</script>
<div id="modal-contact-edit-container">
</div>