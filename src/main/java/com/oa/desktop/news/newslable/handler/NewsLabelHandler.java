package com.oa.desktop.news.newslable.handler;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.valueobject.Page;
import com.oa.desktop.news.newslable.service.INewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/desktop/news")
public class NewsLabelHandler {

    @Autowired
    private INewsLabelService newsLabelService;

    @RequestMapping("/queryNewsLabel")
    public String queryNewsLable(@RequestParam(defaultValue = "1") int pagenum, Model model){

        List<NewsLabel> parent = newsLabelService.findAllParent();

        Page<NewsLabel> page = newsLabelService.findCurrentPage(pagenum);

        model.addAttribute("page",page);
        model.addAttribute("parent",parent);
        return "/html/news/newsLabelManger.jsp";
    }

    @RequestMapping("/deleteNewsLabel")
    public String deleteNewsLabel(Model model){
        return null;
    }

}
