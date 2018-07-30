<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1" width="800">
        <tr>
            <td>标题</td>
            <td><input type="text"  value="${post.postname}"></td>
        </tr>
        <tr>
            <td>帖子类别</td>
            <td><input type="text" value="${post.topic.topicname}"></td>
        </tr>
        <tr>
            <td>帖子内容</td>
            <td><input type="text" value="${post.content}"></td>
        </tr>
        <tr>
            <td>图片上传</td>
            <td><img id="img" src=" ${post.picpath}" ><!-- 显示图片的 --></td>
        </tr>
        <tr><td colspan="2">
            <a href="/selectAll.do">返回首页</a>
        </td></tr>
    </table>
</body>
</html>
