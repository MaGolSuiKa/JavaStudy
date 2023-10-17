package com.geekaca.mall.mapper;

import com.geekaca.mall.controller.vo.MallIndexCategoryVO;
import com.geekaca.mall.controller.vo.SecondLevelCategoryVO;
import com.geekaca.mall.controller.vo.ThirdLevelCategoryVO;
import com.geekaca.mall.domain.GoodsCategory;
import com.geekaca.mall.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author kanata
* @description 针对表【tb_newbee_mall_goods_category】的数据库操作Mapper
* @createDate 2023-10-13 03:24:05
* @Entity com.geekaca.mall.domain.GoodsCategory
*/
@Mapper
public interface GoodsCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GoodsCategory record);

    int insertSelective(GoodsCategory record);

    GoodsCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsCategory record);

    int updateByPrimaryKey(GoodsCategory record);

    List<GoodsCategory> findAll(PageQueryUtil pageUtil);

    int getTotalCategories(PageQueryUtil pageUtil);

    GoodsCategory selectByCategoryName(String categoryName);

    int deleteByIds(Long[] ids);

    //三级分类
    List<MallIndexCategoryVO> getCategoriesForIndex();

    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);


    int getTotalCategoryCounts(PageQueryUtil pageQueryUtil);

    List<GoodsCategory> getCategoryList(PageQueryUtil pageQueryUtil);
}
