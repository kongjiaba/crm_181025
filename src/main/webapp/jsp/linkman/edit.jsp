<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wjun
  Date: 2018/10/27
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>联系人修改编辑页面</title>
</head>
<body>
<s:debug></s:debug>
<form action="${pageContext.request.contextPath}/linkman/updateLinkMan" method="post">
    <input type="hidden" name="linkman.lkmId" value="${lkmId}">
    <table>
        <tr>
            <td>联系人姓名：</td>
            <td><input type="text" name="linkman.lkmName" value="${lkmName}"></td>
        </tr>
        <tr>
            <td>联系人性别：</td>
            <td>男<input type="radio" name="linkman.lkmGender" value="1" ${lkmGender=="1"?"checked":""}>&nbsp;&nbsp;
                女<input type="radio" name="linkman.lkmGender" value="0" ${lkmGender=="0"?"checked":""}>
            </td>
        </tr>
        <tr>
            <td>联系人办公电话：</td>
            <td><input type="text" name="linkman.lkmPhone" value="${lkmPhone}"></td>
        </tr>
        <tr>
            <td>联系人手机：</td>
            <td><input type="text" name="linkman.lkmMobile" value="${lkmMobile}"></td>
        </tr>
        <tr>
            <td>联系人邮箱：</td>
            <td><input type="text" name="linkman.lkmEmail" value="${lkmEmail}"></td>
        </tr>
        <tr>
            <td>联系人职位：</td>
            <td><input type="text" name="linkman.lkmPosition" value="${lkmPosition}"></td>
        </tr>
        <tr>
            <td>联系人简介：</td>
            <td><input type="text" name="linkman.lkmMemo" value="${lkmMemo}"></td>
        </tr>
        <tr>
            <td>联系人所属客户：</td>
            <td><select name="linkman.customerEntity.custId">
                <c:forEach items="${customerEntities}" var="customer">
                    <option value="${customer.custId}" ${customerEntity.custId == customer.custId ? "selected":""}>${customer.custName}</option>
                </c:forEach>
            </select></td>
        </tr>
    </table>
    <input type="submit" value="确认修改">
</form>
<p style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></p>

</body>
</html>
