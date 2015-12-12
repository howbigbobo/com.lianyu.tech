<!-- Included JS Files -->
<@js src="dreamer/jquery.js"/>
<@js src="dreamer/modernizr.foundation.js"/>
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