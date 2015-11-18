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

    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<@url value='/static/img/dreamer/apple-touch-icon-144x144-precomposed.png'/>">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<@url value='/static/img/dreamer/apple-touch-icon-114x114-precomposed.png'/>">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<@url value='/static/img/dreamer/apple-touch-icon-72x72-precomposed.png'/>">
    <link rel="apple-touch-icon-precomposed" href="<@url value='/static/img/dreamer/apple-touch-icon-57x57-precomposed.png'/>">
    <link rel="apple-touch-icon" href="<@url value='/static/img/dreamer/apple-touch-icon.png'/>">
    <link rel="shortcut icon" href="<@url value='/static/img/dreamer/favicon.ico'/>"/>

    <!-- This script prevents links from opening in Mobile Safari. https://gist.github.com/1042026 -->
    <script>(function (a, b, c) {
        if (c in b && b[c]) {
            var d, e = a.location, f = /^(a|html)$/i;
            a.addEventListener("click", function (a) {
                d = a.target;
                while (!f.test(d.nodeName))d = d.parentNode;
                "href"in d && (d.href.indexOf("http") || ~d.href.indexOf(e.host)) && (a.preventDefault(), e.href = d.href)
            }, !1)
        }
    })(document, window.navigator, "standalone")</script>

    <!-- Included CSS Files -->
    <@css href="dreamer/style.css"/>
    <@css href="dreamer/css/portfolio.css"/>
    <@css href="dreamer/css/foundation.css"/>
    <@css href="dreamer/css/normalize.css"/>
    <@css href="dreamer/css/supersized.css" type="text/css" media="screen"/>
    <@css href="dreamer/css/supersized.shutter.css" type="text/css" media="screen"/>
    <@css href="dreamer/css/prettyPhoto.css" type="text/css" media="screen" title="prettyPhoto main stylesheet"/>

    <!-- g Web Fonts -->
    <@css href="dreamer/fontcss/pt_sans.css"/>
    <@css href="dreamer/fontcss/ubuntu.css"/>
    <@css href="dreamer/fontcss/gentium_book_basic.css"/>
    <@css href="dreamer/fontcss/lato.css"/>

    <!-- Included JS Files -->
    <@js src="dreamer/modernizr.foundation.js"/>
    <@js src="dreamer/jquery.js"/>
    <@js src="dreamer/custom.js"/>
    <@js src="dreamer/raphael.js"/>
    <@js src="dreamer/init.js"/>

    <script type="text/javascript">
        $(document).ready(function () {
            $('.parallax-one').css("margin-top", $(window).height());

            $("a[rel^='prettyPhoto']").prettyPhoto();

            var windowsize = $(window).width();

            $(window).resize(function () {
                var windowsize = $(window).width();
            });

            if (windowsize > 1024) {
                //if the window is greater than 1024px wide then load one orbit settings
                //.parallax(xPosition, speedFactor, outerHeight) options:
                //xPosition - Horizontal position of the element
                //inertia - speed to move relative to vertical scroll. Example: 0.1 is one tenth the speed of scrolling, 2 is twice the speed of scrolling
                //outerHeight (true/false) - Whether or not jQuery should use it's outerHeight option to determine when a section is in the viewport
                $('.parallax-one').parallax("50%", 0.5);
                $('.parallax-two').parallax("50%", 0.5);
                $('.parallax-three').parallax("50%", 0.5);
                $('.parallax-four').parallax("50%", 0.5);
                $('.parallax-five').parallax("50%", 0.5);
                $('.parallax-six').parallax("50%", 0.5);
            }
        })
    </script>

    <!-- Hook up the Loader -->
    <script type="text/javascript">
        $(window).load(function () {
            $("#loading").fadeOut("1000", function () {
                // Animation complete
                $('#loading img').css("display", "none");
                $('#loading').css("display", "none");
                $('#loading').css("background", "none");
                $('#loading').css("width", "0");
                $('#loading').css("height", "0");
            });
        });
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
                    <li><a href="#about-us">关于我们</a></li>
                    <li><a href="#portfolio">成功案例</a></li>
                    <li><a href="#services">服务项目</a></li>
                    <li><a href="#news">新闻动态</a></li>
                    <li><a href="#contact">联系我们</a></li>
                </ul>
            </section>

            <select class="responsive-nav show-for-small" onChange="moveTo(this.value)" onFocus="moveTo(this.value)">
                <option value="#homepage">首页</option>
                <option value="#introduction">公司简介</option>
                <option value="#about-us">关于我们</option>
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
    </div>
    <!-- Parallax Two - Content -->
    <div class="parallax-two">
        <div class="quote2-pattern">
            <div class="quote2-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">${config.get("aboutus.firstHead")!}</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.book.open.writing.png'/>" alt='${config.get("aboutus.firstHead")!}'>
                </div>
                <h2 class="parallax-subtitle">${config.get("aboutus.firstHead")!}</h2>
            </div>
        </div>
    </div>

    <!-- About Us Page -->
    <div class="page-container pattern-1" id="about-us">
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

