  
package com.geekaca.mall.controller.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 首页轮播图VO
 * 值对象
 */
@Data
public class CarouselVO implements Serializable {

    @ApiModelProperty("轮播图图片地址")
    private String carouselUrl;

    @ApiModelProperty("轮播图点击后的跳转路径")
    private String redirectUrl;
}
