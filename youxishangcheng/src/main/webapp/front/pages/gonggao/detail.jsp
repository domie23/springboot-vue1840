<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>

<!-- 首页 -->
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
</head>
<style>
</style>
<body>

    <div id="app">
    <!-- 标题 -->
    <!--  <h2 class="index-title">NEWS / INFORMATION</h2> -->
    <h2 class="index-title">公告</h2>
    <div class="line-container">
        <p class="line"> 公告 </p>
    </div>
    <!-- 标题 -->

    <!-- banner -->
    <div class="banner"></div>
    <!-- banner -->

    <div class="news-container">
        <h1 class="title">{{detail.gonggaoName}}</h1>
        <div class="auth-container" v-if="detail.insertTime">
            时间：{{detail.insertTime}}
        </div>

        <div class="content" v-html="myFilters(detail.gonggaoContent)">
        </div>

        <div class="bottom-container">
            <div class="title">
                本篇文章：{{detail.gonggaoName}}
            </div>
            <div onclick="back()" class="btn">
                返回列表
            </div>
        </div>
    </div>    </div>

<script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 组件配置信息 -->
<script src="../../js/config.js"></script>
<!-- 扩展插件配置信息 -->
<script src="../../modules/config.js"></script>
<!-- 工具方法 -->
<script src="../../js/utils.js"></script>

<script>
    Vue.prototype.myFilters= function (msg) {
        if(msg != null){
            return msg.replace(/\n/g, "<br>");
        }else{
            return "";
        }
    };
    var vue = new Vue({
        el: '#app',
        data: {
            // 轮播图
            swiperList: [],
            // 数据详情
            detail: {
                id: 0
            },
            // 商品标题
            title: '',

            storeupFlag: 0,//收藏 [0为收藏 1已收藏]
            //系统推荐
            gonggaoRecommendList: [],
            dataList: [],
            // 当前详情页表
            detailTable: 'gonggao',
        },
        //  清除定时器
        destroyed: function () {
            // 不知道具体作用
            // window.clearInterval(this.inter);
        },
        methods: {
            jump(url) {
                jump(url)
            }
            //预约
            ,gonggaoYuyue(){
                let _this = this;
                // localStorage.setItem('gonggaoId', _this.detail.id);
                // _this.jump("../gonggaoOrder/add.jsp");

                let data={
                    gonggaoId:_this.detail.id,
                    yonghuId:localStorage.getItem("userid"),
                    gonggaoOrderYesnoTypes:1,
                }
                // 提交数据
                layui.http.requestJson('gonggaoOrder/add', 'post', data, function (res) {
                    if(res.code == 0) {
                        layui.layer.msg('预约成功', {
                            time: 2000,
                            icon: 6
                        }, function () {
                            _this.jump("../gonggaoOrder/list.jsp");
                        });
                    }else{
                        layui.layer.msg(res.msg, {
                            time: 5000,
                            icon: 5
                        });
                    }
                });
            },
        }
    });

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery', 'laypage', 'rate'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;
        var laypage = layui.laypage;
        var rate = layui.rate;//评分

        var limit = 10;

        // 设置数量
        jquery('#buyNumber').val(vue.buyNumber);

        // 数据ID
        var id = http.getParam('id');
        vue.detail.id = id;
        // 当前详情
        http.request(`${vue.detailTable}/detail/` + id, 'get', {}, function (res) {
            // 详情信息
            vue.detail = res.data;
            vue.title = vue.detail.gonggaoName;
           // 轮播图片
            vue.swiperList = vue.detail.gonggaoPhoto ? vue.detail.gonggaoPhoto.split(",") : [];
            var swiperItemHtml = '';
            for (let item of vue.swiperList) {
                swiperItemHtml +=
                        '<div>' +
                        '<img class="swiper-item" src="' + item + '" style="margin-top: 50px;" >' +
                        '</div>';
            }
            jquery('#swiper-item').html(swiperItemHtml);
            // 轮播图
            carousel.render({
                elem: '#swiper',
                width: swiper.width, height: swiper.height,
                arrow: swiper.arrow,
                anim: swiper.anim,
                interval: swiper.interval,
                indicator: swiper.indicator
            });
        });

        // 系统推荐
        http.request(`gonggao/list`, 'get', {
            page: 1,
            limit: 5,
            gonggaoTypes: vue.detail.gonggaoTypes,


        }, function (res) {
            vue.gonggaoRecommendList = res.data.list;
        });



    });





</script>
</body>
</html>
