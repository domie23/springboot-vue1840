package com.entity.vo;

import com.entity.YouxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 游戏
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("youxi")
public class YouxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 游戏名称
     */

    @TableField(value = "youxi_name")
    private String youxiName;


    /**
     * 游戏编号
     */

    @TableField(value = "youxi_uuid_number")
    private String youxiUuidNumber;


    /**
     * 游戏照片
     */

    @TableField(value = "youxi_photo")
    private String youxiPhoto;


    /**
     * 最低配置
     */

    @TableField(value = "youxi_zuidipeizhi")
    private String youxiZuidipeizhi;


    /**
     * 推荐配置
     */

    @TableField(value = "youxi_tuijianpeizhi")
    private String youxiTuijianpeizhi;


    /**
     * 开发商
     */

    @TableField(value = "youxi_kaifashang")
    private String youxiKaifashang;


    /**
     * 支持语言
     */

    @TableField(value = "youxi_yuyan")
    private String youxiYuyan;


    /**
     * 需要空间
     */

    @TableField(value = "youxi_kongjian")
    private String youxiKongjian;


    /**
     * 首发日期
     */

    @TableField(value = "youxi_shoufa")
    private String youxiShoufa;


    /**
     * 游戏下载链接
     */

    @TableField(value = "youxi_address")
    private String youxiAddress;


    /**
     * 购买获得积分
     */

    @TableField(value = "youxi_price")
    private Integer youxiPrice;


    /**
     * 游戏原价
     */

    @TableField(value = "youxi_old_money")
    private Double youxiOldMoney;


    /**
     * 现价
     */

    @TableField(value = "youxi_new_money")
    private Double youxiNewMoney;


    /**
     * 游戏热度
     */

    @TableField(value = "youxi_clicknum")
    private Integer youxiClicknum;


    /**
     * 游戏详细介绍
     */

    @TableField(value = "youxi_content")
    private String youxiContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "youxi_delete")
    private Integer youxiDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：游戏名称
	 */
    public String getYouxiName() {
        return youxiName;
    }


    /**
	 * 获取：游戏名称
	 */

    public void setYouxiName(String youxiName) {
        this.youxiName = youxiName;
    }
    /**
	 * 设置：游戏编号
	 */
    public String getYouxiUuidNumber() {
        return youxiUuidNumber;
    }


    /**
	 * 获取：游戏编号
	 */

    public void setYouxiUuidNumber(String youxiUuidNumber) {
        this.youxiUuidNumber = youxiUuidNumber;
    }
    /**
	 * 设置：游戏照片
	 */
    public String getYouxiPhoto() {
        return youxiPhoto;
    }


    /**
	 * 获取：游戏照片
	 */

    public void setYouxiPhoto(String youxiPhoto) {
        this.youxiPhoto = youxiPhoto;
    }
    /**
	 * 设置：最低配置
	 */
    public String getYouxiZuidipeizhi() {
        return youxiZuidipeizhi;
    }


    /**
	 * 获取：最低配置
	 */

    public void setYouxiZuidipeizhi(String youxiZuidipeizhi) {
        this.youxiZuidipeizhi = youxiZuidipeizhi;
    }
    /**
	 * 设置：推荐配置
	 */
    public String getYouxiTuijianpeizhi() {
        return youxiTuijianpeizhi;
    }


    /**
	 * 获取：推荐配置
	 */

    public void setYouxiTuijianpeizhi(String youxiTuijianpeizhi) {
        this.youxiTuijianpeizhi = youxiTuijianpeizhi;
    }
    /**
	 * 设置：开发商
	 */
    public String getYouxiKaifashang() {
        return youxiKaifashang;
    }


    /**
	 * 获取：开发商
	 */

    public void setYouxiKaifashang(String youxiKaifashang) {
        this.youxiKaifashang = youxiKaifashang;
    }
    /**
	 * 设置：支持语言
	 */
    public String getYouxiYuyan() {
        return youxiYuyan;
    }


    /**
	 * 获取：支持语言
	 */

    public void setYouxiYuyan(String youxiYuyan) {
        this.youxiYuyan = youxiYuyan;
    }
    /**
	 * 设置：需要空间
	 */
    public String getYouxiKongjian() {
        return youxiKongjian;
    }


    /**
	 * 获取：需要空间
	 */

    public void setYouxiKongjian(String youxiKongjian) {
        this.youxiKongjian = youxiKongjian;
    }
    /**
	 * 设置：首发日期
	 */
    public String getYouxiShoufa() {
        return youxiShoufa;
    }


    /**
	 * 获取：首发日期
	 */

    public void setYouxiShoufa(String youxiShoufa) {
        this.youxiShoufa = youxiShoufa;
    }
    /**
	 * 设置：游戏下载链接
	 */
    public String getYouxiAddress() {
        return youxiAddress;
    }


    /**
	 * 获取：游戏下载链接
	 */

    public void setYouxiAddress(String youxiAddress) {
        this.youxiAddress = youxiAddress;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getYouxiPrice() {
        return youxiPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setYouxiPrice(Integer youxiPrice) {
        this.youxiPrice = youxiPrice;
    }
    /**
	 * 设置：游戏原价
	 */
    public Double getYouxiOldMoney() {
        return youxiOldMoney;
    }


    /**
	 * 获取：游戏原价
	 */

    public void setYouxiOldMoney(Double youxiOldMoney) {
        this.youxiOldMoney = youxiOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getYouxiNewMoney() {
        return youxiNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setYouxiNewMoney(Double youxiNewMoney) {
        this.youxiNewMoney = youxiNewMoney;
    }
    /**
	 * 设置：游戏热度
	 */
    public Integer getYouxiClicknum() {
        return youxiClicknum;
    }


    /**
	 * 获取：游戏热度
	 */

    public void setYouxiClicknum(Integer youxiClicknum) {
        this.youxiClicknum = youxiClicknum;
    }
    /**
	 * 设置：游戏详细介绍
	 */
    public String getYouxiContent() {
        return youxiContent;
    }


    /**
	 * 获取：游戏详细介绍
	 */

    public void setYouxiContent(String youxiContent) {
        this.youxiContent = youxiContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYouxiDelete() {
        return youxiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYouxiDelete(Integer youxiDelete) {
        this.youxiDelete = youxiDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
