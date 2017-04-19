<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 18673
  Date: 2017/4/18 0018
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .font{
            font-size:13px;
        }
    </style>
</head>
<body>
    <table border="1" align="center" width="570" cellpadding="10" cellspacing="0" bgcolor="#ff7f50" class="font1">
        <tr bgcolor="#faebd7">
            <th>图书 ID</th> <th>ISBN</th> <th> 书名 </th> <th>出版社</th> <th>价格</th><th>借书时间</th>
        </tr>
        <s:iterator value="#request.list" id ="lend">
            <tr>
                <td><s:property value="#lend.bookId"/> </td>
                <td><s:property value="#lend.ISBN"/> </td>
                <td><s:property value="#lend.bookName"/> </td>
                <td><s:property value="#lend.publisher"/> </td>
                <td><s:property value="#lend.price"/> </td>
                <td><s:property value="#lend.lendTime"/> </td>
            </tr>
        </s:iterator>
    </table>
</body>
</html>
