<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: GhostJun
  Date: 16/8/15
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}"/>
    <script src="http://libs.useso.com/js/jquery/2.1.0/jquery.min.js"></script>
    <script src="${ctx}/static/utils/webuploader/webuploader.js"></script>
    <link rel="stylesheet" href="${ctx}/static/utils/webuploader/webuploader.css">
    <script>
        var ctx = "${ctx}";
    </script>
</head>
<body>
<div id="uploader-demo">
    <!--用来存放item-->
    <div id="fileList" class="uploader-list"></div>
    <div id="filePicker">选择图片</div>
</div>
姓名<input type="text" id="name">
电话<input type="text" id="phone">
<button id="submit">提交</button>

<script>
    // 初始化Web Uploader
    var uploader = WebUploader.create({
        auto: true,
        swf: ctx + 'static/utils/webuploader/Uploader.swf',
        server: ctx + '/file/image/upload',
        pick: '#filePicker',
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        }
    });
    uploader.on('uploadSuccess', function (file, responseData) {
        console.log(responseData);
        console.log(responseData.data);
        var imageFile = responseData.data;
        console.log(imageFile);
    });

</script>
</body>
</html>
