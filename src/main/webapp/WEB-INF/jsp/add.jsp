<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/resource/js/jquery-1.8.3.min.js"></script>
</head>
<body>
<form action="/add.do" id="imm" method="post" enctype="multipart/form-data" >
    <table border="1" width="800">
        <tr>
            <td>标题</td>
            <td><input type="text" name="postname"></td>
        </tr>
        <tr>
            <td>帖子类别</td>
            <td><select name="posttypeid">
                <option value="0">全部</option>
                <c:forEach items="${topics}" var="TList">
                    <option value="${TList.topicid}">${TList.topicname}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>帖子内容</td>
            <td><input type="text" name="content"></td>
        </tr>
        <tr>
            <td>发布时间</td>
            <td><input type="date" name="posttime"></td>
        </tr>
        <tr>
            <td>图片上传</td>
            <td><img id="img" src=""><!-- 显示图片的 -->
                <input name="fileImage" type="file" onchange="uploadImage()">
                <input type="hidden" name="picpath" id="pic"  >
            </td>
        </tr>
        <tr><td colspan="2">
            <input type="hidden" name="clicknum" value="0">
            <input type="submit" value="发帖">
            <input type="reset" value="重置">
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
