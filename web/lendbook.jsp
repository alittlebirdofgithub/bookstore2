<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="S" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: 18673
  Date: 2017/4/18 0018
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .font{
            font-size: 13px;
        }
    </style>
</head>
<body>
    <table border="1" width="599">
        <!-- -->
        <S:form action="lendBook" method="POST" theme="simple">
            <tr bgcolor="#ffe4c4" class="font1">
                <s:if test="#request.readerId==null">
                    <td colspan="2">
                        图书信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN<s:textfield name="lend.ISBN" size="15" disabled="true"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;图书 ID<s:textfield name="lend.bookId" size="15" disabled="true"/>
                        <s:submit value="借书" disabled="true"/>
                    </td>
                </s:if>
                <s:else>
                    <td colspan="2">
                        图书信息&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ISBN <s:textfield name="lend.ISBN" size="15"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;图书 ID <s:textfield name="lend.bookId" size="15"/>
                        <input type="hidden" name="lend.readerId" value="<s:property value="#request.readerId"/> "/>
                        <s:submit value="借书"/>
                    </td>
                </s:else>
            </tr>
        </S:form>
        <!-- -->
        <tr>
            <td height="360" valign="top"><jsp:include page="lendbookinfo.jsp"/></td>
        </tr>
        <tr>
            <td align="center">
                <font color="red"><s:property value="message"/> </font>
            </td>
        </tr>
        <tr bgcolor="#7fffd4" class="font1">
            <td align="right">
                <s:set name="page" value="#request.page"/>
                <a href="selectBook.action?pageNow=1&lend.readerId=<s:property value="#request.readerId"/>">首页</a>
                <s:if test="#page.hasPre">
                    <a href="selectBook.action?pageNow=<s:property value="#page.pageNow-1"/>&lend.readerId=<s:property value="#request.readerId"/> ">
                        上一页
                    </a>
                </s:if>
                <s:else>
                    <a href="selectBook.action?pageNow=1&lend.readerId=<s:property value="#request.readerId"/> ">
                        上一页
                    </a>
                </s:else>
                <s:if test="#page.hasNext">
                    <a href="selectBook.action?pageNow=<s:property value="#page.pageNow+1"/>&lend.readerId=<s:property value="#request.readerId"/> ">
                        下一页
                    </a>
                </s:if>
                <s:else>
                    <a href="selectBook.action?pageNow=<s:property value="#page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/> ">
                        下一页
                    </a>
                </s:else>
                <a href="selectBook.action?pageNow=<s:property value="#page.totalPage"/>&lend.readerId=<s:property value="#request.readerId"/> ">
                    尾页
                </a>
            </td>
        </tr>
    </table>
</body>
</html>
