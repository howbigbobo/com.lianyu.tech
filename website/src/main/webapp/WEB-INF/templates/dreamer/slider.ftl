<@css href="dreamer/css/jssor.slider.css"/>
<script>
    jQuery(document).ready(function ($) {

        var jssor_1_SlideoTransitions = [
            [{b: 5500.0, d: 3000.0, o: -1.0, r: 240.0, e: {r: 2.0}}],
            [{b: -1.0, d: 1.0, o: -1.0, c: {x: 51.0, t: -51.0}}, {b: 0.0, d: 1000.0, o: 1.0, c: {x: -51.0, t: 51.0}, e: {o: 7.0, c: {x: 7.0, t: 7.0}}}],
            [{b: -1.0, d: 1.0, o: -1.0, sX: 9.0, sY: 9.0}, {b: 1000.0, d: 1000.0, o: 1.0, sX: -9.0, sY: -9.0, e: {sX: 2.0, sY: 2.0}}],
            [{b: -1.0, d: 1.0, o: -1.0, r: -180.0, sX: 9.0, sY: 9.0}, {b: 2000.0, d: 1000.0, o: 1.0, r: 180.0, sX: -9.0, sY: -9.0, e: {r: 2.0, sX: 2.0, sY: 2.0}}],
            [{b: -1.0, d: 1.0, o: -1.0}, {b: 3000.0, d: 2000.0, y: 180.0, o: 1.0, e: {y: 16.0}}],
            [{b: -1.0, d: 1.0, o: -1.0, r: -150.0}, {b: 7500.0, d: 1600.0, o: 1.0, r: 150.0, e: {r: 3.0}}],
            [{b: 10000.0, d: 2000.0, x: -379.0, e: {x: 7.0}}],
            [{b: 10000.0, d: 2000.0, x: -379.0, e: {x: 7.0}}],
            [{b: -1.0, d: 1.0, o: -1.0, r: 288.0, sX: 9.0, sY: 9.0}, {b: 9100.0, d: 900.0, x: -1400.0, y: -660.0, o: 1.0, r: -288.0, sX: -9.0, sY: -9.0, e: {r: 6.0}}, {
                b: 10000.0,
                d: 1600.0,
                x: -200.0,
                o: -1.0,
                e: {x: 16.0}
            }]
        ];

        var jssor_1_options = {
            $AutoPlay: true,
            $SlideDuration: 1200,
            $SlideEasing: $Jease$.$OutQuint,
            $CaptionSliderOptions: {
                $Class: $JssorCaptionSlideo$,
                $Transitions: jssor_1_SlideoTransitions
            },
            $ArrowNavigatorOptions: {
                $Class: $JssorArrowNavigator$
            },
            $BulletNavigatorOptions: {
                $Class: $JssorBulletNavigator$
            }
        };

        var jssor_1_slider = new $JssorSlider$("jssor_1", jssor_1_options);

        //responsive code begin
        //you can remove responsive code if you don't want the slider scales while window resizes
        function ScaleSlider() {
            var refSize = jssor_1_slider.$Elmt.parentNode.clientWidth * 0.85;
            if (refSize) {
                refSize = Math.min(refSize, 1920);
                jssor_1_slider.$ScaleWidth(refSize);
            }
            else {
                window.setTimeout(ScaleSlider, 30);
            }
        }

        ScaleSlider();
        $(window).bind("load", ScaleSlider);
        $(window).bind("resize", ScaleSlider);
        $(window).bind("orientationchange", ScaleSlider);
        //responsive code end
    });
</script>

<div id="jssor_1" style="z-index:100;position: fixed; margin: 0 auto; top: 80px; left: 150px; width: 1300px; height: 600px; overflow: hidden; visibility: hidden;">
    <!-- Loading Screen -->
    <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 600px; overflow: hidden;">
        <div data-p="225.00" style="display: none;">
            <img data-u="image" src="<@url value='/static/css/dreamer/img/blue.jpg'/>"/>

            <div style="position: absolute; top: 30px; left: 30px; width: 480px; height: 120px; font-size: 50px; color: #ffffff; line-height: 60px;">TOUCH SWIPE SLIDER</div>
            <div style="position: absolute; top: 300px; left: 30px; width: 480px; height: 120px; font-size: 30px; color: #ffffff; line-height: 38px;">Build your slider with anything, includes image,
                content, text, html, photo, picture
            </div>
        </div>
        <div data-p="225.00" style="display: none;">
            <img data-u="image" src="<@url value='/static/css/dreamer/img/red.jpg'/>"/>
        </div>
        <div data-p="225.00" style="display: none;">
            <img data-u="image" src="<@url value='/static/css/dreamer/img/purple.jpg'/>"/>

            <div style="position: absolute; top: 300px; left: 30px; width: 480px; height: 120px; font-size: 30px; color: #ffffff; line-height: 38px;">Build your slider with anything, includes image,
                content, text, html, photo, picture
            </div>
        </div>
    </div>
    <!-- Bullet Navigator -->
    <div data-u="navigator" class="jssorb05" style="bottom:16px;right:6px;" data-autocenter="1">
        <!-- bullet navigator item prototype -->
        <div data-u="prototype" style="width:16px;height:16px;"></div>
    </div>
    <!-- Arrow Navigator -->
    <span data-u="arrowleft" class="jssora22l" style="top:123px;left:12px;width:40px;height:58px;" data-autocenter="2"></span>
    <span data-u="arrowright" class="jssora22r" style="top:123px;right:12px;width:40px;height:58px;" data-autocenter="2"></span>
</div>

<style>
    .mfp-container {
        text-align: center;
        position: absolute;
        width: 100%;
        height: 100%;
        left: 0;
        top: 0;
        padding: 0 8px;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        z-index: 101;
    }
</style>
<script>
    $(function () {
        $('.mfp-container').click(function () {
            alert('click');
        });
        // $('.mfp-container').width($(document).width()).height($(document).height());
    });
</script>
<div id="" class="mfp-container1" style="opacity: 0.8; display: block; cursor: pointer;position:fixed;height: 100%;
    width: 100%;
    background: #000;
    background: rgba(0, 0, 0, 0.45);
    z-index: 40;
    top: 0;
    left: 0;">

</div>