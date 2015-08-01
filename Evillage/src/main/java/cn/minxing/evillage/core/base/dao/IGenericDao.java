package cn.minxing.evillage.core.base.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.ReplicationMode;
import org.hibernate.criterion.DetachedCriteria;

import cn.minxing.evillage.common.exception.dao.ApplicationDataAccessException;

/**
 * GenericDao Interface
 * <p>
 * All DAO interface need to extend this generic DAO interface
 * </p>
 * 
 * @author 李彬峰
 * 
 * @param <T>
 * @param <ID>
 */
public interface IGenericDao<T, ID extends Serializable> {

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
	public T get(ID id) throws ApplicationDataAccessException;

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
	public T get(ID id, LockMode lockMode) throws ApplicationDataAccessException;

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
	public Object get(String entityName, ID id) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Return the persistent instance of the given entity class with the given
	 * identifier, throwing an exception if not found
	 * 
	 * @param id
	 *            the identifier of the persistent instance
	 * @return the persistent instance
	 * @throws ApplicationDataAccessException
	 */
	public T load(ID id) throws ApplicationDataAccessException;

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
	public T load(ID id, LockMode lockMode) throws ApplicationDataAccessException;

	/**
	 * Load the persistent instance with the given identifier into the given
	 * object, throwing an exception if not found
	 * 
	 * @param entity
	 *            the object (of the target class) to load into
	 * @param id
	 * @throws ApplicationDataAccessException
	 */
	public void load(Object entity, ID id) throws ApplicationDataAccessException;

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
	public Object load(String entityName, ID id) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Return all persistent instances of the given entity class
	 * 
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> loadAll() throws ApplicationDataAccessException;

