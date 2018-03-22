package com.dgit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgit.domain.Criteria;
import com.dgit.domain.ProjectVO;
import com.dgit.persistence.ProjectDAO;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDAO dao;
	
	@Override
	public List<ProjectVO> listProject(Criteria cri) {
		
		return dao.listAllProject(cri);
	}

	@Override
	public ProjectVO readProject(int pno) {
		return dao.readProject(pno);
	}

	@Override
	public void registerProject(ProjectVO vo) {
		dao.addProject(vo);
	}

	@Override
	public void modifyProject(ProjectVO vo) {
		dao.updateProject(vo);
	}

	@Override
	public void removeProject(int pno) {
		dao.removeProject(pno);
	}

	@Override
	public int totalCountProject() {
		return dao.totalCountProject();
	}

}
