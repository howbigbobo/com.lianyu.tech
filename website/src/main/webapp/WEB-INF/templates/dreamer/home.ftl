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

            //if submit button is clicked
            $('#submit').click(function () {

                //Get the data from all the fields
                var name = $('input[name=name]');
                var email = $('input[name=email]');
                var phonenumber = $('input[name=phonenumber]');
                var website = $('input[name=website]');
                var projectbudget = $('input[name=projectbudget]');
                var timeframe = $('input[name=timeframe]');
                var youreinterestedin = $('input[name=youreinterestedin]');
                var howdidyouhearaboutus = $('input[name=howdidyouhearaboutus]');
                var comment = $('textarea[name=comment]');

                //Simple validation to make sure user entered something
                //If error found, add hightlight class to the text field
                if (name.val() == '') {
                    name.addClass('hightlight');
                    return false;
                } else name.removeClass('hightlight');

                if (email.val() == '') {
                    email.addClass('hightlight');
                    return false;
                } else email.removeClass('hightlight');

                if (comment.val() == '') {
                    comment.addClass('hightlight-message');
                    return false;
                } else comment.removeClass('hightlight-message');

                //organize the data properly
                var data = 'name=' + name.val() + '&email=' + email.val() + '&phonenumber=' + phonenumber.val() + '&website=' + website.val() + '&projectbudget=' + projectbudget.val() + '&timeframe=' + timeframe.val() + '&youreinterestedin=' + youreinterestedin.val() + '&howdidyouhearaboutus=' + howdidyouhearaboutus.val() + '&comment=' + encodeURIComponent(comment.val());

                //disabled all the text fields
                $('.text').attr('disabled', 'true');

                //show the loading sign
                document.getElementById("submit").disabled = true;
                document.getElementById("submit").value = 'Please Wait..';

                //start the ajax
                $.ajax({
                    //this is the php file that processes the data and send mail
                    url: "contact-form.php",

                    //GET method is used
                    type: "GET",

                    //pass the data
                    data: data,

                    //Do not cache the page
                    cache: false,

                    //success
                    success: function (html) {
                        //if process.php returned 1/true (send mail success)
                        if (html == 1) {
                            //hide the form
                            $('.contact-form-div').fadeOut('slow');

                            //show the success message
                            $('.done').fadeIn('slow');

                            //if process.php returned 0/false (send mail failed)
                        } else alert('Sorry, unexpected error. Please try again later.');
                    }
                });

                //cancel the submit button default behaviours
                return false;
            });
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
                    <li><a href="#intruduction">公司简介</a></li>
                    <li><a href="#about-us">关于我们</a></li>
                    <li><a href="#portfolio">成功案例</a></li>
                    <li><a href="#services">服务项目</a></li>
                    <li><a href="#news">新闻动态</a></li>
                    <li><a href="#contact">联系我们</a></li>
                </ul>
            </section>

            <select class="responsive-nav show-for-small" onChange="moveTo(this.value)" onFocus="moveTo(this.value)">
                <option value="#homepage">首页</option>
                <option value="#intruduction">公司简介</option>
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
    <h1>${company.name}</h1>

    <div class="bottom-divider"></div>
    <h2>${company.slogan!}</h2>

    <h3>${company.leadDescription!}</h3>

    <div class="bottom-icon">
        <a href="#parallax-one"><img src="<@url value='/static/css/dreamer/images/homepage-text-bottom-icon.png'/>" alt="首页底部"></a>
    </div>
</div>

