package com.dao;

import com.entity.YouxiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxiOrderView;

/**
 * 游戏订单 Dao 接口
 *
 * @author 
 */
public interface YouxiOrderDao extends BaseMapper<YouxiOrderEntity> {

   List<YouxiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
