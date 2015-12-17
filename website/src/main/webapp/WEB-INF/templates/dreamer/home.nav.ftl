<div class="header-container">

    <!-- Basic Needs -->
    <div class="row">

        <nav class="top-bar">

            <ul>
                <li class="name"><a href="#homepage"><img src="<@url value='/static/img/logo_w.png'/>" alt="${company.name}"></a></li>
            </ul>

            <section class="hide-for-small">
                <ul class="right">
                    <li><a href="#homepage">首页</a></li>
                    <li><a href="#introduction">公司简介</a></li>
                    <li><a href="#portfolio">成功案例</a></li>
                    <li><a href="#services">服务项目</a></li>
                    <li><a href="#news">新闻动态</a></li>
                    <li><a href="#contact">联系我们</a></li>
                    <span>
                        <a href="#contact" id="head-phone">电话：0592-5530440</a>
                    </span>
                </ul>
            </section>

            <select class="responsive-nav show-for-small" onChange="moveTo(this.value)" onFocus="moveTo(this.value)">
                <option value="#homepage">首页</option>
                <option value="#introduction">公司简介</option>
                <option value="#portfolio">成功案例</option>
                <option value="#services">服务项目</option>
                <option value="#news">新闻动态</option>
                <option value="#contact">联系我们(0592-5530440)</option>
            </select>
        </nav>
    </div>
</div>