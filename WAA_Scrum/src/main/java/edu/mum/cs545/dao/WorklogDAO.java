package edu.mum.cs545.dao;

import edu.mum.cs545.entity.Worklog;
import java.util.List;

public interface WorklogDAO {
	
	public void createWorklog(Worklog worklog);
	public List<Worklog> worklogList(int userStoryId);
	public Worklog getWorklogById(int worklogId);
	public void updateWorklog(Worklog worklog);
	public void deleteWorklog(int worklogId);
	
}
