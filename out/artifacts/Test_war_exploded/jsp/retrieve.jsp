<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% application.setAttribute("path",request.getContextPath());%>
<head>
    <meta charset="UTF-8">
    <title>学生管理系统</title>
    <style>
        .divHead1{
            margin-top: 25px;
            margin-left:150px;
            width: 300px;
            float: left;
        }

        .divHead2{
            margin-top: 20px;
            margin-right: 180px;
            float: right;
            font-size: 18px;
        }

        .mydiv{
            height: 80px;
        }
        .span1{
            font-size: 30px;
            text-align: center;
        }
        .ordinary{
            width: 360px;
            height: 40px;
            margin-top: 10px;
            border-radius: 10px;
            border:2px solid  rgba(0,0,0,0.25);
        }
        .bottom{
            font-size: 15px;
            margin-top: 160px;
            color: #8c8c8c;
            text-align: center;
        }
        .mySubmit{
            color: #19aa8d;
            border:none;
            background:none;
            cursor:pointer;
            outline:none;
        }
        .bigDiv{
            width: 1500px;
            height: 230px;
            background-color: white;

        }
        body{
            margin: 0;
        }
        .divBody-one{
            float: right;
            margin-top: 28px;
            margin-right: 180px;
            background: white;
            border:1px solid #000;
            width:400px;
            height:500px;
            border-radius:10px;
        }
        .divBody-two{
            float: left;
            margin-left: 150px;
            margin-top: 60px;
        }
        .foot{
            font-size: 15px;
            color: black;
        }
        a:hover{
            color: blue;
        }
        a{
            color: #19aa8d;
            text-decoration:none
        }
    </style>
</head>

<div class="bigDiv">
    <%--head--%>
    <div class="mydiv">
        <div class="divHead1">
            <img src="../image/logo.png" width="180px" alt="加载失败">
        </div>
        <div class="divHead2">
            <p>CH&nbsp;&nbsp;|&nbsp;&nbsp;<a href="../jspEn/retrieve2.jsp">EN</a></p>
        </div>
    </div>
    <%--身体--%>
    <div>
        <div  class="divBody-one">
            <div align="center" style="margin-top: 25px">
                <span class="span1" ><b>密码找回系统</b></span>
            </div>
            <div align="center" style="margin-top: 10px">
                <span style="color: red;font-size: 20px;">${back}<br></span>
                <form action="${path }/Select" method="post">
                    <input type="hidden" name="status" value="back"><br>
                    <input type="text" name="name" placeholder="请输用户名" class="ordinary"><br>
                    <input  type="password" name="account" placeholder="请输入账号" class="ordinary">
                    <input type="submit" value="立即找回" style="background: #19aa8d;border: none;width: 370px;" class="ordinary">
                </form>
            </div>

            <div class="bottom">
                想起了密码?<a href="../login.jsp">立即登录</a>
            </div>
        </div>
        <div class="divBody-two">
            <img src="../image2/back.png" alt="图片加载失败！">
        </div>

    </div>
    <div align="center" style="margin-top: 580px">
        <p class="foot">版权所有    Copyright &copy;   2008-2021    山西维信致远科技有限公司    晋ICP备14001858号-1    地址 :   山西省晋中市榆次区诸园文化</p>
    </div>
</div>
</body>
</html>
