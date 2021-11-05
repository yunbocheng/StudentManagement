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
  <title>学生班级分布图</title>
  <link rel="stylesheet" href="../css/index.css" type="text/css">
  <script src=../js/echarts.min.js type="text/javascript"></script>
  <script src="../JQuery/jquery-3.6.0.js"  type="text/javascript"></script>
  <style>
    #pie1{
      width: 400px;
      height:360px;
      padding-right: 40px;
      margin-top: 20px;

    }
    .mydiv{
      font-size: 45px;
      color: #1e90ff;
      margin-top: 25px;
      text-align: center;
    }
    .rim{
      border-radius: 10px;
      border: 2px #3c374a dashed;
      width: 900px;
      margin-left: 450px;
      margin-top: 20px;
      height: 440px;
    }
    #button01{
      margin-top: 0;
      margin-left: 230px;
      border-radius: 10px;
      border:none;
      width:130px;
      background-repeat:no-repeat;
      background-color: #19aa8d;
      height:40px;
      padding-top:0;
      font-size: 15px;
    }
    .div1{
      height: 100px;
      margin-top: 30px;
    }
    .div2{
      font-size: 25px;
      text-align: center;
    }
    .myTable{
      margin-left: 60px;
      font-size: 16px;
    }
    td{

    }
  </style>
</head>
<body>
<%--写一个隐藏于，用来获取绝对路径--%>
<input type="hidden" id="path" value="${path }"/>
<script type="text/javascript">
  $(document).ready(function () {
    $("#button01").click(function () {
      var path = $("#path").val();
      $.ajax({
       type:'post',
       data:'status=info',
       dataType:'json',
       url:path +'/Info',
       success:function (msg) {
         console.log(msg)
         var myChart = echarts.init($("#pie1").get(0));
         var option = {
           title: {
             text: '班级信息饼状图',
             subtext: 'Fake Data',
             left: 'center'
           },
           tooltip: {
             trigger: 'item',
             formatter: '{a} <br/>{b} : {c} ({d}%)'
           },
           legend: {
             orient: 'vertical',
             left: 'left'
           },
           series: [
             {
               name: 'Access From',
               type: 'pie',
               radius: '50%',
               data: msg,
               emphasis: {
                 itemStyle: {
                   shadowBlur: 10,
                   shadowOffsetX: 0,
                   shadowColor: 'rgba(0, 0, 0, 0.5)'
                 }
               }
             }
           ]
         };
         myChart.setOption(option);
       }
      });
    });
  });
</script>
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
      <div class="mydiv">学生信息统计图</div>
      <div class="rim">
          <div id="pie1" style="float:right;">

          </div>

        <div style="float:left;height: 380px;margin-top:3px;width: 350px;margin-left: 20px">
          <div class="div1">
            <div style="text-align: center;font-size: 30px">班级成绩表</div>
            <br>
            <div class="div2">Java1103班</div>
            <table class="myTable">
              <tr>
                <td>
                  👑最高分：
                </td>
                <td>
                  ${sessionScope.listScore.get(0).maxScore}&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                  🎉最低分：
                </td>
                <td>
                  ${sessionScope.listScore.get(0).minScore}
                </td>
              </tr>
              <tr>
                <td>
                  🧠平均分：
                </td>
                <td>
                  ${sessionScope.listScore.get(0).avgScore}
                </td>
              </tr>
            </table>
          </div>
          <br><br>
          <div class="div1">
            <div class="div2">Java1104班</div>
            <table class="myTable">
              <tr>
                <td>
                  👑最高分：
                </td>
                <td>
                  ${sessionScope.listScore.get(1).maxScore}&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                  🎉最低分：
                </td>
                <td>
                  ${sessionScope.listScore.get(1).minScore}
                </td>
              </tr>
              <tr>
                <td>
                  🧠平均分：
                </td>
                <td>
                  ${sessionScope.listScore.get(1).avgScore}
                </td>
              </tr>
            </table>
          </div>
          <div class="div1">
            <div class="div2">Java1105班</div>
            <table class="myTable">
              <tr>
                <td>
                  👑最高分：
                </td>
                <td>
                  ${sessionScope.listScore.get(2).maxScore}&nbsp;&nbsp;&nbsp;
                </td>
                <td>
                  🎉最低分：
                </td>
                <td>
                  ${sessionScope.listScore.get(2).minScore}
                </td>
              </tr>
              <tr>
                <td>
                  🧠平均分：
                </td>
                <td>
                  ${sessionScope.listScore.get(2).avgScore}
                </td>
              </tr>
            </table>
          </div>
        </div>
        <button type="button" id="button01">学生班级占比图</button>
      </div>
    </div>
  </div>
</div>
</body>
</html>