<div class="content-container">

    <div id="homepage"></div>

    <div class="parallax-one">
        <div class="quote1-pattern" id="parallax-one">
            <div class="quote1-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">公司简介</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.people.multiple.png'/>" alt="更多">
                </div>
                <h2 class="parallax-subtitle">${company.slogan}</h2>
            </div>
        </div>
    </div>
    <!-- Our Team Page -->
    <div class="page-container pattern-2" id="intruduction">
        <#include "introduction.ftl"/>
    </div>
    <!-- Parallax Two - Content -->
    <div class="parallax-two">
        <div class="quote2-pattern">
            <div class="quote2-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">READ MORE ABOUT US</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.book.open.writing.png'/>" alt="Read More About Us">
                </div>
                <h2 class="parallax-subtitle">We love building and rebuilding brands.<br>Using colour, fonts and illustration, we brand companies in a way you’ll never forget.</h2>
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
                <h1 class="parallax-title">成功案例</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.camera.png'/>" alt="案例">
                </div>
                <h2 class="parallax-subtitle">We love building and rebuilding brands.<br>Using colour, fonts and illustration, we brand companies in a way you’ll never forget.</h2>
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
                <h1 class="parallax-title">CHECK OUT OUR SERVICES</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.cogs.png'/>" alt="Read More About Us">
                </div>
                <h2 class="parallax-subtitle">We love building and rebuilding brands.<br>Using colour, fonts and illustration, we brand companies in a way you’ll never forget.</h2>
            </div>
        </div>
    </div>

    <!-- Our Services Page -->
    <div class="page-container pattern-1" id="services">

        <div class="row">
            <div class="twelve columns page-content">
                <h1 class="page-title">Check Out Our Services</h1>

                <h2 class="page-subtitle">We love building and <span>rebuilding brands.</span><br>Using <span>colour, fonts</span> and illustration, we brand companies in a way you’ll never forget.
                </h2>
            </div>
        </div>

        <div class="row services-wide-banner">
            <div class="twelve columns"><img src="<@url value='/static/css/dreamer/images/services-banner.png'/>" alt="Our Services"></div>
        </div>

        <div class="row">
            <div class="twelve columns services-top">
                <div class="four columns services first-column mobile-two">
                    <h3 class="services-title">OUR STRAGEGY</h3>

                    <div class="services-image">
                        <div class="services-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/services/1.png'/>" alt="Our Strategy">

                        <div class="services-divider-bottom"></div>
                    </div>
                    <p class="services-text">Habitasse pulvinar elit tristique elm auctor placerat sit ut acu uctor. Ptor eetas scelerisque, non. Ac egestas mauris proin, pulviar tuis!</p>
                </div>
                <div class="four columns services middle-column mobile-two">
                    <h3 class="services-title">USER EXPERIENCE</h3>

                    <div class="services-image">
                        <div class="services-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/services/2.png'/>" alt="Our Strategy">

                        <div class="services-divider-bottom"></div>
                    </div>
                    <p class="services-text">Habitasse pulvinar elit tristique elm auctor placerat sit ut acu uctor. Ptor eetas scelerisque, non. Ac egestas mauris proin, pulviar tuis!</p>
                </div>
                <div class="four columns services last-column mobile-two">
                    <h3 class="services-title">DESIGN</h3>

                    <div class="services-image">
                        <div class="services-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/services/3.png'/>" alt="Our Strategy">

                        <div class="services-divider-bottom"></div>
                    </div>
                    <p class="services-text">Habitasse pulvinar elit tristique elm auctor placerat sit ut acu uctor. Ptor eetas scelerisque, non. Ac egestas mauris proin, pulviar tuis!</p>
                </div>
                <div class="four columns services first-column mobile-two">
                    <h3 class="services-title">DEVELOPMENT</h3>

                    <div class="services-image">
                        <div class="services-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/services/4.png'/>" alt="Our Strategy">

                        <div class="services-divider-bottom"></div>
                    </div>
                    <p class="services-text">Habitasse pulvinar elit tristique elm auctor placerat sit ut acu uctor. Ptor eetas scelerisque, non. Ac egestas mauris proin, pulviar tuis!</p>
                </div>
                <div class="four columns services middle-column mobile-two">
                    <h3 class="services-title">BRANDING</h3>

                    <div class="services-image">
                        <div class="services-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/services/5.png'/>" alt="Our Strategy">

                        <div class="services-divider-bottom"></div>
                    </div>
                    <p class="services-text">Habitasse pulvinar elit tristique elm auctor placerat sit ut acu uctor. Ptor eetas scelerisque, non. Ac egestas mauris proin, pulviar tuis!</p>
                </div>
                <div class="four columns services last-column mobile-two">
                    <h3 class="services-title">MARKETING</h3>

                    <div class="services-image">
                        <div class="services-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/services/6.png'/>" alt="Our Strategy">

                        <div class="services-divider-bottom"></div>
                    </div>
                    <p class="services-text">Habitasse pulvinar elit tristique elm auctor placerat sit ut acu uctor. Ptor eetas scelerisque, non. Ac egestas mauris proin, pulviar tuis!</p>
                </div>
            </div>
        </div>
    </div>

    <!-- Parallax Five - Content -->
    <div class="parallax-five">
        <div class="quote5-pattern">
            <div class="quote5-shape"></div>
        </div>
        <div class="row">
            <div class="twelve columns parallax-container">
                <h1 class="parallax-title">LATEST NEWS</h1>

                <div class="parallax-divider">
                    <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.globe.png'/>" alt="Read More About Us">
                </div>
                <h2 class="parallax-subtitle">We love building and rebuilding brands.<br>Using colour, fonts and illustration, we brand companies in a way you’ll never forget.</h2>
            </div>
        </div>
    </div>

    <!-- Our Latest News Page -->
    <div class="page-container pattern-2" id="news">

        <div class="row">
            <div class="twelve columns page-content">
                <h1 class="page-title">Check Our Latest News</h1>

                <h2 class="page-subtitle">We love building and <span>rebuilding brands.</span><br>Using <span>colour, fonts</span> and illustration, we brand companies in a way you’ll never forget.
                </h2>
            </div>

            <div class="twelve columns news">
                <div id="news-slider">

                    <!-- News -->
                    <div class="news-section" data-thumb=<@url value='/static/css/dreamer/images/our-news.png'/>
                    ">

                    <div class="four columns news-item mobile-two">
                        <section class="news-cat-image">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="News Image">
                        </section>
                        <span class="news-date">Published on January 18, 2013</span>
                        <a href="#" class="photo-link" data-reveal-id="single-news"><img src="<@url value='/static/css/dreamer/images/news/1.jpg'/>" alt="News Image" class="wide-image"></a>
                        <section class="news-details">
                            <h3 class="news-title"><a href="#" data-reveal-id="single-news">Et elementum odio amet consectue single elementum etcon!</a></h3>

                            <div class="news-title-divider"></div>
                            <p class="news-content">Habitasse pulvinar elit tristique elmauctr placerat sit ut acu uctor. Ptor eetas sceris que, non. Ac egesta, pulviar tuis!</p>
                        </section>
                        <section class="news-hover hide-for-small">
                            <div class="open-news-item">
                                <a href="#" data-reveal-id="single-news" class="news-link"></a>
                            </div>
                        </section>
                    </div>

                    <div class="four columns news-item mobile-two">
                        <section class="news-cat-image">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="News Image">
                        </section>
                        <span class="news-date">Published on January 18, 2013</span>
                        <a href="#" class="photo-link" data-reveal-id="single-news"><img src="<@url value='/static/css/dreamer/images/news/2.jpg'/>" alt="News Image" class="wide-image"></a>
                        <section class="news-details">
                            <h3 class="news-title"><a href="#" data-reveal-id="single-news">Et elementum odio amet consectue single elementum etcon!</a></h3>

                            <div class="news-title-divider"></div>
                            <p class="news-content">Habitasse pulvinar elit tristique elmauctr placerat sit ut acu uctor. Ptor eetas sceris que, non. Ac egesta, pulviar tuis!</p>
                        </section>
                        <section class="news-hover hide-for-small">
                            <div class="open-news-item">
                                <a href="#" data-reveal-id="single-news" class="news-link"></a>
                            </div>
                        </section>
                    </div>

                    <div class="four columns news-item mobile-two">
                        <section class="news-cat-image">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="News Image">
                        </section>
                        <span class="news-date">Published on January 18, 2013</span>
                        <a href="#" class="photo-link" data-reveal-id="single-news"><img src="<@url value='/static/css/dreamer/images/news/3.jpg'/>" alt="News Image" class="wide-image"></a>
                        <section class="news-details">
                            <h3 class="news-title"><a href="#" data-reveal-id="single-news">Et elementum odio amet consectue single elementum etcon!</a></h3>

                            <div class="news-title-divider"></div>
                            <p class="news-content">Habitasse pulvinar elit tristique elmauctr placerat sit ut acu uctor. Ptor eetas sceris que, non. Ac egesta, pulviar tuis!</p>
                        </section>
                        <section class="news-hover hide-for-small">
                            <div class="open-news-item">
                                <a href="#" data-reveal-id="single-news" class="news-link"></a>
                            </div>
                        </section>
                    </div>

                    <div class="four columns news-item mobile-two">
                        <section class="news-cat-image">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="News Image">
                        </section>
                        <span class="news-date">Published on January 18, 2013</span>
                        <a href="#" class="photo-link" data-reveal-id="single-news"><img src="<@url value='/static/css/dreamer/images/news/4.jpg'/>" alt="News Image" class="wide-image"></a>
                        <section class="news-details">
                            <h3 class="news-title"><a href="#" data-reveal-id="single-news">Et elementum odio amet consectue single elementum etcon!</a></h3>

                            <div class="news-title-divider"></div>
                            <p class="news-content">Habitasse pulvinar elit tristique elmauctr placerat sit ut acu uctor. Ptor eetas sceris que, non. Ac egesta, pulviar tuis!</p>
                        </section>
                        <section class="news-hover hide-for-small">
                            <div class="open-news-item">
                                <a href="#" data-reveal-id="single-news" class="news-link"></a>
                            </div>
                        </section>
                    </div>

                    <div class="four columns news-item mobile-two">
                        <section class="news-cat-image">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="News Image">
                        </section>
                        <span class="news-date">Published on January 18, 2013</span>
                        <a href="#" class="photo-link" data-reveal-id="single-news"><img src="<@url value='/static/css/dreamer/images/news/5.jpg'/>" alt="News Image" class="wide-image"></a>
                        <section class="news-details">
                            <h3 class="news-title"><a href="#" data-reveal-id="single-news">Et elementum odio amet consectue single elementum etcon!</a></h3>

                            <div class="news-title-divider"></div>
                            <p class="news-content">Habitasse pulvinar elit tristique elmauctr placerat sit ut acu uctor. Ptor eetas sceris que, non. Ac egesta, pulviar tuis!</p>
                        </section>
                        <section class="news-hover hide-for-small">
                            <div class="open-news-item">
                                <a href="#" data-reveal-id="single-news" class="news-link"></a>
                            </div>
                        </section>
                    </div>

                    <div class="four columns news-item mobile-two">
                        <section class="news-cat-image">
                            <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="News Image">
                        </section>
                        <span class="news-date">Published on January 18, 2013</span>
                        <a href="#" class="photo-link" data-reveal-id="single-news"><img src="<@url value='/static/css/dreamer/images/news/6.jpg'/>" alt="News Image" class="wide-image"></a>
                        <section class="news-details">
                            <h3 class="news-title"><a href="#" data-reveal-id="single-news">Et elementum odio amet consectue single elementum etcon!</a></h3>

                            <div class="news-title-divider"></div>
                            <p class="news-content">Habitasse pulvinar elit tristique elmauctr placerat sit ut acu uctor. Ptor eetas sceris que, non. Ac egesta, pulviar tuis!</p>
                        </section>
                        <section class="news-hover hide-for-small">
                            <div class="open-news-item">
                                <a href="#" data-reveal-id="single-news" class="news-link"></a>
                            </div>
                        </section>
                    </div>

                </div>

                <!-- Twitter Feed -->
                <div class="twitter-section" data-thumb=<@url value='/static/css/dreamer/images/twitter-feed.png'/>
                ">
                <div id="jstwitter">
                </div>
            </div>
        </div>
    </div>

