package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.WorklogDAO;
import edu.mum.cs545.entity.Worklog;
import edu.mum.cs545.service.WorklogService;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorklogServiceImpl implements WorklogService {

	@Inject
	private WorklogDAO worklogDao;
	private static final Logger LOGGER = LoggerFactory.getLogger(WorklogServiceImpl.class);
	
	@Override
	public void createWorklog(Worklog worklog) {
		LOGGER.info("Create user story : " + worklog);
		worklogDao.createWorklog(worklog);
		
	}

	@Override
	public List<Worklog> worklogList(int userStoryId) {
		return worklogDao.worklogList(userStoryId);
	}

	@Override
	public Worklog getWorklogById(int worklogId) {
		return worklogDao.getWorklogById(worklogId);
	}

	@Override
	public void updateWorklog(Worklog worklog) {
		worklogDao.updateWorklog(worklog);
		
	}

	@Override
	public void deleteWorklog(int worklogId) {
		worklogDao.deleteWorklog(worklogId);
		
	}

}
