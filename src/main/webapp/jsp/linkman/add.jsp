<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wjun
  Date: 2018/10/26
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>添加联系人</title>
</head>
<body>
    <s:debug></s:debug>
    <form action="${pageContext.request.contextPath}/linkman/addLinkMan.action" method="post">
        <table>
            <tr>
                <td>联系人姓名：</td>
                <td><input type="text" name="linkman.lkmName"></td>
            </tr>
            <tr>
                <td>联系人性别：</td>
                <td>男<input type="radio" id="1" name="linkman.lkmGender" value="1">&nbsp;&nbsp;
                    女<input type="radio" id="0" name="linkman.lkmGender" value="0"></td>
            </tr>
            <tr>
                <td>联系人办公电话：</td>
                <td><input type="text" name="linkman.lkmPhone"></td>
            </tr>
            <tr>
                <td>联系人手机：</td>
                <td><input type="text" name="linkman.lkmMobile"></td>
            </tr>
            <tr>
                <td>联系人邮箱：</td>
                <td><input type="text" name="linkman.lkmEmail"></td>
            </tr>
            <tr>
                <td>联系人职位：</td>
                <td><input type="text" name="linkman.lkmPosition"></td>
            </tr>
            <tr>
                <td>联系人简介：</td>
                <td><input type="text" name="linkman.lkmMemo"></td>
            </tr>
            <tr>
                <td>联系人所属客户：</td>
                <td><select name="linkman.customerEntity.custId">
                    <option value="">---请选择---</option>
                    <c:forEach items="${customerEntities}" var="customer">
                        <option value="${customer.custId}">${customer.custName}</option>
                    </c:forEach>
                </select></td>
            </tr>
        </table>
        <input type="submit" value="保存">
    </form>
    <p style="text-align: center"><a href="${pageContext.request.contextPath}/index.jsp">返回首页</a></p>
</body>
</html>
