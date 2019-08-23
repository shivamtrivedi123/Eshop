package com.shivam.backend.DAO.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shivam.backend.DAO.SupplierDAO;
import com.shivam.backend.model.Supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;

	
	public boolean insertSupp(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().persist(supplier);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	
	public boolean updateSupp(Supplier supplier) {
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	
	public boolean deleteSupp(int sid) {
		try {
			sessionFactory.getCurrentSession().delete(getSupplierById(sid));
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	
	public Supplier getSupplierById(int sid) {
		try {
			return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(sid));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	
	public List<Supplier> list() {
		String selectSupplier = "FROM Supplier";

		Query query = sessionFactory.getCurrentSession().createQuery(selectSupplier);

		return query.getResultList();
	}

}
