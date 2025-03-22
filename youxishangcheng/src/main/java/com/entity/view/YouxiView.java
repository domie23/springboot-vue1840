package com.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.entity.YouxiEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 * 游戏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("youxi")
public class YouxiView extends YouxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 游戏类型的值
		*/
		private String youxiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public YouxiView() {

	}

	public YouxiView(YouxiEntity youxiEntity) {
		try {
			BeanUtils.copyProperties(this, youxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 游戏类型的值
			*/
			public String getYouxiValue() {
				return youxiValue;
			}
			/**
			* 设置： 游戏类型的值
			*/
			public void setYouxiValue(String youxiValue) {
				this.youxiValue = youxiValue;
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











}
