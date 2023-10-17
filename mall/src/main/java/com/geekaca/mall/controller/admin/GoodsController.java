package com.geekaca.mall.controller.admin;


import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.common.Constants;
import com.geekaca.mall.controller.admin.param.BatchIdParam;
import com.geekaca.mall.controller.admin.param.GoodsAddParam;
import com.geekaca.mall.domain.GoodsInfo;
import com.geekaca.mall.service.GoodsInfoService;
import com.geekaca.mall.utils.PageResult;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping("/manage-api/v1")
public class GoodsController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     * test
     *
     * @param pageNumber
     * @param pageSize
     * @param goodsName       模糊搜索
     * @param goodsSellStatus
     * @return
     */
    @ApiOperation(value = "商品列表", notes = "查询所有商品")
    @RequestMapping(value = "/goods/list", method = RequestMethod.GET)
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                       @RequestParam(required = false) @ApiParam(value = "商品名称") String goodsName,
                       @RequestParam(required = false) @ApiParam(value = "上架状态 0-上架 1-下架") Integer goodsSellStatus) {

        if (pageNumber == null) {
            pageNumber = 1;
        }
        if (pageSize == null) {
            pageSize = 20;
        }
        PageResult pageResult = goodsInfoService.findAllGoods(pageNumber, pageSize, goodsName);
        //还需要一个查询，查询符合条件的记录条数
        Result result = ResultGenerator.genSuccessResult();
        result.setData(pageResult);
        return result;
    }

    //添加商品
    @RequestMapping(value = "/goods", method = RequestMethod.POST)
    @ApiOperation(value = "新增商品信息", notes = "新增商品信息")
    public Result list(@RequestBody @Valid GoodsAddParam goodsAddParam) {
        Boolean addGood = goodsInfoService.addGood(goodsAddParam);
        if (addGood == true) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 下架商品
     */
    @RequestMapping(value = "/goods/status/{sellStatus}", method = RequestMethod.PUT)
    @ApiOperation(value = "批量修改销售状态", notes = "批量修改销售状态")
    public Result delete(@RequestBody BatchIdParam batchIdParam, @PathVariable("sellStatus") int sellStatus) {
        if (batchIdParam == null || batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (sellStatus != Constants.SELL_STATUS_UP && sellStatus != Constants.SELL_STATUS_DOWN) {
            return ResultGenerator.genFailResult("状态异常！");
        }
        if (goodsInfoService.updateSellStatus(batchIdParam.getIds(),sellStatus)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
