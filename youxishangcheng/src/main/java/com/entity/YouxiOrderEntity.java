package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 游戏订单
 *
 * @author 
 * @email
 */
@TableName("youxi_order")
public class YouxiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YouxiOrderEntity() {

	}

	public YouxiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
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
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "YouxiOrder{" +
            "id=" + id +
            ", youxiOrderUuidNumber=" + youxiOrderUuidNumber +
            ", youxiId=" + youxiId +
            ", yonghuId=" + yonghuId +
            ", youxiOrderTruePrice=" + youxiOrderTruePrice +
            ", youxiOrderTypes=" + youxiOrderTypes +
            ", youxiOrderPaymentTypes=" + youxiOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