	/**
	 * Persist the given transient instance
	 * 
	 * @param entity
	 *            the transient instance to persist
	 * @return the generated identifier
	 * @throws ApplicationDataAccessException
	 */
	public ID save(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Save or update the given persistent instance, according to its id
	 * (matching the configured "unsaved-value"?)
	 * 
	 * @param entity
	 *            the persistent instance to save or update (to be associated
	 *            with the Hibernate Session)
	 * @throws ApplicationDataAccessException
	 */
	public void saveOrUpdate(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Update the given persistent instance, associating it with the current
	 * Hibernate Session
	 * 
	 * @param entity
	 *            the persistent instance to update
	 * @throws ApplicationDataAccessException
	 */
	public void update(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Delete the given persistent instance
	 * 
	 * @param entity
	 *            the persistent instance to delete
	 * @throws ApplicationDataAccessException
	 */
	public void delete(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Delete all given persistent instances
	 * 
	 * @param entities
	 *            the persistent instances to delete
	 * @throws ApplicationDataAccessException
	 */
	public void deleteAll(Collection<?> entities) throws ApplicationDataAccessException;

	/**
	 * Persist the given transient instance. Follows JSR-220 semantics.Similar
	 * to save, associating the given object with the current Hibernate Session
	 * 
	 * @param entity
	 *            the persistent instance to persist
	 * @throws ApplicationDataAccessException
	 */
	public void persist(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
	public T merge(T entity) throws ApplicationDataAccessException;

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
	public T merge(String entityName, T entity) throws ApplicationDataAccessException;

	// -----------------------------Criteria Query-----------------------------

	/**
	 * Create a Criteria that is associated with Hibernate's session
	 * 
	 * @return Criteria instance
	 * @throws ApplicationDataAccessException
	 */
	public Criteria createCriteria() throws ApplicationDataAccessException;

	/**
	 * Create a DetachedCriteria that is not associated with Hibernate's session
	 * 
	 * @return DetachedCriteria instance
	 * @throws ApplicationDataAccessException
	 */
	public DetachedCriteria createDetachedCriteria()
			throws ApplicationDataAccessException;

	/**
	 * Execute a query based on a given Hibernate criteria object
	 * 
	 * @param criteria
	 *            the detached Hibernate criteria object
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByCriteria(DetachedCriteria criteria)
			throws ApplicationDataAccessException;

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
			int maxResults) throws ApplicationDataAccessException;

	/**
	 * Execute a query and return all results
	 * 
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findAll() throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Execute a "like" query based on a given Hibernate criteria object
	 * 
	 * @param criteria
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findSimilarByCriteria(T entity, String[] propertyName)
			throws ApplicationDataAccessException;

	/**
	 * Execute a "like" query based on the given Hibernate criteria object.
	 * Return results page by page
	 * 
	 * @param criteria
	 *            the detached Hibernate criteria object
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
			int firstResult, int maxResult) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			int firstResult, int maxResults) throws ApplicationDataAccessException;

	/**
	 * Execute a query based on the given example entity object
	 * 
	 * @param exampleEntity
	 *            an instance of the desired entity, serving as example for
	 *            "query-by-example"
	 * @return a List containing 0 or more persistent instances
	 * @throws ApplicationDataAccessException
	 */
	public List<T> findByExample(T exampleEntity) throws ApplicationDataAccessException;

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
			int maxResults) throws ApplicationDataAccessException;

	/**
	 * Obtain the number of persistent instances which satisfy condition
	 * 
	 * @return 0 or positive integer
	 * @throws ApplicationDataAccessException
	 */
	public int getRowCount() throws ApplicationDataAccessException;

	/**
	 * Obtain the total number
	 * 
	 * @return 0 or positive integer
	 * @throws ApplicationDataAccessException
	 */
	public int getTotalCount() throws ApplicationDataAccessException;

	/**
	 * Obtain the maximum value of a property
	 * 
	 * @return maximum value
	 * @throws ApplicationDataAccessException
	 */
	public Object getMaxValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException;

	/**
	 * Obtain the minimum value of a property
	 * 
	 * @return minimum value
	 * @throws ApplicationDataAccessException
	 */
	public Object getMinValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException;

	/**
	 * Obtain the average value of a property
	 * 
	 * @return average value
	 * @throws ApplicationDataAccessException
	 */
	public Object getAvgValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException;

	/**
	 * Obtain the sum value of a property
	 * 
	 * @return sum value
	 * @throws ApplicationDataAccessException
	 */
	public Object getSumValue(DetachedCriteria criteria, String propertyName)
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			Object[] values) throws ApplicationDataAccessException;

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
			Object value) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			String[] paramNames, Object[] values) throws ApplicationDataAccessException;

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
			String paramName, Object value) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			Object valueBean) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Immediately close an Iterator created by any of the various iterate(..)
	 * operations, instead of waiting until the session is closed or
	 * disconnected
	 * 
	 * @param it
	 *            the Iterator to close
	 * @throws ApplicationDataAccessException
	 */
	public void closeIterator(Iterator<?> it) throws ApplicationDataAccessException;

	// ----------------------------Other Method-------------------------------
	/**
	 * Check whether the given object is in the Session cache
	 * 
	 * @param entity
	 *            the persistence instance to check
	 * @return whether the given object is in the Session cache
	 * @throws ApplicationDataAccessException
	 */
	public boolean contains(Object entity) throws ApplicationDataAccessException;

	/**
	 * Remove the given object from the Session cache
	 * 
	 * @param entity
	 *            the persistent instance to evict
	 * @throws ApplicationDataAccessException
	 */
	public void evict(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

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
			ReplicationMode replicationMode) throws ApplicationDataAccessException;

	/**
	 * @return Return the fetch size specified for this HibernateTemplate
	 */
	public int getFetchSize();

	/**
	 * Set the fetch size for this HibernateTemplate. This is important for
	 * processing large result sets: Setting this higher than the default value
	 * will increase processing speed at the cost of memory consumption; setting
	 * this lower can avoid transferring row data that will never be read by the
	 * application. Default is 0, indicating to use the JDBC driver's default
	 * 
	 * @param fetchSize
	 */
	public void setFetchSize(int fetchSize);

	/**
	 * @return Return the maximum number of rows specified for this
	 *         HibernateTemplate
	 */
	public int getMaxResults();

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
	public void setMaxResults(int maxResults);

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
			throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

	/**
	 * Flush all pending saves, updates and deletes to the database
	 * 
	 * @throws ApplicationDataAccessException
	 * 
	 */
	public void flush() throws ApplicationDataAccessException;

	/**
	 * Remove all objects from the Session cache, and cancel all pending saves,
	 * updates and deletes
	 * 
	 * @throws ApplicationDataAccessException
	 * 
	 */
	public void clear() throws ApplicationDataAccessException;

	/**
	 * Re-read the state of the given persistent instance.
	 * 
	 * @param entity
	 *            the persistent instance to re-read
	 * @throws ApplicationDataAccessException
	 */
	public void refresh(Object entity) throws ApplicationDataAccessException;

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
			throws ApplicationDataAccessException;

}
