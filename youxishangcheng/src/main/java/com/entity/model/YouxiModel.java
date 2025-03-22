package com.entity.model;

import com.entity.YouxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 游戏
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YouxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 游戏名称
     */
    private String youxiName;


    /**
     * 游戏编号
     */
    private String youxiUuidNumber;


    /**
     * 游戏照片
     */
    private String youxiPhoto;


    /**
     * 最低配置
     */
    private String youxiZuidipeizhi;


    /**
     * 推荐配置
     */
    private String youxiTuijianpeizhi;


    /**
     * 开发商
     */
    private String youxiKaifashang;


    /**
     * 支持语言
     */
    private String youxiYuyan;


    /**
     * 需要空间
     */
    private String youxiKongjian;


    /**
     * 首发日期
     */
    private String youxiShoufa;


    /**
     * 游戏下载链接
     */
    private String youxiAddress;


    /**
     * 购买获得积分
     */
    private Integer youxiPrice;


    /**
     * 游戏原价
     */
    private Double youxiOldMoney;


    /**
     * 现价
     */
    private Double youxiNewMoney;


    /**
     * 游戏热度
     */
    private Integer youxiClicknum;


    /**
     * 游戏详细介绍
     */
    private String youxiContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer youxiDelete;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：游戏名称
	 */
    public String getYouxiName() {
        return youxiName;
    }


    /**
	 * 设置：游戏名称
	 */
    public void setYouxiName(String youxiName) {
        this.youxiName = youxiName;
    }
    /**
	 * 获取：游戏编号
	 */
    public String getYouxiUuidNumber() {
        return youxiUuidNumber;
    }


    /**
	 * 设置：游戏编号
	 */
    public void setYouxiUuidNumber(String youxiUuidNumber) {
        this.youxiUuidNumber = youxiUuidNumber;
    }
    /**
	 * 获取：游戏照片
	 */
    public String getYouxiPhoto() {
        return youxiPhoto;
    }


    /**
	 * 设置：游戏照片
	 */
    public void setYouxiPhoto(String youxiPhoto) {
        this.youxiPhoto = youxiPhoto;
    }
    /**
	 * 获取：最低配置
	 */
    public String getYouxiZuidipeizhi() {
        return youxiZuidipeizhi;
    }


    /**
	 * 设置：最低配置
	 */
    public void setYouxiZuidipeizhi(String youxiZuidipeizhi) {
        this.youxiZuidipeizhi = youxiZuidipeizhi;
    }
    /**
	 * 获取：推荐配置
	 */
    public String getYouxiTuijianpeizhi() {
        return youxiTuijianpeizhi;
    }


    /**
	 * 设置：推荐配置
	 */
    public void setYouxiTuijianpeizhi(String youxiTuijianpeizhi) {
        this.youxiTuijianpeizhi = youxiTuijianpeizhi;
    }
    /**
	 * 获取：开发商
	 */
    public String getYouxiKaifashang() {
        return youxiKaifashang;
    }


    /**
	 * 设置：开发商
	 */
    public void setYouxiKaifashang(String youxiKaifashang) {
        this.youxiKaifashang = youxiKaifashang;
    }
    /**
	 * 获取：支持语言
	 */
    public String getYouxiYuyan() {
        return youxiYuyan;
    }


    /**
	 * 设置：支持语言
	 */
    public void setYouxiYuyan(String youxiYuyan) {
        this.youxiYuyan = youxiYuyan;
    }
    /**
	 * 获取：需要空间
	 */
    public String getYouxiKongjian() {
        return youxiKongjian;
    }


    /**
	 * 设置：需要空间
	 */
    public void setYouxiKongjian(String youxiKongjian) {
        this.youxiKongjian = youxiKongjian;
    }
    /**
	 * 获取：首发日期
	 */
    public String getYouxiShoufa() {
        return youxiShoufa;
    }


    /**
	 * 设置：首发日期
	 */
    public void setYouxiShoufa(String youxiShoufa) {
        this.youxiShoufa = youxiShoufa;
    }
    /**
	 * 获取：游戏下载链接
	 */
    public String getYouxiAddress() {
        return youxiAddress;
    }


    /**
	 * 设置：游戏下载链接
	 */
    public void setYouxiAddress(String youxiAddress) {
        this.youxiAddress = youxiAddress;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getYouxiPrice() {
        return youxiPrice;
    }


    /**
	 * 设置：购买获得积分
	 */
    public void setYouxiPrice(Integer youxiPrice) {
        this.youxiPrice = youxiPrice;
    }
    /**
	 * 获取：游戏原价
	 */
    public Double getYouxiOldMoney() {
        return youxiOldMoney;
    }


    /**
	 * 设置：游戏原价
	 */
    public void setYouxiOldMoney(Double youxiOldMoney) {
        this.youxiOldMoney = youxiOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getYouxiNewMoney() {
        return youxiNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setYouxiNewMoney(Double youxiNewMoney) {
        this.youxiNewMoney = youxiNewMoney;
    }
    /**
	 * 获取：游戏热度
	 */
    public Integer getYouxiClicknum() {
        return youxiClicknum;
    }


    /**
	 * 设置：游戏热度
	 */
    public void setYouxiClicknum(Integer youxiClicknum) {
        this.youxiClicknum = youxiClicknum;
    }
    /**
	 * 获取：游戏详细介绍
	 */
    public String getYouxiContent() {
        return youxiContent;
    }


    /**
	 * 设置：游戏详细介绍
	 */
    public void setYouxiContent(String youxiContent) {
        this.youxiContent = youxiContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYouxiDelete() {
        return youxiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setYouxiDelete(Integer youxiDelete) {
        this.youxiDelete = youxiDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