<!-- Pop Up Windows - Single Project With Video -->
<div id="single-project-video" class="reveal-modal large">


    <h3 class="single-project-title">Project Page With Video</h3>

    <p class="single-project-details hide-for-small">
        <span>Published on</span> January 21st by Admin
        <span class="category">Category:</span> Photography, Website Design
        <span class="tags">Tags:</span> minimal, web, design, inspiration
    </p>

    <div class="four columns first-column">
        <p class="single-project-content"><span class="dropcap-1">S</span>it sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et.
            Enim mid proin mid eu augue odio elementum? Placerat sit? In pulvinar a in a, et, proin?</p>
    </div>
    <div class="four columns middle-column">
        <p class="single-project-content"><span class="dropcap-2">S</span>it sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et.
            Enim mid proin mid eu augue odio elementum? Nunc odio ac! Dapibus et. Nec!</p>
    </div>
    <div class="four columns last-column">
        <p class="single-project-content"><span class="dropcap-3">S</span>it sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et.
            Enim mid proin mid eu augue odio elementum? Dapibus et. Nec! Aliquam hac, porttitor? Hac dis!</p>
    </div>

    <div class="single-project-tab-details">
        <dl class="tabs contained">
            <dt>Project Details</dt>
            <dd class="active"><a href="#simpleContained1">Design</a></dd>
            <dd class="hide-for-small"><a href="#simpleContained2">Development</a></dd>
            <dd class="hide-for-small"><a href="#simpleContained3">Client Details</a></dd>
        </dl>
        <ul class="tabs-content contained">
            <li class="active" id="simpleContained1Tab">Photos in Portfolio and News are property of <a href="http://seanwes.com/">Sean McCabe</a> and <a href="http://pixelpixelpixel.com/">pixelpixelpixel.com</a>
            </li>
            <li id="simpleContained2Tab">Sit sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et. Enim mid proin mid eu augue odio
                elementum? Placerat sit? In pulvinar a in a, et, proin?
            </li>
            <li id="simpleContained3Tab">Sit sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et. Enim mid proin mid eu augue odio
                elementum? Placerat sit? In pulvinar a in a, et, proin?
            </li>
        </ul>
    </div>

    <div class="eight columns first-column">
        <p class="single-project-content">Sit sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et. Enim mid proin mid eu augue
            odio elementum? Placerat sit? In pulvinar a in a, et, proin? Sit sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et.
            Enim mid proin mid eu augue odio elementum? Nunc odio ac! Dapibus et. Nec! Aliquam hac, porttitor?</p>
    </div>
    <div class="four columns middle-column">
        <p class="single-project-content">Sit sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus magna pulvinar, velit turpis parturient! Proin et. Enim mid proin mid eu augue
            odio elementum? Nunc odio ac! Dapibus et. Nec!</p>
    </div>

    <div class="single-project-share-buttons">

        <div class="twelve columns">
            <div class="facebook-share-button">
                <div class="facebook-share-button-over">Like It Now</div>

            </div>
            <div class="twitter-tweet-button">
                <div class="twitter-tweet-button-over">Tweet It</div>
                <div class="twitter-tweet-button-inner">
                    <a href="https://twitter.com/share" class="twitter-share-button" data-via="AvaThemes" data-related="AvaThemes">Tweet</a>
                </div>
            </div>
            <div class="linkedin-share-button">
                <div class="linkedin-share-button-over">Share It</div>
                <div class="linkedin-share-button-inner">
                </div>
            </div>
        </div>
    </div>

    <a class="close-reveal-modal">&#215;</a>
