<%--
  Created by IntelliJ IDEA.
  User: wjun
  Date: 2018/10/26
  Time: 1:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改编辑</title>
</head>
<body>
    <s:debug></s:debug>
    <form action="${pageContext.request.contextPath}/customer/updateCustomer" method="post">
        客户名称：<input type="text" name="cstCustomerEntity.custName" value="${custName}"><br/>
        <input type="hidden" name="cstCustomerEntity.custId" value="${custId}" >
        客户信息来源：
        <select name="cstCustomerEntity.custSource.dictId">
            <c:forEach items="${custSources}" var="custSource">
                <option value="${custSource.dictId}">${custSource.dictItemName}</option>
            </c:forEach>
        </select><br/>
        客户所属行业：
        <select name="cstCustomerEntity.custIndustry" >
            <option value="">---请选择---</option>
            <option value="家电" ${custIndustry == "家电" ? "selected":""}>家电</option>
            <option value="五金" ${custIndustry == "五金" ? "selected":""}>五金</option>
            <option value="建材" ${custIndustry == "建材" ? "selected":""}>建材</option>
            <option value="汽摩" ${custIndustry == "汽摩" ? "selected":""}>汽摩</option>
        </select><br/>
        客户级别：
        <select name="cstCustomerEntity.custLevel.dictId">
            <c:forEach items="${custLevels}" var="custLevel">
                <option value="${custLevel.dictId}">${custLevel.dictItemName}</option>
            </c:forEach>
        </select><br/>
        客户联系地址：<input type="text" name="cstCustomerEntity.custAddress" value="${custAddress}"><br/>
        客户联系电话：<input type="text" name="cstCustomerEntity.custPhone" value="${custPhone}"><br/>
        <input type="submit" value="确认修改">
    </form>
    <p style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></p>
</body>
</html>
