package edu.mum.cs545.service;

import edu.mum.cs545.entity.ReleaseBacklog;
import java.util.List;

public interface ReleaseBacklogService {

    public List<ReleaseBacklog> listRelease();

    public List<ReleaseBacklog> listReleaseByProductId(int productId);

    public void createRelease(ReleaseBacklog release);

    public ReleaseBacklog getReleaseBacklogById(int releaseId);

    public void updateReleaseBacklog(ReleaseBacklog releaseBacklog);

    public void deleteReleaseBacklog(int id);
}
