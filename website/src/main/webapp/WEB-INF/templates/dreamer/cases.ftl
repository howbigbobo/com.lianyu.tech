<div class="row">

    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("cases.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("cases.secondSubHead")!} </h2>

        <div class="twelve columns">
            <div class="section-divider testimonial-margin">
                <img src="<@url value='/static/css/dreamer/images/crown.png'/>" alt="Read More About Us">
            </div>
        </div>
    </div>

    <div class="twelve columns portfolio" id="cases-content">
        <#assign descriptionVos = cases/>
        <#assign pageNumber = 1/>
        <#include "cases.item.ftl"/>
    </div>

    <#import "pager.ftl" as page>
        <#if casePageCount?? && casePageCount gt 1>
            <@page.pager pageNumber=casePageCount pageUrl="/d/cases" callback="loadCases"/>
        </#if>
</div>
