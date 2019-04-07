<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>add Student</title>
</head>

<body>
<form:form action="${pageContext.request.contextPath}/student" modelAttribute="stu" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <table>
        <tr>
            <caption>Student Update</caption>
            <%--    不能这么写，modelAttribute里面没有这个属性会报错--%>
            <%--<form:hidden path="_method" value="UPDATE"></form:hidden>--%>
        </tr>
        <tr>
            <td><form:label path="sno">学号</form:label></td>
            <td><form:input path="sno" readonly="true"/></td>
        </tr>
        <tr>
            <td><form:label path="sname">姓名</form:label></td>
            <td><form:input path="sname"/></td>
        </tr>
        <tr>
            <td><form:label path="score">分数</form:label></td>
            <td><form:input path="score"/></td>
        </tr>
        <tr>
            <td><input type="reset" value="reset"/></td>
            <td><input type="submit" value="submit"/></td>
        </tr>
    </table>
</form:form>
<a href="javascript:history.back()"> 返回 </a>
</body>
</html>
