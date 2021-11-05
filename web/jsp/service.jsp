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
        a:hover{
            color: blue;
            text-decoration:underline;
        }
        a{
            text-decoration:none;
            color: red;
        }
        .mid{
            margin-top: 0;
        }
    </style>

</head>
<body>

<div class="head">
    <div class="head1">
        <img src="../image/logo.png" alt="image Failed ToLoad！" class="logo" width="150px">
    </div>
    <div class="head2">
        <p class="register" >服务条款</p>
    </div>
</div>

<div class="neck">
    <div class="exist">
        <p>请仔细阅读以下服务条款</p>
    </div>
</div>

<div class="divBody">
    <div class="mid">
        <div align="center" style="color: red">欢迎您访问维信科技管理平台！</div>
        维信科技管理平台（以下简称 "维信科技"）依据以下条例和条款提供您所拥有的服务。本《服务条款》（或称《用户协议》）为使用者访问和使用本网站及其服务的条件和条款规定如下：<br>
        <br>
        一、接受条款<br>
        使用者（也称"您"）在访问或使用本网站及其服务时，即已经表示同意并不加修改地接受本《用户协议》、本网站的《隐私声明》、《法律声明》以及其关或相链接的网页和网站的条件和条款的规定。我们强烈建议：在您阅读和接受本《用户协议》时，也应阅读并接受本《用户协议》中所提到《隐私声明》、《法律声明》及其相关或相链接网页或网站所包含的资料，因为《隐私声明》、《法律声明》及其它相关网页或网站可能包含对您适用的进一步规定。（请注意：点击划有底线的词句即可链接到上述《隐私声明》、《法律声明》及其它相关或相链接的网页和网站。<br><br>
        二、使用者的资格要求<br>
        在本网站中"使用者"指的是浏览、阅读、使用本网站信息或服务的任何个人或组织。本网站的服务仅适用于根据相关法律的规定具有签订有约束力的合同的个人或组织并仅由其使用。本网站的服务不向18周岁以下的个人使用者提供，也不向临时被本网站中止或取消使用者资格的使用者提供。如果使用者不符合本条规定，请停止使用本网站或本网站的服务。
        <br>
        <br>
        三、本网站的所有权
        <br>
        山西太原维新致远有限公司（简称"维新科技"）为本网站内所有资料的著作权、本网站"logo"标志、"维信科技网"网络实名。本公司的法定地址为：山西省晋中市榆次区诸园文化
        <br>
        <br>
        四、本网站的服务范围
        <br>
        本网站的基本服务包括为使用者提供和维护一个公布相关交易信息并就货物和服务的交易进行协商以达成 交易目的的一个虚拟的网络交易平台，本网站的服务还包括为了上述目的的而为使用者提供的在相应法律法规允许范围内的服务等。
        <br>
        </p>
        <div align="center"><a href="register.jsp">我已详细阅读，返回注册页面</a></div>
    </div>
    <div align="center" style="margin-top: 20px;height: 38px">
        <p class="foot">版权所有    Copyright &copy;   2008-2021    山西维信致远科技有限公司    晋ICP备14001858号-1    地址 :   山西省晋中市榆次区诸园文化</p>
    </div>
</div>
</body>
</html>
