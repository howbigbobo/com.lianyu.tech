;
(function ($, window, undefined) {
    'use strict';

    var $doc = $(document),
        Modernizr = window.Modernizr;

    $(document).ready(function () {
        $.fn.foundationAlerts ? $doc.foundationAlerts() : null;
        $.fn.foundationButtons ? $doc.foundationButtons() : null;
        $.fn.foundationAccordion ? $doc.foundationAccordion() : null;
        $.fn.foundationNavigation ? $doc.foundationNavigation() : null;
        $.fn.foundationTopBar ? $doc.foundationTopBar() : null;
        $.fn.foundationCustomForms ? $doc.foundationCustomForms() : null;
        $.fn.foundationMediaQueryViewer ? $doc.foundationMediaQueryViewer() : null;
        $.fn.foundationTabs ? $doc.foundationTabs({callback: $.foundation.customForms.appendCustomMarkup}) : null;
        $.fn.foundationTooltips ? $doc.foundationTooltips() : null;
        $.fn.foundationMagellan ? $doc.foundationMagellan() : null;
        $.fn.foundationClearing ? $doc.foundationClearing() : null;

        $.fn.placeholder ? $('input, textarea').placeholder() : null;
    });

    // UNCOMMENT THE LINE YOU WANT BELOW IF YOU WANT IE8 SUPPORT AND ARE USING .block-grids
    // $('.block-grid.two-up>li:nth-child(2n+1)').css({clear: 'both'});
    // $('.block-grid.three-up>li:nth-child(3n+1)').css({clear: 'both'});
    // $('.block-grid.four-up>li:nth-child(4n+1)').css({clear: 'both'});
    // $('.block-grid.five-up>li:nth-child(5n+1)').css({clear: 'both'});

    // Hide address bar on mobile devices (except if #hash present, so we don't mess up deep linking).
    if (Modernizr.touch && !window.location.hash) {
        $(window).load(function () {
            setTimeout(function () {
                window.scrollTo(0, 1);
            }, 0);
        });
    }

    $(document).ready(function () {
        $('.parallax-one').css("margin-top", $(window).height());

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

        $('#nothing-only-to-init-prettyPhoto').prettyPhoto();

        $('body').on('click', '.description-link', function () {
            var id = $(this).data('id');
            openDescription(id);
            return false;
        });

        $('body').on('click', '.portfolio-hover-details,.news-hover', function () {
            $(this).parent().find(".description-link:first").click();
        });
    });

    jQuery(function () {
        initSupersized(main_sliders);
    });

})(jQuery, this);

function initSupersized(mainSliders) {
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
        slides: mainSliders,

        // Theme Options
        progress_bar: 1,			// Timer for each slide
        mouse_scrub: 0

    });
}

function openDescription(descriptionId) {
    if (!descriptionId) return;
    postJson('description/' + descriptionId, {}, function (response) {
        if (!response || !response.items) return;

        var api_images = [];
        var api_titles = [];
        var api_descriptions = [];

        for (var i = 0; i < response.items.length; i++) {
            api_titles.push(response.info.head);
            api_images.push(response.items[i].imageUrl);
            api_descriptions.push(response.items[i].content || "");
        }
        $.prettyPhoto.open(api_images, api_titles, api_descriptions);
    });
}

function afterLoaded() {
    initSupersized(main_sliders2);
    setTimeout(loadLazyImg, 400);
}

function loadLazyImg() {
    var images = $('img[src_lazy]');
    if (images.length > 0) {
        $.each(images, function (i, e) {
            $(e).attr('src', $(e).attr('src_lazy')).removeAttr('src_lazy');
        });
    }
}

// pagination
var CASES_LIST_CACHE = {};
function loadCases(ctrl) {
    var $ctrl = $(ctrl);
    if ($ctrl.closest('li').hasClass('active')) return false;
    $ctrl.closest('ul').find('.page-number-li').removeClass('active');
    $ctrl.closest('li').addClass('active');
    var url = $ctrl.attr('href');

    if (CASES_LIST_CACHE[url] && CASES_LIST_CACHE[url].length > 0) {
        $('#cases-content').html(CASES_LIST_CACHE[url]);
        loadLazyImg();
        return false;
    }
    postPage(url, {}, function (html) {
        CASES_LIST_CACHE[url] = html;
        $('#cases-content').html(html);
        loadLazyImg();
    });

    return false;
}