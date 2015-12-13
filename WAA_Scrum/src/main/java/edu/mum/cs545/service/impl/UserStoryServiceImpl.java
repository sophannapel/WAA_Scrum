package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.UserStoryDAO;
import edu.mum.cs545.entity.UserStory;
import edu.mum.cs545.service.UserStoryService;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserStoryServiceImpl implements UserStoryService {

    @Inject
    private UserStoryDAO userStoryDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryServiceImpl.class);

    @Override
    public void createUserStory(UserStory userStory) {
        LOGGER.info("Create user story : " + userStory.getId());
        userStoryDao.createUserStory(userStory);
    }

    @Override
    public List<UserStory> userStoryList() {
        return userStoryDao.userStoryList();
    }

    @Override
    public UserStory getUserStoryById(int id) {
        return userStoryDao.getUserStoryById(id);
    }

    @Override
    public void updateUserStory(UserStory userStory) {
        userStoryDao.updateUserStory(userStory);
    }

    @Override
    public void deleteUserStory(int id) {
        userStoryDao.deleteUserStory(id);
    }

    @Override
    public List<UserStory> getUserStoryForRelease(int releaseId) {
        return userStoryDao.getUserStoryForRelease(releaseId);

    }

    @Override
    public void updateSprintForUserStory(UserStory userStory, int sprintId) {
        userStoryDao.updateSprintForUserStory(userStory, sprintId);

    }

    public List<UserStory> userStoryListForDevTest(int empID) {
        return userStoryDao.userStoryListForDevTest(empID);
    }

    @Override
    public void updateUserStoryForDevTest(UserStory userStory) {
        userStoryDao.updateUserStoryForDevTest(userStory);

    }

}
