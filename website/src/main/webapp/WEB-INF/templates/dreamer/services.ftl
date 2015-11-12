<div class="row">
    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("services.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("services.secondSubHead")!}
        </h2>
    </div>
</div>

<div class="row">
    <div class="twelve columns services-top">
        <#list services as service>
            <div class="four columns services first-column mobile-two">
                <h3 class="services-title">${(service.info.head)!}</h3>

                <div class="services-image">
                    <div class="services-divider-top"></div>
                    <img src="${(service.defaultItem.imageUrl)!}" alt="${(service.info.head)!}">

                    <div class="services-divider-bottom"></div>
                </div>
                <p class="services-text">${(service.info.content)!}</p>
            </div>
        </#list>
    </div>
</div>