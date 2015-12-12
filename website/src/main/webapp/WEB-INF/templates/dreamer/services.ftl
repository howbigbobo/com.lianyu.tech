<div class="row">
    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("services.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("services.secondSubHead")!} </h2>

        <div class="twelve columns">
            <div class="section-divider testimonial-margin">
                <img src="<@url value='/static/css/dreamer/images/crown.png'/>" alt="Read More About Us">
            </div>
        </div>
    </div>
</div>

<div class="row">
    <div class="twelve columns services-top">
        <#list services as service>
            <div class="four columns services first-column mobile-two">
                <h3 class="services-title">${(service.info.head)!}</h3>

                <div class="services-image">
                    <div class="services-divider-top"></div>
                    <img src="${(service.defaultItem.imageThumbUrl)!}" alt="${(service.info.head)!}">

                    <div class="services-divider-bottom"></div>
                </div>
                <p class="services-text">${(service.info.content)!}</p>
            </div>
        </#list>
    </div>
</div>