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

<div class="content-container">

    <!-- Contact Page -->
    <div class="page-container pattern-1" id="contact">
        <div class="row" style="margin-bottom: 950px;">
            
        </div>
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

</body>
</html>
