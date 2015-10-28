<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header" data-original-title="">
            <h2><i class="halflings-icon edit"></i><span class="break"></span>详细</h2>

            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content" id="description-item-container">
            <form class="form-horizontal description-item">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label">图片</label>

                        <div class="controls">
                            <div class="uploader" id="uniform-image-pic">
                                <input type="file" name="image" multiple="">
                                <span class="filename" style="-webkit-user-select: none;">No file selected</span>
                                <span class="action" style="-webkit-user-select: none;">Choose File</span>
                            </div>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">描述</label>

                        <div class="controls">
                            <textarea name="content" class="large" rows="1"/></textarea>
                            <span class="help-inline">
                                <a href="javascript:;" title="保存"><i class="halflings-icon ok"></i></a>
                                <a href="javascript:;" title="上移"><i class="halflings-icon arrow-up"></i></a>
                                <a href="javascript:;" title="下移"><i class="halflings-icon arrow-down"></i></a>
                                <a href="javascript:;" title="删除"><i class="halflings-icon trash"></i></a>
                            </span>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        <div class="form-horizontal box-content">
            <fieldset>
                <div class="form-actions">
                    <button type="button" class="btn btn-primary" onclick="saveDescription();"> &nbsp;全部保存&nbsp;&nbsp;</button>
                    <label class="label-warning" id="description-message"></label>
                </div>
            </fieldset>
        </div>
    </div>
    <!--/span-->
</div>

<script type="text/html" id="template-description-item-edit">
    <form class="form-horizontal description-item">
        <fieldset>
            <div class="control-group success">
                <label class="control-label">图片</label>

                <div class="controls">
                    <div class="uploader" id="uniform-image-pic">
                        <input type="file" name="image" multiple="">
                        <span class="filename" style="-webkit-user-select: none;">No file selected</span>
                        <span class="action" style="-webkit-user-select: none;">Choose File</span>
                    </div>
                </div>
            </div>
            <div class="control-group success">
                <label class="control-label">描述</label>

                <div class="controls">
                    <textarea name="content" class="large" rows="1"/></textarea>
                            <span class="help-inline">
                                <a href="javascript:;" title="保存"><i class="halflings-icon ok"></i></a>
                                <a href="javascript:;" title="上移"><i class="halflings-icon arrow-up"></i></a>
                                <a href="javascript:;" title="下移"><i class="halflings-icon arrow-down"></i></a>
                                <a href="javascript:;" title="删除"><i class="halflings-icon trash"></i></a>
                            </span>
                </div>
            </div>
        </fieldset>
    </form>
</script>