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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchSysException;
import de.uhh.l2g.plugins.model.Sys;
import de.uhh.l2g.plugins.model.impl.SysImpl;
import de.uhh.l2g.plugins.model.impl.SysModelImpl;
import de.uhh.l2g.plugins.service.persistence.SysPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the sys service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see SysPersistence
 * @see de.uhh.l2g.plugins.service.persistence.SysUtil
 * @generated
 */
@ProviderType
public class SysPersistenceImpl extends BasePersistenceImpl<Sys>
	implements SysPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SysUtil} to access the sys persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SysImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysModelImpl.FINDER_CACHE_ENABLED, SysImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysModelImpl.FINDER_CACHE_ENABLED, SysImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public SysPersistenceImpl() {
		setModelClass(Sys.class);
	}

	/**
	 * Caches the sys in the entity cache if it is enabled.
	 *
	 * @param sys the sys
	 */
	@Override
	public void cacheResult(Sys sys) {
		entityCache.putResult(SysModelImpl.ENTITY_CACHE_ENABLED, SysImpl.class,
			sys.getPrimaryKey(), sys);

		sys.resetOriginalValues();
	}

	/**
	 * Caches the syses in the entity cache if it is enabled.
	 *
	 * @param syses the syses
	 */
	@Override
	public void cacheResult(List<Sys> syses) {
		for (Sys sys : syses) {
			if (entityCache.getResult(SysModelImpl.ENTITY_CACHE_ENABLED,
						SysImpl.class, sys.getPrimaryKey()) == null) {
				cacheResult(sys);
			}
			else {
				sys.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all syses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SysImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the sys.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Sys sys) {
		entityCache.removeResult(SysModelImpl.ENTITY_CACHE_ENABLED,
			SysImpl.class, sys.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Sys> syses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Sys sys : syses) {
			entityCache.removeResult(SysModelImpl.ENTITY_CACHE_ENABLED,
				SysImpl.class, sys.getPrimaryKey());
		}
	}

	/**
	 * Creates a new sys with the primary key. Does not add the sys to the database.
	 *
	 * @param sysId the primary key for the new sys
	 * @return the new sys
	 */
	@Override
	public Sys create(int sysId) {
		Sys sys = new SysImpl();

		sys.setNew(true);
		sys.setPrimaryKey(sysId);

		return sys;
	}

	/**
	 * Removes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys that was removed
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	@Override
	public Sys remove(int sysId) throws NoSuchSysException {
		return remove((Serializable)sysId);
	}

	/**
	 * Removes the sys with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the sys
	 * @return the sys that was removed
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	@Override
	public Sys remove(Serializable primaryKey) throws NoSuchSysException {
		Session session = null;

		try {
			session = openSession();

			Sys sys = (Sys)session.get(SysImpl.class, primaryKey);

			if (sys == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(sys);
		}
		catch (NoSuchSysException nsee) {
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
	protected Sys removeImpl(Sys sys) {
		sys = toUnwrappedModel(sys);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sys)) {
				sys = (Sys)session.get(SysImpl.class, sys.getPrimaryKeyObj());
			}

			if (sys != null) {
				session.delete(sys);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (sys != null) {
			clearCache(sys);
		}

		return sys;
	}

	@Override
	public Sys updateImpl(Sys sys) {
		sys = toUnwrappedModel(sys);

		boolean isNew = sys.isNew();

		Session session = null;

		try {
			session = openSession();

			if (sys.isNew()) {
				session.save(sys);

				sys.setNew(false);
			}
			else {
				sys = (Sys)session.merge(sys);
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

		entityCache.putResult(SysModelImpl.ENTITY_CACHE_ENABLED, SysImpl.class,
			sys.getPrimaryKey(), sys, false);

		sys.resetOriginalValues();

		return sys;
	}

	protected Sys toUnwrappedModel(Sys sys) {
		if (sys instanceof SysImpl) {
			return sys;
		}

		SysImpl sysImpl = new SysImpl();

		sysImpl.setNew(sys.isNew());
		sysImpl.setPrimaryKey(sys.getPrimaryKey());

		sysImpl.setSysId(sys.getSysId());
		sysImpl.setVersion(sys.getVersion());
		sysImpl.setSetupWizard(sys.getSetupWizard());

		return sysImpl;
	}

	/**
	 * Returns the sys with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the sys
	 * @return the sys
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	@Override
	public Sys findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSysException {
		Sys sys = fetchByPrimaryKey(primaryKey);

		if (sys == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSysException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return sys;
	}

	/**
	 * Returns the sys with the primary key or throws a {@link NoSuchSysException} if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys
	 * @throws NoSuchSysException if a sys with the primary key could not be found
	 */
	@Override
	public Sys findByPrimaryKey(int sysId) throws NoSuchSysException {
		return findByPrimaryKey((Serializable)sysId);
	}

	/**
	 * Returns the sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the sys
	 * @return the sys, or <code>null</code> if a sys with the primary key could not be found
	 */
	@Override
	public Sys fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SysModelImpl.ENTITY_CACHE_ENABLED,
				SysImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Sys sys = (Sys)serializable;

		if (sys == null) {
			Session session = null;

			try {
				session = openSession();

				sys = (Sys)session.get(SysImpl.class, primaryKey);

				if (sys != null) {
					cacheResult(sys);
				}
				else {
					entityCache.putResult(SysModelImpl.ENTITY_CACHE_ENABLED,
						SysImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SysModelImpl.ENTITY_CACHE_ENABLED,
					SysImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return sys;
	}

	/**
	 * Returns the sys with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the sys
	 * @return the sys, or <code>null</code> if a sys with the primary key could not be found
	 */
	@Override
	public Sys fetchByPrimaryKey(int sysId) {
		return fetchByPrimaryKey((Serializable)sysId);
	}

	@Override
	public Map<Serializable, Sys> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Sys> map = new HashMap<Serializable, Sys>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Sys sys = fetchByPrimaryKey(primaryKey);

			if (sys != null) {
				map.put(primaryKey, sys);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SysModelImpl.ENTITY_CACHE_ENABLED,
					SysImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Sys)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SYS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((int)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Sys sys : (List<Sys>)q.list()) {
				map.put(sys.getPrimaryKeyObj(), sys);

				cacheResult(sys);

				uncachedPrimaryKeys.remove(sys.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SysModelImpl.ENTITY_CACHE_ENABLED,
					SysImpl.class, primaryKey, nullModel);
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
	 * Returns all the syses.
	 *
	 * @return the syses
	 */
	@Override
	public List<Sys> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @return the range of syses
	 */
	@Override
	public List<Sys> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of syses
	 */
	@Override
	public List<Sys> findAll(int start, int end,
		OrderByComparator<Sys> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the syses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SysModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of syses
	 * @param end the upper bound of the range of syses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of syses
	 */
	@Override
	public List<Sys> findAll(int start, int end,
		OrderByComparator<Sys> orderByComparator, boolean retrieveFromCache) {
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

		List<Sys> list = null;

		if (retrieveFromCache) {
			list = (List<Sys>)finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SYS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SYS;

				if (pagination) {
					sql = sql.concat(SysModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Sys>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Sys>)QueryUtil.list(q, getDialect(), start, end);
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
	 * Removes all the syses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Sys sys : findAll()) {
			remove(sys);
		}
	}

	/**
	 * Returns the number of syses.
	 *
	 * @return the number of syses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SYS);

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
	protected Map<String, Integer> getTableColumnsMap() {
		return SysModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the sys persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SysImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SYS = "SELECT sys FROM Sys sys";
	private static final String _SQL_SELECT_SYS_WHERE_PKS_IN = "SELECT sys FROM Sys sys WHERE sysId IN (";
	private static final String _SQL_COUNT_SYS = "SELECT COUNT(sys) FROM Sys sys";
	private static final String _ORDER_BY_ENTITY_ALIAS = "sys.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Sys exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(SysPersistenceImpl.class);
}