package com.dgit.persistence;

import java.util.List;

import com.dgit.domain.Criteria;
import com.dgit.domain.ProjectVO;

public interface ProjectDAO {
	public List<ProjectVO> listAllProject(Criteria cri);
	public ProjectVO readProject(int pno);
	public void addProject(ProjectVO vo);
	public void removeProject(int pno);
	public void updateProject(ProjectVO vo);
	public int totalCountProject();
}	
