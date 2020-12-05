<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <style>
	    #title{
		    font-size: 25px;
		    font-weight: bold;
		    color: rgb(11, 11, 85);
		    margin-right: auto;
		    transform: rotate(-30deg);
		    width: fit-content;
		    height: fit-content;
		    padding-top: 60px;
		}
		button{
		    width: 180px;
		    height: 40px;
		    line-height: 40px;
		    background-color: rgb(20, 157, 211);
		    color: white;        
		    text-align: center;
		    float: right;          
		}
		#todo, #doing, #done{         
		    width: 250px;
		    height: 40px;
		    line-height: 40px;
		    background-color: rgb(6, 52, 71);
		    color: white;        
		    text-align: left;
		    margin: 15px;
		    padding: 20px;
		}
		
		#todoing, #doinging, #doneing{         
		    width: 250px;
		    height: 40px;
		    font-size: 12px;
		    background-color: rgb(8, 172, 243);
		    color: white;        
		    text-align: left;
		    margin: 15px;
		    padding: 20px;
		}
		
		#fromtodo{
		    width: 20px;
		    height: 20px;
		    line-height: 15px;
		    text-align: center;
		    font-size: 12px;
		    color: black;
		    background-color: white;
		}
		
		ul, #title{
		    float : left;
		}
		ul{
		    list-style: none;
		}
    </style>
    <title>ToDoList</title>
</head>
<body>
	<div id = title>나의 해야할 일들</div>
    <button type="button" onclick="location.href='todoForm.html'">새로운 TODO등록</button>
    <br><br>
    <ul>
        <li id = "todo">TODO</li>
        <c:forEach items="${todolist}" var="todo">

		<li id = "doinging"><a style="font-size: 15px; color: black;">${todo.title }</a><br>
		${todo.regdate } ${todo.name }, 우선순위: ${todo.sequence } 
		<form method="post" action="todoup">
		<input type="hidden" name="todoupf" value=${todo.id }>
		<input id="fromtodo" type="submit" value=">"></form></li>			
		</c:forEach>
    </ul>
    <ul>
        <li id = "doing">DOING</li>
        <c:forEach items="${doinglist}" var="doing">

		<li id = "todoing"><a style="font-size: 15px; color: black;">${doing.title }</a><br>
		${doing.regdate } ${doing.name }, 우선순위: ${doing.sequence } 
		<form method="post" action="doingup">
		<input type="hidden" name="doingupf" value=${doing.id }>
		<input id="fromtodo" type="submit" value=">"></form></li>			
		</c:forEach>
    </ul>
    <ul>
        <li id = "done">DONE</li>
        <c:forEach items="${donelist}" var="done">

		<li id = "doneing"><a style="font-size: 15px; color: black;">${done.title }</a><br>
		${done.regdate } ${done.name }, 우선순위: ${done.sequence } 
		</li>			
		</c:forEach>
    </ul>
</body>
</html>