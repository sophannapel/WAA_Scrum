package edu.mum.cs545.service.impl;

import edu.mum.cs545.dao.RoleDAO;
import edu.mum.cs545.entity.Role;
import edu.mum.cs545.service.RoleService;
import java.util.List;
import javax.inject.Inject;

public class RoleServiceImpl implements RoleService {

    @Inject
    private RoleDAO roleDao;

    @Override
    public Role getRole(int roleId) {
        return roleDao.getRole(roleId);
    }

    @Override
    public List<Role> roleList() {
        return roleDao.roleList();
    }
}
