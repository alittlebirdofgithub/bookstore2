<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
   <style>
       .font1{font-size: 13px}
   </style>
</head>
<body>
<table border="1"width="200"cellspacing="1"class="font1">
    <tr bgcolor="#E9EDF5">
        <td>功能选择</td>
    </tr>
    <tr>
        <td align="center" valign="top" height="400">
            <br><s:submit value="图书追加" method="addBook"/><br>
            <br><s:submit value="图书删除" method="deleteBook"/><br>
            <br><s:submit value="图书修改" method="updateBook"/><br>
            <br><s:submit value="图书查询" method="selectBook"/><br>
        </td>
    </tr>
</table>
</body>
</html>
