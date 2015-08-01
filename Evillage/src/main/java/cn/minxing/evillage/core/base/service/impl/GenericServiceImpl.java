package cn.minxing.evillage.core.base.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.minxing.evillage.common.exception.dao.ApplicationDataAccessException;
import cn.minxing.evillage.common.exception.service.ApplicationServiceException;
import cn.minxing.evillage.common.exception.service.CopyObjectException;
import cn.minxing.evillage.common.exception.service.CountObjectException;
import cn.minxing.evillage.common.exception.service.CreateObjectException;
import cn.minxing.evillage.common.exception.service.DeleteObjectException;
import cn.minxing.evillage.common.exception.service.EvitObjectException;
import cn.minxing.evillage.common.exception.service.RetrieveObjectException;
import cn.minxing.evillage.common.exception.service.NoSuchObjectException;
import cn.minxing.evillage.common.exception.service.UpdateObjectException;
import cn.minxing.evillage.core.base.dao.IGenericDao;
import cn.minxing.evillage.core.base.service.IGenericService;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class GenericServiceImpl<T, ID extends Serializable> implements
		IGenericService<T, ID> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass()
			.getName());

	private Class<T> entityClass;

	public GenericServiceImpl() {
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

	// Abstract method to obtain the generic DAO instance
	public abstract IGenericDao<T, ID> getGenericDao();

	/**
	 * Persist the given transient instance, first assigning a generated
	 * identifier(Or using the current value of the identifier property if the
	 * assigned generator is used)
	 * 
	 * @param entity
	 *            a transient instance of a persistent class
	 * @return the generated identifier
	 * @throws ApplicationServiceException
	 */
	public ID save(T entity) throws ApplicationServiceException {
		logger.debug("[{}.save(T entity)] is invoking ...", this.entityClass);
		try {
			return (ID) this.getGenericDao().save(entity);
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new CreateObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Copy the state of the given object onto the persistent object with the
	 * same identifier. If there is no persistent instance currently associated
	 * with the session, it will be loaded. Return the persistent instance. If
	 * the given instance is unsaved, save a copy of and return it as a newly
	 * persistent instance. The given instance does not become associated with
	 * the session
	 * 
	 * @param entity
	 *            a detached instance with state to be copied
	 * @return an updated persistent instance
	 * @throws ApplicationServiceException
	 */
	public T merge(T entity) throws ApplicationServiceException {
		logger.debug("[{}.merge(T entity)] is invoking ...", this.entityClass);
		try {
			return this.getGenericDao().merge(entity);
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new CopyObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Remove this instance from the session cache. Changes to the instance will
	 * not be synchronized with the database.
	 * 
	 * @param entity
	 *            The entity to evict
	 * @throws ApplicationServiceException
	 */
	public void evict(T entity) throws ApplicationServiceException {
		logger.debug("[{}.evict(T entity)] is invoking ...", this.entityClass);
		try {
			this.getGenericDao().evict(entity);
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new EvitObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, or null if there is no such persistent instance (If the
	 * instance is already associated with the session, return that instance.
	 * This method never returns an uninitialized instance)
	 * 
	 * @param id
	 *            an identifier
	 * @return a persistent instance or null
	 * @throws ApplicationServiceException
	 */
	public T get(ID id) throws ApplicationServiceException {
		logger.debug("[{}.get(ID id)] is invoking ...", this.entityClass);
		try {
			T t = this.getGenericDao().get(id);
			if (t == null) {
				throw new NoSuchObjectException("No instance can be retrieve");
			} else {
				return t;
			}
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new RetrieveObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Return a List which contains all persistent instances of the given entity
	 * class,or null if there is no such persistent instance
	 * 
	 * @return List<T> persistent instances or null
	 * @throws ApplicationServiceException
	 */
	public List<T> findAll() throws ApplicationServiceException {
		logger.debug("[{}.findAll()] is invoking ...", this.entityClass);
		try {
			List<T> list = this.getGenericDao().findAll();
			if (list == null) {
				throw new NoSuchObjectException("No instance can be retrieve");
			} else {
				return list;
			}
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new RetrieveObjectException(ex.getMessage(), ex);
		}
	}

	/**
	 * Return a List which contains all persistent instances of the given entity
	 * class page by page,or null if there is no such persistent instance
	 * 
	 * @param firstResult
	 *            the index of the first result instance to be retrieved
	 * @param maxResults
	 *            the maximum number of result instance to retrieve
	 * 
	 * @return List<T> persistent instances or null
	 * @throws ApplicationServiceException
	 */
	public List<T> findAllByPagination(int firstResult, int maxResults)
			throws ApplicationServiceException {
		logger.debug(
				"[{}.findAllByPagination(int firstResult, int maxResults)] is invoking ...",
				this.entityClass);
		try {
			List<T> list = this.getGenericDao().findAllByPagination(
					firstResult, maxResults);
			if (list == null) {
				throw new NoSuchObjectException("No instance can be retrieve");
			}
			return list;
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new RetrieveObjectException(ex.getMessage(), ex);
		}
	}

	/**
	 * Update the persistent instance with the identifier of the given detached
	 * instance. If there is a persistent instance with the same identifier, an
	 * exception is thrown
	 * 
	 * @param entity
	 *            a detached instance containing updated state
	 * @throws ApplicationServiceException
	 */
	public void update(T entity) throws ApplicationServiceException {
		logger.debug("[{}.update(T entity)] is invoking ...", this.entityClass);
		try {
			this.getGenericDao().update(entity);
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new UpdateObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state
	 * 
	 * @param entity
	 *            the instance to be removed
	 * @throws ApplicationServiceException
	 */
	public void delete(T entity) throws ApplicationServiceException {
		logger.debug("[{}.delete(T entity)] is invoking ...", this.entityClass);
		try {
			this.getGenericDao().delete(entity);
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new DeleteObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Remove a collection of persistent instances from the datastore. The
	 * argument may be instances associated with the receiving Session or
	 * transient instances with identifiers associated with existing persistent
	 * state
	 * 
	 * @param entities
	 *            the instances to be removed
	 * @throws ApplicationServiceException
	 */
	public void deleteAll(Collection<T> entities)
			throws ApplicationServiceException {
		logger.debug("[{}.deleteAll(Collection<T> entities)] is invoking ...",
				this.entityClass);
		try {
			this.getGenericDao().deleteAll(entities);
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new DeleteObjectException(ex.getMessage(), ex);
		}

	}

	/**
	 * Obtain the number of all persistent instances of the given entity class
	 * 
	 * @return positive integer or 0
	 * @throws ApplicationServiceException
	 */
	public int getTotalCount() throws ApplicationServiceException {
		logger.debug("[{}.getTotalCount()] is invoking ...", this.entityClass);
		try {
			return this.getGenericDao().getTotalCount();
		} catch (ApplicationDataAccessException ex) {
			logger.error("service exception: {}", ex);
			throw new CountObjectException(ex.getMessage(), ex);
		}

	}

}
