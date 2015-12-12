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
    
    <div class="twelve columns portfolio">
        <ul class="ourHolder">
            <#if cases??>
                <#list cases as case>
                    <li class="four columns item mobile-two" data-id="id-1" data-type="photography">
                        <div class="portfolio-item">
                            <div class="portfolio-hover-details hide-for-small">
                                <div class="open-portfolio">
                                    <a href="${(case.defaultItem.imageUrl)!}" class="open-portfolio-large" rel="prettyPhoto"></a>
                                    <a href="#" data-reveal-id="single-project-photo" class="open-portfolio-link"></a>
                                </div>
                            </div>
                            <a href="${(case.defaultItem.imageUrl)!}" class="photo-link" rel="prettyPhoto"><img
                                    src="${(case.defaultItem.imageThumbUrl)!}"
                                    alt="${(case.info.head)!}"
                                    class="wide-image"></a>

                            <div class="portfolio-details">
                                <h4 class="portfolio-title"><a href="#" data-reveal-id="single-project-photo">${(case.info.head)!}</a></h4>

                                <div class="portfolio-divider"></div>
                                <p class="portfolio-categories">${(case.info.subhead)!}</p>
                            </div>
                        </div>
                    </li>
                </#list>
            </#if>
        </ul>
    </div>

</div>
