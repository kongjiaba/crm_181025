<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wjun
  Date: 2018/10/27
  Time: 2:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系人列表</title>
    <script language="JavaScript">
        function delOne(lkmId) {
            var sure = window.confirm("确定删除吗？");
            if (sure){
                window.location.href="${pageContext.request.contextPath}/linkman/deleteLinkMan?lkmId="+lkmId;
            }
        }
    </script>
</head>
<body>
<s:debug></s:debug>
<form action="${pageContext.request.contextPath}/linkman/findAllLinkMan" method="post">
    联系人姓名：<input type="text" name="lkmName">&nbsp;&nbsp;
    联系人职位：<input type="text" name="lkmPosition">&nbsp;&nbsp;
    所属客户:<select name="customerEntity.custId">
        <option value="">---请选择---</option>
        <c:forEach items="${customerEntities}" var="customer">
             <option value="${customer.custId}">${customer.custName}</option>
        </c:forEach>
    </select>&nbsp;&nbsp;
    联系人性别：<select name="lkmGender">
        <option value="">---请选择---</option>
        <option value="1">男</option>
        <option value="0">女</option>
    </select>
    <input type="submit" value="筛选">
    <table border="1">
        <caption>联系人列表</caption>
        <tr>
            <th>联系人名称</th>
            <th>性别</th>
            <th>办公电话</th>
            <th>手机</th>
            <th>邮箱</th>
            <th>职位</th>
            <th>备注</th>
            <th>所属客户</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${linkmans}" var="linkman">
            <tr>
                <td>${linkman.lkmName}</td>
                <td>${linkman.lkmGender == '1' ? '男' :( linkman.lkmGender == '0' ? '女' : '未知') }</td>
                <td>${linkman.lkmPhone}</td>
                <td>${linkman.lkmMobile}</td>
                <td>${linkman.lkmEmail}</td>
                <td>${linkman.lkmPosition}</td>
                <td>${linkman.lkmMemo}</td>
                <td>${linkman.customerEntity.custName}</td>
                <td><a href="${pageContext.request.contextPath}/linkman/editUILinkMan?lkmId=${linkman.lkmId}">修改</a>&nbsp;&nbsp;
                    <a href="javascript:void(0)" onclick="delOne(${linkman.lkmId})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>

    <p style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></p>
</body>
</html>
