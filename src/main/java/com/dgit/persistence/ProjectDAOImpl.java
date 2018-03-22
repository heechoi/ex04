package com.dgit.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dgit.domain.Criteria;
import com.dgit.domain.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO{
	
	private static final String namespace = "com.dgit.mapper.ProjectMapper";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public List<ProjectVO> listAllProject(Criteria cri) {
		Criteria cri2 =new Criteria();
		cri2.setPage((cri.getPage()-1)*cri.getPerPageNum());
		return session.selectList(namespace+".listAllProject",cri2);
	}

	@Override
	public ProjectVO readProject(int pno) {
		return session.selectOne(namespace+".readProject",pno);
	}

	@Override
	public void addProject(ProjectVO vo) {
		session.insert(namespace+".addProject",vo);
	}

	@Override
	public void removeProject(int pno) {
		session.delete(namespace+".removeProject",pno);
	}

	@Override
	public void updateProject(ProjectVO vo) {
		session.update(namespace+".updateProject",vo);
	}

	@Override
	public int totalCountProject() {
		return session.selectOne(namespace+".totalCountProject");
	}

}
