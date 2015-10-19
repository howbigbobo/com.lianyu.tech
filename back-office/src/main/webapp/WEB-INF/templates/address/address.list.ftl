<@master template="master/master">
<div class="row-fluid sortable ui-sortable">
    <div class="box span12">
        <div class="box-header">
            <h2><i class="halflings-icon align-justify"></i><span class="break"></span>地址列表</h2>
        </div>
        <div class="box-content">
            <table class="table table-bordered table-striped table-condensed">
                <thead>
                <tr>
                    <th>省</th>
                    <th>市</th>
                    <th>区/县</th>
                    <th>街道</th>
                    <th>详细地址</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <#list addresses as address>
                    <tr>
                        <td>
                            ${(address.province)!}
                        </td>
                        <td class="center">${(address.city)!}</td>
                        <td class="center">${(address.region)!}</td>
                        <td class="center">
                            ${(address.street)!}
                        </td>
                        <td class="center">
                            ${(address.address)!}
                        </td>
                        <td class="center">
                            <a class="btn btn-info" href="javascript:" onclick="edit(${(address.id)!});">
                                <i class="halflings-icon white edit"></i>
                            </a>
                            <a class="btn btn-danger" href="javascript:" onclick="deleteAddress(${(address.id)!});">
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
<#include "./address.edit.ftl"/>
</@master>
<@js src="address.js"/>