<div class="row">
    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("contact.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("contact.secondSubHead")!}</h2>

        <div class="twelve columns">
            <div class="section-divider testimonial-margin">
                <img src="<@url value='/static/css/dreamer/images/crown.png'/>" alt="Read More About Us">
            </div>
        </div>
    </div>
</div>

<div class="row" style="margin-bottom: 50px;">

    <div class="twelve columns contact">
        <div id="contact-slider1">
        <#assign contactsCount = 0/>
        <#assign streeetCount = 0/>
        <#if contacts?? && contacts.contacts??>
            <#assign contactsCount = contacts.contacts?size/>
        </#if>
        <#if address?? &&address.defaultAddress??>
            <div class="six columns first-column mobile-two contact-margin">
                <h3 class="contact-title">公司地址</h3>

                <div class="contact-image hide-for-760">
                    <div class="contact-divider-top"></div>
                    <img src="<@url value='/static/css/dreamer/images/los-angeles.jpg'/>" alt="公司地址">

                    <div class="contact-divider-bottom"></div>
                </div>
                <p class="contact-text">${(address.defaultAddress.province)!}${(address.defaultAddress.city)!}${(address.defaultAddress.region)!}</p>
                <#if address.defaultAddress.street??>
                    <p class="contact-text">${(address.defaultAddress.street)!}</p>
                    <#assign streeetCount = 1/>
                </#if>
                <p class="contact-text">${(address.defaultAddress.address)!}</p>
                <#assign pCount = contactsCount - 2 - streeetCount/>
                <#list 1..pCount as c>
                    <p class="contact-text">&nbsp;</p>
                </#list>
                <div class="contact-image">
                    <img src="<@url value='/static/img/wx.jpg'/>" alt="微信二维码" style="height: 200px;">
                </div>
            </div>
        </#if>
            <div class="six columns last-column mobile-two contact-margin">
                <h3 class="contact-title">联系方式</h3>

                <div class="contact-image hide-for-760">
                    <div class="contact-divider-top"></div>
                    <img src="<@url value='/static/css/dreamer/images/los-angeles.jpg'/>" alt="联系方式">

                    <div class="contact-divider-bottom"></div>
                </div>
            <#if contacts?? && contacts.contacts??>
                <#list contacts.contacts as contact>
                    <p class="contact-text"><span>${contact.type}</span> ${contact.value}</p>
                </#list>
            </#if>
                <div class="contact-image">
                    <img src="<@url value='/static/img/wx.jpg'/>" alt="微信二维码" style="height: 200px;">
                </div>
            </div>

        </div>

    </div>
</div>