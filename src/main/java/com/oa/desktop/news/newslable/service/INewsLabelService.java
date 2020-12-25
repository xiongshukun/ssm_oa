package com.oa.desktop.news.newslable.service;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.valueobject.Page;

import java.util.List;

public interface INewsLabelService {
    Page<NewsLabel> findCurrentPage(int pagenum);

    List<NewsLabel> findAllParent();

    void deleteNewsLabel(Integer id);
}
