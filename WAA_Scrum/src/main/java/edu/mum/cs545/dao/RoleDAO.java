package edu.mum.cs545.dao;

import edu.mum.cs545.entity.Role;
import java.util.List;

public interface RoleDAO {

    public Role getRole(int roleId);
    
    public List<Role> roleList();
}
