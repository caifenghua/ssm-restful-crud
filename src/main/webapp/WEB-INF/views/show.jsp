<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>show</title>

</head>
<style>
    td{
        width:100px;
    }
    table{text-align:center}
</style>
<body>
<h2>Student Info</h2>
<table border="1">
    <tr>
        <td>sno</td>
        <td>sname</td>
        <td>score</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${stus}" var="stu">

        <tr>
            <td>${stu.sno}</td>
            <td>${stu.sname}</td>
            <td>${stu.score}</td>
            <td><button onclick="deleteById(${stu.sno})">删除</button><a href="updatejsp/${stu.sno}"><button>编辑</button></a></td>
        </tr>
    </c:forEach>
</table>
<a href="javascript:history.back()"> 返回 </a>
<script  src="static/js/jquery-3.1.1.min.js"></script>
<script>
        function deleteById(sno){
            $.ajax({
                type:"post",
                url:"student",
                data:{
                    "sno":sno,
                    "_method":"DELETE"
                },
                dataType:"json",
                success:function (data) {
                    console.log(data);
                    if (data.i == 1)
                        alert("学号"+sno+"删除成功")
                    window.location.reload();
                },
                error:function (data) {
                    alert("学号"+sno+"删除失败")
                }

            })
        }

</script>
</body>
</html>
