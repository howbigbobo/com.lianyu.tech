<div class="row">

    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("aboutus.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("aboutus.secondSubHead")!} </h2>

        <div class="twelve columns">
            <div class="section-divider testimonial-margin">
                <img src="<@url value='/static/css/dreamer/images/crown.png'/>" alt="Read More About Us">
            </div>
        </div>
    </div>

    <div class="four columns about mobile-three-one">
        <img src="<@url value='/static/css/dreamer/images/about-us/1.png'/>" alt="${config.get(" aboutus.secondHead")!}">

        <h3 class="about-us-title">${config.get("aboutus.mission")!}</h3>

        <p class="about-us-text">${config.get("aboutus.missionContent")!}</p>

    </div>

    <div class="four columns about mobile-three-one">
        <img src="<@url value='/static/css/dreamer/images/about-us/2.png'/>" alt="About US">

        <h3 class="about-us-title">${config.get("aboutus.skill")!}</h3>

        <p class="about-us-text">${config.get("aboutus.skillContent")!}</p>
    </div>

    <div class="four columns about mobile-three-one">
        <img src="<@url value='/static/css/dreamer/images/about-us/3.png'/>" alt="About US">

        <h3 class="about-us-title">${config.get("aboutus.client")!}</h3>

        <p class="about-us-text">${config.get("aboutus.clientContent")!}</p>
    </div>

    <div class="twelve columns page-section hide-for-760">
        <p>${config.get("aboutus.thirdHead")!}</p>

        <h2 class="page-subtitle">${config.get("aboutus.thirdSubhead")!}
        </h2>
    </div>

    <div class="twelve columns hide-for-760">
        <div class="section-divider">
            <img src="<@url value='/static/css/dreamer/images/crown.png'/>" alt='${config.get("aboutus.thirdHead")!}'>
        </div>
    </div>

    <div class="twelve columns hide-for-760">
        <p class="about-us-text">${config.get("aboutus.thirdContent")!}</p>

        <p class="about-us-text">&nbsp;</p>
    </div>
</div>