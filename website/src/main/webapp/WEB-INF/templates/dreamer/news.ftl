<div class="row">
    <div class="twelve columns page-content">
        <h1 class="page-title">${config.get("news.secondHead")!}</h1>

        <h2 class="page-subtitle">${config.get("news.secondSubHead")!}
        </h2>
    </div>

    <div class="twelve columns news">
        <div id="news-slider">

            <!-- News -->
            <div class="news-section" data-thumb="<@url value='/static/css/dreamer/images/our-news.png'/>">
                <#if news??>
                    <#list news as cNew>
                        <div class="four columns news-item mobile-two">
                            <section class="news-cat-image">
                                <img src="<@url value='/static/css/dreamer/images/icons/40px/white/124.png'/>" alt="${(cNew.info.head)!}">
                            </section>
                            <#if (cNew.info.beginTime)??>
                                <span class="news-date">${cNew.info.beginTime?string("yyyy-MM-dd")}</span>
                            </#if>
                            <a href="#" class="photo-link" data-reveal-id="single-news"><img src="${(cNew.defaultItem.imageThumbUrl)!}" alt="${(cNew.info.head)!}" class="wide-image"></a>
                            <section class="news-details">
                                <h3 class="news-title"><a href="#" data-reveal-id="single-news">${(cNew.info.head)!}</a></h3>

                                <div class="news-title-divider"></div>
                                <p class="news-content">${(cNew.info.subhead)!}

                                <p class="news-content">${(cNew.info.content)!}</p>
                                </p>
                            </section>
                            <section class="news-hover hide-for-small">
                                <div class="open-news-item">
                                    <a href="#" data-reveal-id="single-news" class="news-link"></a>
                                </div>
                            </section>
                        </div>
                    </#list>
                </#if>
            </div>
        </div>
    </div>

</div>