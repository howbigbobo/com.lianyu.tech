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