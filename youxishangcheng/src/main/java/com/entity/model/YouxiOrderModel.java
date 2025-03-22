package com.entity.model;

import com.entity.YouxiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 游戏订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YouxiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String youxiOrderUuidNumber;


    /**
     * 游戏
     */
    private Integer youxiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double youxiOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer youxiOrderTypes;


    /**
     * 支付类型
     */
    private Integer youxiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getYouxiOrderUuidNumber() {
        return youxiOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setYouxiOrderUuidNumber(String youxiOrderUuidNumber) {
        this.youxiOrderUuidNumber = youxiOrderUuidNumber;
    }
    /**
	 * 获取：游戏
	 */
    public Integer getYouxiId() {
        return youxiId;
    }


    /**
	 * 设置：游戏
	 */
    public void setYouxiId(Integer youxiId) {
        this.youxiId = youxiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getYouxiOrderTruePrice() {
        return youxiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setYouxiOrderTruePrice(Double youxiOrderTruePrice) {
        this.youxiOrderTruePrice = youxiOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getYouxiOrderTypes() {
        return youxiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setYouxiOrderTypes(Integer youxiOrderTypes) {
        this.youxiOrderTypes = youxiOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getYouxiOrderPaymentTypes() {
        return youxiOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setYouxiOrderPaymentTypes(Integer youxiOrderPaymentTypes) {
        this.youxiOrderPaymentTypes = youxiOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