</div>
</div>

<!-- Parallax Six - Content -->
<div class="parallax-six">
    <div class="quote6-pattern">
        <div class="quote6-shape"></div>
    </div>
    <div class="row">
        <div class="twelve columns parallax-container">
            <h1 class="parallax-title">CONTACT US TODAY</h1>

            <div class="parallax-divider">
                <img src="<@url value='/static/css/dreamer/images/icons/60px/white/appbar.email.png'/>" alt="Read More About Us">
            </div>
            <h2 class="parallax-subtitle">We love building and rebuilding brands.<br>Using colour, fonts and illustration, we brand companies in a way you’ll never forget.</h2>
        </div>
    </div>
</div>

<!-- Contact Page -->
<div class="page-container pattern-1" id="contact">

    <div class="row">
        <div class="twelve columns page-content">
            <h1 class="page-title">Contact Us Today</h1>

            <h2 class="page-subtitle">We love building and <span>rebuilding brands.</span><br>Using <span>colour, fonts</span> and illustration, we brand companies in a way you’ll never forget.
            </h2>
        </div>
    </div>


    <div class="row">

        <div class="twelve columns contact">
            <div id="contact-slider">

                <!-- Contact Details -->
                <div class="contact-details" data-thumb=<@url value='/static/css/dreamer/images/contact-details.png'/>
                ">
                <div class="four columns first-column mobile-three-one contact-margin">
                    <h3 class="contact-title">San Francisco</h3>

                    <div class="contact-image hide-for-760">
                        <div class="contact-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/san-francisco.jpg'/>" alt="San Francisco">

                        <div class="contact-divider-bottom"></div>
                    </div>
                    <p class="contact-text">One Auctor Stockton Street<br>London, UK 94108</p>

                    <p class="contact-text"><span>EMAIL:</span> info@dreamer.com</p>

                    <p class="contact-text"><span>PHONE:</span> 415.415.4155</p>
                </div>
                <div class="four columns middle-column mobile-three-one contact-margin">
                    <h3 class="contact-title">Los Angeles</h3>

                    <div class="contact-image hide-for-760">
                        <div class="contact-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/los-angeles.jpg'/>" alt="Los Angeles">

                        <div class="contact-divider-bottom"></div>
                    </div>
                    <p class="contact-text">One Auctor Stockton Street<br>London, UK 94108</p>

                    <p class="contact-text"><span>EMAIL:</span> info@dreamer.com</p>

                    <p class="contact-text"><span>PHONE:</span> 415.415.4155</p>
                </div>
                <div class="four columns last-column mobile-three-one contact-margin">
                    <h3 class="contact-title">New York</h3>

                    <div class="contact-image hide-for-760">
                        <div class="contact-divider-top"></div>
                        <img src="<@url value='/static/css/dreamer/images/new-york.jpg'/>" alt="London">

                        <div class="contact-divider-bottom"></div>
                    </div>
                    <p class="contact-text">One Auctor Stockton Street<br>New York, NY 94108</p>

                    <p class="contact-text"><span>EMAIL:</span> info@dreamer.com</p>

                    <p class="contact-text"><span>PHONE:</span> 415.415.4155</p>
                </div>
            </div>

            <!-- Contact Form -->
            <div class="contact-form" data-thumb=<@url value='/static/css/dreamer/images/contact-form.png'/>
            ">

            <div class="done"><b style="color:#e44d26;">THANK YOU!</b><br> We have received your message.</div>

            <form method="post" action="http://avathemes.com/HTML5/Dreamer/contact-form.php">
                <div class="twelve columns contact-form-div">
                    <div class="eight columns mobile-four-760">
                        <div class="six columns first-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/1.png'/>" alt="Contact Name"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="Name *" name="name" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns middle-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/2.png'/>" alt="Contact Email"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="Email *" name="email" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns first-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/3.png'/>" alt="Phone Number"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="Phone Number" name="phonenumber" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns middle-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/4.png'/>" alt="Website"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="Website / Link" name="website" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns first-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/5.png'/>" alt="Project Budget"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="Project Budget" name="projectbudget" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns middle-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/6.png'/>" alt="Timeframe"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="Timeframe" name="timeframe" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns first-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/7.png'/>" alt="You're interested in?"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="You're interested in?" name="youreinterestedin" value=""/>
                                </div>
                            </div>
                        </div>
                        <div class="six columns middle-column mobile-two-670">
                            <div class="row collapse">
                                <div class="two mobile-one columns">
                                    <span class="prefix"><img src="<@url value='/static/css/dreamer/images/icons/40px/8.png'/>" alt="How did you hear about us?"></span>
                                </div>
                                <div class="ten mobile-three columns">
                                    <input type="text" placeholder="How did you hear about us?" name="howdidyouhearaboutus" id="subject" value=""/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="four columns last-column mobile-four-760">
                        <textarea placeholder="Message *" name="comment"></textarea>
                    </div>
                    <div class="twelve columns submit-760">
                        <input type="submit" class="button radius secondary submit-wide" value="Send Message" id="submit"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="twelve columns contact-section">
    <h1 class="page-title">Social Media Icons & Buttons</h1>

    <h2 class="page-subtitle">We’re fortunate to work with <span>fantastic clients</span><br>from across the globe in over <span>11 countries</span> on design, branding, and <span>development projects.</span>
    </h2>
