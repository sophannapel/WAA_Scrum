package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.WorklogDAO;
import edu.mum.cs545.entity.Worklog;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WorklogDAOImpl implements WorklogDAO {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryDAOImpl.class);
	
	@Override
	@Transactional
	public void createWorklog(Worklog worklog) {
		LOGGER.info("Save worklog : " + worklog.toString());
		entityManager.merge(worklog);
		entityManager.flush();
		
	}

	@Override
	public List<Worklog> worklogList(int userStoryId) {
		LOGGER.info("worklogList Method call");
		Query q = entityManager.createQuery("FROM Worklog WHERE userStoryId = :userStoryId");
		q.setParameter("userStoryId", userStoryId);
		List<Worklog> worklogList = q.getResultList();
		
		for(Worklog w : worklogList)
			LOGGER.info("User story list::" + w);
		return worklogList;
	}

	@Override
	@Transactional
	public Worklog getWorklogById(int worklogId) {
		LOGGER.info("getWorklogById Method call");
		Query query = entityManager.createQuery("FROM Worklog WHERE id=:id");
		query.setParameter("id", worklogId);
		List<Worklog> list = query.getResultList();
		if(list.isEmpty())
			return null;
		else 
			return list.get(0);
	}

	@Override
	@Transactional
	public void updateWorklog(Worklog worklog) {
		LOGGER.info("updateWorklog Method, id = " + worklog.getId());
		Query query = entityManager.createQuery("UPDATE Worklog SET actualEffort=:actualEffort,"
				+ " modifiedDate=:modifiedDate,"
				+ " effortType=:effortType WHERE id=:id");
		query.setParameter("actualEffort", worklog.getActualEffort());
		query.setParameter("modifiedDate", worklog.getModifiedDate());
		query.setParameter("effortType", worklog.getEffortType());
		query.setParameter("id", worklog.getId());
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public void deleteWorklog(int worklogId) {
		LOGGER.info("deleteWorklog Method, id = " + worklogId);
		Worklog wl = entityManager.find(Worklog.class, worklogId);
		entityManager.remove(wl);
		entityManager.flush();
		
	}

}
