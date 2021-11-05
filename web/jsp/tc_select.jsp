<%--  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/10/27
  Time: 20:27
  To change this template use File | Settings | File Templates.
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% application.setAttribute("path",request.getContextPath());%>
<html>
<head>
  <title>维信科技信息管理系统</title>
  <link type="text/css" rel="stylesheet" href="../bootstrap/bootstrap.min.css">
  <script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
  <style>
    #page_nav{
      position: absolute;
      left: 420px;
      top: 570px;
      font-size: 20px;
    }
    #pn_input{
      width: 30px;
    }
    .foot{
      position: absolute;
      left: 130px;
      top: 330px;
      width: 1000px;
      font-size: 18px;
    }
    .input{
      position: absolute;
      left: 1200px;
      top: 520px;
    }
  </style>
</head>
<body>
<div align="center" style="color: dodgerblue;font-size: 40px">
  维信科技管理平台
</div>

<div align="center">
  <a href="../index.jsp" style="color: #2e6da4;font-size: 20px">☛返 回 主 页</a>
</div>
<div style="color: red;font-size: 20px;height: 20px;margin-top: 2px" align="center">${error}</div>
<div align="center" style="margin-top: 10px">
  <form action="${path }/Select" method="post">
    <input type="hidden" name="status" value="classRoom">
    <font style="font-size: 18px">按班级查询: </font>
    <select name="room" style="width: 120px">
      <option value="" selected>- - -请选择- - -</option>
      <option value="all">全部</option>
      <option value="Java1103">Java1103班</option>
      <option value="Java1104">Java1104班</option>
      <option value="Java1105">Java1105班</option>
    </select>
    &emsp;
    <input type="submit" value="查询">
  </form>
</div>

<div>
  <table class="table table-hover" style="width: 1100px;" align="center">
    <thead>
    <tr>
      <th>学号</th>
      <th>姓名</th>
      <th>班级</th>
      <th>年龄</th>
      <th>分数</th>
      <th>详细信息</th>
      <th>修改</th>
      <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.items}" var="stu">
      <tr>
        <td>
            ${stu.num}
        </td>
        <td>
            ${stu.name}
        </td>
        <td>
            ${stu.room}
        </td>
        <td>
            ${stu.age}
        </td>
        <td>
            ${stu.score}
        </td>
        <td>
          <form action="${path }/Select" method="post">
            <input type="hidden" name="status" value="all">
            <input type="hidden" name="num" value="${stu.num}">
            <input type="submit" value="详细信息">
          </form>
        </td>
        <td>
          <form action="${path }/Update" method="post">
            <input type="hidden" name="status" value="updateTurn">
            <input type="hidden" name="room" value="${stu.room}">
            <input type="hidden" name="num" value="${stu.num}">
            <input type="submit" value="修改">
          </form>
        </td>
        <td>
          <form action="${path }/delete" method="post">
            <input type="hidden" name="status" value="deleteByNum">
            <input type="hidden" name="num" value="${stu.num}">
            <input type="hidden" name="room" value="${stu.room}">
            <input type="submit" value="删除">
          </form>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<div class="input">
  <form action="${path}/Insert" method="post">
    <input type="hidden" name="status" value="jump">
    <input type="submit" value="录入学生信息">
  </form>
</div>

<div id="page_nav">
  <a href="">首页</a>
  <a href="">上一页</a>
  <a href="">3</a>
  【4】
  <a href="">5</a>
  <a href="">下一页</a>
  <a href="">尾页</a>
  共10页，30条记录 到第<input value="4" name="pn" id="pn_input"/>页
  <input type="button" value="确定">
</div>

<div align="center" class="foot">
  <p class="foot">版权所有    Copyright &copy;   2008-2021    山西维信致远科技有限公司    晋ICP备14001858号-1    地址 :   山西省晋中市榆次区诸园文化</p>
</div>
</body>
</html>--%>


<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/10/23
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/10/23
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<%--
  Created by IntelliJ IDEA.
  User: YunboCheng
  Date: 2021/10/23
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% application.setAttribute("path",request.getContextPath());%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改信息</title>
    <%--<link type="text/css" rel="stylesheet" href="../bootstrap/bootstrap.min.css">--%>
    <script type="text/javascript" src="../bootstrap/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/index.css" type="text/css">
    <style>

        #page_nav a{
            color: blue;
        }
        #page_nav a:hover{
            color: red;
        }
        .tail{
            position: absolute;
            font-size: 18px;
            left: 410px;
            top: 670px;
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
            <div align="center" style="color: dodgerblue;font-size: 40px;margin-top: 10px">
                管理员信息管理平台
            </div>
        </div>
            <div>
                <table class="table table-hover" style="width: 1100px;margin-top: 30px;font-size: 20px" align="center">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>账号</th>
                        <th>删除</th>
                    </tr>
                    </thead>
                    <tbody align="center">
                    <c:forEach items="${list}" var="stu">
                        <tr>
                            <td>
                                    ${stu.id}
                            </td>
                            <td>
                                    ${stu.name}
                            </td>
                            <td>
                                    ${stu.account}
                            </td>

                            <td style="padding-top:2px">
                                <form action="${path }/tc_delete" method="post" style="margin-bottom: 13px;padding-top: 8px">
                                    <input type="hidden" name="status" value="deleteTcByName">
                                    <input type="hidden" name="name" value="${stu.name}">
                                    <input type="submit" value="删除">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="tail">
                版权所有    Copyright &copy;   2008-2021    山西维信致远科技有限公司    晋ICP备14001858号-1    地址 :   山西省晋中市榆次区诸园文化
            </div>
        </div>
    </div>
</div>

</body>
</html>
