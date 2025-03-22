<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page isELIgnored="true" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name='viewport' content='width=device-width, initial-scale=1.0, maximum-scale=1.0'/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>首页</title>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/color.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/global.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/page.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/uzlist.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/fancybox.css"/>
    <script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/superslide.2.1.1.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/wow.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/fancybox.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/common.js"></script>
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/aos.css" />
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../xznstatic/css/idangerous.swiper.css" />
    <link rel="stylesheet" href="../../xznstatic/css/lightbox.css">
    <link rel="stylesheet" href="../../xznstatic/css/app.css" />
    <link rel="stylesheet" href="../../xznstatic/css/apmin.css" />
    <link rel="stylesheet" href="../../css/theme.css" />
    <script type="text/javascript">
        var CATID = "0",
            BCID = "0",
            NAVCHILDER = "",
            ONCONTEXT = 0,
            ONCOPY = 0,
            ONSELECT = 0;
    </script>
    <style>
        .ng-djn-txt {
            text-align: justify;
            text-justify: inter-ideograph;
            word-wrap: break-word;
            word-break: break-all;
        }

        .ng-inpusbox {
            text-indent: 0px;
        }

        .jishuzichis a {
            font-size: 12px;
            color: #878787;
        }

        .ng-siotext {
            line-height: 50px;
        }

        @media screen and (max-width: 992px) {
            .ng-zein-iten-link li {
                width: 50%;
                text-align: center;
            }

            .ng-zein-iten-link li.li {
                width: 100%;
            }

            .bdshare-button-style2-16 a,
            .bdshare-button-style2-16 .bds_more {
                float: initial;
            }

            .ng-zein-code {
                width: 100%;
            }

            .ng-zein-code-tit {
                width: 100%;
                text-align: center;
            }
        }
    </style>
</head>

<body>
<div id="app">
    <div class="layui-carousel" id="swiper">
        <div carousel-item id="swiper-item">
            <div v-for="(item,index) in swiperList" v-bind:key="index">
                <img class="swiper-item" :src="item.img" style="width: 100%;height:400px ">
            </div>
        </div>
    </div>

    <div class="ng-container ng-fault">
        <div class="ng-inmod ng-fault ng-paddor ng-bg-assist">
            <div class="ng-inmod-ini">
                    <div class="index_titlebox">
                        <h3 class="index_title">游戏展示</h3>
                        <p class="index_intro">DATA SHOW</p>
                    </div>
                <div class="ng-incontlst ng-fault ng-container ng-ai-drive1_map" aos="fade-up">
                    <div class="project-sec pt-100 pb-70">
                        <div class="row">
                            <div v-for="(item,index) in youxiList" v-bind:key="index" class="col-md-3 col-sm-6">
                                <div class="item" @click="jumpCheck('../youxi/detail.jsp?id='+item.id , item.aaaaaaaaaa == null?'':item.aaaaaaaaaa , item.shangxiaTypes == null?'':item.shangxiaTypes)">
                                    <div class="project-thumb">
                                        <img :src="item.youxiPhoto?item.youxiPhoto.split(',')[0]:''" style="height: 350px;width:100%;"/>
                                        <div class="project-hoverlay">
                                            <div class="project-text">
                                                <h3 v-if="item.youxiNewMoney">
                                                    {{item.youxiNewMoney}} RMB
                                                </h3>
                                                <h3 v-else>
                                                    {{item.youxiValue}}
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <h2>{{item.youxiName}}</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="ng-inmod ng-fault ng-paddor ng-bg-assist">
            <div class="ng-inmod-ini">
                    <div class="index_titlebox">
                        <h3 class="index_title">公告展示</h3>
                        <p class="index_intro">DATA SHOW</p>
                    </div>
                <div class="ng-incontlst ng-fault ng-container ng-ai-drive1_map" aos="fade-up">
                    <div class="project-sec pt-100 pb-70">
                        <div class="row">
                            <div v-for="(item,index) in gonggaoList" v-bind:key="index" class="col-md-3 col-sm-6">
                                <div class="item" @click="jumpCheck('../gonggao/detail.jsp?id='+item.id , item.aaaaaaaaaa == null?'':item.aaaaaaaaaa , item.shangxiaTypes == null?'':item.shangxiaTypes)">
                                    <div class="project-thumb">
                                        <img :src="item.gonggaoPhoto?item.gonggaoPhoto.split(',')[0]:''" style="height: 350px;width:100%;"/>
                                        <div class="project-hoverlay">
                                            <div class="project-text">
                                                <h3 v-if="item.gonggaoNewMoney">
                                                    {{item.gonggaoNewMoney}} RMB
                                                </h3>
                                                <h3 v-else>
                                                    {{item.gonggaoValue}}
                                                </h3>
                                            </div>
                                        </div>
                                    </div>
                                    <h2>{{item.gonggaoName}}</h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="margin-top: 50px"></div><!-- 这个是为了让最后一个不被遮挡 -->
    <div class="am-end">
        <div class="ng-siobox ng-fault ng-paddor">
            <div class="am-end-ini">
                <div class="ng-siotext" aos="fade-up" aos-delay="400" aos-anchor-placement="top-bottom">
                    <p>欢迎访问<span v-text="projectName"></span>！</p>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<script src="../../js/config.js"></script>
