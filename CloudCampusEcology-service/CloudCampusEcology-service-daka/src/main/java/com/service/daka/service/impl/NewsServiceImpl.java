package com.service.daka.service.impl;

import com.service.daka.mapper.NewsMapper;
import com.service.daka.model.News;
import com.service.daka.model.NewsExample;
import com.service.daka.service.NewsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName NewsServiceImpl
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/11 22:00
 * @Version 1.0
 */
@Service
@Transactional
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsMapper newsMapper;


    @Override
    public List<News> getList() {
        NewsExample example = new NewsExample();
        example.setOrderByClause("create_time");
        return newsMapper.selectByExample(example);
    }

    @Override
    public void delNews(String id) {
        News news = new News();
        news.setId(id);
        newsMapper.updateByPrimaryKeySelective(news);
    }

    @Override
    public News getNewsDetail(String id) {
        return newsMapper.selectByPrimaryKey(id);
    }
}
