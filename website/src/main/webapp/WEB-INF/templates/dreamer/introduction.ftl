<div class="row">

    <div class="twelve columns page-content">
        <h1 class="page-title">公司简介</h1>

        <h2 class="page-subtitle">${company.slogan}</h2>
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
        <h1 class="page-title">Testimonials</h1>

        <h2 class="page-subtitle">We’re fortunate to work with <span>fantastic clients</span><br>from across the globe in over <span>11 countries</span> on design, branding, and <span>development projects.</span>
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
                <div class="testimonial-day">17</div>
            </div>
            <div class="three columns mobile-four">
                <div class="testimonial-month">JANUARY</div>
                <div class="testimonial-circle">th</div>
            </div>
        </div>

        <div class="six columns testimonial-content mobile-four">
            <div class="testimonial-content-inner">
                <h4 class="testimonial-title mobile-four">Testimonial Title Goes Here</h4>

                <p class="testimonial-content mobile-four">Habitasse pulvinar elit magnis tritue elementum auctor placerat sit ut cu auctor. Ac egestas mauris proin! Elementum auctor placerat
                    sit. Habitasse pulvinar elit magnis tritue elementum.</p>

                <p class="testimonial-signature mobile-four">Anna McDonald<span> Executive Manager at Pepsi</span></p>
            </div>
        </div>

        <div class="two columns hide-for-small"></div>

    </div>

    <div class="twelve columns testimonial-bottom">

        <div class="two columns hide-for-small"></div>

        <div class="four columns testimonial-date hide-for-small">
            <div class="nine columns">
                <div class="testimonial-day">14</div>
            </div>
            <div class="three columns mobile-four">
                <div class="testimonial-month">JANUARY</div>
                <div class="testimonial-circle">th</div>
            </div>
        </div>

        <div class="six columns testimonial-content mobile-four">
            <div class="testimonial-content-inner">
                <h4 class="testimonial-title mobile-four">Testimonial Title Goes Here</h4>

                <p class="testimonial-content mobile-four">Habitasse pulvinar elit magnis tritue elementum auctor placerat sit ut cu auctor. Ac egestas mauris proin! Elementum auctor placerat
                    sit. Habitasse pulvinar elit magnis tritue elementum.</p>

                <p class="testimonial-signature mobile-four">Anna McDonald<span> Executive Manager at Pepsi</span></p>
            </div>
        </div>
    </div>
</div>