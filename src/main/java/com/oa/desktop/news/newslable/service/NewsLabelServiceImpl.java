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

    @Override
    public void deleteNewsLabel(Integer id) {
        newsLabelDao.deleteNewsLabel(id);
    }

    @Override
    public void updateNewsLabel(NewsLabel newsLabel) {
        newsLabelDao.updateNewsLabel(newsLabel);
        System.out.println(newsLabel.getId());
    }

    @Override
    public void insertNewsLabel(NewsLabel newsLabel) {
        newsLabelDao.insertNewsLabel(newsLabel);
    }

    @Override
    public List<NewsLabel> FindAll() {
        return newsLabelDao.FindAll();
    }

    @Override
    public NewsLabel FindUpdate(Integer id) {
        return newsLabelDao.FindUpdate(id);
    }

    @Override
    public Page<NewsLabel> selectAllCurrentPage(int id, int pagenum) {
        Page<NewsLabel> page = new Page<>();
        page.setPagenum(pagenum);
        int count = newsLabelDao.findCount(id);
        page.setTotalRows(count);
        System.out.println(count);
        List<NewsLabel> labels = newsLabelDao.findNewsLabel(page,id);
        page.setDatas(labels);
        List<NewsLabel> data = page.getDatas();
        for (int i = 0;i < data.size(); i++){
            System.out.println(data.get(i));
        }
        return page;
    }

    @Override
    public List<NewsLabel> findAllNewsLabel() {
        return newsLabelDao.findAllNewsLabel();
    }
}
