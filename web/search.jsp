<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 18673
  Date: 2017/4/18 0018
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .font{ font-size: 13px; }
    </style>
</head>
<body>
    <s:form action="selectBook" method="POST" theme="simple">
        <table border="1" width="200" cellspacing="1" class="font1">
            <tr bgcolor="#ffe4c4">
                <td> 内容选择 </td>
            </tr>
            <tr>
                <td align="left" valign="top" height="400">
                    <br> 借书证号: <br><br>
                    <s:textfield name="lend.readerId" size="15"/>
                    <s:submit value="查询"/>
                </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
