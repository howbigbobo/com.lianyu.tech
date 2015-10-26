<@master template="master/master">
<input type="hidden" id="description-type" value="${type}"/>
<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header" data-original-title="">
            <h2><i class="halflings-icon edit"></i><span class="break"></span>${descText}</h2>

            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content">
            <form class="form-horizontal">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label">标题</label>

                        <div class="controls">
                            <input type="text" id="description-head" name="head" class="large">
                            <span class="help-inline">(必填)</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">副标题</label>

                        <div class="controls">
                            <input type="text" id="description-subhead" name="subhead" class="large">
                            <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success">
                        <label class="control-label">开始时间</label>

                        <div class="controls">
                            <input type="text" class="input-xlarge datepicker hasDatepicker" id="description-beginTime" name="beginTime" value='${.now?string("yyyy-MM-dd")}'>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">结束时间</label>

                        <div class="controls">
                            <input type="text" class="input-xlarge datepicker hasDatepicker" id="description-endTime" name="endTime" value='${.now?string("yyyy-MM-dd")}'>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">地点</label>

                        <div class="controls">
                            <input type="text" id="description-location" name="location" class="large">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">详细描述</label>

                        <div class="controls">
                            <textarea id="description-content" name="content" cols="50" rows="5" class="large"></textarea>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Save changes</button>
                        <button class="btn">Cancel</button>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>
    <!--/span-->

</div>
<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header" data-original-title="">
            <h2><i class="halflings-icon edit"></i><span class="break"></span>Form Elements</h2>

            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
                <a href="#" class="btn-minimize"><i class="halflings-icon chevron-down"></i></a>
                <a href="#" class="btn-close"><i class="halflings-icon trash"></i></a>
            </div>
        </div>
        <div class="box-content">
            <form class="form-horizontal">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label" for="inputSuccess">Input with success</label>

                        <div class="controls">
                            <input type="text" id="inputSuccess">
                            <span class="help-inline">Woohoo!</span>
                        </div>
                    </div>


                    <div class="form-actions">
                        <button type="submit" class="btn btn-primary">Save changes</button>
                        <button class="btn">Cancel</button>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>
    <!--/span-->

</div>
</@master>