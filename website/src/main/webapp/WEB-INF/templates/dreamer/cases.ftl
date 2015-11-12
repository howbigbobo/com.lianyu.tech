<div class="row">

    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("cases.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("cases.secondSubHead")!}
        </h2>
    </div>

    <div class="twelve columns portfolio-filter hide-for-760">
        <ul class="filterOptions">
            <li class="active"><a href="#" class="all"><img src="<@url value='/static/css/dreamer/images/icons/40px/123.png'/>" alt="All Projects"><span>All Projects</span></a></li>
            <li><a href="#" class="photography"><img src="<@url value='/static/css/dreamer/images/icons/40px/96.png'/>" alt="Photography"><span>Photography</span></a></li>
            <li><a href="#" class="website-design"><img src="<@url value='/static/css/dreamer/images/icons/40px/121.png'/>" alt="Website Design"><span>Website Design</span></a></li>
            <li><a href="#" class="branding"><img src="<@url value='/static/css/dreamer/images/icons/40px/155.png'/>" alt="Branding"><span>Branding</span></a></li>
            <li><a href="#" class="logo-design"><img src="<@url value='/static/css/dreamer/images/icons/40px/88.png'/>" alt="Logo Design"><span>Logo Design</span></a></li>
        </ul>
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
                                    src="${(case.defaultItem.imageUrl)!}"
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
