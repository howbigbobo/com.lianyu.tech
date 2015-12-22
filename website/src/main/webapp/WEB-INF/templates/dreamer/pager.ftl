<#macro pager pageNumber pageUrl callback>
    <#if pageNumber ?? && pageNumber gt 1>
        <#assign ulWidth = pageNumber * 100/>
        <div class="twelve columns portfolio-filter">
            <ul class="filterOptions" style="width:${ulWidth}px;">
                <#list 1..pageNumber as page>
                    <#assign active = ""/>
                    <#if page ==1>
                        <#assign active = "active"/>
                    </#if>
                    <li class="${active} page-number-li">
                        <a href="${pageUrl}?page=${page}" class="page-number" onclick="return ${callback}(this);" page="${page}">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/121.png'/>" alt="Website Design">
                            <span>${page}</span>
                        </a>
                    </li>
                </#list>
            </ul>
        </div>
    </#if>
</#macro>