<#if descriptionVos??>
    <ul class="ourHolder description-page-content page-${pageNumber}">
        <#list descriptionVos as descriptionVo>
            <li class="four columns item mobile-two" data-id="id-1" data-type="photography">
                <div class="portfolio-item">
                    <div class="portfolio-hover-details hide-for-small">
                        <div class="open-portfolio">
                            <a href="javascript:void(0);" class="open-portfolio-large"></a>
                        </div>
                    </div>
                    <a href="<@url value='/description/${(descriptionVo.info.id)!}'/>" data-id="${(descriptionVo.info.id)!}" title="${(descriptionVo.info.head)!}" class="photo-link description-link">
                        <img src_lazy="${(descriptionVo.defaultItem.imageThumbUrl)!}" src="<@url value='/static/css/dreamer/images/loader.gif'/>" alt="${(descriptionVo.info.head)!}"
                             class="wide-image">
                    </a>

                    <div class="portfolio-details">
                        <h4 class="portfolio-title"><a href="#">${(descriptionVo.info.head)!}</a></h4>

                        <div class="portfolio-divider"></div>
                        <p class="portfolio-categories">${(descriptionVo.info.subhead)!}</p>
                    </div>
                </div>
            </li>
        </#list>
    </ul>
</#if>