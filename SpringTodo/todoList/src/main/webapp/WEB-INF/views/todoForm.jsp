<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>할일 등록</title>
<style>
        *{
            text-align: center;
        }       
    </style>
</head>
<body>
<h2>할일 등록</h2>
    <form method="post" action="write">
        <a id = "ans">어떤일인가요?</a> <br>
		<input type="text" name="title" value="swift 공부하기(24자까지)" maxlength="24"><br>
        <br><a id = "ans">누가 할일인가요?</a> <br>
        <input type="text" name="name" value="홍길동"><br>
        <br>
        <a id = "ans">우선순위를 선택하세요.</a><br>
        <input type="radio" name="sequence" value="1" checked /> 1순위
        <input type="radio" name="sequence" value="2" /> 2순위
        <input type="radio" name="sequence" value="3" /> 3순위
		<br><br><a href="main.html"> <-이전 </a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="제출">&nbsp;&nbsp;<input type="reset" value="내용지우기">
	</form>
</body>
</html>