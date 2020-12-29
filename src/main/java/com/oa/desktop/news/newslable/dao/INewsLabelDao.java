package com.oa.desktop.news.newslable.dao;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.valueobject.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface INewsLabelDao {
    int selectAllCount();

    List<NewsLabel> selectCurrentPageNewsLabel(Page<NewsLabel> page);

    List<NewsLabel> selectAllParent();
    
    void deleteNewsLabel(Integer id);

    void updateNewsLabel(NewsLabel newsLabel);

    void insertNewsLabel(NewsLabel newsLabel);

    List<NewsLabel> FindAll();

    NewsLabel FindUpdate(int id);

    Page<NewsLabel> selectAllCurrentPage(int id, int pagenum);

    int findCount(int id);

    List<NewsLabel> findNewsLabel(@Param("page") Page<NewsLabel> page, @Param("id") int id);

    List<NewsLabel> findAllNewsLabel();
}
