<%--
  Created by IntelliJ IDEA.
  User: 18673
  Date: 2017/4/18 0018
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>图书管理系统</title>
</head>
<body bgcolor="#ff7f50">
    <s:form action="login" method="POST" theme="simple">
        <table>
            <caption>用户登录</caption>
            <tr>
                <td>
                    登录名: <s:textfield name="login.name" size="20"/>
                </td>
            </tr>
            <tr>
                <td>
                    密码: <s:password name="login.password" size="20"/>
                </td>
            </tr>
            <tr>
                <td>
                    <s:submit value="submit"/>
                    <s:reset value="reset"/>
                </td>
            </tr>
            <!-----失败 ----->
            <tr>
                <td>
                    <font color="red">
                        <s:fielderror/><s:property value="message"/>
                    </font>
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
