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

import de.uhh.l2g.plugins.exception.NoSuchInstitutionException;
import de.uhh.l2g.plugins.model.Institution;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Provides the local service interface for Institution. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Iavor Sturm
 * @see InstitutionLocalServiceUtil
 * @see de.uhh.l2g.plugins.service.base.InstitutionLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.InstitutionLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface InstitutionLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link InstitutionLocalServiceUtil} to access the institution local service. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.InstitutionLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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

	/**
	* Adds the institution to the database. Also notifies the appropriate model listeners.
	*
	* @param institution the institution
	* @return the institution that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Institution addInstitution(Institution institution);

	/**
	* Creates a new institution with the primary key. Does not add the institution to the database.
	*
	* @param institutionId the primary key for the new institution
	* @return the new institution
	*/
	public Institution createInstitution(long institutionId);

	/**
	* Deletes the institution from the database. Also notifies the appropriate model listeners.
	*
	* @param institution the institution
	* @return the institution that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Institution deleteInstitution(Institution institution);

	/**
	* Deletes the institution with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param institutionId the primary key of the institution
	* @return the institution that was removed
	* @throws PortalException if a institution with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Institution deleteInstitution(long institutionId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution fetchInstitution(long institutionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution getByGroupIdAndId(long groupId, long institutionId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution getById(long institutionId) throws SystemException;

	/**
	* Returns the institution with the primary key.
	*
	* @param institutionId the primary key of the institution
	* @return the institution
	* @throws PortalException if a institution with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution getInstitution(long institutionId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution getRoot(long companyId, long groupId)
		throws SystemException, NoSuchInstitutionException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution getRootByGroupId(long companyId, long groupId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Institution getRootByParentAndCompanyAndGroup(long parentId,
		long companyId, long groupId)
		throws SystemException, NoSuchInstitutionException;

	/**
	* Updates the institution in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param institution the institution
	* @return the institution that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Institution updateInstitution(Institution institution);

	public Institution updateInstitution(long institutionId,
		java.lang.String name, int sort, ServiceContext serviceContext)
		throws PortalException, SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getByGroupIdAndParentCount(long groupId, long parentId)
		throws SystemException;

	/**
	* Returns the number of institutions.
	*
	* @return the number of institutions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getInstitutionsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLockingElements(long institutionId) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMaxSortByParentId(long parentId) throws SystemException;

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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public List<Institution> getByGroupId(long groupId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByGroupIdAndParent(long groupId, long parentId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByGroupIdAndParent(long groupId, long parentId,
		int start, int end) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByLectureseriesId(long lectureseriesId,
		int begin, int end) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByLevel(int level) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByParentId(long parentId)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getByParentId(long parentId, java.lang.String type)
		throws SystemException;

	/**
	* Returns a range of all the institutions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of institutions
	* @param end the upper bound of the range of institutions (not inclusive)
	* @return the range of institutions
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getInstitutions(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getInstitutionsFromLectureseriesIdsAndVideoIds(
		ArrayList<java.lang.Long> lectureseriesIds,
		ArrayList<java.lang.Long> videoIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getInstitutionsFromLectureseriesIdsAndVideoIds(
		ArrayList<java.lang.Long> lectureseriesIds,
		ArrayList<java.lang.Long> videoIds, java.lang.Long parentId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Institution> getRootInstitutionsByOpenAccessVideos()
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<java.lang.String, java.lang.String> getAllSortedAsTree(
		int begin, int end) throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<java.lang.String, java.lang.String> getByParent(long parentId)
		throws SystemException;

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