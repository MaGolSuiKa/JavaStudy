package com.geekaca.mall.controller.admin;


import cn.hutool.core.bean.BeanUtil;
import com.geekaca.mall.controller.admin.param.BatchIdParam;
import com.geekaca.mall.controller.admin.param.IndexConfigAddParam;
import com.geekaca.mall.controller.admin.param.IndexConfigEditParam;
import com.geekaca.mall.domain.IndexConfig;
import com.geekaca.mall.service.IndexService;
import com.geekaca.mall.utils.PageQueryUtil;
import com.geekaca.mall.utils.Result;
import com.geekaca.mall.utils.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;
import java.util.Map;

@Slf4j
@RestController
@Api(value = "v1", tags = "8-4.后台管理系统首页配置模块接口")
@RequestMapping("/manage-api/v1")
public class AdminIndexConfigController {
    @Autowired
    private IndexService indexService;

    /**
     * 列表
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.GET)
    @ApiOperation(value = "首页配置列表", notes = "首页配置列表")
    public Result list(@RequestParam(required = false) @ApiParam(value = "页码") Integer pageNumber,
                       @RequestParam(required = false) @ApiParam(value = "每页条数") Integer pageSize,
                       @RequestParam(required = false) @ApiParam(value = "1-搜索框热搜 2-搜索下拉框热搜 3-(首页)热销商品 4-(首页)新品上线 5-(首页)为你推荐") Integer configType,
                       @RequestParam Map<String, Object> params) {
        params.put("page", pageNumber);
        params.put("limit", pageSize);
        params.put("configType", configType);
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(indexService.getConfigsPage(pageUtil));
    }

    /**
     * 添加
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.POST)
    @ApiOperation(value = "新增首页配置项", notes = "新增首页配置项")
    public Result save(@RequestBody @Valid IndexConfigAddParam indexConfigAddParam) {
        IndexConfig indexConfig = new IndexConfig();
        BeanUtil.copyProperties(indexConfigAddParam, indexConfig);
        Boolean saveIndexConfig = indexService.saveIndexConfig(indexConfig);
        if (saveIndexConfig == true) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/indexConfigsDel", method = RequestMethod.DELETE)
    @ApiOperation(value = "批量删除首页配置项信息", notes = "批量删除首页配置项信息")
    public Result delete(@RequestBody BatchIdParam batchIdParam) {
        if (batchIdParam == null || batchIdParam.getIds().length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (indexService.deleteIndex(batchIdParam.getIds())) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/indexConfigs/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "获取单条首页配置项信息", notes = "根据id查询")
    public Result info(@PathVariable("id") Long id) {
        IndexConfig config = indexService.getIndexConfigById(id);
        if (config == null) {
            return ResultGenerator.genFailResult("未查询到数据");
        }
        return ResultGenerator.genSuccessResult(config);
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/indexConfigs", method = RequestMethod.PUT)
    @ApiOperation(value = "修改首页配置项", notes = "修改首页配置项")
    public Result update(@RequestBody @Valid IndexConfigEditParam indexConfigEditParam) {
        Boolean updateIndex = indexService.updateIndexConfig(indexConfigEditParam);
        if (updateIndex == true) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }
}
