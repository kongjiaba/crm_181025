<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>开始页面</title>
</head>
<body>
<h2>Hello World!</h2>
    <a href="/customer/addUICustomer">添加客户</a><br/>
    <a href="${pageContext.request.contextPath}/customer/findAllCustomer.action">查询全部客户</a><br/>
    <a href="${pageContext.request.contextPath}/linkman/addUILinkMan">添加联系人</a><br/>
    <a href="${pageContext.request.contextPath}/linkman/findAllLinkMan">联系人列表</a>
</body>
</html>
