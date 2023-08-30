package com.geekaca;

import com.geekaca.config.MySpringConfig;
import com.geekaca.domain.Goods;
import com.geekaca.service.GoodsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 记笔记上！！！！
 */
//Junit测试Spring的项目
//设置类运行器
@RunWith(SpringJUnit4ClassRunner.class)
//设置Spring环境对应的配置类
@ContextConfiguration(classes = MySpringConfig.class)
public class TestService {
    @Autowired
    private GoodsService goodsService;

    @Test
    public void testSelectAll(){
        List<Goods> all = goodsService.search();
        // 断言 预期 :当程序是正常的，符合预期的，那么就可以通过这个单元测试，否则就通不过测试
        // 单元测试保障    你的逻辑和预期是一致的
        Assert.assertNotNull(all);
        Assert.assertTrue(all.size() > 0);
    }
}