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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Tagcloud. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see TagcloudLocalService
 * @see de.uhh.l2g.plugins.service.base.TagcloudLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl
 * @generated
 */
@ProviderType
public class TagcloudLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.TagcloudLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the tagcloud to the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was added
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud addTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud) {
		return getService().addTagcloud(tagcloud);
	}

	/**
	* Creates a new tagcloud with the primary key. Does not add the tagcloud to the database.
	*
	* @param tagcloudId the primary key for the new tagcloud
	* @return the new tagcloud
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud createTagcloud(
		long tagcloudId) {
		return getService().createTagcloud(tagcloudId);
	}

	/**
	* Deletes the tagcloud from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was removed
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud deleteTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud) {
		return getService().deleteTagcloud(tagcloud);
	}

	/**
	* Deletes the tagcloud with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud that was removed
	* @throws PortalException if a tagcloud with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud deleteTagcloud(
		long tagcloudId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteTagcloud(tagcloudId);
	}

	public static de.uhh.l2g.plugins.model.Tagcloud fetchTagcloud(
		long tagcloudId) {
		return getService().fetchTagcloud(tagcloudId);
	}

	public static de.uhh.l2g.plugins.model.Tagcloud getByObjectIdAndObjectClassType(
		long objectId, java.lang.String objectClassType)
		throws com.liferay.portal.kernel.exception.SystemException,
			de.uhh.l2g.plugins.exception.NoSuchTagcloudException {
		return getService()
				   .getByObjectIdAndObjectClassType(objectId, objectClassType);
	}

	/**
	* Returns the tagcloud with the primary key.
	*
	* @param tagcloudId the primary key of the tagcloud
	* @return the tagcloud
	* @throws PortalException if a tagcloud with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud getTagcloud(long tagcloudId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getTagcloud(tagcloudId);
	}

	/**
	* Updates the tagcloud in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param tagcloud the tagcloud
	* @return the tagcloud that was updated
	*/
	public static de.uhh.l2g.plugins.model.Tagcloud updateTagcloud(
		de.uhh.l2g.plugins.model.Tagcloud tagcloud) {
		return getService().updateTagcloud(tagcloud);
	}

	/**
	* Returns the number of tagclouds.
	*
	* @return the number of tagclouds
	*/
	public static int getTagcloudsCount() {
		return getService().getTagcloudsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the tagclouds.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tagclouds
	* @param end the upper bound of the range of tagclouds (not inclusive)
	* @return the range of tagclouds
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Tagcloud> getTagclouds(
		int start, int end) {
		return getService().getTagclouds(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static void add(
		java.util.ArrayList<java.lang.String> tagCloudArrayString,
		java.lang.String className, java.lang.Long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().add(tagCloudArrayString, className, objectId);
	}

	public static void deleteByObjectId(long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().deleteByObjectId(objectId);
	}

	public static void generateForAllLectureseries() {
		getService().generateForAllLectureseries();
	}

	public static void generateForAllVideos() {
		getService().generateForAllVideos();
	}

	public static void generateForLectureseries(java.lang.Long lectureseriesId) {
		getService().generateForLectureseries(lectureseriesId);
	}

	public static void generateForVideo(java.lang.Long videoId) {
		getService().generateForVideo(videoId);
	}

	public static void updateByObjectIdAndObjectClassType(
		java.util.ArrayList<java.lang.String> tagCloudArrayString,
		java.lang.String className, long objectId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.updateByObjectIdAndObjectClassType(tagCloudArrayString, className,
			objectId);
	}

	public static TagcloudLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TagcloudLocalService, TagcloudLocalService> _serviceTracker =
		ServiceTrackerFactory.open(TagcloudLocalService.class);
}