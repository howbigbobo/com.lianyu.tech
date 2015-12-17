<script type="text/javascript">
    var main_sliders = [			// Slideshow Images
        {image: '<@url value="/static/css/dreamer/images/homepage-slideshow/1.jpg"/>', title: '联娱传媒'},
        {image: '<@url value="/static/css/dreamer/images/homepage-slideshow/2.jpg"/>', title: '联娱传媒'},
        {image: '<@url value="/static/css/dreamer/images/homepage-slideshow/3.jpg"/>', title: '联娱传媒'}
    ];
</script>

<@js src="dreamer/jquery.js"/>
<@js src="dreamer/modernizr.foundation.js"/>
<@js src="dreamer/foundation.min.js"/>
<@js src="dreamer/jquery.parallax-1.1.3.js" type="text/javascript"/>
<@js src="dreamer/jquery.prettyPhoto.js"/>
<@js src="dreamer/jquery.easing.min.js"/>
<@js src="dreamer/jquery-css-transform.js"/>
<@js src="dreamer/supersized.3.2.7.min.js"/>
<@js src="dreamer/supersized.shutter.min.js"/>
<@js src="dreamer/custom.js"/>
<@js src="dreamer/raphael.js"/>
<@js src="dreamer/init.js"/>
<@js src="ajax.common.js"/>
<@js src="dreamer/app.js"/>

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
