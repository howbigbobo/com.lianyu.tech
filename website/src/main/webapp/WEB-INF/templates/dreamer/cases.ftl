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
        <#if cases??>
            <ul class="ourHolder description-page-content page-1">
                <#list cases as case>
                    <li class="four columns item mobile-two" data-id="id-1" data-type="photography">
                        <div class="portfolio-item">
                            <div class="portfolio-hover-details hide-for-small">
                                <div class="open-portfolio">
                                    <a href="javascript:void(0);" class="open-portfolio-large"></a>
                                </div>
                            </div>
                            <a href="<@url value='/description/${(case.info.id)!}'/>" data-id="${(case.info.id)!}" title="${(case.info.head)!}" class="photo-link description-link">
                                <img src_lazy="${(case.defaultItem.imageThumbUrl)!}" src="<@url value='/static/css/dreamer/images/loader.gif'/>" alt="${(case.info.head)!}" class="wide-image">
                            </a>

                            <div class="portfolio-details">
                                <h4 class="portfolio-title"><a href="#">${(case.info.head)!}</a></h4>

                                <div class="portfolio-divider"></div>
                                <p class="portfolio-categories">${(case.info.subhead)!}</p>
                            </div>
                        </div>
                    </li>
                </#list>
            </ul>
        </#if>
    </div>
    <#import "pager.ftl" as page>
        <#if cases??>
            <@page.pager pageNumber=3 pageUrl="/a/b" callback="loadCases"/>
        </#if>
</div>
