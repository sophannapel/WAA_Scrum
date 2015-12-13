package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.ReleaseBacklogDAO;
import edu.mum.cs545.entity.ReleaseBacklog;
import edu.mum.cs545.service.ReleaseBacklogService;
import java.util.List;
import javax.inject.Inject;


public class ReleaseBacklogServiceImpl implements ReleaseBacklogService{


	@Inject
	private ReleaseBacklogDAO releaseDao;
	
	@Override
	public List<ReleaseBacklog> listRelease() {
		return releaseDao.listRelease();
	}

	@Override
	public List<ReleaseBacklog> listReleaseByProductId(int productId) {
		return releaseDao.listReleaseByProductId(productId);
	}

	@Override
	public void createRelease(ReleaseBacklog release) {
		releaseDao.createRelease(release);
	}

	@Override
	public ReleaseBacklog getReleaseBacklogById(int releaseId) {
		return releaseDao.getReleaseBacklogById(releaseId);
	}

	@Override
	public void updateReleaseBacklog(ReleaseBacklog releaseBacklog) {
		releaseDao.updateReleaseBacklog(releaseBacklog);
	}

	@Override
	public void deleteReleaseBacklog(int id) {
		releaseDao.deleteReleaseBacklog(id);
	}

	
}
