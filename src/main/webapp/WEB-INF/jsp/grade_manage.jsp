<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>加分申请处理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all"/>
    <!--<link rel="stylesheet" href="//at.alicdn.com/t/font_eolqem241z66flxr.css" media="all" />-->
    <link rel="stylesheet" href="/css/message.css" media="all"/>
    <link rel="stylesheet" href="/css/reset.css" media="all"/>
    <script type="text/javascript" src="/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="/layui/layui.js"></script>
    <style>
        .layui-elem-quote {
            padding: 10px;
        }

        .layui-word-aux {
            font-size: 20px;
            margin-left: -130px;
        }

        .layui-table th {
            text-align: center;
        }

        .layui-table td {
            text-align: center;
        }

        /*.layui-talbe td a {

        }*/
        .lookMore, .agree, .reject {
            font-size: 12px;
            background-color: cadetblue;
            color: #FFFFFF;
            padding: 2px;
            border-radius: 3px;
            margin-right: 5px;
            opacity: 0.4;
            transition: opacity 1s;
            -moz-transition: opacity 1s; /* Firefox 4 */
            -webkit-transition: opacity 1s; /* Safari 和 Chrome */
            -o-transition: opacity 1s;
        }

        .lookMore:hover {
            background-color: cadetblue;
            opacity: 1;
            color: #FFFFFF;
        }

        .agree {
            background-color: green;
        }

        .agree:hover {
            opacity: 1;
            background-color: green;
            color: #FFFFFF;
        }

        .reject {
            background-color: red;
        }

        .reject:hover {
            opacity: 1;
            background-color: red;
            color: #FFFFFF;
        }

        .mask {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: #000000;
            opacity: 0.4;
            /*z-index: 5;*/
            display: none;
        }

        .activity_describe {
            margin-top: 200px;
            position: absolute;
            top: 0;
            left: 50%;
            margin-left: -250px;
            width: 500px;
            border: 1px solid #999999;
            border-radius: 3px;
            display: none;
            /*padding: 15px;*/
        }

        .activity_describe h3 {
            float: left;
            font-size: 20px;
            /*margin: 10px;*/
            margin-left: 10px;
            color: #999999;
        }

        .activity_header {
            background-color: #f2f2f2;
            /*padding: 2px;*/
            /*height: 40px;
            line-height: 40px;*/
            overflow: hidden;
        }

        .activity_header .clear {
            float: left;
            display: inline-block;
            height: 40px;
            width: 3px;
            background-color: #009688;
        }

        .activity_content {
            /*padding: 15px;*/
            margin-top: 50px;
            /*position: absolute;
            z-index: 10;*/

        }

        .describe-close {
            float: right;
            font-size: 16px;
            background-color: #F2F2F2;
            color: #999999;
        }

        .application-for-activity {
            margin-bottom: 10px;
        }

        table {
            table-layout: fixed;
        }

        /*设置页面超出指定范围为省略号*/
        .cont {
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
        }

        .activity_describe {
            display: none;
            position: absolute;
            top: 0;
            left: 0;
            width: 99%;
            height: 98%;
            margin-left: 8px;
            margin-top: 8px;
            background-color: #FFFFFF;
            border: none;
        }

        .activity_describe .activity-detail-block h4 {
            /*float: left;*/
            margin: 0;
            font-size: 20px;
            color: #999
        }

        .describe-close {
            /*display: inline-block;*/
            position: absolute;
            right: 20px;
            top: 15px;
            float: right;
            cursor: pointer;
            text-decoration: none;
            font-size: 20px;
            font-weight: bold;
            color: #9999;
        }
    </style>
</head>
<body>
<div class="childrenBody">
    <form class="layui-form">
        <blockquote class="layui-elem-quote application-for-activity" style="justify-content: flex-end">
            <div class="layui-inline selectMsg"></div>
            <div class="layui-inline">
                <div class="layui-form-mid layui-word-aux">申请列表</div>
                <div class="layui-upload">
                    <input type="file" name="file1"  lay-type="file" class="layui-upload-file">
                    <%--<button type="button" class="layui-btn layui-btn-normal" id="test">选择文件</button>--%>
                    <%--<button type="button" class="layui-btn" id="btn-excel-sure">开始上传</button>--%>
                </div>
            </div>

        </blockquote>



        <table class="layui-table">
            <colgroup>
                <col width="20%">
                <col width="10%">
                <col width="25%">
                <col width="10%">
                <col width="10%"/>
                <col width="25%"/>
            </colgroup>
            <thead>
            <!--主席的功能添加部门，删除部门，查看部门简介即通过点击部门简介可以链到前台界面-->
            <tr>
                <th>姓名</th>
                <th>学号</th>
                <th>时间</th>
                <th>分值</th>
                <th>状态</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody class="links_content" id="j_tb"></tbody>
        </table>
    </form>
