<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java"  %>
<html>
<head>
    <title>查询</title>
    <script type="text/javascript" src="/resource/js/jquery-1.8.3.min.js"></script>
    <style type="text/css">
        div{
            width: 800px;
            height: 600px;
            margin: 0px auto;
            border: 1px solid red;
        }
        #bottom-text td a{
            margin-right: 35px;
        }
        td{
            text-align: center;
        }
    </style>
</head>
<body>
<div>
    <h1 style="text-align: center;">论坛发帖列表</h1>
    <form action="/selectAll.do" method="post" style="text-align: center;" id="f">
        标题<input type="text" name="postname" value="${postname}">
        帖子类型<select name="posttypeid">
        <option value="0">全部</option>
        <c:forEach items="${Topic}" var="TList">
            <option value="${TList.topicid}" <c:if test="${TList.topicid==posttypeid}">selected="selected"</c:if> >${TList.topicname}</option>
        </c:forEach>
    </select>&nbsp;
        点击数<input type="text" name="topnum" value="${topnum}">&nbsp;
        到<input type="text" name="bomnum" value="${bomnum}">&nbsp;
        <input type="hidden" name="now"  value="1" id="pg">
        <input type="submit" value="查询">
    </form>
    <a href="/insert.do" style="float: right;margin-right: 30px">发帖</a>
    <form id="deleteids" action="/batchdelete.do" method="post">
        <table border="1" width="800">
            <thead>
            <tr>
                <td>编号</td><td>标题</td><td>发帖时间</td><td>点击数</td><td>帖子类型</td><td>详细</td><td>删除</td><td>修改</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${PageInfo.list}" var="selectT">
                <tr>
                    <td>${selectT.topid}</td><td>${selectT.postname}</td><td><fmt:formatDate value="${selectT.posttime}" pattern="yyyy-MM-dd" /></td>
                    <td>${selectT.clicknum}</td>
                    <td>${selectT.topic.topicname}</td>
                    <td><a href="/Details.do?topid=${selectT.topid}">详细</a></td>
                    <td><a href="/delete.do?topid=${selectT.topid}">删除</a></td>
                    <td><a href="/EditId.do?topid=${selectT.topid}">修改</a></td>
                </tr>
            </c:forEach>
            <tr id="bottom-text">
                <td  colspan="10"><a onclick="pageNo(1)">首页</a><a onclick="pageNo(${PageInfo.pageNum-1})">上一页</a><a onclick="pageNo(${PageInfo.pageNum+1})" >下一页</a><a onclick="pageNo(${PageInfo.pages})">尾页</a>&nbsp;&nbsp;<span>${PageInfo.pageNum}/${PageInfo.pages}页</span></td>
            </tr>
            </tbody>
        </table>
    </form>
</div>

</body>
<script>
    function pageNo(obj) {

        $("#pg").val(obj);
        $("#f").submit();

    }

</script>
</html>

