package com.service.daka.service;

import com.service.daka.model.News;

import java.util.List;

/**
 * @ClassName NewsService
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/11 22:00
 * @Version 1.0
 */
public interface NewsService {

    List<News> getList();

    void delNews(String id);

    News getNewsDetail(String id);
}
