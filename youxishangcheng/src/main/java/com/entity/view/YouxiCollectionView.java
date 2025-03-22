package com.entity.view;

import com.entity.YouxiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 游戏收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("youxi_collection")
public class YouxiCollectionView extends YouxiCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String youxiCollectionValue;



		//级联表 yonghu
			/**
			* 用户编号
			*/
			private String yonghuUuidNumber;
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 用户头像
			*/
			private String yonghuPhoto;
			/**
			* 年龄
			*/
			private Integer age;
			/**
			* 学历
			*/
			private Integer xueliTypes;
				/**
				* 学历的值
				*/
				private String xueliValue;
			/**
			* 电子邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 总积分
			*/
			private Double yonghuSumJifen;
			/**
			* 现积分
			*/
			private Double yonghuNewJifen;
			/**
			* 会员等级
			*/
			private Integer huiyuandengjiTypes;
				/**
				* 会员等级的值
				*/
				private String huiyuandengjiValue;

		//级联表 youxi
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer youxiDelete;

	public YouxiCollectionView() {

	}

	public YouxiCollectionView(YouxiCollectionEntity youxiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, youxiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getYouxiCollectionValue() {
				return youxiCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setYouxiCollectionValue(String youxiCollectionValue) {
				this.youxiCollectionValue = youxiCollectionValue;
			}














				//级联表的get和set yonghu

					/**
					* 获取： 用户编号
					*/
					public String getYonghuUuidNumber() {
						return yonghuUuidNumber;
					}
					/**
					* 设置： 用户编号
					*/
					public void setYonghuUuidNumber(String yonghuUuidNumber) {
						this.yonghuUuidNumber = yonghuUuidNumber;
					}

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 用户头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 年龄
					*/
					public Integer getAge() {
						return age;
					}
					/**
					* 设置： 年龄
					*/
					public void setAge(Integer age) {
						this.age = age;
					}

					/**
					* 获取： 学历
					*/
					public Integer getXueliTypes() {
						return xueliTypes;
					}
					/**
					* 设置： 学历
					*/
					public void setXueliTypes(Integer xueliTypes) {
						this.xueliTypes = xueliTypes;
					}


						/**
						* 获取： 学历的值
						*/
						public String getXueliValue() {
							return xueliValue;
						}
						/**
						* 设置： 学历的值
						*/
						public void setXueliValue(String xueliValue) {
							this.xueliValue = xueliValue;
						}

					/**
					* 获取： 电子邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}

					/**
					* 获取： 总积分
					*/
					public Double getYonghuSumJifen() {
						return yonghuSumJifen;
					}
					/**
					* 设置： 总积分
					*/
					public void setYonghuSumJifen(Double yonghuSumJifen) {
						this.yonghuSumJifen = yonghuSumJifen;
					}

					/**
					* 获取： 现积分
					*/
					public Double getYonghuNewJifen() {
						return yonghuNewJifen;
					}
					/**
					* 设置： 现积分
					*/
					public void setYonghuNewJifen(Double yonghuNewJifen) {
						this.yonghuNewJifen = yonghuNewJifen;
					}

					/**
					* 获取： 会员等级
					*/
					public Integer getHuiyuandengjiTypes() {
						return huiyuandengjiTypes;
					}
					/**
					* 设置： 会员等级
					*/
					public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
						this.huiyuandengjiTypes = huiyuandengjiTypes;
					}


						/**
						* 获取： 会员等级的值
						*/
						public String getHuiyuandengjiValue() {
							return huiyuandengjiValue;
						}
						/**
						* 设置： 会员等级的值
						*/
						public void setHuiyuandengjiValue(String huiyuandengjiValue) {
							this.huiyuandengjiValue = huiyuandengjiValue;
						}


				//级联表的get和set youxi

					/**
					* 获取： 游戏名称
					*/
					public String getYouxiName() {
						return youxiName;
					}
					/**
					* 设置： 游戏名称
					*/
					public void setYouxiName(String youxiName) {
						this.youxiName = youxiName;
					}

					/**
					* 获取： 游戏编号
					*/
					public String getYouxiUuidNumber() {
						return youxiUuidNumber;
					}
					/**
					* 设置： 游戏编号
					*/
					public void setYouxiUuidNumber(String youxiUuidNumber) {
						this.youxiUuidNumber = youxiUuidNumber;
					}

					/**
					* 获取： 游戏照片
					*/
					public String getYouxiPhoto() {
						return youxiPhoto;
					}
					/**
					* 设置： 游戏照片
					*/
					public void setYouxiPhoto(String youxiPhoto) {
						this.youxiPhoto = youxiPhoto;
					}

					/**
					* 获取： 最低配置
					*/
					public String getYouxiZuidipeizhi() {
						return youxiZuidipeizhi;
					}
					/**
					* 设置： 最低配置
					*/
					public void setYouxiZuidipeizhi(String youxiZuidipeizhi) {
						this.youxiZuidipeizhi = youxiZuidipeizhi;
					}

					/**
					* 获取： 推荐配置
					*/
					public String getYouxiTuijianpeizhi() {
						return youxiTuijianpeizhi;
					}
					/**
					* 设置： 推荐配置
					*/
					public void setYouxiTuijianpeizhi(String youxiTuijianpeizhi) {
						this.youxiTuijianpeizhi = youxiTuijianpeizhi;
					}

					/**
					* 获取： 开发商
					*/
					public String getYouxiKaifashang() {
						return youxiKaifashang;
					}
					/**
					* 设置： 开发商
					*/
					public void setYouxiKaifashang(String youxiKaifashang) {
						this.youxiKaifashang = youxiKaifashang;
					}

					/**
					* 获取： 支持语言
					*/
					public String getYouxiYuyan() {
						return youxiYuyan;
					}
					/**
					* 设置： 支持语言
					*/
					public void setYouxiYuyan(String youxiYuyan) {
						this.youxiYuyan = youxiYuyan;
					}

					/**
					* 获取： 需要空间
					*/
					public String getYouxiKongjian() {
						return youxiKongjian;
					}
					/**
					* 设置： 需要空间
					*/
					public void setYouxiKongjian(String youxiKongjian) {
						this.youxiKongjian = youxiKongjian;
					}

					/**
					* 获取： 首发日期
					*/
					public String getYouxiShoufa() {
						return youxiShoufa;
					}
					/**
					* 设置： 首发日期
					*/
					public void setYouxiShoufa(String youxiShoufa) {
						this.youxiShoufa = youxiShoufa;
					}

					/**
					* 获取： 游戏下载链接
					*/
					public String getYouxiAddress() {
						return youxiAddress;
					}
					/**
					* 设置： 游戏下载链接
					*/
					public void setYouxiAddress(String youxiAddress) {
						this.youxiAddress = youxiAddress;
					}

					/**
					* 获取： 购买获得积分
					*/
					public Integer getYouxiPrice() {
						return youxiPrice;
					}
					/**
					* 设置： 购买获得积分
					*/
					public void setYouxiPrice(Integer youxiPrice) {
						this.youxiPrice = youxiPrice;
					}

					/**
					* 获取： 游戏原价
					*/
					public Double getYouxiOldMoney() {
						return youxiOldMoney;
					}
					/**
					* 设置： 游戏原价
					*/
					public void setYouxiOldMoney(Double youxiOldMoney) {
						this.youxiOldMoney = youxiOldMoney;
					}

					/**
					* 获取： 现价
					*/
					public Double getYouxiNewMoney() {
						return youxiNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setYouxiNewMoney(Double youxiNewMoney) {
						this.youxiNewMoney = youxiNewMoney;
					}

					/**
					* 获取： 游戏热度
					*/
					public Integer getYouxiClicknum() {
						return youxiClicknum;
					}
					/**
					* 设置： 游戏热度
					*/
					public void setYouxiClicknum(Integer youxiClicknum) {
						this.youxiClicknum = youxiClicknum;
					}

					/**
					* 获取： 游戏详细介绍
					*/
					public String getYouxiContent() {
						return youxiContent;
					}
					/**
					* 设置： 游戏详细介绍
					*/
					public void setYouxiContent(String youxiContent) {
						this.youxiContent = youxiContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getYouxiDelete() {
						return youxiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setYouxiDelete(Integer youxiDelete) {
						this.youxiDelete = youxiDelete;
					}













}
