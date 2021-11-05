<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/10/24
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取这个web项目的根路径--%>
<% application.setAttribute("path",request.getContextPath());%>
<script type="text/javascript" src="../JQuery/jquery-3.6.0.js"></script>
<html>
<head>
    <title>Registration System</title>
    <style>
        body{
            border:0;
        }
        a:hover{
            text-decoration:underline;
        }
        a{
            text-decoration:none
        }
        .head{
            height: 70px;
            width: 1530px;
            background-color: #ffffff;
            border:0;
            margin-top: 0;
            margin-right: 0;
        }
        .head1{
            float: left;
            margin-top:15px;
            margin-left: 150px;
            width: 150px;
        }
        .head2{
            float: left;
            margin-left: 20px;
            margin-top: 0px;
            width: 150px;
            font-size: 25px;
        }
        .head3{
            float: right;
            margin-top: 10px;
            margin-right: 150px;
            width: 100px;
            font-size: 18px;
        }
        .register{
            margin-top: 18px;
        }
        .neck{
            height: 60px;
            background-color: #eff5f9;
        }
        .exist{
            float: right;
            margin-right: 150px;
        }
        .divBody{
            background-color: #eff5f9;
        }
        .mid{
            margin-right: 150px;
            margin-left: 150px;
            height: 500px;
            background-color: white;
        }
        .mid{
            text-align: center;
        }

        .divOne{
            height: 50px;
            font-size: 30px;
            padding-top: 20px;
            padding-left:70px ;
        }
        #error{
            color: red;
            font-size: 20px;
            height: 30px;
            padding-left: 75px;
        }
        .common{
            width: 280px;
            height: 50px;
            margin-top: 15px;
            border-radius: 10px;
            border:2px lightsteelblue solid;

        }
        #checkbox{
            float: left;
            padding-top: 15px;
            margin-left: 460px;
        }
        #protocol{
            float: right;
            padding-top: 15px;
            margin-right:430px ;
        }
        .divTwo{
            height: 40px;
        }
        .divThree{
            height: 100px;
        }
        #submit{
            padding-top: 15px;
            float: left;
            margin-left: 420px;
        }
        #reset{
            padding-top: 15px;
            float: right;
            margin-right: 420px;
        }
        .button{
            border-radius: 10px;
            margin:0;
            border:none;
            width:180px;
            background-repeat:no-repeat;
            background-color: #19aa8d;
            height:40px;
            padding-top:0;
        }
    </style>

    <%--以下是JQuery事件--%>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#form").submit(function(){
                alert("Are You Sure?");
            });
        });
    </script>

</head>
<body>

<div class="head">
    <div class="head1">
        <img src="../image/logo.png" alt="image Failed ToLoad！" class="logo" width="150px">
    </div>
    <div class="head2">
        <p class="register" >REGISTER</p>
    </div>
    <div class="head3">
        <p><a href="../jsp/register.jsp" style="color: #19aa8d;">CH</a>&nbsp;&nbsp;|&nbsp;&nbsp;EN</p>
    </div>
</div>

<div class="neck">
    <div class="exist">
        <p>Already Have An Account?<a href="../login.jsp" style="color: blue">LogIn Now</a></p>
    </div>
</div>

<div class="divBody">
    <div class="mid">
        <form action="${path }/myWeb" method="post" style="height: 400px;" id="form">
            <input type="hidden" name="status" value="registered">
            <div class="divOne">User Registration</div>
            <div id="error">${error}</div>
            userName：&nbsp;<input type="text" name="name" placeholder="Required" class="common"><br>
            loginAccount：&nbsp;<input type="text" name="account" placeholder="6~11 digits" class="common"><br>
            loginPassword：&nbsp;<input type="password" name="password" placeholder="Numbers 、Letters、SpecialSymbols" class="common"><br>
            confirmPassword：<input type="password" name="password1" placeholder="enter The Password Again" class="common"><br>
            <div class="divTwo">
                <div id="checkbox">
                    <input type="checkbox" name="protocol" value="protocol" style="zoom: 130%">
                </div>
                <div id="protocol">
                    <span style="font-size: 15px">同意并遵循 <a href="../jsp/service.jsp">《服务条款》</a>和<a href="../jsp/privacy.jsp">《隐私协议》</a></span>
                </div>
            </div>

            <div class="divThree">
                <div id="submit">
                    <input type="submit" value="register" class="button">
                </div>
                <div id="reset">
                    <input type="reset" value="reset" class="button">
                </div>
            </div>
        </form>
    </div>
    <div align="center" style="margin-top: 20px;height: 38px">
        <p class="foot">all Rights Reserved    Copyright &copy;   2008-2021    SHANXI_WEIXIN_ZHIYUAN_TECHNOLOGY_CO_LTD    晋ICP备14001858号-1    Address:Zhuyuan Culture in Yuci District, Jinzhong City, Shanxi Province</p>
    </div>
</div>
</body>
</html>
