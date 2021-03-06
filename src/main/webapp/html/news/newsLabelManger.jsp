<%@ page contentType="text/html;charset=UTF-8" language ="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>栏目管理</title>
    <link href="../../css/style.css" rel="stylesheet" type="text/css">
    <script language="javascript" src="../../js/util.js"></script>
    <script>
        function shanchu()
        {
            var  str = confirm("是否确定删除上级栏目？");
            if(str == true)
            {
                alert("确定删除！");
            }
            else
            {
                alert("取消删除！");
            }
        }
        function select(value) {
            var id = value;
            var ge = document.getElementById("mySelect");
            console.log(ge)
            alert("即将查询"+ge.options[ge.selectedIndex].innerText);
            window.location.href="${pageContext.request.contextPath}/desktop/news/find?id="+id;
        }
    </script>
</head>

<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<center>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="25" align="center" valign="bottom" class="td06"><table width="100%"  border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="2%" valign="middle" background="../../images/bg_03.gif">&nbsp;</td>
                    <td width="2%" valign="middle" background="../../images/bg_03.gif"><img src="../../images/main_28.gif" width="9" height="9" align="absmiddle"></td>
                    <td height="30" valign="middle" background="../../images/bg_03.gif"><div align="left"><font color="#FFFFFF">栏目管理</font></div></td>
                </tr>
            </table></td>
        </tr>
    </table>
    <form name="form1" method="post" action="">
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">
            <tr>
                <td colspan="2" class="td_02"><SPAN class=td_title>根据栏目名称查询</SPAN></td>
            </tr>
            <tr>
                <td width="14%" class="td_02">栏目名称</td>
                <td width="86%" class="td_02">
                    <select id="mySelect" name="label_name" class="input" style="width:99% " onchange="select(this.value)">
                        <option value="0" selected>--请选择--</option>
                        <c:forEach items="${parent}" var="item">
                            <option value="${item.id}">${item.label_name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </table>
        <br>
        <table width="95%"  border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
                <td class="td_page" align="left">
                    <div align="right">
                        <a href="${pageContext.request.contextPath}/desktop/news/newsLabelInsert" class="buttonface02" name="Submit">添加栏目</a>
<%--                        <input name="Submit" type="submit" class="buttonface02" value="添加栏目" onClick="javascript:windowOpen('${pageContext.request.contextPath}/desktop/news/insertNewsLabel','',700,300,'','','')">--%>
                    </div></td>
            </tr>
        </table>
        <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0" class="table01">

            <c:choose>
                <c:when test="${page.totalRows == 0 || page.pagenum == 1 && page.pagenum == totalPages}">
                    <tr>
                        <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页 共 ${page.totalPages} 页 ${page.totalRows} 条记录</td>
                    </tr>
                </c:when>
                <c:when test="${page.pagenum == 1}">
                    <tr>
                        <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=${page.pagenum+1}">下一页</a> <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=${page.totalPages}">末页</a> 共 ${page.totalPages} 页 ${page.totalRows} 条记录</td>
                    </tr>
                </c:when>
                <c:when test="${page.pagenum == page.totalPages}">
                    <tr>
                        <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=1">首页</a> <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=${page.pagenum-1}">上一页</a> <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页 共 ${page.totalPages} 页 ${page.totalRows} 条记录</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=1">首页</a> <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=${page.pagenum-1}">上一页</a> <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=${page.pagenum+1}">下一页</a> <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> <a href="${pageContext.request.contextPath}/desktop/news/queryNewsLabel?pagenum=${page.totalPages}">末页</a> 共 ${page.totalPages} 页 ${page.totalRows} 条记录</td>
                    </tr>
                </c:otherwise>
            </c:choose>
<%--            <tr>--%>
<%--                <td colspan="5" align="right" class="td07"><img src="../../images/1.gif" width="4" height="5" align="absmiddle"> 首页　 <img src="../../images/2.gif" width="3" height="5" align="absmiddle"> 上一页　 <img src="../../images/2-2.gif" width="3" height="5" align="absmiddle"> 下一页　 <img src="../../images/3.gif" width="4" height="5" align="absmiddle"> 末页　　共 ${page.totalPages} 页 ${page.totalRows} 条记录</td>--%>
<%--            </tr>--%>
            <tr>
                <td width="17%" class="td_top">栏目名称</td>
                <td width="15%" class="td_top">上级栏目名称</td>
                <td width="44%" class="td_top">栏目描述</td>
                <td width="12%" class="td_top">删除</td>
                <td width="12%" class="td_top">修改</td>
            </tr>

            <c:forEach items="${page.datas}" var="data">
                <tr>
                    <td class="td07">${data.label_name}</td>
                    <td class="td07">${data.parent.label_name == null?"无":data.parent.label_name}</td>
                    <td class="td07">${data.label_content}</td>
                    <td class="td07"><a href="${pageContext.request.contextPath}/desktop/news/deleteNewsLabel?id=${data.id}">删除</a></td>
<%--                    <td class="td07"><a href="${pageContext.request.contextPath}/desktop/news/updateNewsLabel?id=${data.id}" onClick="javascript:windowOpen('${pageContext.request.contextPath}/desktop/news/updateNewsLabel','','',670,260,'no','yes','100','100')">修改</a></td>--%>
                    <td class="td07"><a href="${pageContext.request.contextPath}/desktop/news/newsLabelUpdate?id=${data.id}")>修改</a></td>
                </tr>
            </c:forEach>
        </table>
        <p>&nbsp;</p>
    </form>
</center>
</body>
</html>