</div>

<div class="activity_describe">
    <div class="activity_header">
        <div class="clear"></div>
        <blockquote class="layui-elem-quote activity-detail-block">
            <h4>加分证明</h4>
            <a href="javascript:void(0);" class="describe-close">x</a>
        </blockquote>
    </div>
    <div class="activity_content"></div>
</div>

<script src="layui/layui.js"></script>
<script>
    layui.use('upload', function () {
        layui.upload({
            url: '/grade/upload' //上传接口
            , ext: 'xlsx|xls'
            , success: function (res) { //上传成功后的回调

                if(res.code===200){
                    layer.msg("数据导入成功");
                }
                window.location.reload();
            }
        });
    });
</script>

<script>

    $(function () {

        var application = (function () {

            function init() {
                render();
            }

            function render() {
                $.ajax({
                    type: "post",
                    url: "/grade/getAllGrade",
                    async: true,
                    dataType: "json",
                    success: function (data) {
                        $.each(data, function (i, data) {
                            if (data.g_status == "0") {
                                var activity_status = "待处理";
                            } else if (data.g_status == "1") {
                                var activity_status = "已通过";
                            }
                            var $tr = '<tr><td>' + data.s_name + '</td><td>' + data.s_num + '</td><td>' + data.g_time + '</td><td><div>' + data.g_value + '</div></td><td>' + activity_status + '</td><td><a g_id = "' + data.g_id + '" href="javascript:void(0);" class="lookMore" onclick="lookMore(this)";><i  class="layui-icon">&#xe60a;</i>查看</a><a href="javascript:void(0);" g_id = "' + data.g_id + '" class="agree" onclick="agree(this)"><i class="layui-icon">&#x1005;</i>通过</a><a href="javascript:void(0);" g_id = "' + data.g_id + '"  class="reject" onclick="reject(this)"><i class="layui-icon">&#x1007;</i>驳回</a></td></tr>';
                            $("tbody").append($tr);

                        });
                    }
                });
            }

            return {
                init: init
            }

        })();

        application.init();


        //点击查看更多弹出框的x，关闭弹出框
        $(".describe-close").click(function () {
            $(".activity_describe").hide();
            $(".mask").hide();
        })

    })
</script>

<script>
    //点击查看详细活动描述
    function lookMore(obj) {
        var g_id = $(obj).attr("g_id");
        $.ajax({
            type: "post",
            url: "/grade/getGrade",
            async: true,
            data: {
                "g_id": g_id
            },
            dataType: "json",
            success: function (data) {
                //从后台把活动描述传过来
                $(".activity_content").html(data.g_prove);
            }
        });
        $(".activity_describe").show();
        $(".mask").show();
    }

    //点击同意申请状态改变
    function agree(obj) {
        var $this = $(obj);
        //前端活动状态变为已同意
        $this.parent().siblings(".activity-status").html("已通过");
        var g_id = $this.attr("g_id");
//				向后台传递状态值
        $.ajax({
            type: "post",
            url: "/grade/updateStatus",
            async: true,
            dataType: "json",
            data: {
                "g_id": g_id,
                "g_status": "1"
            },
            success: function (data) {
                window.location.reload();
            }
        });
    }

    //点击驳回申请状态改变
    function reject(obj) {
        var $this = $(obj);
        $this.parent().siblings(".activity-status").html("已驳回");
        var g_id = $this.attr("g_id");
        //向后台传递状态值
        $.ajax({
            type: "post",
            url: "/activity/updateStatus",
            async: true,
            dataType: "json",
            data: {
                "g_id": g_id,
                "g_status": "2"
            },
            success: function (data) {
                window.location.reload();
            }
        });
    }
</script>


</body>
</html>