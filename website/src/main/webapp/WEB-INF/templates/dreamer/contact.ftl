<div class="row">
    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("contact.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("contact.secondSubHead")!}
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