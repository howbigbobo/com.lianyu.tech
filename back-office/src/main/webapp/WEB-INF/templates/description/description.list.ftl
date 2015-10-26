<@master template="master/master">
<input type="hidden" id="description-type" value="${type}"/>
<input type="hidden" id="list-url" value="<@url value='/description/list'/>"/>

<div class="box span12">
    <div class="box-header">
        <h2><i class="halflings-icon align-justify"></i><span class="break"></span>列表</h2>
    </div>
    <div class="box-content">
        <table class="table table-bordered table-striped table-condensed">
            <thead>
            <tr>
                <th>标题</th>
                <th>副标题</th>
                <th>时间</th>
                <th>地点</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody id="description-list">
            </tbody>
        </table>
        <div>
            <div id="description-pagination" class="fr pagination">
            </div>
        </div>
        <div class="box-icon">
            <a class="btn btn-primary" href="javascript:" onclick="add();"> 添加 </a>
        </div>
    </div>
</div>

<script type="text/html" id="template-description-list">
    {{each descriptions as description}}
    <tr>
        <td>
            {{description.head}}
        </td>
        <td class="center"> {{description.subHead}}</td>
        <td class="center">{{description.beginTime | dateFormat('yyyy-MM-dd')}} - {{description.endTime | dateFormat('yyyy-MM-dd')}}</td>
        <td class="center">{{description.location}}</td>
        <td class="center">
            <a class="btn btn-info" href="javascript:" onclick="detail({{description.id}});">
                <i class="halflings-icon white zoom-in"></i>
            </a>
            <a class="btn btn-info" href="javascript:" onclick="edit({{description.id}});">
                <i class="halflings-icon white edit"></i>
            </a>
            <a class="btn btn-danger" href="javascript:" onclick="deleteDescription({{description.id}});">
                <i class="halflings-icon white trash"></i>
            </a>
        </td>
    </tr>
    {{/each}}
</script>
</@master>
<@js src = "description.js"/>