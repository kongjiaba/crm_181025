<%--
  Created by IntelliJ IDEA.
  User: wjun
  Date: 2018/10/25
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>客户列表</title>
<script language="JavaScript">
    function delOne(custId) {
        var sure = window.confirm("确定删除吗？");
        if (sure){
            window.location.href="${pageContext.request.contextPath}/customer/deleteCustomer?custId="+custId;
        }
    }
    function topage(num) {
        //1、给表单中提供一个隐藏域赋值，用于提供当前页
        document.getElementById("pagenum").value = num;
        //2、提交表单
        document.forms[0].submit();
    }
</script>
</head>
<body>
    <s:debug></s:debug>
    <form action="${pageContext.request.contextPath}/customer/findAllCustomer" method="post">
        <input name="num" id="pagenum" value="" type="hidden">
        客户名称：<input type="text" name="custName">&nbsp;
        所属行业：<input type="text" name="custIndustry">&nbsp;
        信息来源：<select name="custSource.dictId">
        <option value="">---请选择---</option>
        <c:forEach items="${custSources}" var="source">
            <option value="${source.dictId}">${source.dictItemName}</option>
        </c:forEach>
        </select>&nbsp;
        客户级别：<select name="custLevel.dictId">
        <option value="">---请选择---</option>
        <c:forEach items="${custLevels}" var="level">
            <option value="${level.dictId}">${level.dictItemName}</option>
        </c:forEach>
        </select>&nbsp;
        <input type="submit" value="筛选">
        <table border="1">
            <caption>客户列表</caption>
            <tr>
                <td>客户名称</td>
                <td>客户信息来源</td>
                <td>客户所属行业</td>
                <td>客户级别</td>
                <td>客户联系地址</td>
                <td>客户联系电话</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${page.records}" var="customer">
                <tr>
                    <td>${customer.custName}</td>
                    <td>${customer.custSource.dictItemName}</td>
                    <td>${customer.custIndustry}</td>
                    <td>${customer.custLevel.dictItemName}</td>
                    <td>${customer.custAddress}</td>
                    <td>${customer.custPhone}</td>
                    <td><a href="${pageContext.request.contextPath}/customer/editUICustomer?custId=${customer.custId}">修改</a>&nbsp;&nbsp;
                        <a href="javascript:void(0)" onclick="delOne(${customer.custId})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
        <p align="center"><a href="javascript:topage(1)">首页</a> &nbsp;&nbsp;
            <a href="javascript:topage(${page.prePageNum})">上一页</a> &nbsp;&nbsp;
            <a href="javascript:topage(${page.nextPageNum})">下一页</a> &nbsp;&nbsp;
            <a href="javascript:topage(${page.tatolPageNum})">末页</a> &nbsp;&nbsp;
            第${page.currentPageNum}页/共${page.tatolPageNum}页</a></p>
    </form>
    <p style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></p>
</body>
</html>
