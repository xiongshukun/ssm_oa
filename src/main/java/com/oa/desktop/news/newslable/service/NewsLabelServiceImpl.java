package com.oa.desktop.news.newslable.service;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.valueobject.Page;
import com.oa.desktop.news.newslable.dao.INewsLabelDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsLabelServiceImpl implements INewsLabelService{

    @Autowired
    private INewsLabelDao newsLabelDao;

    @Override
    public Page<NewsLabel> findCurrentPage(int pagenum) {
        Page<NewsLabel> page = new Page<>();
        page.setPagenum(pagenum);

        int totalRows = newsLabelDao.selectAllCount();
        page.setTotalRows(totalRows);

        List<NewsLabel> datas = newsLabelDao.selectCurrentPageNewsLabel(page);
        page.setDatas(datas);
        return page;
    }

    @Override
    public List<NewsLabel> findAllParent() {
        return newsLabelDao.selectAllParent();
    }
}