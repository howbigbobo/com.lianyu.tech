<@master template="master/master">
<div class="row-fluid sortable">
    <div class="box span12">
        <div id="progress">
            <div class="bar" style="width: 12%;"></div>
        </div>
        <div class="box-content">
            <form class="form-horizontal" id="image-form" action="<@url value='/image/save'/>" method="post" enctype="multipart/form-data">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label" for="image-description">图片描述</label>

                        <div class="controls">
                            <input type="text" id="image-description" name="description" value="">
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">图片</label>

                        <div class="controls">
                            <input type="file" name="image" id="image-pic" multiple="">
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label"> </label>

                        <div class="controls" id="image-container">

                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">保存
                        </button>
                    </div>
                </fieldset>
            </form>
        </div>
    </div>

    <!--/span-->
    <style type="text/css">
        .bar {
            height: 18px;
            background: green;
        }
    </style>
</div><!--/row-->
</@master>
<@js src="plugin/jquery.fileupload/vendor/jquery.ui.widget.js"/>
<@js src="plugin/jquery.fileupload/jquery.iframe-transport.js"/>
<@js src="plugin/jquery.fileupload/jquery.fileupload.js"/>
<@js src="image.demo.js"/>