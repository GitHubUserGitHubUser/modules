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
 * Provides the local service utility for Producer. This utility wraps
 * {@link de.uhh.l2g.plugins.service.impl.ProducerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Iavor Sturm
 * @see ProducerLocalService
 * @see de.uhh.l2g.plugins.service.base.ProducerLocalServiceBaseImpl
 * @see de.uhh.l2g.plugins.service.impl.ProducerLocalServiceImpl
 * @generated
 */
@ProviderType
public class ProducerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link de.uhh.l2g.plugins.service.impl.ProducerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static de.uhh.l2g.plugins.model.Institution getInstitutionByProducer(
		long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getInstitutionByProducer(producerId);
	}

	/**
	* Adds the producer to the database. Also notifies the appropriate model listeners.
	*
	* @param producer the producer
	* @return the producer that was added
	*/
	public static de.uhh.l2g.plugins.model.Producer addProducer(
		de.uhh.l2g.plugins.model.Producer producer) {
		return getService().addProducer(producer);
	}

	/**
	* Creates a new producer with the primary key. Does not add the producer to the database.
	*
	* @param producerId the primary key for the new producer
	* @return the new producer
	*/
	public static de.uhh.l2g.plugins.model.Producer createProducer(
		long producerId) {
		return getService().createProducer(producerId);
	}

	/**
	* Deletes the producer from the database. Also notifies the appropriate model listeners.
	*
	* @param producer the producer
	* @return the producer that was removed
	*/
	public static de.uhh.l2g.plugins.model.Producer deleteProducer(
		de.uhh.l2g.plugins.model.Producer producer) {
		return getService().deleteProducer(producer);
	}

	/**
	* Deletes the producer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param producerId the primary key of the producer
	* @return the producer that was removed
	* @throws PortalException if a producer with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Producer deleteProducer(
		long producerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteProducer(producerId);
	}

	public static de.uhh.l2g.plugins.model.Producer fetchProducer(
		long producerId) {
		return getService().fetchProducer(producerId);
	}

	public static de.uhh.l2g.plugins.model.Producer getById(long producerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getById(producerId);
	}

	public static de.uhh.l2g.plugins.model.Producer getProdUcer(
		java.lang.Long producerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getProdUcer(producerId);
	}

	/**
	* Returns the producer with the primary key.
	*
	* @param producerId the primary key of the producer
	* @return the producer
	* @throws PortalException if a producer with the primary key could not be found
	*/
	public static de.uhh.l2g.plugins.model.Producer getProducer(long producerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getProducer(producerId);
	}

	/**
	* Updates the producer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param producer the producer
	* @return the producer that was updated
	*/
	public static de.uhh.l2g.plugins.model.Producer updateProducer(
		de.uhh.l2g.plugins.model.Producer producer) {
		return getService().updateProducer(producer);
	}

	public static int getProducersByHostIdCount(long hostId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProducersByHostIdCount(hostId);
	}

	/**
	* Returns the number of producers.
	*
	* @return the number of producers
	*/
	public static int getProducersCount() {
		return getService().getProducersCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static java.util.List<java.lang.Long> getAllProducerIds(
		java.lang.Long lectureseriesId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllProducerIds(lectureseriesId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Producer> getAllProducers(
		int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllProducers(begin, end);
	}

	public static java.util.List<java.lang.Long> getProducerIds(
		java.lang.Long lectureseriesId, int begin, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProducerIds(lectureseriesId, begin, end);
	}

	/**
	* Returns a range of all the producers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link de.uhh.l2g.plugins.model.impl.ProducerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of producers
	* @param end the upper bound of the range of producers (not inclusive)
	* @return the range of producers
	*/
	public static java.util.List<de.uhh.l2g.plugins.model.Producer> getProducers(
		int start, int end) {
		return getService().getProducers(start, end);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Producer> getProducersByHostId(
		long hostId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProducersByHostId(hostId);
	}

	public static java.util.List<de.uhh.l2g.plugins.model.Producer> getProducersByInstitutionId(
		long institutionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getProducersByInstitutionId(institutionId);
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

	public static ProducerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProducerLocalService, ProducerLocalService> _serviceTracker =
		ServiceTrackerFactory.open(ProducerLocalService.class);
}