<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/4/18
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
    <title>图书管理系统</title>
    <style>
        .font1{font-size:13px;}
    </style>
    <script language="JavaScript">
        function check(thisObject) {
            var sTmp="";
            sTmp = thisObject.value;
            if(isNaN(sTmp)){
                alert("请输入数字");
                thisObject.select();
            }
        }
    </script>
</head>
<body>
<table bgcolor=#71CABF align="center" class="font1">
    <tr>
        <td colspan="2"><jsp:include page="head.jsp"/></td>
    </tr>
    <tr>
        <s:form theme="simple" action="book" method="POST" enctype="multipart/form-data" validate="true">
            <td> <jsp:include page="funcselect.jsp"/></td>
            <td><jsp:include page="bookinfo.jsp"/></td>
        </s:form>
    </tr>
    <tr>
        <td colspan="2" align="center">
            南京师范大学:南京市宁海路122号&nbsp;&nbsp;邮编:210097<br>师教教育研究中心版权所有2010-2015
        </td>
    </tr>
</table>
</body>
</html>
