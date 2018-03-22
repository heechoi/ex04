package com.dgit.service;

import java.util.List;

import com.dgit.domain.Criteria;
import com.dgit.domain.ProjectVO;

public interface ProjectService {
	public List<ProjectVO> listProject(Criteria cri);
	public ProjectVO readProject(int pno);
	public void registerProject(ProjectVO vo);
	public void modifyProject(ProjectVO vo);
	public void removeProject(int pno);
	public int totalCountProject();
}
