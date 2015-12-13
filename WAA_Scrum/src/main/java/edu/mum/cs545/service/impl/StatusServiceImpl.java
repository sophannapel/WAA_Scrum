package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.StatusDAO;
import edu.mum.cs545.entity.Status;
import edu.mum.cs545.service.StatusService;
import java.util.List;
import javax.inject.Inject;

public class StatusServiceImpl implements StatusService {
		
	@Inject
	private StatusDAO statusDao;
	
	@Override
	public List<Status> statusList() {
		return statusDao.statusList();
	}

}
