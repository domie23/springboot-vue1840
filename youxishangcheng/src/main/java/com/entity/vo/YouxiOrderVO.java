package com.entity.vo;

import com.entity.YouxiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 游戏订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("youxi_order")
public class YouxiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "youxi_order_uuid_number")
    private String youxiOrderUuidNumber;


    /**
     * 游戏
     */

    @TableField(value = "youxi_id")
    private Integer youxiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "youxi_order_true_price")
    private Double youxiOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "youxi_order_types")
    private Integer youxiOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "youxi_order_payment_types")
    private Integer youxiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getYouxiOrderUuidNumber() {
        return youxiOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setYouxiOrderUuidNumber(String youxiOrderUuidNumber) {
        this.youxiOrderUuidNumber = youxiOrderUuidNumber;
    }
    /**
	 * 设置：游戏
	 */
    public Integer getYouxiId() {
        return youxiId;
    }


    /**
	 * 获取：游戏
	 */

    public void setYouxiId(Integer youxiId) {
        this.youxiId = youxiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getYouxiOrderTruePrice() {
        return youxiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setYouxiOrderTruePrice(Double youxiOrderTruePrice) {
        this.youxiOrderTruePrice = youxiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getYouxiOrderTypes() {
        return youxiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setYouxiOrderTypes(Integer youxiOrderTypes) {
        this.youxiOrderTypes = youxiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getYouxiOrderPaymentTypes() {
        return youxiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setYouxiOrderPaymentTypes(Integer youxiOrderPaymentTypes) {
        this.youxiOrderPaymentTypes = youxiOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
