package com.dao;

import com.entity.YouxiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxiCommentbackView;

/**
 * 游戏评价 Dao 接口
 *
 * @author 
 */
public interface YouxiCommentbackDao extends BaseMapper<YouxiCommentbackEntity> {

   List<YouxiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