</div>


<!-- Pop Up Windows - Single Blog Post -->
<div id="single-news" class="reveal-modal single-news medium">

    <div class="single-news-image-video">
        <img src="<@url value='/static/css/dreamer/images/news/single/1.jpg'/>" alt="Project Image">
    </div>

    <h3 class="single-news-title">Your Blog Post Title Goes Here!</h3>

    <p class="single-news-details hide-for-small">
        <span>Published on</span> January 21st by Admin
        <span class="category">Category:</span> Photography, Website Design
    </p>

    <div class="twelve columns first-column">
        <p class="single-news-content"><span class="dropcap-1">P</span>hotos in Portfolio and News are property of <a href="http://seanwes.com/">Sean McCabe</a> and <a
                href="http://pixelpixelpixel.com/">pixelpixelpixel.com</a> Placerat sit? In pulvinar a in a, et, proin? Sit sagittis aliquet cras, rhoncus cras arcu odio risus a, auctor urna. Mus
            magna pulvinar, velit turpis parturient! Proin et. Enim mid proin mid eu augue odio elementum? Nunc odio ac! Dapibus et. Nec! Aliquam hac, porttitor?</p>

        <blockquote>
            <p>I do not fear computers. I fear the lack of them. Porta natoque lacus urna cum, dictumst a risus facilisis, lundium, mid nisi lundium amet vel sit cursus proin in!
                <cite>Isaac Asimov</cite></p>
        </blockquote>

        <p class="single-news-content">Velit integer elit lacus ut enim nascetur augue proin magnis, turpis mus phasellus, placerat cursus scelerisque augue scelerisque, habitasse, et lectus? Porta
            natoque lacus urna cum, dictumst a risus facilisis, lundium, mid nisi lundium amet vel sit cursus proin in!</p>

        <p class="single-news-content">Lorem pulvinar penatibus in tortor porta purus auctor nisi lectus nascetur, porta? Turpis turpis? Lundium placerat ac eu adipiscing porttitor, et diam vut et!
            Cum augue! Massa arcu scelerisque pulvinar? Proin dictumst. Porttitor tincidunt egestas!</p>
    </div>

    <div class="single-news-share-buttons">

        <div class="twelve columns">
            <div class="facebook-share-button">
                <div class="facebook-share-button-over">Like It Now</div>

            </div>
            <div class="twitter-tweet-button">
                <div class="twitter-tweet-button-over">Tweet It</div>
                <div class="twitter-tweet-button-inner">
                    <a href="https://twitter.com/share" class="twitter-share-button" data-via="AvaThemes" data-related="AvaThemes">Tweet</a>
                </div>
            </div>
            <div class="linkedin-share-button">
                <div class="linkedin-share-button-over">Share It</div>
                <div class="linkedin-share-button-inner">
                </div>
            </div>
        </div>
    </div>

    <a class="close-reveal-modal">&#215;</a>
</div>

<!-- Included JS Files (Compressed) -->
<@js src="dreamer/foundation.min.js"/>

<!-- Parallax JS File -->
<@js src="dreamer/jquery.parallax-1.1.3.js" type="text/javascript"/>

<!-- prettyPhoto JS File -->
<@js src="dreamer/jquery.prettyPhoto.js"/>

<!-- Portfolio Filter JS FIles -->
<@js src="dreamer/jquery.easing.min.js"/>
<@js src="dreamer/portfolio.js"/>
<@js src="dreamer/jquery.quicksand.js"/>
<@js src="dreamer/jquery-css-transform.js"/>

<!-- Supersized JS Files -->
<@js src="dreamer/supersized.3.2.7.min.js"/>
<@js src="dreamer/supersized.shutter.min.js"/>

