<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!doctype html>
<html lang="en">
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> -->
<script src="<%=application.getContextPath()%>/resources/js/app.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/cmm/router.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/cmm/auth.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/vue/auth_vue.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/cmm/brd.js"></script>
<script src="<%=application.getContextPath()%>/resources/js/vue/brd_vue.js"></script>
<body>
<div id='wrapper'>
</div>
<script>
app.run('<%=application.getContextPath()%>')
</script>

</body>
</html>