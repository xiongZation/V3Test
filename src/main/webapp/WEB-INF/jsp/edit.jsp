<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/resource/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<form action="/UpdateEdit.do" id="imm" method="post" enctype="multipart/form-data" >
    <table border="1" width="800">
        <tr>
            <td>标题</td>
            <td><input type="text" name="postname" value="${post.postname}"></td>
        </tr>
        <tr>
            <td>帖子类别</td>
            <td><select name="posttypeid">
                <option value="0">全部</option>
                <c:forEach items="${topics}" var="TList">
                <option value="${TList.topicid}" <c:if test="${TList.topicid==post.posttypeid}">selected="selected"</c:if> >${TList.topicname}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>帖子内容</td>
            <td><input type="text" name="content"  value="${post.content}"></td>
        </tr>
        <tr>
            <td>图片上传</td>
            <td><img id="img" src=" ${post.picpath}" ><!-- 显示图片的 -->
                <input name="fileImage" type="file" onchange="uploadImage()">
                <input type="hidden" name="picpath" id="pic"  >
            </td>
        </tr>
        <tr><td colspan="2">
            <input type="hidden" name="topid" value="${post.topid}">
            <input type="submit" value="修改">
            <a href="/selectAll.do">返回首页</a>
        </td></tr>
    </table>
</form>
</body>
<script type="text/javascript"src="/resource/js/jquery-form.js"></script>

<script>
    function uploadImage() {
        //编写ajax
        var obj={
            url:"imageupload",
            dataType:"json",
            type:"post",
            success:function(data){
                $("#img").attr("src",data.imagePath);
                $("#pic").val(data.imagePath);
            }
        };
        //提交form
        $("#imm").ajaxSubmit(obj);
    }


</script>
</html>
