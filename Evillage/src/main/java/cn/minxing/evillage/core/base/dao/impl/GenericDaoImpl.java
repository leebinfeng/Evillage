package cn.minxing.evillage.core.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.ScrollableResults;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.minxing.evillage.common.exception.dao.ApplicationDataAccessException;
import cn.minxing.evillage.core.base.dao.IGenericDao;

/**
 * Implementation class of IGenericDao
 * <p>
 * This class is {@code abstract} to force the programmer to extend the
 * class.All implementation classes in DAO tier need to extend this generic DAO
 * implementation class
 * </p>
 * 
 * @author 李彬峰
 * 
 * @param <T>
 * @param <ID>
 * @see org.springframework.orm.hibernate4.support.HibernateDaoSupport
 *
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class GenericDaoImpl<T, ID extends Serializable> extends
		HibernateDaoSupport implements IGenericDao<T, ID> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());
	private Class<T> entityClass;

	public GenericDaoImpl() {
		this.entityClass = null;
		try {
			// Returns the runtime class of this Object
			Class c = getClass();
			/*
			 * Returns the Type representing the direct superclass of the entity
			 * (class, interface, primitive type or void) represented by this
			 * Class
			 */
			Type t = c.getGenericSuperclass();
			/*
			 * ParameterizedType represents a parameterized type such as
			 * Collection<String>
			 */
			ParameterizedType p = (ParameterizedType) t;
			// Returns an array of Type objects representing the actual type
			// arguments to this type
			this.entityClass = (Class<T>) p.getActualTypeArguments()[0];
			logger.debug("[{}] is invoking ...", this.entityClass);

		} catch (Exception e) {
			logger.error("[{}] throws exception ---> {}", this.entityClass, e);
		}
	}

	@Resource
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	// ------------------------------Basic CRUD---------------------------------
	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if not found
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 * @throws ApplicationDataAccessException
	 */
	public T get(ID id) throws ApplicationDataAccessException {
		logger.debug("[{}.get(ID id)] is invoking ...", this.entityClass);
		try {
			return this.getHibernateTemplate().get(entityClass, id);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier and add lock, or null if not found
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @param lockMode
	 *            the lock mode to obtain
	 * @return the persistent instance, or null if not found
	 * @throws ApplicationDataAccessException
	 */
	public T get(ID id, LockMode lockMode) throws ApplicationDataAccessException {
		logger.debug("[{}. get(ID id, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			T t = this.getHibernateTemplate().get(entityClass, id, lockMode);
			if (t != null) {
				// flush instantly or the lock won't be available
				this.flush();
			}
			return t;
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}
	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if not found
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance, or null if not found
	 * @throws ApplicationDataAccessException
	 */
	public Object get(String entityName, ID id) throws ApplicationDataAccessException {
		logger.debug("[{}.get(String entityName, ID id) is invoking ...]",
				this.entityClass);
		try {
			return this.getHibernateTemplate().get(entityName, id);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier and add lock, or null if not found
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param id
	 *            the identifier of the persistent instance
	 * @param lockMode
	 *            the lock mode to obtain
	 * @return the persistent instance, or null if not found
	 * @throws ApplicationDataAccessException
	 */
	public Object get(String entityName, ID id, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.get(String entityName, ID id, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			T t = (T) this.getHibernateTemplate().get(entityName, id, lockMode);
			if (t != null) {
				this.flush();
			}
			return t;
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, throwing an exception if not found
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public T load(ID id) throws ApplicationDataAccessException {
		logger.debug("[{}.load(ID id)] is invoking ...", this.entityClass);
		try {
			return this.getHibernateTemplate().load(entityClass, id);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier and add lock, throwing an exception if not found
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @param lockMode
	 *            the lock mode to obtain
	 * @return the persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public T load(ID id, LockMode lockMode) throws ApplicationDataAccessException {
		logger.debug("[{}.load(ID id, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			T t = this.getHibernateTemplate().load(entityClass, id, lockMode);
			if (t != null) {
				this.flush();
			}
			return t;
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Load the persistent instance with the given identifier into the given
	 * object, throwing an exception if not found
	 * 
	 * @param entity
	 *            the object (of the target class) to load into
	 * @param id
	 *            the identifier of the persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public void load(Object entity, ID id) throws ApplicationDataAccessException {
		logger.debug("[{}.load(Object entity, ID id)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().load(entity, id);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, throwing an exception if not found
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public Object load(String entityName, ID id) throws ApplicationDataAccessException {
		logger.debug("[{}.load(String entityName, ID id)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().load(entityName, id);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}
	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier and add lock, throwing an exception if not found
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param id
	 *            the identifier of the persistent instance
	 * @param lockMode
	 *            the lock mode to obtain
	 * @return the persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public Object load(String entityName, ID id, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.load(String entityName, ID id, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			T t = (T) this.getHibernateTemplate()
					.load(entityName, id, lockMode);
			if (t != null) {
				this.flush();
			}
			return t;
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return all persistent instances of the given entity class
	 * 
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> loadAll() throws ApplicationDataAccessException {
		logger.debug("[{}.loadAll()] is invoking ...", this.entityClass);
		try {
			return this.getHibernateTemplate().loadAll(entityClass);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Persist the given transient instance
	 * 
	 * @param entity
	 *            the transient instance to persist
	 * @return the generated identifier
	 * @throws ApplicationDataAccessException
	 */
	public ID save(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.save(Object entity)] is invoking ...",
				this.entityClass);
		try {
			return (ID) this.getHibernateTemplate().save(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Persist the given transient instance
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the transient instance to persist
	 * @return the generated identifier
	 * @throws ApplicationDataAccessException
	 */
	public ID save(String entityName, Object entity)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.save(String entityName, Object entity)] is invoking ...",
				this.entityClass);
		try {
			return (ID) this.getHibernateTemplate().save(entityName, entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Save or update the given persistent instance, according to its id
	 * (matching the configured "unsaved-value"?)
	 * 
	 * @param entity
	 *            the persistent instance to save or update (to be associated
	 *            with the Hibernate Session)
	 * @throws ApplicationDataAccessException
	 */
	public void saveOrUpdate(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.saveOrUpdate(Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().saveOrUpdate(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Save or update the given persistent instance, according to its id
	 * (matching the configured "unsaved-value"?)
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to save or update (to be associated
	 *            with the Hibernate Session)
	 * @throws ApplicationDataAccessException
	 */
	public void saveOrUpdate(String entityName, Object entity)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.saveOrUpdate(String entityName, Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().saveOrUpdate(entityName, entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Update the given persistent instance, associating it with the current
	 * Hibernate Session
	 * 
	 * @param entity
	 *            the persistent instance to update
	 * @throws ApplicationDataAccessException
	 */
	public void update(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.update(Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().update(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Update the given persistent instance and add lock, associating it with
	 * the current Hibernate Session
	 * 
	 * @param entity
	 *            the persistent instance to update
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void update(Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.update(Object entity, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().update(entity, lockMode);
			this.flush();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Update the given persistent instance, associating it with the current
	 * Hibernate Session
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to update
	 * @throws ApplicationDataAccessException
	 */
	public void update(String entityName, Object entity)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.update(String entityName, Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().update(entityName, entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Update the given persistent instance and add lock, associating it with
	 * the current Hibernate Session
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to update
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void update(String entityName, Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.update(String entityName, Object entity, LockMode lockMode) is invoking ...]",
				this.entityClass);
		try {
			this.getHibernateTemplate().update(entityName, entity, lockMode);
			this.flush();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Delete the given persistent instance
	 * 
	 * @param entity
	 *            the persistent instance to delete
	 * @throws ApplicationDataAccessException
	 */
	public void delete(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.delete(Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().delete(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Delete the given persistent instance and add lock
	 * 
	 * @param entity
	 *            the persistent instance to delete
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void delete(Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.delete(Object entity, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().delete(entity, lockMode);
			this.flush();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Delete the given persistent instance
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to delete
	 * @throws ApplicationDataAccessException
	 */
	public void delete(String entityName, Object entity)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}].delete(String entityName, Object entity) is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().delete(entityName, entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Delete the given persistent instance and add lock
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to delete
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void delete(String entityName, Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.delete(String entityName, Object entity, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().delete(entityName, entity, lockMode);
			this.flush();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Delete all given persistent instances
	 * 
	 * @param entities
	 *            the persistent instances to delete
	 * @throws ApplicationDataAccessException
	 */
	public void deleteAll(Collection<?> entities) throws ApplicationDataAccessException {
		logger.debug("[{}.deleteAll(Collection<?> entities)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().deleteAll(entities);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Persist the given transient instance. Follows JSR-220 semantics.Similar
	 * to save, associating the given object with the current Hibernate Session
	 * 
	 * @param entity
	 *            the persistent instance to persist
	 * @throws ApplicationDataAccessException
	 */
	public void persist(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.persist(Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().persist(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Persist the given transient instance. Follows JSR-220 semantics. Similar
	 * to save, associating the given object with the current Hibernate Session.
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to persist
	 * @throws ApplicationDataAccessException
	 */
	public void persist(String entityName, Object entity)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.persist(String entityName, Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().persist(entityName, entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Copy the state of the given object onto the persistent object with the
	 * same identifier. Follows JSR-220 semantics. Similar to saveOrUpdate, but
	 * never associates the given object with the current Hibernate Session. In
	 * case of a new entity, the state will be copied over as well
	 * 
	 * Note that merge will not update the identifiers in the passed-in object
	 * graph (in contrast to TopLink)! Consider registering Spring's
	 * IdTransferringMergeEventListener if you would like to have newly assigned
	 * ids transferred to the original object graph too
	 * 
	 * @param entity
	 *            the object to merge with the corresponding persistence
	 *            instance
	 * @return the updated, registered persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public T merge(T entity) throws ApplicationDataAccessException {
		logger.debug("[{}.merge(T entity)] is invoking ...");
		try {
			return this.getHibernateTemplate().merge(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Copy the state of the given object onto the persistent object with the
	 * same identifier. Follows JSR-220 semantics. Similar to saveOrUpdate, but
	 * never associates the given object with the current Hibernate Session. In
	 * the case of a new entity, the state will be copied over as well
	 * 
	 * Note that merge will not update the identifiers in the passed-in object
	 * graph (in contrast to TopLink)! Consider registering Spring's
	 * IdTransferringMergeEventListener if you would like to have newly assigned
	 * ids transferred to the original object graph too
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the object to merge with the corresponding persistence
	 *            instance
	 * @return the updated, registered persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public T merge(String entityName, T entity) throws ApplicationDataAccessException {
		logger.debug("[{}.merge(String entityName, T entity)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().merge(entityName, entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	// -----------------------------Criteria Query-----------------------------
	/**
	 * Create a Criteria that is associated with Hibernate's session
	 * 
	 * @return Criteria instance
	 * @throws ApplicationDataAccessException
	 */
	public Criteria createCriteria() throws ApplicationDataAccessException {
		logger.debug("[{}.createCriteria()] is invoking ...", this.entityClass);
		try {
			return this.createDetachedCriteria().getExecutableCriteria(
					this.getHibernateTemplate().getSessionFactory()
							.getCurrentSession());
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Create a DetachedCriteria that is not associated with Hibernate's session
	 * 
	 * @return DetachedCriteria instance
	 * @throws ApplicationDataAccessException
	 */
	public DetachedCriteria createDetachedCriteria()
			throws ApplicationDataAccessException {
		logger.debug("[{}.createDetachedCriteria()] is invoking ...",
				this.entityClass);
		try {
			return DetachedCriteria.forClass(this.entityClass);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query based on a given Hibernate criteria object
	 * 
	 * @param criteria
	 *            the detached Hibernate criteria object
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByCriteria(DetachedCriteria criteria)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByCriteria(DetachedCriteria criteria)] is invoking ...",
				this.entityClass);
		try {
			return (List<T>) this.getHibernateTemplate().findByCriteria(
					criteria);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query based on the given Hibernate criteria object. Return
	 * results page by page
	 * 
	 * @param criteria
	 *            the detached Hibernate criteria object
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResults
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByCriteria(DetachedCriteria criteria, int firstResult,
			int maxResults) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByCriteria(DetachedCriteria criteria, int firstResult,int maxResults)] is invoking ...",
				this.entityClass);
		try {
			return (List<T>) this.getHibernateTemplate().findByCriteria(
					criteria, firstResult, maxResults);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query and return all results
	 * 
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findAll() throws ApplicationDataAccessException {
		logger.debug("[{}.findAll()] is invoking ...", this.entityClass);
		try {
			return this.findByCriteria(this.createDetachedCriteria());
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query and return all results page by page
	 * 
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResults
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findAllByPagination(int firstResult, int maxResults)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findAllByPagination(int firstResult, int maxResults)] is invoking ...",
				this.entityClass);
		try {
			return this.findByCriteria(this.createDetachedCriteria(),
					firstResult, maxResults);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a "like" query based on a given Hibernate criteria object
	 * 
	 * @param entity
	 *            the object to match
	 * @param propertyName
	 *            the property's name of entity
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findSimilarByCriteria(T entity, String[] propertyName)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findSimilarByCriteria(T entity,String[] propertyName)] is invoking ...",
				this.entityClass);
		try {
			Criteria criteria = this.createCriteria();
			for (String property : propertyName) {
				Object value = PropertyUtils.getProperty(entity, property);
				if (value instanceof String) {
					criteria.add(Restrictions.like(property, (String) value,
							MatchMode.ANYWHERE));
					criteria.addOrder(Order.asc(property));
				} else {
					criteria.add(Restrictions.eq(property, value));
					criteria.addOrder(Order.asc(property));
				}
			}
			return (List<T>) criteria.list();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		} catch (Exception e) {
			logger.error(
					"PropertyUtils.getProperty(entity, property) exception: {}",
					e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Execute a "like" query based on the given Hibernate criteria object.
	 * Return results page by page
	 * 
	 * @param entity
	 *            the object to match
	 * @param propertyName
	 *            the property's name of entity
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResult
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findSimilarByCriteria(T entity, String[] propertyName,
			int firstResult, int maxResult) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findSimilarByCriteria(T entity,String[] propertyName, int firstResult, int maxResult)] is invoking ...",
				this.entityClass);
		try {
			Criteria criteria = this.createCriteria();
			for (String property : propertyName) {
				Object value = PropertyUtils.getProperty(entity, property);
				if (value instanceof String) {
					criteria.add(Restrictions.like(property, (String) value,
							MatchMode.ANYWHERE));
					criteria.addOrder(Order.asc(property));
				} else {
					criteria.add(Restrictions.eq(property, value));
					criteria.addOrder(Order.asc(property));
				}
				criteria.setFirstResult(firstResult).setMaxResults(maxResult);
				return (List<T>) criteria.list();
			}
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		} catch (Exception e) {
			logger.error(
					"PropertyUtils.getProperty(entity, property) exception: {}",
					e);
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * Execute a query based on the given example entity object
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param exampleEntity
	 *            an instance of the desired entity, serving as example for
	 *            "query-by-example"
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByExample(String entityName, T exampleEntity)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByExample(String entityName, T exampleEntity)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByExample(entityName,
					exampleEntity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query based on the given example entity object. Return results
	 * page by page
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param exampleEntity
	 *            an instance of the desired entity, serving as example for
	 *            "query-by-example"
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResults
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByExample(String entityName, T exampleEntity,
			int firstResult, int maxResults) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByExample(String entityName, T exampleEntity,int firstResult, int maxResults)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByExample(entityName,
					exampleEntity, firstResult, maxResults);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query based on the given example entity object
	 * 
	 * @param exampleEntity
	 *            an instance of the desired entity, serving as example for
	 *            "query-by-example"
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByExample(T exampleEntity) throws ApplicationDataAccessException {
		logger.debug("[{}.findByExample(T exampleEntity) is invoking ...]",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByExample(exampleEntity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query based on a given example entity object.Return results
	 * page by page
	 * 
	 * @param exampleEntity
	 *            an instance of the desired entity, serving as example for
	 *            "query-by-example"
	 * @param firstResult
	 *            the index of the first result object to be retrieved (numbered
	 *            from 0)
	 * @param maxResults
	 *            the maximum number of result objects to retrieve (or <=0 for
	 *            no limit)
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByExample(T exampleEntity, int firstResult,
			int maxResults) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByExample(T exampleEntity, int firstResult,int maxResults)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByExample(exampleEntity,
					firstResult, maxResults);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the number of persistent instances which statisfy condition
	 * 
	 * @return 0 or positive integer
	 * @throws ApplicationDataAccessException
	 */
	public int getRowCount() throws ApplicationDataAccessException {
		logger.debug("[{}.getRowCount()] is invoking ...", this.entityClass);
		try {
			Criteria criteria = this.createCriteria();
			return (int) criteria.setProjection(Projections.rowCount())
					.uniqueResult();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the total number
	 * 
	 * @return 0 or positive integer
	 * @throws ApplicationDataAccessException
	 */
	public int getTotalCount() throws ApplicationDataAccessException {
		logger.debug("[{}.getTotalCount()] is invoking ...", this.entityClass);
		try {
			ScrollableResults sr = this.createCriteria().scroll();
			sr.last();
			return sr.getRowNumber() + 1;
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the maximum value of a property
	 * 
	 * @return maximum value
	 * @throws ApplicationDataAccessException
	 */
	public Object getMaxValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.getMaxValue(DetachedCriteria criteria,String propertyName)] is invoking ...",
				this.entityClass);
		try {
			return criteria.setProjection(Projections.max(propertyName));
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the minimum value of a property
	 * 
	 * @return minimum value
	 * @throws ApplicationDataAccessException
	 */
	public Object getMinValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.getMinValue(DetachedCriteria criteria,String propertyName)] is invoking ...",
				this.entityClass);
		try {
			return criteria.setProjection(Projections.min(propertyName));
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the average value of a property
	 * 
	 * @return average value
	 * @throws ApplicationDataAccessException
	 */
	public Object getAvgValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.getAvgValue(DetachedCriteria criteria, String propertyName)] is invoking ...",
				this.entityClass);
		try {
			return criteria.setProjection(Projections.avg(propertyName));
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the sum value of a property
	 * 
	 * @return sum value
	 * @throws ApplicationDataAccessException
	 */
	public Object getSumValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.getSumValue(DetachedCriteria criteria, String propertyName)] is invoking ...",
				this.entityClass);
		try {
			return criteria.setProjection(Projections.sum(propertyName));
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	// -----------------------------HQL Query----------------------------------
	/**
	 * Execute an HQL query, binding a number of values to "?" parameters in the
	 * query string
	 * 
	 * @param queryString
	 *            a query expressed in Hibernate's query language
	 * @param values
	 *            the values of the parameters
	 * @return entity list a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> find(String queryString, Object... values)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.find(String queryString, Object... values)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().find(queryString, values);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute an HQL query, binding a number of values to ":" named parameters
	 * in the query string
	 * 
	 * @param queryString
	 *            a query expressed in Hibernate's query language
	 * @param paramNames
	 *            the names of the parameters
	 * @param values
	 *            the values of the parameters
	 * @return entity list a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByNamedParam(String queryString, String[] paramNames,
			Object[] values) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByNamedParam(String queryString, String[] paramNames,Object[] values)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByNamedParam(queryString,
					paramNames, values);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * @param queryString
	 *            a query expressed in Hibernate's query language
	 * @param paramName
	 *            the name of the parameter
	 * @param value
	 *            the value of the parameter
	 * @return a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByNamedParam(String queryString, String paramName,
			Object value) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByNamedParam(String queryString, String paramName,Object value)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByNamedParam(queryString,
					paramName, value);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a named query binding a number of values to "?" parameters in the
	 * query string
	 * 
	 * @param queryName
	 *            the name of a Hibernate query in a mapping file
	 * @param values
	 *            the values of the parameters
	 * @return a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByNamedQuery(String queryName, Object... values)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByNamedQuery(String queryName, Object... values)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByNamedQuery(queryName,
					values);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a named query, binding a number of values to ":" named parameters
	 * in the query string
	 * 
	 * @param queryName
	 *            the name of a Hibernate query in a mapping file
	 * @param paramNames
	 *            the names of the parameters
	 * @param values
	 *            the values of the parameters
	 * @return a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByNamedQueryAndNamedParam(String queryName,
			String[] paramNames, Object[] values) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByNamedQueryAndNamedParam(String queryName,String[] paramNames, Object[] values)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByNamedQueryAndNamedParam(
					queryName, paramNames, values);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a named query, binding one value to a ":" named parameter in the
	 * query string
	 * 
	 * @param queryName
	 *            the name of a Hibernate query in a mapping file
	 * @param paramName
	 *            the name of parameter
	 * @param value
	 *            the value of the parameter
	 * @return a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByNamedQueryAndNamedParam(String queryName,
			String paramName, Object value) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByNamedQueryAndNamedParam(String queryName,String paramName, Object value)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByNamedQuery(queryName,
					paramName, value);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute an HQL query, binding the properties of the given bean to named
	 * parameters in the query string
	 * 
	 * @param queryString
	 *            a query expressed in Hibernate's query language
	 * @param valueBean
	 *            the values of the parameters
	 * @return a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByValueBean(String queryString, Object valueBean)
			throws ApplicationDataAccessException {
		logger.debug("[{}.findByValueBean(String queryString, Object valueBean)] is invoking ...");
		try {
			return this.getHibernateTemplate().findByValueBean(queryString,
					valueBean);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a named query, binding the properties of the given bean to ":"
	 * named parameters in the query string
	 * 
	 * @param queryName
	 *            the name of a Hibernate query in a mapping file
	 * @param valueBean
	 *            the values of the parameters
	 * @return a List containing the results of the query execution
	 * @throws ApplicationDataAccessException
	 */
	public List<?> findByNamedQueryAndValueBean(String queryName,
			Object valueBean) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.findByNamedQueryAndValueBean(String queryName,Object valueBean)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().findByNamedQueryAndValueBean(
					queryName, valueBean);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Update/delete all objects according to the given query, binding a number
	 * of values to "?" parameters in the query string
	 * 
	 * @param queryString
	 *            an update/delete query expressed in Hibernate's query language
	 * @param values
	 *            the values of the parameters
	 * @return the number of instances updated/deleted
	 * @throws ApplicationDataAccessException
	 */
	public int bulkUpdate(String queryString, Object... values)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.bulkUpdate(String queryString, Object... values)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().bulkUpdate(queryString, values);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Execute a query for persistent instances, binding a number of values to
	 * "?" parameters in the query string
	 * 
	 * @param queryString
	 *            a query expressed in Hibernate's query language
	 * @param values
	 *            the values of the parameters
	 * @return an Iterator containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public Iterator<?> iterate(String queryString, Object... values)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.Iterator<?> iterate(String queryString, Object... values)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().iterate(queryString, values);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Immediately close an Iterator created by any of the various iterate(..)
	 * operations, instead of waiting until the session is closed or
	 * disconnected
	 * 
	 * @param it
	 *            the Iterator to close
	 * @throws ApplicationDataAccessException
	 */
	public void closeIterator(Iterator<?> it) throws ApplicationDataAccessException {
		logger.debug("[{}.closeIterator(Iterator<?> it)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().closeIterator(it);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	// ----------------------------Other Method-------------------------------
	/**
	 * Check whether the given object is in the Session cache
	 * 
	 * @param entity
	 *            the persistence instance to check
	 * @return whether the given object is in the Session cache
	 * @throws ApplicationDataAccessException
	 */
	public boolean contains(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.contains(Object entity)] is invoking ...",
				this.entityClass);
		try {
			return this.getHibernateTemplate().contains(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Remove the given object from the Session cache
	 * 
	 * @param entity
	 *            the persistent instance to evict
	 * @throws ApplicationDataAccessException
	 */
	public void evict(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.evict(Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().evict(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Persist the state of the given detached instance according to the given
	 * replication mode, reusing the current identifier value
	 * 
	 * @param entity
	 *            the persistent object to replicate
	 * @param replicationMode
	 *            the Hibernate ReplicationMode
	 * @throws ApplicationDataAccessException
	 */
	public void replicate(Object entity, ReplicationMode replicationMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.replicate(Object entity, ReplicationMode replicationMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().replicate(entity, replicationMode);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Persist the state of the given detached instance according to the given
	 * replication mode, reusing the current identifier value
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent object to replicate
	 * @param replicationMode
	 *            the Hibernate ReplicationMode
	 * @throws ApplicationDataAccessException
	 */
	public void replicate(String entityName, Object entity,
			ReplicationMode replicationMode) throws ApplicationDataAccessException {
		logger.debug(
				"[{}.replicate(String entityName, Object entity,ReplicationMode replicationMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().replicate(entityName, entity,
					replicationMode);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}
	}

	/**
	 * @return Return the fetch size specified for this HibernateTemplate
	 */
	public int getFetchSize() {
		logger.debug("[{}.getFetchSize()] is invoking ...", this.entityClass);
		return this.getHibernateTemplate().getFetchSize();
	}

	/**
	 * Set the fetch size for this HibernateTemplate. This is important for
	 * processing large result sets: Setting this higher than the default value
	 * will increase processing speed at the cost of memory consumption; setting
	 * this lower can avoid transferring row data that will never be read by the
	 * application. Default is 0, indicating to use the JDBC driver's default
	 * 
	 * @param fetchSize
	 */
	public void setFetchSize(int fetchSize) {
		logger.debug("[{}.setFetchSize(int fetchSize)] is invoking ...",
				this.entityClass);
		this.getHibernateTemplate().setFetchSize(fetchSize);
	}

	/**
	 * @return Return the maximum number of rows specified for this
	 *         HibernateTemplate
	 */
	public int getMaxResults() {
		logger.debug("[{}.getMaxResults()] is invoking ...", this.entityClass);
		return this.getHibernateTemplate().getMaxResults();
	}

	/**
	 * Set the maximum number of rows for this HibernateTemplate. This is
	 * important for processing subsets of large result sets, avoiding to read
	 * and hold the entire result set in the database or in the JDBC driver if
	 * we're never interested in the entire result in the first place (for
	 * example, when performing searches that might return a large number of
	 * matches). Default is 0, indicating to use the JDBC driver's default
	 * 
	 * @param maxResults
	 */
	public void setMaxResults(int maxResults) {
		logger.debug("[{}.setMaxResults(int maxResults)] is invoking ...",
				this.entityClass);
		this.getHibernateTemplate().setMaxResults(maxResults);
	}

	/**
	 * Obtain the specified lock level upon the given object, implicitly
	 * checking whether the corresponding database entry still exists
	 * 
	 * @param entity
	 *            the persistent instance to lock
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void lock(Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.lock(Object entity, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().lock(entity, lockMode);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the specified lock level upon the given object, implicitly
	 * checking whether the corresponding database entry still exists
	 * 
	 * @param entityName
	 *            the name of the persistent entity
	 * @param entity
	 *            the persistent instance to lock
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void lock(String entityName, Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.lock(String entityName, Object entity, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().lock(entityName, entity, lockMode);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Flush all pending saves, updates and deletes to the database
	 * 
	 * @throws ApplicationDataAccessException
	 */
	public void flush() throws ApplicationDataAccessException {
		logger.debug("[{}.flush()] is invoking ...", this.entityClass);
		try {
			this.getHibernateTemplate().flush();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Remove all objects from the Session cache, and cancel all pending saves,
	 * updates and deletes
	 * 
	 * @throws ApplicationDataAccessException
	 */
	public void clear() throws ApplicationDataAccessException {
		logger.debug("[{}.clear()] is invoking ...", this.entityClass);
		try {
			this.getHibernateTemplate().clear();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Re-read the state of the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to re-read
	 * @throws ApplicationDataAccessException
	 */
	public void refresh(Object entity) throws ApplicationDataAccessException {
		logger.debug("[{}.refresh(Object entity)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().refresh(entity);
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

	/**
	 * Re-read the state of the given persistent instance. Obtains the specified
	 * lock mode for the instance
	 * 
	 * @param entity
	 *            the persistent instance to re-read
	 * @param lockMode
	 *            the lock mode to obtain
	 * @throws ApplicationDataAccessException
	 */
	public void refresh(Object entity, LockMode lockMode)
			throws ApplicationDataAccessException {
		logger.debug(
				"[{}.refresh(Object entity, LockMode lockMode)] is invoking ...",
				this.entityClass);
		try {
			this.getHibernateTemplate().refresh(entity, lockMode);
			this.flush();
		} catch (DataAccessException ex) {
			logger.error("data access exception: {}", ex);
			throw new ApplicationDataAccessException(ex.getMessage(), ex);
		}

	}

}
