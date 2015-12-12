<!DOCTYPE html>
<!--[if IE 8]>
<html class="no-js lt-ie9" lang="zh-cmn"> <![endif]-->
<!--[if gt IE 8]>
<!-->
<html class="no-js" lang="zh-cmn"><!--<![endif]-->
<head>
    <meta charset="utf-8"/>

    <title>${company.name!}</title>
    <meta name="description" content="${company.slogan!}">

    <!-- Set the viewport width to device width for mobile -->
    <meta name="viewport" content="width=device-width"/>
    <meta name="HandheldFriendly" content="True">
    <meta name="MobileOptimized" content="320">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-touch-fullscreen" content="yes"/>

    <#include "mobile.spec.ftl"/>

    <#include "common.css.ftl"/>

    <script>
        var globalRootUrl = "<@url value='/'/>";
    </script>

</head>
<body>

<!-- Loader -->
<div id="loading">
    <img src="<@url value='/static/css/dreamer/images/loader.gif'/>" alt="Website Loader"/>
</div>

<!-- Slideshow Pattern & Overlay -->
<div class="slideshow-pattern"></div>
<div class="slideshow-overlay"></div>

<div class="triangle-top"></div>
<div class="triangle-bottom"></div>

<div class="header-container">

    <!-- Basic Needs -->
    <div class="row">

        <nav class="top-bar">

            <ul>
                <li class="name"><a href="#homepage"><img src="<@url value='/static/img/logo_full.png'/>" alt="${company.name}"></a></li>
            </ul>

            <section class="hide-for-small">
                <ul class="right">
                    <li><a href="#homepage">首页</a></li>
                    <li><a href="#introduction">公司简介</a></li>
                    <li><a href="#portfolio">成功案例</a></li>
                    <li><a href="#services">服务项目</a></li>
                    <li><a href="#news">新闻动态</a></li>
                    <li><a href="#contact">联系我们</a></li>
                </ul>
            </section>

            <select class="responsive-nav show-for-small" onChange="moveTo(this.value)" onFocus="moveTo(this.value)">
                <option value="#homepage">首页</option>
                <option value="#introduction">公司简介</option>
                <option value="#portfolio">成功案例</option>
                <option value="#services">服务项目</option>
                <option value="#news">新闻动态</option>
                <option value="#contact">联系我们</option>
            </select>
        </nav>
    </div>
</div>

<div class="homepage-text">
    <div class="top-icon">
        <img src="<@url value='/static/img/logo.png'/>" alt="${company.name}">
    </div>
    <div class="top-divider"></div>
    <h1>${config.get("landing.title")!}</h1>

    <div class="bottom-divider"></div>
    <h2>${config.get("landing.slogan")!}</h2>

    <h3>${config.get("landing.subSlogan")!}</h3>

    <div class="bottom-icon">
        <a href="#introduction"><img src="<@url value='/static/css/dreamer/images/homepage-text-bottom-icon.png'/>" alt="${company.name}"></a>
    </div>
</div>

<div class="content-container">

    <div id="homepage"></div>
    <div id="diagram" class="hide"></div>
    <div class="parallax-one">
        <div class="quote1-pattern" id="parallax-one">
            <div class="quote1-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">${config.get("introduce.firstHead")!}</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.people.multiple.png'/>" alt="更多">
                </div>
                <h2 class="parallax-subtitle">${config.get("introduce.firstSubHead")!}</h2>
            </div>
        </div>
    </div>
    <!-- Our Team Page -->
    <div class="page-container pattern-2" id="introduction">
        <#include "introduction.ftl"/>

        <#include "aboutus.ftl"/>
    </div>

    <!-- Parallax Three - Content -->
    <div class="parallax-three">
        <div class="quote3-pattern">
            <div class="quote3-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">${config.get("cases.firstHead")!}</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.camera.png'/>" alt='${config.get("cases.firstHead")!}'>
                </div>
                <h2 class="parallax-subtitle">${config.get("cases.firstSubHead")!}</h2>
            </div>
        </div>
    </div>

    <!-- Our Portfolio Page -->
    <div class="page-container pattern-2" id="portfolio">
        <#include "cases.ftl"/>
    </div>

    <!-- Parallax Four - Content -->
    <div class="parallax-four">
        <div class="quote4-pattern">
            <div class="quote4-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">${config.get("services.firstHead")!}</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.cogs.png'/>" alt='${config.get("services.firstHead")!}'>
                </div>
                <h2 class="parallax-subtitle">${config.get("services.firstSubHead")!}</h2>
            </div>
        </div>
    </div>

    <!-- Our Services Page -->
    <div class="page-container pattern-1" id="services">
        <#include "services.ftl"/>
    </div>

    <!-- Parallax Five - Content -->
    <div class="parallax-five">
        <div class="quote5-pattern">
            <div class="quote5-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">${config.get("news.firstHead")!}</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.globe.png'/>" alt="Read More About Us">
                </div>
                <h2 class="parallax-subtitle">${config.get("news.firstSubHead")!}</h2>
            </div>
        </div>
    </div>

    <!-- Our Latest News Page -->
    <div class="page-container pattern-2" id="news">
        <#include "news.ftl"/>
    </div>

    <!-- Parallax Six - Content -->
    <div class="parallax-six">
        <div class="quote6-pattern">
            <div class="quote6-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">${config.get("contact.firstHead")!}</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.email.png'/>" alt='${config.get("contact.firstHead")!}'>
                </div>
                <h2 class="parallax-subtitle">${config.get("contact.firstSubHead")!}</h2>
            </div>
        </div>
    </div>

    <!-- Contact Page -->
    <div class="page-container pattern-1" id="contact">
        <#include "contact.ftl"/>
    </div>


    <div class="footer-container">
        <div class="row">
            <div class="four columns first-column hide-for-small">
                <p class="footer-left">版权所有&copy; ${.now?string("yyyy")} </p>
            </div>
            <div class="four columns middle-column back-to-top hide-for-small">
                <a href="#homepage"><img src="<@url value='/static/css/dreamer/images/back-to-top.png'/>" alt="Go Back To Top"></a>
            </div>
            <div class="four columns last-column mobile-four">
                <p class="footer-right"><a href="<@url value='/'/>" target="_blank">${company.name}</a></p>
            </div>
        </div>
    </div>
</div>

<#include "cases.item.ftl"/>

<#include "common.js.ftl"/>

include "slider.ftl"
</body>
</html>
