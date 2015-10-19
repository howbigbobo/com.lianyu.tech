<script type="text/html" id="template-address-edit">
    <div class="modal hide fade" id="modal-address-edit">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">×</button>
            <h3>{{title}}</h3>
        </div>
        <div class="modal-body">
            <form class="form-horizontal" id="company_form">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label" for="addressProvince">省</label>

                        <div class="controls">
                            <input type="hidden" id="addressId" name="id" value="{{address.id}}">
                            <input type="hidden" id="companyId" name="companyId" value="{{address.companyId}}">
                            <input type="text" id="addressProvince" name="province" value="{{address.province}}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="addressCity">市</label>

                        <div class="controls">
                            <input type="text" id="addressCity" name="city" value="{{address.city}}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="addressRegion">区/县</label>

                        <div class="controls">
                            <input type="text" id="addressRegion" name="region" value="{{address.region}}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="addressStreet">街道</label>

                        <div class="controls">
                            <input type="text" id="addressStreet" name="street" value="{{address.street}}">
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label" for="addressRegion">详细地址</label>

                        <div class="controls">
                            <input type="text" id="addressAddress" name="address" value="{{address.address}}">
                            <span class="help-inline">（必填）</span>
                        </div>
                    </div>
                </fieldset>
        </div>
        </form>
        <div class="modal-footer">
            <a href="#" class="btn" data-dismiss="modal">取消</a>
            <a href="#" class="btn btn-primary" onclick="save();">保存</a>
        </div>
    </div>
</script>
<div id="modal-address-edit-container">
</div>