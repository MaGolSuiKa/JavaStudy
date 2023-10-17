package com.geekaca.mall.service;

import com.geekaca.mall.controller.admin.param.CategoryParam;
import com.geekaca.mall.controller.admin.param.GoodsAddParam;
//<<<<<<< HEAD
import com.geekaca.mall.utils.PageQueryUtil;
//=======
import com.geekaca.mall.controller.vo.FrontPageVo;
//>>>>>>> cb75049 (前台 搜索)
import com.geekaca.mall.utils.PageResult;
import org.apache.ibatis.annotations.Param;

public interface GoodsInfoService {
    PageResult findAllGoods(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize, @Param("goodsName") String goodsName);

    Boolean addGood(GoodsAddParam goodsAddParam);

    boolean updateSellStatus(Long[] ids,int sellStatus);
//
//    PageResult searchGoods(PageQueryUtil pageUtil);

    PageResult searchFrontGoods(FrontPageVo frontPageVo);
}
