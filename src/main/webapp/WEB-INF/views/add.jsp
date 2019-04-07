<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:useBean id="command" class="com.cfh.entity.Student" scope="request" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>add Student</title>
</head>
<body>
<form:form action="student" method="post">
    <table>
        <tr>
            <caption>Student ADD</caption>
        </tr>
        <tr>
            <td><form:label path="sno">学号</form:label></td>
            <td><form:input path="sno"/></td>
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
