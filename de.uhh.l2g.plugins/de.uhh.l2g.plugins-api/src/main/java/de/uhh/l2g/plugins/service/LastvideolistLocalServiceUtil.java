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
 * Provides the local service utility for Lastvideolist. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.LastvideolistLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see LastvideolistLocalService
 * @see de.uhh.l2g.plugins.service.base.LastvideolistLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.LastvideolistLocalServiceImpl
 * @generated
 */
@ProviderType
public class LastvideolistLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.LastvideolistLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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
	* Adds the lastvideolist to the database. Also notifies the appropriate model listeners.
	*
	* @param lastvideolist the lastvideolist
	* @return the lastvideolist that was added
	*/
	public static de.uhh.l2g.plugins.model.Lastvideolist addLastvideolist(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {
		return getService().addLastvideolist(lastvideolist);
	}

	/**
	* Creates a new lastvideolist with the primary key. Does not add the lastvideolist to the database.
	*
	* @param lastvideolistId the primary key for the new lastvideolist
	* @return the new lastvideolist
	*/
	public static de.uhh.l2g.plugins.model.Lastvideolist createLastvideolist(
		int lastvideolistId) {
		return getService().createLastvideolist(lastvideolistId);
	}

	/**
	* Deletes the lastvideolist from the database. Also notifies the appropriate model listeners.
	*
	* @param lastvideolist the lastvideolist
	* @return the lastvideolist that was removed
	*/
	public static de.uhh.l2g.plugins.model.Lastvideolist deleteLastvideolist(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {
		return getService().deleteLastvideolist(lastvideolist);
	}

	/**
	* Deletes the lastvideolist with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist that was removed
	* @throws PortalException if a lastvideolist with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Lastvideolist deleteLastvideolist(
		int lastvideolistId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteLastvideolist(lastvideolistId);
	}

	public static de.uhh.l2g.plugins.model.Lastvideolist fetchLastvideolist(
		int lastvideolistId) {
		return getService().fetchLastvideolist(lastvideolistId);
	}

	/**
	* Returns the lastvideolist with the primary key.
	*
	* @param lastvideolistId the primary key of the lastvideolist
	* @return the lastvideolist
	* @throws PortalException if a lastvideolist with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Lastvideolist getLastvideolist(
		int lastvideolistId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getLastvideolist(lastvideolistId);
	}

	/**
	* Updates the lastvideolist in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param lastvideolist the lastvideolist
	* @return the lastvideolist that was updated
	*/
	public static de.uhh.l2g.plugins.model.Lastvideolist updateLastvideolist(
		de.uhh.l2g.plugins.model.Lastvideolist lastvideolist) {
		return getService().updateLastvideolist(lastvideolist);
	}

	/**
	* Returns the number of lastvideolists.
	*
	* @return the number of lastvideolists
	*/
	public static int getLastvideolistsCount() {
		return getService().getLastvideolistsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the lastvideolists.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.LastvideolistModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lastvideolists
	* @param end the upper bound of the range of lastvideolists (not inclusive)
	* @return the range of lastvideolists
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Lastvideolist> getLastvideolists(
		int start, int end) {
		return getService().getLastvideolists(start, end);
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

	public static void deleteByVideoId(java.lang.Long videoId) {
		getService().deleteByVideoId(videoId);
	}

	public static LastvideolistLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LastvideolistLocalService, LastvideolistLocalService> _serviceTracker =
		ServiceTrackerFactory.open(LastvideolistLocalService.class);
}