package com.buimanhthanh.dao.impl;

import java.util.List;
import java.util.Optional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.buimanhthanh.dao.RoleDao;
import com.buimanhthanh.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Optional<Role> getRoleById(Integer id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Role as a where a.id =: i",Role.class)
                .setParameter("i",id)
                .getSingleResult());
    }
    
    @Override
    public Optional<Role> getRoleByAuthority(String authority){
    	return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Role as a where a.authority =: i",Role.class)
                .setParameter("i",authority)
                .getSingleResult());
    }

    @Override
    public Optional<List<Role>> getAllRole() {
        return Optional.ofNullable(sessionFactory.getCurrentSession()
                .createQuery("from Role",Role.class)
                .getResultList());
    }

    @Override
    public Boolean saveOrUpdateRole(Role role) {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(role);
            return true;
        } catch (HibernateException e){
            System.out.println( "Error == add Role" + e.getMessage());
        }
        return false;
    }

    @Override
    public void deleteRole(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Role role = session.get(Role.class, id);
        if(role!=null)
            session.delete(role);
    }

    @Override
    public void deleteRole(List<Integer> ids) {
        if(!ids.isEmpty())
            ids.forEach(this::deleteRole);
    }
}