</div>
<div class="twelve columns">
    <div class="section-divider">
        <img src="<@url value='/static/css/dreamer/images/social-media.png'/>" alt="Read More About Us">
    </div>
</div>
<div class="twelve columns">
    <div class="social-media-buttons">
        <a href="#" class="behance-button has-tip tip-top radius" title="Behance"></a>
        <a href="#" class="blogger-button has-tip tip-top radius" title="Blogger"></a>
        <a href="#" class="digg-button has-tip tip-top radius" title="Digg"></a>
        <a href="#" class="dribbble-button has-tip tip-top radius" title="Dribbble"></a>
        <a href="#" class="email-button has-tip tip-top radius" title="Email"></a>
        <a href="#" class="facebook-button has-tip tip-top radius" title="Facebook"></a>
        <a href="#" class="flickr-button has-tip tip-top radius" title="Flickr"></a>
        <a href="#" class="gplus-button has-tip tip-top radius" title="Google Plus"></a>
        <a href="#" class="instagram-button has-tip tip-top radius" title="Instagram"></a>
        <a href="#" class="lastfm-button has-tip tip-top radius" title="Last.fm"></a>
        <a href="#" class="linkedin-button has-tip tip-top radius" title="Linkedin"></a>
        <a href="#" class="livejournal-button has-tip tip-top radius" title="LiveJournal"></a>
        <a href="#" class="myspace-button has-tip tip-top radius" title="MySpace"></a>
        <a href="#" class="paypal-button has-tip tip-top radius" title="Paypal"></a>
        <a href="#" class="pinterest-button has-tip tip-top radius" title="Pinterest"></a>
        <a href="#" class="reddit-button has-tip tip-top radius" title="Reddit"></a>
        <a href="#" class="soundcloud-button has-tip tip-top radius" title="Sound Cloud"></a>
        <a href="#" class="spotify-button has-tip tip-top radius" title="Spotify"></a>
        <a href="#" class="stumbleupon-button has-tip tip-top radius" title="StumbleUpon"></a>
        <a href="#" class="tumblr-button has-tip tip-top radius" title="Tumblr"></a>
        <a href="#" class="twitter-button has-tip tip-top radius" title="Twitter"></a>
        <a href="#" class="vimeo-button has-tip tip-top radius" title="Vimeo"></a>
        <a href="#" class="wordpress-button has-tip tip-top radius" title="WordPress"></a>
        <a href="#" class="youtube-button has-tip tip-top radius" title="Youtube"></a>
    </div>
</div>

<div class="twelve columns sharing-section">
    <h3 class="sharing-buttons">Sharing Buttons</h3>
</div>

<div class="twelve columns sharing-icons">
    <div class="facebook-share-button">
        <div class="facebook-share-button-over">Like It Now</div>
    </div>
    <div class="twitter-tweet-button">
        <div class="twitter-tweet-button-over">Tweet It</div>

    </div>
</div>

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
            <p class="footer-right"><a href="#/user/AVAThemes/portfolio" target="_blank">CREATED BY AVATHEMES</a></p>
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
