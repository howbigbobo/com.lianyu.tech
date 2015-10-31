<@master template="master/master">
<input type="hidden" id="description-type" value="${type}"/>
<input type="hidden" id="description-id" value="${descriptionId!}"/>
<a href="<@url value='/description/${type}'/>" class="btn">返回</a>
<br/><br/>
<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header" data-original-title="">
            <h2><i class="halflings-icon edit"></i><span class="break"></span>${descText}</h2>

            <div class="box-icon">
                <a href="#" class="btn-minimize"><i class="halflings-icon chevron-up"></i></a>
            </div>
        </div>
        <div class="box-content">
            <form class="form-horizontal" id="description-form">
                <fieldset>
                    <div class="control-group success">
                        <label class="control-label">标题</label>

                        <div class="controls">
                            <input type="text" id="description-head" name="head" class="large" value="${(description.head)!}">
                            <span class="help-inline">(必填)</span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">副标题</label>

                        <div class="controls">
                            <input type="text" id="description-subhead" name="subhead" class="large" value="${(description.subhead)!}">
                            <span class="help-inline"></span>
                        </div>
                    </div>

                    <div class="control-group success">
                        <label class="control-label">开始时间</label>

                        <div class="controls">
                            <input type="text" class="input-xlarge datepicker hasDatepicker" id="description-beginTime" name="beginTime"
                            <#if description??&&description.beginTime??> value = '${description.beginTime?string("yyyy-MM-dd")}'
                            </#if>
                            />
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">结束时间</label>

                        <div class="controls">
                            <input type="text" class="input-xlarge datepicker hasDatepicker" id="description-endTime" name="endTime"
                            <#if description??&&description.endTime??> value = '${description.endTime?string("yyyy-MM-dd")}'
                            </#if>
                            />
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">地点</label>

                        <div class="controls">
                            <input type="text" id="description-location" name="location" class="large" value="${(description.location)!}">
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="control-group success">
                        <label class="control-label">详细描述</label>

                        <div class="controls">
                            <textarea id="description-content" name="content" cols="50" rows="5" class="large">${(description.content)!}</textarea>
                            <span class="help-inline"></span>
                        </div>
                    </div>
                    <div class="form-actions">
                        <button type="button" class="btn btn-primary" onclick="saveDescription(); return false;"> &nbsp;保 &nbsp;&nbsp;存&nbsp;&nbsp;</button>
                        <label class="label-warning" id="description-message"></label>
                    </div>
                </fieldset>
            </form>

        </div>
    </div>
    <!--/span-->
</div>
<#if description??>
    <#include "description.item.edit.ftl"/>
</#if>
</@master>
<@js src="plugin/jquery.fileupload/vendor/jquery.ui.widget.js"/>
<@js src="plugin/jquery.fileupload/jquery.iframe-transport.js"/>
<@js src="plugin/jquery.fileupload/jquery.fileupload.js"/>

<@js src = "description.js"/>