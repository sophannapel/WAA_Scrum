package edu.mum.cs545.service;

import edu.mum.cs545.entity.Role;
import java.util.List;

public interface RoleService {

    public Role getRole(int roleId);
    
    public List<Role> roleList();
}
