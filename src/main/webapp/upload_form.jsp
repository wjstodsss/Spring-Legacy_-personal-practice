<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Upload Form</title>
</head>
<body>
    <h2>File Upload Form</h2>
    <form action="/admin/upload" method="post" enctype="multipart/form-data">
  
        <div>
            <label for="uploadFiles">Choose Files:</label>
            <input type="file" id="uploadFiles" name="uploadFiles" multiple>
        </div>
        <div>
            <input type="submit" value="Upload">
        </div>
    </form>
</body>
</html>
