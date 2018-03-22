package com.dgit.ex04;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dgit.domain.Criteria;
import com.dgit.domain.ProjectVO;
import com.dgit.persistence.ProjectDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class ProjectTest {
	
	@Autowired
	ProjectDAO dao;
	
	//@Test
	public void listTest(){
		Criteria cri = new Criteria();
		cri.setPage(1);
		cri.setPerPageNum(5);
		dao.listAllProject(cri);
	}
	
	//@Test
	public void addTest(){
		ProjectVO vo = new ProjectVO();
		vo.setName("새로운사람");
		vo.setContent("새로운 내용");
		vo.setStartdate(new Date());
		vo.setEnddate(new Date());
		vo.setState("준비");
		
		dao.addProject(vo);
	}
	
	//@Test
	public void readTest(){
		dao.readProject(1);
	}
	
	//@Test
	public void updateTest(){
		ProjectVO vo = new ProjectVO();
		vo.setPno(1);
		vo.setName("수정");
		vo.setContent("수정 내용");
		vo.setStartdate(new Date());
		vo.setEnddate(new Date());
		vo.setState("준비");
		dao.updateProject(vo);
	}
	@Test
	public void deleteTest(){
		dao.removeProject(1);
	}
}