<script type="text/javascript">
    jQuery(function ($) {
        $.supersized({
            // Functionality
            slideshow: 1,			// Slideshow on/off
            autoplay: 1,			// Slideshow starts playing automatically
            start_slide: 1,			// Start slide (0 is random)
            stop_loop: 0,			// Pauses slideshow on last slide
            random: 0,			// Randomize slide order (Ignores start slide)
            slide_interval: 3000,		// Length between transitions
            transition: 1, 			// 0-None, 1-Fade, 2-Slide Top, 3-Slide Right, 4-Slide Bottom, 5-Slide Left, 6-Carousel Right, 7-Carousel Left
            transition_speed: 1500,		// Speed of transition
            new_window: 1,			// Image links open in new window/tab
            pause_hover: 0,			// Pause slideshow on hover
            keyboard_nav: 1,			// Keyboard navigation on/off
            performance: 1,			// 0-Normal, 1-Hybrid speed/quality, 2-Optimizes image quality, 3-Optimizes transition speed // (Only works for Firefox/IE, not Webkit)
            image_protect: 1,			// Disables image dragging and right click with Javascript
            // Size & Position
            min_width: 0,			// Min width allowed (in pixels)
            min_height: 0,			// Min height allowed (in pixels)
            vertical_center: 1,			// Vertically center background
            horizontal_center: 1,			// Horizontally center background
            fit_always: 0,			// Image will never exceed browser width or height (Ignores min. dimensions)
            fit_portrait: 1,			// Portrait images will not exceed browser height
            fit_landscape: 0,			// Landscape images will not exceed browser width
            // Components
            slide_links: 'blank',	// Individual links for each slide (Options: false, 'num', 'name', 'blank')
            thumb_links: 1,			// Individual thumb links for each slide
            thumbnail_navigation: 0,			// Thumbnail navigation
            slides: [			// Slideshow Images
                {image: '<@url value="/static/css/dreamer/images/homepage-slideshow/1.jpg"/>', title: 'Dreamer - Responsive One Page Parallax Template'},
                {image: '<@url value="/static/css/dreamer/images/homepage-slideshow/2.jpg"/>', title: 'Dreamer - Responsive One Page Parallax Template'},
                {image: '<@url value="/static/css/dreamer/images/homepage-slideshow/3.jpg"/>', title: 'Dreamer - Responsive One Page Parallax Template'}
            ],

            // Theme Options
            progress_bar: 1,			// Timer for each slide
            mouse_scrub: 0

        });
    });
</script>

<!-- Initialize JS Plugins -->
<@js src="dreamer/app.js"/>
<@js src="dreamer/jquery.foundation.tooltips.js"/>
<@js src="dreamer/jquery.foundation.reveal.js"/>
<@js src="dreamer/jquery.foundation.tabs.js"/>

<!-- Initialize Orbit -->
<@js src="dreamer/jquery.foundation.orbit.js"/>
<@js src="dreamer/jssor.slider.mini.js"/>
<script type='text/javascript'>
    $(window).load(function () {
        var windowsize = $(window).width();

        $(window).resize(function () {
            var windowsize = $(window).width();
        });

        if (windowsize > 1024) {
            //if the window is greater than 1024px wide then load one orbit settings
            $('#contact-slider').orbit({
                fluid: '16x5',
                timer: false,
                directionalNav: false,
                bullets: true,
                bulletThumbs: true,
                bulletThumbLocation: ''
            });
            $('#news-slider').orbit({
                fluid: '16x12',
                timer: false,
                directionalNav: false,
                bullets: true,
                bulletThumbs: true,
                bulletThumbLocation: ''
            });
        }
        else {
            if (windowsize > 765) {
                $('#contact-slider').orbit({
                    fluid: '16x6',
                    timer: false,
                    directionalNav: false,
                    bullets: true,
                    bulletThumbs: true,
                    bulletThumbLocation: ''
                });
                $('#news-slider').orbit({
                    fluid: '16x23',
                    timer: false,
                    directionalNav: false,
                    bullets: true,
                    bulletThumbs: true,
                    bulletThumbLocation: ''
                });
            }
        }
    });
</script>

<script type="text/javascript" charset="utf-8">
    $(document).ready(function () {
        $("a[rel^='prettyPhoto']").prettyPhoto();
    });
</script>

<!-- Initialize FitVids Script -->
<@js src="dreamer/jquery.fitvids.js"/>
<script>
    $(".single-project-image-video").fitVids();
</script>
<#include "slider.ftl"/>
</body>
</html>
