
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 游戏订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/youxiOrder")
public class YouxiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(YouxiOrderController.class);

    @Autowired
    private YouxiOrderService youxiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YouxiService youxiService;
@Autowired
private CartService cartService;
@Autowired
private YouxiCommentbackService youxiCommentbackService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = youxiOrderService.queryPage(params);

        //字典表数据转换
        List<YouxiOrderView> list =(List<YouxiOrderView>)page.getList();
        for(YouxiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YouxiOrderEntity youxiOrder = youxiOrderService.selectById(id);
        if(youxiOrder !=null){
            //entity转view
            YouxiOrderView view = new YouxiOrderView();
            BeanUtils.copyProperties( youxiOrder , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(youxiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                YouxiEntity youxi = youxiService.selectById(youxiOrder.getYouxiId());
                if(youxi != null){
                    BeanUtils.copyProperties( youxi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYouxiId(youxi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YouxiOrderEntity youxiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,youxiOrder:{}",this.getClass().getName(),youxiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            youxiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        youxiOrder.setInsertTime(new Date());
        youxiOrder.setCreateTime(new Date());
        youxiOrderService.insert(youxiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YouxiOrderEntity youxiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,youxiOrder:{}",this.getClass().getName(),youxiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            youxiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<YouxiOrderEntity> queryWrapper = new EntityWrapper<YouxiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YouxiOrderEntity youxiOrderEntity = youxiOrderService.selectOne(queryWrapper);
        if(youxiOrderEntity==null){
            youxiOrderService.updateById(youxiOrder);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        youxiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YouxiOrderEntity> youxiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YouxiOrderEntity youxiOrderEntity = new YouxiOrderEntity();
//                            youxiOrderEntity.setYouxiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            youxiOrderEntity.setYouxiId(Integer.valueOf(data.get(0)));   //游戏 要改的
//                            youxiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            youxiOrderEntity.setYouxiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            youxiOrderEntity.setYouxiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            youxiOrderEntity.setYouxiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            youxiOrderEntity.setInsertTime(date);//时间
//                            youxiOrderEntity.setCreateTime(date);//时间
                            youxiOrderList.add(youxiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("youxiOrderUuidNumber")){
                                    List<String> youxiOrderUuidNumber = seachFields.get("youxiOrderUuidNumber");
                                    youxiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> youxiOrderUuidNumber = new ArrayList<>();
                                    youxiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("youxiOrderUuidNumber",youxiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<YouxiOrderEntity> youxiOrderEntities_youxiOrderUuidNumber = youxiOrderService.selectList(new EntityWrapper<YouxiOrderEntity>().in("youxi_order_uuid_number", seachFields.get("youxiOrderUuidNumber")));
                        if(youxiOrderEntities_youxiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(YouxiOrderEntity s:youxiOrderEntities_youxiOrderUuidNumber){
                                repeatFields.add(s.getYouxiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        youxiOrderService.insertBatch(youxiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = youxiOrderService.queryPage(params);

        //字典表数据转换
        List<YouxiOrderView> list =(List<YouxiOrderView>)page.getList();
        for(YouxiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YouxiOrderEntity youxiOrder = youxiOrderService.selectById(id);
            if(youxiOrder !=null){


                //entity转view
                YouxiOrderView view = new YouxiOrderView();
                BeanUtils.copyProperties( youxiOrder , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(youxiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YouxiEntity youxi = youxiService.selectById(youxiOrder.getYouxiId());
                if(youxi != null){
                    BeanUtils.copyProperties( youxi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYouxiId(youxi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YouxiOrderEntity youxiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,youxiOrder:{}",this.getClass().getName(),youxiOrder.toString());
            /*YouxiEntity youxiEntity = youxiService.selectById(youxiOrder.getYouxiId());
            if(youxiEntity == null){
                return R.error(511,"查不到该游戏");
            }
            // Double youxiNewMoney = youxiEntity.getYouxiNewMoney();

            if(false){
            }
            else if(youxiEntity.getYouxiNewMoney() == null){
                return R.error(511,"游戏价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - youxiEntity.getYouxiNewMoney()*youxiOrder.getBuyNumber();//余额
            buyJifen = new BigDecimal(youxiEntity.getYouxiPrice()).multiply(new BigDecimal(youxiOrder.getBuyNumber())).doubleValue();//所获积分
            if(balance<0)
                return R.error(511,"余额不够支付");
            youxiOrder.setYouxiOrderTypes(1); //设置订单状态为已支付
            youxiOrder.setYouxiOrderTruePrice(youxiEntity.getYouxiNewMoney()*youxiOrder.getBuyNumber()); //设置实付价格
            youxiOrder.setYonghuId(userId); //设置订单支付人id
            youxiOrder.setYouxiOrderUuidNumber(String.valueOf(new Date().getTime()));
            youxiOrder.setYouxiOrderPaymentTypes(1);
            youxiOrder.setInsertTime(new Date());
            youxiOrder.setCreateTime(new Date());
                youxiOrderService.insert(youxiOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
            yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);
            yonghuService.updateById(yonghuEntity);*/
            return R.ok();
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String youxiOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        Integer youxiOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("youxiOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("youxis"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> youxis = JSON.parseObject(jsonArray.toString(), List.class);


        ArrayList<Integer> ids = new ArrayList<>();
        for (Map<String, Object> map : youxis) {
            String youxiId = String.valueOf(map.get("youxiId"));
            if(StringUtil.isNotEmpty(youxiId))
                ids.add(Integer.valueOf(youxiId));
        }

        List<YouxiOrderEntity> youxiOrderEntities = youxiOrderService.selectList(new EntityWrapper<YouxiOrderEntity>()
                .in("youxi_id", ids)
                .eq("yonghu_id", userId)
        );

        if(youxiOrderEntities.size()>0){
            List<YouxiEntity> youxiEntities = youxiService.selectList(new EntityWrapper<YouxiEntity>());
            Map<Integer, String> hashMap = new HashMap<>();
            for(YouxiEntity y:youxiEntities){
                hashMap.put(y.getId(),y.getYouxiName());
            }
            List<String> strings = new ArrayList<>();
            for(YouxiOrderEntity y:youxiOrderEntities){
                strings.add(hashMap.get(y.getYouxiId()));
            }
            return R.error("这次购买清单中的以下游戏已被购买:"+strings.toString());
        }


        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<YouxiOrderEntity> youxiOrderList = new ArrayList<>();
        //商品表
        List<YouxiEntity> youxiList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);
        // 获取折扣
        Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", "huiyuandengji_types")
                .eq("dic_name", "会员等级类型")
                .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                ;
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
        if(dictionaryEntity != null ){
            zhekou = BigDecimal.valueOf(Double.valueOf(dictionaryEntity.getBeizhu()));
        }

        //循环取出需要的数据
        for (Map<String, Object> map : youxis) {
           //取值
            Integer youxiId = Integer.valueOf(String.valueOf(map.get("youxiId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            YouxiEntity youxiEntity = youxiService.selectById(youxiId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));


            //订单信息表增加数据
            YouxiOrderEntity youxiOrderEntity = new YouxiOrderEntity<>();

            //赋值订单信息
            youxiOrderEntity.setYouxiOrderUuidNumber(youxiOrderUuidNumber);//订单号
            youxiOrderEntity.setYouxiId(youxiId);//游戏
            youxiOrderEntity.setYonghuId(userId);//用户
            youxiOrderEntity.setYouxiOrderTypes(1);//订单类型
            youxiOrderEntity.setYouxiOrderPaymentTypes(youxiOrderPaymentTypes);//支付类型
            youxiOrderEntity.setInsertTime(new Date());//订单创建时间
            youxiOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(youxiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(youxiEntity.getYouxiNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                        buyJifen = new BigDecimal(youxiEntity.getYouxiPrice()).multiply(new BigDecimal(buyNumber)).doubleValue();
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额
                    yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() + buyJifen); //设置总积分
                    yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置现积分
                        if(yonghuEntity.getYonghuSumJifen()  < 10000)
                            yonghuEntity.setHuiyuandengjiTypes(1);
                        else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                            yonghuEntity.setHuiyuandengjiTypes(2);
                        else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                            yonghuEntity.setHuiyuandengjiTypes(3);


                    youxiOrderEntity.setYouxiOrderTruePrice(money);

                }
            }
            youxiOrderList.add(youxiOrderEntity);
            youxiList.add(youxiEntity);

        }
        youxiOrderService.insertBatch(youxiOrderList);
        youxiService.updateBatchById(youxiList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }

    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            YouxiOrderEntity youxiOrder = youxiOrderService.selectById(id);
//            Integer buyNumber = 1;
            Integer youxiOrderPaymentTypes = youxiOrder.getYouxiOrderPaymentTypes();
            Integer youxiId = youxiOrder.getYouxiId();
            if(youxiId == null)
                return R.error(511,"查不到该游戏");
            YouxiEntity youxiEntity = youxiService.selectById(youxiId);
            if(youxiEntity == null)
                return R.error(511,"查不到该游戏");
            Double youxiNewMoney = youxiEntity.getYouxiNewMoney();
            if(youxiNewMoney == null)
                return R.error(511,"游戏价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;
            // 获取折扣
            Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                    .eq("dic_code", "huiyuandengji_types")
                    .eq("dic_name", "会员等级类型")
                    .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                    ;
            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
            if(dictionaryEntity != null ){
                zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
            }


            //判断是什么支付方式 1代表余额 2代表积分
            if(youxiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = youxiEntity.getYouxiNewMoney()  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                buyJifen = new BigDecimal(youxiEntity.getYouxiPrice()).doubleValue();
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
                yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() - buyJifen); //设置总积分
                if(yonghuEntity.getYonghuNewJifen() - buyJifen <0 )
                    return R.error("积分已经消费,无法退款！！！");
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - buyJifen); //设置现积分

                if(yonghuEntity.getYonghuSumJifen()  < 10000)
                    yonghuEntity.setHuiyuandengjiTypes(1);
                else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                    yonghuEntity.setHuiyuandengjiTypes(2);
                else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                    yonghuEntity.setHuiyuandengjiTypes(3);

            }




            youxiOrder.setYouxiOrderTypes(2);//设置订单状态为退款
            youxiOrderService.updateById(youxiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            youxiService.updateById(youxiEntity);//更新订单中游戏的信息
            return R.ok();
    }


    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id ){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YouxiOrderEntity  youxiOrderEntity = new  YouxiOrderEntity();;
        youxiOrderEntity.setId(id);
        youxiOrderEntity.setYouxiOrderTypes(3);
        boolean b =  youxiOrderService.updateById( youxiOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }














    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        YouxiOrderEntity  youxiOrderEntity = new  YouxiOrderEntity();
        youxiOrderEntity.setId(id);
        youxiOrderEntity.setYouxiOrderTypes(4);
        boolean b =  youxiOrderService.updateById( youxiOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText, Integer youxiCommentbackPingfenNumber, HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
            YouxiOrderEntity youxiOrder = youxiOrderService.selectById(id);
        if(youxiOrder == null)
            return R.error(511,"查不到该订单");
        if(youxiOrder.getYouxiOrderTypes() != 1)
            return R.error(511,"您不能评价");
        Integer youxiId = youxiOrder.getYouxiId();
        if(youxiId == null)
            return R.error(511,"查不到该游戏");

        YouxiCommentbackEntity youxiCommentbackEntity = new YouxiCommentbackEntity();
            youxiCommentbackEntity.setId(id);
            youxiCommentbackEntity.setYouxiId(youxiId);
            youxiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            youxiCommentbackEntity.setYouxiCommentbackText(commentbackText);
            youxiCommentbackEntity.setInsertTime(new Date());
            youxiCommentbackEntity.setReplyText(null);
            youxiCommentbackEntity.setUpdateTime(null);
            youxiCommentbackEntity.setCreateTime(new Date());
            youxiCommentbackService.insert(youxiCommentbackEntity);

            youxiOrder.setYouxiOrderTypes(5);//设置订单状态为已评价
            youxiOrderService.updateById(youxiOrder);//根据id更新
            return R.ok();
    }












}
