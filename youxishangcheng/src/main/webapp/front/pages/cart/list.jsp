<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="true" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <!--通用-->
    <meta name="format-detection" content="telephone=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0">
    <title>购物车列表页</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <link rel="stylesheet" href="../../layui/css/layui.css">
    <link rel="stylesheet" href="../../xznstatic/css/aos.css" />
    <link rel="stylesheet" href="../../xznstatic/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../../xznstatic/css/idangerous.swiper.css" />
    <link rel="stylesheet" href="../../xznstatic/css/lightbox.css">
    <link rel="stylesheet" href="../../xznstatic/css/app.css" />
    <link rel="stylesheet" href="../../xznstatic/css/apmin.css"/>
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/iconfont.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/color.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/global.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/page.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/uzlist.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="../../xznstatic/css/fancybox.css" />
    <script type="text/javascript" src="../../xznstatic/js/jquery.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/superslide.2.1.1.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/wow.min.js"></script>
    <script type="text/javascript" src="../../xznstatic/js/fancybox.js"></script>
    <!-- 样式 -->
    <link rel="stylesheet" href="../../css/style.css"/>
    <!-- 主题（主要颜色设置） -->
    <link rel="stylesheet" href="../../css/theme.css"/>
    <!-- 通用的css -->
    <link rel="stylesheet" href="../../css/common.css"/>
    <script type="text/javascript" charset="utf-8">
        window.UEDITOR_HOME_URL = "../../../resources/ueditor/"; //UEDITOR_HOME_URL、config、all这三个顺序不能改变
    </script>
    <script type="text/javascript" charset="utf-8"
            src="../../../resources/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="../../../resources/ueditor/ueditor.all.min.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="../../../resources/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript">
        var CATID = "0",
                BCID = "0",
                NAVCHILDER = "",
                ONCONTEXT = 0,
                ONCOPY = 0,
                ONSELECT = 0;
    </script>
    <style>

    /*标题*/
    .index-title {
        text-align: center;
        box-sizing: border-box;
        width: 1200px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
    }
    .index-title span {
        padding: 0 10px;
        line-height: 1.4;
    }

    /* 把标签默认的间距设为0 */
    body,ul,ol,p,h1,h2,h3,h4,h5,h6,dl,dd,select,input,textarea,form{margin:0;padding:0}

    /* 让h标签文字大小继承body的文字设置 */
    h1,h2,h3,h4,h5,h6{font-size:100%;font-weight:normal;}

    /* 去掉列表默认的图标 */
    ul,ol{list-style:none;}

    /* 去掉em默认的斜体 */
    em{font-style: normal;}

    /* 去掉a标签默认的下划线 */
    a{text-decoration:none;}


    /* 去掉加链接时产生的框线 */
    img{border:0;}

    /* 清除浮动 */
    .clearfix:before,.clearfix:after{content:"";display:table}
    .clearfix:after{clear:both;}
    .clearfix{zoom:1}

    /* 浮动 */
    .fl{float:left}
    .fr{float:right}
    /*轮播图相关 start*/
    #swiper {
        overflow: hidden;
    }


    .cart_list_th{width:1198px;border:1px solid #ddd;background-color:#f7f7f7;margin:0 auto;}
    .cart_list_th li{height:40px;line-height:40px;float:left;text-align:center;}
    .cart_list_th .col01{width:26%;}
    .cart_list_th .col02{width:16%;}
    .cart_list_th .col03{width:16%;}
    .cart_list_th .col04{width:13%;}
    .cart_list_th .col05{width:18%;}
    .cart_list_th .col06{width:18%;}

    .cart_list_td{width:1198px;border:1px solid #ddd;background-color:#edfff9;margin:0 auto;margin-top:-1px;}
    .cart_list_td li{height:120px;line-height:120px;float:left;text-align:center;}

    .cart_list_td .col01{width:6%;}
    .cart_list_td .col02{width:12%;}
    .cart_list_td .col03{width:10%;}
    .cart_list_td .col04{width:16%;}
    .cart_list_td .col05{width:13%;}
    .cart_list_td .col06{width:15%;}
    .cart_list_td .col07{width:16%;}
    .cart_list_td .col08{width:19%;}

    .cart_list_td .col02 img{width:100px;height:100px;border:1px solid #ddd;display:block;margin:10px auto 0;}
    .cart_list_td .col03{height:48px;text-align:left;line-height:24px;margin-top:38px;}
    .cart_list_td .col03 em{color:#999}
    .cart_list_td .col08 a{color:#666}

    .cart_list_td .col06 .num_add{width:98px;margin:40px auto 0;}
    .cart_list_td .col06 .num_add a{width:29px;height:28px;line-height:28px;background-color:#f3f3f3;font-size:14px;color:#666}
    .cart_list_td .col06 .num_add input{width:38px;height:28px;text-align:center;line-height:30px;border:0px;display:block;float:left;outline:none;border-left:1px solid #ddd;border-right:1px solid #ddd;}


    .settlements{width:1198px;height:78px;border:1px solid #ddd;background-color:#fff4e8;margin:-1px auto 0;}
    .settlements li{line-height:78px;float:left;}
    .settlements .col01{width:4%;text-align:center}
    .settlements .col02{width:12%;}
    .settlements .col03{width:82%; height:48px; line-height:28px;text-align:right;margin-top:10px;}
    .settlements .col03 span{color:#ff0000;padding-right:5px}
    .settlements .col03 em{color:#ff3d3d;font-size:22px;font-weight:bold;}
    .settlements .col03 span{color:#ff0000;}
    .settlements .col03 b{color:#ff0000;font-size:14px;padding:0 5px;}

    .settlements .col04{width:14%;text-align:center;float:right;}
    .settlements .col04 a{display:block;height:78px;background-color:#ff3d3d;text-align:center;line-height:78px;color:#fff;font-size:24px}
    </style>
</head>
<body >
<div id="app">
    <!-- 标题 -->
    <div class="index-title" :style='{"padding":"10px","boxShadow":"0 0 0px rgba(255,0,0,.8)","margin":"20px auto","borderColor":"rgba(0,0,0,.3)","color":"#333","borderRadius":"0px","borderWidth":"0","fontSize":"25px","borderStyle":"solid","height":"auto","backgroundColor":"var(--publicMainColor, #808080)"}'>
        <span>SHOP / CART</span><span>购物车</span>
    </div>
    <!-- 标题 -->
    <ul class="cart_list_th clearfix">
        <li class="col01">名称</li>
        <li class="col03">价格</li>
        <li class="col04">数量</li>
        <li class="col05">小计</li>
        <li class="col06">操作</li>
    </ul>

    <ul class="cart_list_td clearfix" v-for="(item,index) in dataList" v-bind:key="index">
        <li class="col01"></li>
        <li class="col02"><img :src="item.youxiPhoto"></li>
        <li class="col03">{{item.youxiName}}<br><em>{{item.youxiNewMoney}} RMB</em></li>
        <li class="col05">{{item.youxiNewMoney}} RMB</li>
        <li class="col06">
            <div class="num_add">
                <%--<a @click="reduceCartNum(index)"  class="add fl">-</a>--%>
                <input type="text" disabled class="num_show fl" :value="item.buyNumber" id="buyNumber" name="buyNumber">
                <%--<a @click="addCartNum(index)" class="minus fl">+</a>--%>
            </div>
        </li>
        <li class="col07">{{(item.youxiNewMoney*item.buyNumber).toFixed(2)}} RMB</li>
        <li class="col08"><a @click="deleteCart(index)" ><i class="layui-icon">&#xe640;</i> 删除</a></li>
    </ul>

    <ul class="settlements">
        <li class="col01"></li>
        <li class="col03">合计：<span>¥</span><em>{{totalZongjiaMoney.toFixed(2)}}</em><br>共计<b>{{dataList.length}}</b>件商品</li>
        <li class="col04"><a @click="buyClick" ><i class="layui-icon">&#xe657;</i>点击结算</a></li>
    </ul>

</div></div>


<script src="../../xznstatic/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../../layui/layui.js"></script>
<script src="../../js/vue.js"></script>
<!-- 引入element组件库 -->
<script src="../../xznstatic/js/element.min.js"></script>
<!-- 引入element样式 -->
<link rel="stylesheet" href="../../xznstatic/css/element.min.css">
<script src="../../js/config.js"></script>
<script src="../../modules/config.js"></script>
<script src="../../js/utils.js"></script>

<script>
    var vue = new Vue({
        el: '#app',
        data: {
            id:null,
            detail: {},
            swiperList: [],//轮播图
            dataList: [],//数据
        // 当前表字典表数据
            cartTypes: 0,//类型
            limit: 8,
            projectName: projectName,//项目名
            centerMenu: centerMenu

        },
        updated: function() {
            layui.form.render(null, 'myForm');
        },
        filters: {
            //把字符串去除无用字符 如果字段长度大于60  就截取到60
            subString: function(val) {
                if (val) {
                    val = val.replace(/<[^<>]+>/g, '').replace(/undefined/g, '');
                    if (val.length > 60) {
                        val = val.substring(0, 60);
                        val+='...';
                    }

                    return val;
                }
                return '';
            }
        },
        computed: {
            totalZongjiaMoney: function() {
                var total = 0;
                for (var item of this.dataList) {
                    total += item.youxiNewMoney * item.buyNumber
                }
                return total;
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
			// 添加数量
			,addCartNum(index) {
				// 查询对应的商品的详情信息，判断是否有商品限次，库存的判断
				var item = this.dataList[index];
				layui.http.request(`youxi/info/${item.youxiId}`, 'get', {}, function(res) {
					// 库存限制
					if (res.data.youxiKucunNumber && res.data.youxiKucunNumber > 0 && res.data.youxiKucunNumber  <= item.buyNumber) {
						layui.layer.msg(`游戏库存不足`, {
							time: 2000,
							icon: 5
						});
						return
					}
					item.buyNumber = item.buyNumber + 1;
					layui.http.requestJson(`cart/update`, 'post', item, function(res) {});
				});
			},
			// 减少数量
			reduceCartNum(index) {
				var item = this.dataList[index];
				if (item.buyNumber > 1) {
					item.buyNumber = item.buyNumber - 1;
					layui.http.requestJson(`cart/update`, 'post', item, function(res) {});
				}
			},
			// 删除
			deleteCart(index) {
				var item = this.dataList[index];
				layui.http.requestJson(`cart/delete`, 'post', [item.id], function(res) {
					window.location.reload();
				});
			},
			// 购买
			buyClick() {
				localStorage.setItem('youxis', JSON.stringify(this.dataList));
				window.location.href = '../youxiOrder/confirm.jsp'
			}
        }
    });

    layui.use(['layer', 'element', 'carousel', 'laypage','form', 'http', 'jquery', 'laydate', 'tinymce'], function() {
        var layer = layui.layer;
        var element = layui.element;
        var carousel = layui.carousel;
        var laypage = layui.laypage;
        var http = layui.http;
        var form = layui.form;
        var laydate = layui.laydate;
        var tinymce = layui.tinymce;
        window.jQuery = window.$ = jquery = layui.jquery;

        var limit = 8;

        // 获取轮播图 数据
        http.request('config/list', 'get', {
            page: 1,
            limit: 5
        }, function(res) {
            if (res.data.list.length > 0) {
                let swiperList = [];
                res.data.list.forEach(element => {
                    if (element.value != null) {
                        swiperList.push({
                            img: element.value
                        });
                    }
                });
                vue.swiperList = swiperList;
                vue.$nextTick(()=>{
                    var mySwiper = new Swiper('.ng-swiper', {
                        speed: 400,
                        spaceBetween: 100,
                        pagination: '.ng-swiper .swiper-pagination',
                        autoplay : 5000,
                        loop : true,
                        autoplayDisableOnInteraction : false,
                        calculateHeight : true
                    });
                    $(".ng-swiper-ovleft").bind("click",function (){ mySwiper.swipePrev();});
                    $(".ng-swiper-ovright").bind("click",function (){ mySwiper.swipeNext();});
                });
            }
        });
        // 查询当前字典表相关
    // 当前表的字典表




        // 获取列表数据
        http.request('cart/page', 'get', {
            page: 1,
            limit: limit,
            yonghuId: localStorage.getItem('userid')
        }, function(res) {
            vue.dataList = res.data.list
            // 分页
            laypage.render({
                elem: 'pager',
                count: res.data.total,
                limit: limit,
                jump: function(obj, first) {
                    //首次不执行
                    if (!first) {
                        http.request('news/list', 'get', {
                            page: obj.curr,
                            limit: obj.limit,
                            yonghuId: localStorage.getItem('userid')
                        }, function(res) {
                            vue.dataList = res.data.list
                        })
                    }
                }
            });
        })
    });
</script>

<script src="../../xznstatic/js/idangerous.swiper.min.js"></script>
<script src="../../xznstatic/js/aos.js" type="text/javascript" charset="utf-8"></script>
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
