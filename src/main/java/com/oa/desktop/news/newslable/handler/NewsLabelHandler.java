package com.oa.desktop.news.newslable.handler;

import com.oa.commons.beans.NewsLabel;
import com.oa.commons.valueobject.Page;
import com.oa.desktop.news.newslable.service.INewsLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
    public String deleteNewsLabel(Integer id){
        newsLabelService.deleteNewsLabel(id);
        return "/desktop/news/queryNewsLabel";
    }

    @RequestMapping("newsLabelUpdate")
    public ModelAndView newsLabelUpdate(Integer id){
        ModelAndView mv = new ModelAndView();
        NewsLabel newsLabel = newsLabelService.FindUpdate(id);
        mv.addObject("newsLabel",newsLabel);
        mv.setViewName("/html/news/newsLabelUpdate.jsp");
        List<NewsLabel> newsLabelList = newsLabelService.FindAll();
        mv.addObject("newsLabelList",newsLabelList);
        return mv;
    }

    @RequestMapping("/updateNewsLabel")
    public String updateNewsLabel(NewsLabel newsLabel){
        newsLabelService.updateNewsLabel(newsLabel);
        System.out.println(newsLabel);
        return "redirect://desktop/news/queryNewsLabel";
    }

    @RequestMapping("/newsLabelInsert")
    public ModelAndView newsLabelInsert(){
        ModelAndView modelAndView = new ModelAndView();
        List<NewsLabel> newsLabelList = newsLabelService.FindAll();
        modelAndView.addObject("newsLabelList",newsLabelList);
        modelAndView.setViewName("/html/news/newsLabelInsert.jsp");

        return modelAndView;
    }

    @RequestMapping("/insertNewsLabel")
    public String insertNewsLabel(NewsLabel newsLabel){
        newsLabelService.insertNewsLabel(newsLabel);
        System.out.println(newsLabel);
        return "redirect://desktop/news/queryNewsLabel";
    }

}