<script src="../../modules/config.js"></script>
<script src="../../js/utils.js"></script>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            projectName: projectName,
            youxiList: [],
            gonggaoList: [],
            swiperList: [{
                img: '../../img/banner.jpg'
            }]
        },
        filters: {
            newsDesc: function (val) {
                if (val) {
                    val = val.replace(/<[^<>]+>/g, '').replace(/undefined/g, '');
                    if (val.length > 60) {
                        val = val.substring(0, 60);
                    }

                    return val;
                }
                return '';
            }
        },
        methods: {
            jump(url) {
                jump(url);
            }
            ,jumpCheck(url,check1,check2) {
                if(check1 == "2" || check1 == 2){//级联表的逻辑删除字段[1:未删除 2:已删除]
                    layui.layer.msg("已经被删除", {
                        time: 2000,
                        icon: 2
                    });
                    return false;
                }
                if(check2 == "2"  || check2 == 2){//是否下架[1:上架 2:下架]
                    layui.layer.msg("已经下架", {
                        time: 2000,
                        icon: 2
                    });
                    return false;
                }
                this.jump(url);
            }
        }
    });

    layui.use(['layer', 'form', 'element', 'carousel', 'http', 'jquery'], function () {
        var layer = layui.layer;
        var element = layui.element;
        var form = layui.form;
        var carousel = layui.carousel;
        var http = layui.http;
        var jquery = layui.jquery;

        http.request('config/list', 'get', {
            page: 1,
            limit: 5
        }, function (res) {
            if (res.data.list.length > 0) {
                var swiperItemHtml = '';
                for (let item of res.data.list) {
                    if (item.value != "" && item.value != null) {
                        swiperItemHtml +=
                            '<div>' +
                            '<img class="swiper-item" src="' + item.value + '" width="100%" height="400px">' +
                            '</div>';
                    }
                }
                jquery('#swiper-item').html(swiperItemHtml);
                // 轮播图
                carousel.render({
                    elem: '#swiper',
                    width: '100%',
                    height: '400px',
                    arrow: 'always',
                    anim: 'fade',
                    interval: 1800,
                    indicator: 'inside'
                });
            }
        });


        http.request(`youxi/list`, 'get', {
            page: 1,
            limit: 8,
            shangxiaTypes: 1,
            youxiDelete: 1,
        }, function (res) {
            vue.youxiList = res.data.list;
        });
        http.request('gonggao/list', 'get', {
            page: 1,
            limit: 8,
        }, function (res) {
            vue.gonggaoList = res.data.list;
            vue.$nextTick(() => {
                $(".teamb-slide-38").slide({
                    mainCell: ".bd ul",
                    autoPage: true,
                    effect: "left",
                    autoPlay: true,
                    vis: 3,
                    trigger: "click",
                    interTime: 7000,
                    pnLoop: false
                });
                $(".click-more-team").on("click", function () {
                    var pars = $(this).parents("li");
                    $(".dask-team-ceng").removeClass("hide");
                    pars.find(".dask-team").removeClass("hide");
                });
                $(".team-colse").on("click", function () {
                    var pars = $(this).parents(".dask-team");
                    $(".dask-team-ceng").addClass("hide");
                    pars.addClass("hide");
                });
            });
        });
    });
</script>

<script src="../../xznstatic/js/idangerous.swiper.min.js"></script>
<script src="../../xznstatic/js/aos.js" type="text/javascript" charset="utf-8"></script>
<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../xznstatic/js/jquery.superslide.2.1.1.js"></script>
<script src="../../xznstatic/js/app.js"></script>
<script src="../../xznstatic/js/lightbox.js"></script>

<script>
    window.xznResize = function() {
        var mySwiper2 = new Swiper('.ng-inzep',{
            calculateHeight : true,
            loop : true,
            paginationClickable :true,
            pagination: ".ng-inzep .swiper-pagination"
        });

        $(document).bind("scroll",function (){
            if($(".ng-swip-porlist").length > 0){
                if($(window).width() > 769){
                    mySwiper2.params.slidesPerView = 4;
                    mySwiper3.params.slidesPerView = 4;
                }else if($(window).width() < 769){
                    if($(window).width() < 480){
                        mySwiper2.params.slidesPerView = 2;
                        mySwiper3.params.slidesPerView = 2;
                    }else{
                        mySwiper2.params.slidesPerView = 3;
                        mySwiper3.params.slidesPerView = 3;
                    }
                }
            }
        });

        $(window).bind("resize", function () {
            // 强制关闭导航
            if ($(window).width() > 992) { $(".ipad-nav").slideUp(); };

            if ($(".ng-swip-porlist").length > 0) {
                if ($(window).width() > 769) {
                    mySwiper2.params.slidesPerView = 4;
                    mySwiper3.params.slidesPerView = 4;
                } else if ($(window).width() < 769) {
                    if ($(window).width() < 480) {
                        mySwiper2.params.slidesPerView = 2;
                        mySwiper3.params.slidesPerView = 2;
                    } else {
                        mySwiper2.params.slidesPerView = 3;
                        mySwiper3.params.slidesPerView = 3;
                    }
                }
            }

            Spirit_dynamicBG($(".ng-inswbg"), 1600, 616, $(".ng-inswbg"));
            Spirit_CallBack($(".ng-porlist-doc>a"), 280, 200);
            Spirit_CallBack($(".ng-incontlst-img"), 368, 240);
            Spirit_CallBack($(".ng-inzep-ims"), 400, 270);
            Spirit_CallBack($(".ng-isenst-img"), 368, 240);
            Spirit_CallBack($(".ng-prslist-img"), 100, 100);
            Spirit_CallBack($(".ng-vrslist-img"), 260, 170);
            Spirit_CallBack($(".ng-newbve-img-ikk"), 368, 240);

            $(".ng-subc-swiper").css({ "height": $(".ng-subc-swiper").width() });

            if ($(window).width() < 640) {
                $(".am-inside-swf").css({
                    "min-height": $(window).height() - 60
                });
            } else {
                $(".am-inside-swf").css({
                    "min-height": "auto"
                });
            }
        }).resize();
    }
</script>
</body>

</html>