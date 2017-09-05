package edu.whut.web.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import edu.whut.web.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements
		BaseDao<T> {
	@SuppressWarnings({ "rawtypes" })
	private final Class paramType;	
	
	@SuppressWarnings({ "rawtypes" })
	public BaseDaoImpl() {
		super();
		paramType = (Class) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public T insert(T object) {
		getHibernateTemplate().save(object);
		return object;
	}

	@Override
	public T update(T object) {
		getHibernateTemplate().update(object);
		return object;
	}

	@Override
	public T delete(T object) {
		getHibernateTemplate().delete(object);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(long id) {
		T object = (T)getHibernateTemplate().get(paramType, id);
		return object;
	}
	
	@Override
	public T merge(T object) {
		getHibernateTemplate().merge(object);
		return object;
	}
	
	@Override
	public List<T> findAllOnes(){
		List<T> objects = getHibernateTemplate().loadAll(paramType);
		return objects;
	}
	

}
