package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.RoleDAO;
import edu.mum.cs545.entity.Role;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleDAOImpl.class);

    @Override
    @Transactional
    public Role getRole(int id) {
        Query query = entityManager.createQuery(" from Role where id = :id");
        query.setParameter("id", id);
        List<Role> role = query.getResultList();
        System.out.println(role.get(0).toString());
        return role.get(0);
    }

    @Override
    @Transactional
    public List<Role> roleList() {
        List<Role> list = entityManager.createQuery("SELECT r FROM Role r").getResultList();
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }
}
