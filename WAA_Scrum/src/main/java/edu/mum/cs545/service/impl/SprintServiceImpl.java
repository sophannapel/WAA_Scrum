package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.SprintDAO;
import edu.mum.cs545.entity.Coordinates;
import edu.mum.cs545.entity.Sprint;
import edu.mum.cs545.service.SprintService;
import java.util.List;
import javax.inject.Inject;

public class SprintServiceImpl implements SprintService {

    @Inject
    private SprintDAO sprintDAO;

    @Override
    public int insertSprint(Sprint sprint) {
        return sprintDAO.insertSprint(sprint);
    }

    @Override
    public List<Sprint> listSprint() {
        return sprintDAO.listSprint();
    }

    @Override
    public Sprint getSprintById(int id) {
        return sprintDAO.getSprintById(id);
    }

    @Override
    public void updateSprint(Sprint sprint) {
        sprintDAO.updateSprint(sprint);
    }

    @Override
    public void deleteSprint(int id) {
        sprintDAO.deleteSprint(id);
    }

    @Override
    public Long getTotalEstimate(int id) {
        return sprintDAO.getTotalEstimate(id);
    }

    @Override
    public List<Coordinates> getWorklogDataSet(int id) {
        return sprintDAO.getWorklogDataSet(id);
    }

    @Override
    public List<Sprint> getSprintsByReleaseId(int releaseId) {
        return sprintDAO.getSprintsByReleaseId(releaseId);
    }

}
