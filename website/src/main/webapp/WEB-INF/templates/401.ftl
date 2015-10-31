<!DOCTYPE html>
<html>
<head>
    <title>401 Error </title>
    <meta charset="utf-8"/>
</head>
<body>
<a href="<@url value='/login'/>">Back To Login</a>

<h1>401 Page</h1>
<#if exception??>
    <pre>${exception.message!}</pre>
    <#else>
        <pre> you are not authorized,please login at first.</pre>
</#if>
</body>
</html>