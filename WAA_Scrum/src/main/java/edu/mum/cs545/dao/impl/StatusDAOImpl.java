package edu.mum.cs545.dao.impl;

import edu.mum.cs545.dao.StatusDAO;
import edu.mum.cs545.entity.Status;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
public class StatusDAOImpl implements StatusDAO {

    @PersistenceContext(unitName = "scrum")
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Status> statusList() {
        List<Status> list = entityManager.createQuery("SELECT s FROM Status s").getResultList();
        if (list.isEmpty()) {
            return null;
        } else {
            return list;
        }
    }

}
