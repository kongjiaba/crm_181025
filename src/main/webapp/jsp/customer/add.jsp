<%--
  Created by IntelliJ IDEA.
  User: wjun
  Date: 2018/10/25
  Time: 16:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加客户</title>
</head>
<body>
<s:debug></s:debug>
    <p>添加客户</p>
    <form action="${pageContext.request.contextPath}/customer/addCustomer" method="post">
        客户名称：<input type="text" name="cstCustomerEntity.custName"><br/>
        客户信息来源：
        <select name="cstCustomerEntity.custSource.dictId">
            <c:forEach items="${custSources}" var="custSource">
                <option value="${custSource.dictId}">${custSource.dictItemName}</option>
            </c:forEach>
        </select><br/>
        客户所属行业：
        <select name="cstCustomerEntity.custIndustry" >
            <option value="家电">家电</option>
            <option value="五金">五金</option>
            <option value="建材">建材</option>
            <option value="汽摩">汽摩</option>
        </select><br/>
        客户级别：
        <select name="cstCustomerEntity.custLevel.dictId">
            <c:forEach items="${custLevels}" var="custLevel">
                <option value="${custLevel.dictId}">${custLevel.dictItemName}</option>
            </c:forEach>
        </select><br/>
        客户联系地址：<input type="text" name="cstCustomerEntity.custAddress"><br/>
        客户联系电话：<input type="text" name="cstCustomerEntity.custPhone"><br/>
        <input type="submit" value="提交">
    </form>
<p style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></p>
</body>
</html>
