package cn.minxing.evillage.core.base.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import cn.minxing.evillage.common.exception.service.ApplicationServiceException;

/**
 * GenericService Interface
 * <p>
 * All service interface need to extend this generic service interface
 * </p>
 * 
 * @author 李彬峰
 * 
 * @param T
 * @param ID
 */
public interface IGenericService<T, ID extends Serializable> {

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
	public ID save(T entity) throws ApplicationServiceException;

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
	public T merge(T entity) throws ApplicationServiceException;

	/**
	 * Remove this instance from the session cache. Changes to the instance will
	 * not be synchronized with the database.
	 * 
	 * @param entity
	 *            The entity to evict
	 * @throws ApplicationServiceException
	 */
	public void evict(T entity) throws ApplicationServiceException;

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
	public T get(ID id) throws ApplicationServiceException;

	/**
	 * Return a List which contains all persistent instances of the given entity
	 * class,or null if there is no such persistent instance
	 * 
	 * @return List<T> persistent instances or null
	 * @throws ApplicationServiceException
	 */
	public List<T> findAll() throws ApplicationServiceException;

	/**
	 * Return a List which contains all persistent instances of the given entity
	 * class page by page,or null if there is no such persistent instance
	 * 
	 * @param start
	 *            the index of the first result instance to be retrieved
	 * @param limit
	 *            the maximum number of result instance to retrieve
	 * 
	 * @return List<T> persistent instances or null
	 * @throws ApplicationServiceException
	 */
	public List<T> findAllByPagination(int firstResult, int maxResults)
			throws ApplicationServiceException;

	/**
	 * Update the persistent instance with the identifier of the given detached
	 * instance. If there is a persistent instance with the same identifier, an
	 * exception is thrown
	 * 
	 * @param entity
	 *            a detached instance containing updated state
	 * @throws ApplicationServiceException
	 */
	public void update(T entity) throws ApplicationServiceException;

	/**
	 * Remove a persistent instance from the datastore. The argument may be an
	 * instance associated with the receiving Session or a transient instance
	 * with an identifier associated with existing persistent state
	 * 
	 * @param entity
	 *            the instance to be removed
	 * @throws ApplicationServiceException
	 */
	public void delete(T entity) throws ApplicationServiceException;

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
			throws ApplicationServiceException;

	/**
	 * Obtain the number of all persistent instances of the given entity class
	 * 
	 * @return positive integer or 0
	 * @throws ApplicationServiceException
	 */
	public int getTotalCount() throws ApplicationServiceException;

}
