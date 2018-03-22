package com.dgit.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dgit.domain.Criteria;
import com.dgit.domain.PageMaker;
import com.dgit.domain.ProjectVO;
import com.dgit.service.ProjectService;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	ProjectService service;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model,@ModelAttribute("cri") Criteria cri) {
		logger.info("home Get");
		List<ProjectVO> list =service.listProject(cri); 
		
		PageMaker pageMaker = new  PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.totalCountProject());
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", pageMaker);
		
		return "home";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGet(){
		logger.info("register Get");
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerPost(ProjectVO vo,String start,String end) throws Exception{
		logger.info("register post");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		vo.setStartdate(startDate);
		vo.setEnddate(endDate);
		service.registerProject(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/read")
	public void readGet(int pno,Model model,Criteria cri){
		logger.info("readPage");
		ProjectVO vo = service.readProject(pno);
		model.addAttribute("project", vo);
		model.addAttribute("cri",cri);
		
	}
	
	@RequestMapping(value="/remove")
	public String remove(int pno,RedirectAttributes rttr){
		logger.info("remove");
		
		service.removeProject(pno);
		rttr.addFlashAttribute("delete","삭제되었습니다.");
		return "redirect:/";
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGet(int pno,Model model,Criteria cri){
		logger.info("modify get");
		ProjectVO vo = service.readProject(pno);
		model.addAttribute("project", vo);
		model.addAttribute("cri", cri);
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPost(ProjectVO vo,String start,String end,RedirectAttributes rttr,Criteria cri) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		vo.setStartdate(startDate);
		vo.setEnddate(endDate);
		service.modifyProject(vo);
		rttr.addFlashAttribute("modify", "수정되었습니다.");
		rttr.addAttribute("pno",vo.getPno());
		logger.info("modify post");
		logger.info(cri.toString());
		rttr.addAttribute("page", cri.getPage());
		return "redirect:read";
	}
}
