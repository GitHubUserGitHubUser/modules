/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package de.uhh.l2g.plugins.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchMetadataException;
import de.uhh.l2g.plugins.model.Metadata;
import de.uhh.l2g.plugins.model.impl.MetadataImpl;
import de.uhh.l2g.plugins.model.impl.MetadataModelImpl;
import de.uhh.l2g.plugins.service.persistence.MetadataPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the metadata service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see MetadataPersistence
 * @see de.uhh.l2g.plugins.service.persistence.MetadataUtil
 * @generated
 */
@ProviderType
public class MetadataPersistenceImpl extends BasePersistenceImpl<Metadata>
	implements MetadataPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MetadataUtil} to access the metadata persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MetadataImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, MetadataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public MetadataPersistenceImpl() {
		setModelClass(Metadata.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("type", "type_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the metadata in the entity cache if it is enabled.
	 *
	 * @param metadata the metadata
	 */
	@Override
	public void cacheResult(Metadata metadata) {
		entityCache.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataImpl.class, metadata.getPrimaryKey(), metadata);

		metadata.resetOriginalValues();
	}

	/**
	 * Caches the metadatas in the entity cache if it is enabled.
	 *
	 * @param metadatas the metadatas
	 */
	@Override
	public void cacheResult(List<Metadata> metadatas) {
		for (Metadata metadata : metadatas) {
			if (entityCache.getResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
						MetadataImpl.class, metadata.getPrimaryKey()) == null) {
				cacheResult(metadata);
			}
			else {
				metadata.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all metadatas.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MetadataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the metadata.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Metadata metadata) {
		entityCache.removeResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataImpl.class, metadata.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Metadata> metadatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Metadata metadata : metadatas) {
			entityCache.removeResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
				MetadataImpl.class, metadata.getPrimaryKey());
		}
	}

	/**
	 * Creates a new metadata with the primary key. Does not add the metadata to the database.
	 *
	 * @param metadataId the primary key for the new metadata
	 * @return the new metadata
	 */
	@Override
	public Metadata create(long metadataId) {
		Metadata metadata = new MetadataImpl();

		metadata.setNew(true);
		metadata.setPrimaryKey(metadataId);

		metadata.setCompanyId(companyProvider.getCompanyId());

		return metadata;
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata remove(long metadataId) throws NoSuchMetadataException {
		return remove((Serializable)metadataId);
	}

	/**
	 * Removes the metadata with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata that was removed
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata remove(Serializable primaryKey)
		throws NoSuchMetadataException {
		Session session = null;

		try {
			session = openSession();

			Metadata metadata = (Metadata)session.get(MetadataImpl.class,
					primaryKey);

			if (metadata == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(metadata);
		}
		catch (NoSuchMetadataException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Metadata removeImpl(Metadata metadata) {
		metadata = toUnwrappedModel(metadata);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(metadata)) {
				metadata = (Metadata)session.get(MetadataImpl.class,
						metadata.getPrimaryKeyObj());
			}

			if (metadata != null) {
				session.delete(metadata);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (metadata != null) {
			clearCache(metadata);
		}

		return metadata;
	}

	@Override
	public Metadata updateImpl(Metadata metadata) {
		metadata = toUnwrappedModel(metadata);

		boolean isNew = metadata.isNew();

		MetadataModelImpl metadataModelImpl = (MetadataModelImpl)metadata;

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (metadata.getCreateDate() == null)) {
			if (serviceContext == null) {
				metadata.setCreateDate(now);
			}
			else {
				metadata.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!metadataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				metadata.setModifiedDate(now);
			}
			else {
				metadata.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (metadata.isNew()) {
				session.save(metadata);

				metadata.setNew(false);
			}
			else {
				metadata = (Metadata)session.merge(metadata);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
			MetadataImpl.class, metadata.getPrimaryKey(), metadata, false);

		metadata.resetOriginalValues();

		return metadata;
	}

	protected Metadata toUnwrappedModel(Metadata metadata) {
		if (metadata instanceof MetadataImpl) {
			return metadata;
		}

		MetadataImpl metadataImpl = new MetadataImpl();

		metadataImpl.setNew(metadata.isNew());
		metadataImpl.setPrimaryKey(metadata.getPrimaryKey());

		metadataImpl.setMetadataId(metadata.getMetadataId());
		metadataImpl.setType(metadata.getType());
		metadataImpl.setLanguage(metadata.getLanguage());
		metadataImpl.setTitle(metadata.getTitle());
		metadataImpl.setSubject(metadata.getSubject());
		metadataImpl.setDescription(metadata.getDescription());
		metadataImpl.setPublisher(metadata.getPublisher());
		metadataImpl.setGroupId(metadata.getGroupId());
		metadataImpl.setCompanyId(metadata.getCompanyId());
		metadataImpl.setUserId(metadata.getUserId());
		metadataImpl.setUserName(metadata.getUserName());
		metadataImpl.setCreateDate(metadata.getCreateDate());
		metadataImpl.setModifiedDate(metadata.getModifiedDate());

		return metadataImpl;
	}

	/**
	 * Returns the metadata with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMetadataException {
		Metadata metadata = fetchByPrimaryKey(primaryKey);

		if (metadata == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMetadataException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return metadata;
	}

	/**
	 * Returns the metadata with the primary key or throws a {@link NoSuchMetadataException} if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata
	 * @throws NoSuchMetadataException if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata findByPrimaryKey(long metadataId)
		throws NoSuchMetadataException {
		return findByPrimaryKey((Serializable)metadataId);
	}

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
				MetadataImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Metadata metadata = (Metadata)serializable;

		if (metadata == null) {
			Session session = null;

			try {
				session = openSession();

				metadata = (Metadata)session.get(MetadataImpl.class, primaryKey);

				if (metadata != null) {
					cacheResult(metadata);
				}
				else {
					entityCache.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
						MetadataImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
					MetadataImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return metadata;
	}

	/**
	 * Returns the metadata with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param metadataId the primary key of the metadata
	 * @return the metadata, or <code>null</code> if a metadata with the primary key could not be found
	 */
	@Override
	public Metadata fetchByPrimaryKey(long metadataId) {
		return fetchByPrimaryKey((Serializable)metadataId);
	}

	@Override
	public Map<Serializable, Metadata> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Metadata> map = new HashMap<Serializable, Metadata>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Metadata metadata = fetchByPrimaryKey(primaryKey);

			if (metadata != null) {
				map.put(primaryKey, metadata);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
					MetadataImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Metadata)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_METADATA_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Metadata metadata : (List<Metadata>)q.list()) {
				map.put(metadata.getPrimaryKeyObj(), metadata);

				cacheResult(metadata);

				uncachedPrimaryKeys.remove(metadata.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MetadataModelImpl.ENTITY_CACHE_ENABLED,
					MetadataImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the metadatas.
	 *
	 * @return the metadatas
	 */
	@Override
	public List<Metadata> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @return the range of metadatas
	 */
	@Override
	public List<Metadata> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of metadatas
	 */
	@Override
	public List<Metadata> findAll(int start, int end,
		OrderByComparator<Metadata> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the metadatas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MetadataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of metadatas
	 * @param end the upper bound of the range of metadatas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of metadatas
	 */
	@Override
	public List<Metadata> findAll(int start, int end,
		OrderByComparator<Metadata> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Metadata> list = null;

		if (retrieveFromCache) {
			list = (List<Metadata>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_METADATA);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_METADATA;

				if (pagination) {
					sql = sql.concat(MetadataModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Metadata>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Metadata>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the metadatas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Metadata metadata : findAll()) {
			remove(metadata);
		}
	}

	/**
	 * Returns the number of metadatas.
	 *
	 * @return the number of metadatas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_METADATA);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MetadataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the metadata persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MetadataImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_METADATA = "SELECT metadata FROM Metadata metadata";
	private static final String _SQL_SELECT_METADATA_WHERE_PKS_IN = "SELECT metadata FROM Metadata metadata WHERE metadataId IN (";
	private static final String _SQL_COUNT_METADATA = "SELECT COUNT(metadata) FROM Metadata metadata";
	private static final String _ORDER_BY_ENTITY_ALIAS = "metadata.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Metadata exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(MetadataPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"type"
			});
}