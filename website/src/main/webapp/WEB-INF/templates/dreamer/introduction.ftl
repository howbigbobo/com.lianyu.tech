<div class="row">

    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("introduce.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("introduce.secondSubHead")!}</h2>
    </div>
    <#if introduces??>
        <#list introduces as introduce>
            <div class="three columns padding-four-columns team-member mobile-two">
                <img src="${(introduce.defaultItem.imageUrl)!}" alt="${(introduce.info.head)!}">

                <h3 class="our-team-title">${(introduce.info.head)!}</h3>

                <h3 class="our-team-subtitle">${(introduce.info.subhead)!}</h3>

                <div class="our-team-divider"></div>
                <p class="our-team-text">${(introduce.info.content)!}</p>

                <div class="team-hover">
                    <div class="team-social-media">
                        <a href="#" class="team-facebook"></a>
                        <a href="#" class="team-twitter"></a>
                        <a href="#" class="team-linkedin"></a>
                    </div>
                </div>
            </div>
        </#list>
    </#if>
    <div class="twelve columns page-section">
        <h1 class="page-title">${config.get("introduce.bottomHead")!}</h1>

        <h2 class="page-subtitle">${config.get("introduce.bottomSubHead")!}</span>
        </h2>
    </div>

    <div class="twelve columns">
        <div class="section-divider testimonial-margin">
            <img src="<@url value='/static/css/dreamer/images/crown.png'/>" alt="Read More About Us">
        </div>
    </div>

    <div class="twelve columns testimonial">

        <div class="four columns testimonial-date hide-for-small">
            <div class="nine columns">
                <div class="testimonial-day">${config.get("introduce.bottomNumber")!}</div>
            </div>
            <div class="three columns mobile-four">
                <div class="testimonial-month">${config.get("introduce.bottomSmallText")!}</div>
                <div class="testimonial-circle">${config.get("introduce.bottomRed")!}</div>
            </div>
        </div>

        <div class="six columns testimonial-content mobile-four">
            <div class="testimonial-content-inner">
                <h4 class="testimonial-title mobile-four">${config.get("introduce.bottomRightTitle")!}</h4>

                <p class="testimonial-content mobile-four">${config.get("introduce.bottomRightContent")!}</p>

                <p class="testimonial-signature mobile-four">${config.get("introduce.bottomRightSub")!}</p>
            </div>
        </div>

        <div class="two columns hide-for-small"></div>

    </div>

    <div class="twelve columns testimonial-bottom">

        <div class="two columns hide-for-small"></div>

        <div class="four columns testimonial-date hide-for-small">
            <div class="nine columns">
                <div class="testimonial-day">${config.get("introduce.bottomNumber2")!}</div>
            </div>
            <div class="three columns mobile-four">
                <div class="testimonial-month">${config.get("introduce.bottomSmallText2")!}</div>
                <div class="testimonial-circle">${config.get("introduce.bottomRed2")!}</div>
            </div>
        </div>

        <div class="six columns testimonial-content mobile-four">
            <div class="testimonial-content-inner">
                <h4 class="testimonial-title mobile-four">${config.get("introduce.bottomRightTitle2")!}</h4>

                <p class="testimonial-content mobile-four">${config.get("introduce.bottomRightContent2")!}</p>

                <p class="testimonial-signature mobile-four">${config.get("introduce.bottomRightSub2")!}</p>
            </div>
        </div>
    </div>
</div>