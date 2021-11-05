<!DOCTYPE html>
<html lang="en">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% application.setAttribute("path",request.getContextPath());%>
<head>
    <meta charset="UTF-8">
    <%--导入bootstrap的依赖--%>
    <link rel="stylesheet" href="bootstrap/bootstrap.min.css">
    <script type="application/javascript" src="bootstrap/bootstrap.min.js"></script>
    <title>学生管理系统</title>
    <style>
        .divHead1{
            margin-top: 16px;
            margin-left:42px;
            width: 300px;
            float: left;
        }
        .divHead2{
            margin-top: 20px;
            margin-right: 41px;
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
            width:1540px;
            height: 700px;
            background-color: white;
        }
        body{
            margin: 0px;
        }
        .divBody-one{
            float: right;
            margin-top: 28px;
            margin-right: 100px;
            background: white;
            border:1px solid #000;
            width:400px;
            height:500px;
            border-radius:10px;
        }
        .divBody-two{
            float: left;
            margin-left: 60px;
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
            <img src="image/logo.png" width="180px" alt="加载失败">
        </div>
        <div class="divHead2">
            <p>CH&nbsp;&nbsp;|&nbsp;&nbsp;<a href="jspEn/login2.jsp">EN</a></p>
        </div>
    </div>
    <%--身体--%>
    <div>
    <div  class="divBody-one">
            <div align="center" style="margin-top: 25px">
                <span class="span1" ><b>维信科技管理平台</b></span>
            </div>
            <div align="center" style="margin-top: 10px">
                <span style="color: red;font-size: 20px;">${message}<br></span>
                <form action="${path }/myWeb" method="post">
                    <input type="hidden" name="status" value="login"><br>
                    <input type="text" name="account" placeholder="请输入账号" class="ordinary"><br>
                    <input  type="password" name="password" placeholder="请输入密码" class="ordinary">
                    <input type="submit" value="登录" style="background: #19aa8d;border: none;width: 370px;" class="ordinary">
                </form>
            </div>
        <div>
            <div style="margin-top: 20px;margin-left: 20px;float:left;">
                    <div style="float:left;">
                        <form action="${path }/myWeb">
                            <input type="checkbox" name="remember" value="remember">
                        </form>
                    </div>

                    <div style="float:right;height: 10px;color: #19aa8d;font-size: 14px;">
                        记住密码
                    </div>
            </div>

            <div style="margin-top: 22px;margin-right: 20px;float:right;">
                <p style="color: #19aa8d;font-size: 14px" ><a href="jsp/retrieve.jsp">忘记密码？</a></p>
            </div>
        </div>
        <div class="bottom">
            <form action="${path }/myWeb" method="post">
                <input type="hidden" name="status" value="register">
                还没有维信科技系统账号?
                <input class="mySubmit" type="submit" value="免费注册 " style="width: 68px;"/>&gt;
            </form>
        </div>
    </div>
<div class="divBody-two">
    <img src="image/homePage.png" alt="图片加载失败！">
</div>

</div>
    <div align="center" style="margin-top: 580px">
        <p class="foot">版权所有    Copyright &copy;   2008-2021    山西维信致远科技有限公司    晋ICP备14001858号-1    地址 :   山西省晋中市榆次区诸园文化</p>
    </div>
</div>
</body>
</html>
