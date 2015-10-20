<@master template="master/master">
<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header">
            <h2><i class="halflings-icon align-justify"></i><span class="break"></span>联系方式列表</h2>
        </div>
        <div class="box-content">
            <table class="table table-bordered table-striped table-condensed">
                <thead>
                <tr>
                    <th>联系类型</th>
                    <th>联系方式</th>
                    <th>显示顺序</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list contacts as contact>
                    <tr>
                        <td>
                            ${(contact.type)!}
                        </td>
                        <td class="center">${(contact.value)!}</td>
                        <td class="center">${(contact.displayOrder)!}</td>
                        <td class="center">
                            <a class="btn btn-info" href="javascript:" onclick="edit(${(contact.id)!});">
                                <i class="halflings-icon white edit"></i>
                            </a>
                            <a class="btn btn-danger" href="javascript:" onclick="deleteContact(${(contact.id)!});">
                                <i class="halflings-icon white trash"></i>
                            </a>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>

            <div class="box-icon">
                <a class="btn btn-primary" href="javascript:" onclick="add();"> 添加 </a>
            </div>
        </div>
    </div>
    <!--/span-->
</div>
<#include "./contact.edit.ftl"/>
</@master>
<@js src="contact.js"/>