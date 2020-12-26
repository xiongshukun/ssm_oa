package com.oa.desktop.news.newslable.dao;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.valueobject.Page;

import java.util.List;

public interface INewsLabelDao {
    int selectAllCount();

    List<NewsLabel> selectCurrentPageNewsLabel(Page<NewsLabel> page);

    List<NewsLabel> selectAllParent();
    
    void deleteNewsLabel(Integer id);

    void updateNewsLabel(NewsLabel newsLabel);

    void insertNewsLabel(NewsLabel newsLabel);
}
