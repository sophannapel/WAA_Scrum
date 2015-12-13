package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.RoleDAO;
import edu.mum.cs545.entity.Role;
import edu.mum.cs545.service.RoleService;
import javax.inject.Inject;

public class RoleServiceImpl implements RoleService {

    @Inject
    private RoleDAO roleDao;

    @Override
    public Role getRole(int roleId) {
        return roleDao.getRole(roleId);
    }

}
