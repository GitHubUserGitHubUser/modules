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

package de.uhh.l2g.plugins.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Statistic;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for Statistic. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see StatisticLocalServiceUtil
 * @see de.uhh.l2g.plugins.service.base.StatisticLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface StatisticLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StatisticLocalServiceUtil} to access the statistic local service. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.StatisticLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Add Database View with same Name
	*/
	public boolean addVideoStatisticView();

	/**
	* Drop table via custom query
	* https://web.liferay.com/de/community/wiki/-/wiki/Main/Working+with+Database+Views+in+Liferay
	*/
	public boolean removeVideoStatisticDefaultTable();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getAllStatistics() throws SystemException;

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Statistic add(int privateVideos, int publicVideos)
		throws PortalException, SystemException;

	public Statistic addDefaultEntry(ServiceContext serviceContext)
		throws PortalException, SystemException;

	public Statistic addEntry(int privateVideos, int publicVideos,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Adds the statistic to the database. Also notifies the appropriate model listeners.
	*
	* @param statistic the statistic
	* @return the statistic that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Statistic addStatistic(Statistic statistic);

	/**
	* Creates a new statistic with the primary key. Does not add the statistic to the database.
	*
	* @param statisticId the primary key for the new statistic
	* @return the new statistic
	*/
	public Statistic createStatistic(long statisticId);

	public Statistic deleteLinkById(long statisticId,
		ServiceContext serviceContext) throws PortalException, SystemException;

	/**
	* Deletes the statistic from the database. Also notifies the appropriate model listeners.
	*
	* @param statistic the statistic
	* @return the statistic that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Statistic deleteStatistic(Statistic statistic);

	/**
	* Deletes the statistic with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic that was removed
	* @throws PortalException if a statistic with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Statistic deleteStatistic(long statisticId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Statistic fetchStatistic(long statisticId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Statistic getByStatisticId(long companyId, long groupId,
		long statisticId) throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Statistic getByStatisticId(long statisticId)
		throws PortalException, SystemException;

	/**
	* Returns the statistic with the primary key.
	*
	* @param statisticId the primary key of the statistic
	* @return the statistic
	* @throws PortalException if a statistic with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Statistic getStatistic(long statisticId) throws PortalException;

	public Statistic updateEntry(long statisticId, int privateVideos,
		int publicVideos, ServiceContext serviceContext)
		throws PortalException, SystemException;

	/**
	* Updates the statistic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param statistic the statistic
	* @return the statistic that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Statistic updateStatistic(Statistic statistic);

	/**
	* Returns the number of statistics.
	*
	* @return the number of statistics
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStatisticsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Statistic> getByCompanyIdandGroupId(long companyId, long groupId)
		throws PortalException, SystemException;

	/**
	* Returns a range of all the statistics.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.StatisticModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of statistics
	* @param end the upper bound of the range of statistics (not inclusive)
	* @return the range of statistics
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Statistic> getStatistics(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}