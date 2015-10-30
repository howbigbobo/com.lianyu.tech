<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header" data-original-title="">
            <h2><i class="halflings-icon edit"></i><span class="break"></span>详细</h2>

            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content">
            <div id="description-item-container">

            </div>
            <form class="form-horizontal box-content">
                <fieldset>
                    <div class="form-actions">
                        <button type="button" class="btn btn-success" onclick="newItemContainer(); return false;"> &nbsp;继续添加&nbsp;&nbsp;</button>
                        &nbsp;&nbsp;
                        <button type="button" class="btn btn-primary" onclick="saveDescription(); return false;"> &nbsp;全部保存&nbsp;&nbsp;</button>
                        <label class="label-warning" id="description-message"></label>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>
    <!--/span-->
</div>
<script type="text/html" id="template-description-item-edit">
    {{each items as item}}
    <form class="form-horizontal description-item" action="<@url value='/description/item/save'/>" method="post" enctype="multipart/form-data">
        <fieldset>
            <input type="hidden" name="id" value="{{item.id}}"/>
            <input type="hidden" name="displayOrder" value="{{item.displayOrder}}"/>
            <input type="hidden" name="origin-displayOrder" value="{{item.displayOrder}}"/>
            <input type="hidden" name="descriptionId" value="{{item.descriptionId}}"/>
            <input type="hidden" name="imageId" value="{{item.imageId}}"/>

            <div class="control-group success">
                <label class="control-label">图片</label>

                <div class="controls image-control">
                    {{if item.imageUrl}}
                    <img src="{{item.imageUrl}}" alt="" style="width: 200px;height: 200px;"/>
                    {{else}}
                    <div class="uploader">
                        <input type="file" name="image" multiple="">
                    </div>
                    {{/if}}
                </div>
            </div>
            <div class="control-group success">
                <label class="control-label">描述</label>

                <div class="controls">
                    <textarea name="content" class="large" rows="1"/></textarea>
                            <span class="help-inline">
                                <a href="javascript:;" class="item-save" title="保存"><i class="halflings-icon ok"></i></a>
                                <a href="javascript:;" onclick="updateItemOrder(this,-1);" title="上移"><i class="halflings-icon arrow-up"></i></a>
                                <a href="javascript:;" onclick="updateItemOrder(this,1);" title="下移"><i class="halflings-icon arrow-down"></i></a>
                                <a href="javascript:;" onclick="deleteItem(this);" title="删除"><i class="halflings-icon trash"></i></a>
                            </span>
                </div>
            </div>
        </fieldset>
    </form>
    {{/each}}
</script>