package com.service.daka.controller;

import com.service.daka.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName NewsController
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/11 21:58
 * @Version 1.0
 */
@Api("新闻")
@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;


    @GetMapping("/getList")
    @ApiOperation(value = "获取新闻列表", notes = "获取新闻列表")
    public Object getList(@RequestParam(value = "pageNum", required = true) int pageNum,
                          @RequestParam(value = "pageSize", required = true) int pageSize) {

        return newsService.getList();

    }

}
