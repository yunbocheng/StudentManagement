<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/10/23
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% application.setAttribute("path",request.getContextPath());%>
<html>
<head>
    <title>删除学生信息</title>
    <link rel="stylesheet" href="../css/index.css" type="text/css">
    <style>
        .update{
            font-size: 30px;
            color: black;
            text-align: center;
            margin-top: 40px;
        }
        .divOne{
            margin-right: 60px;
        }
        .button{
            border-radius: 10px;
            margin:0;
            border:none;
            width:100px;
            background-repeat:no-repeat;
            background-color: #19aa8d;
            height:30px;
            padding-top:0;
        }
        .common{
            width: 280px;
            height: 40px;
            margin-top: 15px;
            border-radius: 10px;
            border:2px lightsteelblue solid;
        }
    </style>
</head>
<body>
<div>

    <div class="head">
        <div class="headOne">
            <p id="system">维信科技信息管理平台</p>
        </div>

        <div class="headTwo">
            <div class="headTwo_two">
                <form action="${path }/Jump" method="post">
                    <div>
                        <div style="float:right;margin-right: 500px;margin-top: 20px;">
                            <input type="hidden" name="status" value="jump">
                            <input type="text" name="template" placeholder="输入需求" id="demand">
                        </div>
                        <div style="float:left;margin-left: 570px;margin-top: 22px">
                            <input type="image" src="../image/搜索.png" name="img" style="width: 20px;">
                        </div>
                    </div>
                </form>
            </div>
        </div>

        <div class="headThree">
            <div class="info" style="margin-top: 10px">
                <img src="../image/样式.png" alt="图片加载失败！">
            </div>

            <div class="manager">
                <div id="manager_one">
                    <img src="../image2/管理员.png" alt="图片加载失败" width="30px">
                </div>
                <div id="manager_two">
                    <div style="font-size: 20px;color:white;">${name}</div>
                </div>
            </div>

            <div class="quit">
                <a class="quit" href="${path}/myWeb?status=quit">☛退 出 登 录</a>
            </div>
        </div>
    </div>
    <div class="body_one">
        <div class="function1">
            🚀功能菜单
        </div>
        <div class="operating">
            <img src="../image/搜索.png" alt="加载失败" width="25px">&nbsp;&nbsp;<span><a href="${path }/tc_select?status=selectByAll">查询用户信息</a></span><br><br>
            <img src="../image/替换.png" alt="加载失败">&nbsp;&nbsp;&nbsp;<span><a href="../jsp/tc_update.jsp">更改用户密码</a></span><br><br>
            <img src="../image/删除.png" alt="加载失败">&nbsp;<span><a href="../jsp/tc_delete.jsp">删除用户信息</a></span><br><br>
            <br>
            <br>
            <img src="../image/搜索.png" alt="加载失败" width="25px">&nbsp;&nbsp;<span><a href="${path }/Select?status=page">查询学生信息</a></span><br><br>
            <img src="../image/替换.png" alt="加载失败">&nbsp;&nbsp;&nbsp;<span><a href="../jsp/update.jsp">修改学生信息</a></span><br><br>
            <img src="../image/新增.png" alt="加载失败">&nbsp;&nbsp;<span><a href="../jsp/insert.jsp">录入学生信息</a></span><br><br>
            <img src="../image/删除.png" alt="加载失败">&nbsp;<span><a href="../jsp/delete.jsp">删除学生信息</a></span><br><br>
            <img src="../image2/比例.png" alt="加载失败">&nbsp;<span><a href="${path }/Info?status=infoIcon">查看学生分数</a></span><br><br>
        </div>
    </div>

    <div class="body_two">
        <div class="body_head">
            <div class="home">
                <a href="../index.jsp"><img src="../image/主页.png" alt="图片加载失败！"></a>
            </div>
            <div class="drop">
                <img src="../image2/下拉条.png" alt="图片加载失败！">
            </div>
        </div>

        <div class="body_tail">
            <div class="update">
                <div class="function">删除管理员信息</div>
            </div>
            <div class="content" align="center">
                <p style="font-size: 20px;color: red">${delete}</p>
                <div class="divOne">
                    <form action="${path }/tc_delete" method="post">
                        <input type="hidden" name="status" value="deleteTc">
                        管理员姓名：&nbsp;&nbsp;<input type="text" name="name" placeholder="请输入管理员姓名" class="common"><br><br>
                        <input type="submit" value="删除" class="button" style="margin-left: 55px;margin-top: 15px">
                        <input type="reset" value="重置"class="button" style="margin-left: 80px">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
