<!DOCTYPE html>
<html lang="en">
<head>
    <title>网站维护中……</title>
</head>

<body>
<div style="text-align: center;">
    <img id="image" style="margin-top: 50px" src="<@url value='/static/img/construction.jpg'/>" alt="网站维护中"/>
</div>
</body>
<@js src="jquery-1.9.1.min.js"/>
<script>
    $('#image').dblclick(function () {
        location.href = "<@url value='/login'/>";
    });
    $(function () {
        setTimeout(function () {
            location.href = "<@url value='/login'/>";
        }, 15000);
    });
</script>
</html>