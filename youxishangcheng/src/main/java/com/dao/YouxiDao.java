package com.dao;

import com.entity.YouxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxiView;

/**
 * 游戏 Dao 接口
 *
 * @author 
 */
public interface YouxiDao extends BaseMapper<YouxiEntity> {

   List<YouxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
