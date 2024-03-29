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

package de.uhh.l2g.plugins.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import de.uhh.l2g.plugins.model.Lectureseries_Category;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lectureseries_ category service. This utility wraps {@link de.uhh.l2g.plugins.service.persistence.impl.Lectureseries_CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryPersistence
 * @see de.uhh.l2g.plugins.service.persistence.impl.Lectureseries_CategoryPersistenceImpl
 * @generated
 */
@ProviderType
public class Lectureseries_CategoryUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Lectureseries_Category lectureseries_Category) {
		getPersistence().clearCache(lectureseries_Category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Lectureseries_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Lectureseries_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Lectureseries_Category> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Lectureseries_Category update(
		Lectureseries_Category lectureseries_Category) {
		return getPersistence().update(lectureseries_Category);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Lectureseries_Category update(
		Lectureseries_Category lectureseries_Category,
		ServiceContext serviceContext) {
		return getPersistence().update(lectureseries_Category, serviceContext);
	}

	/**
	* Returns all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId) {
		return getPersistence().findByLectureseries(lectureseriesId);
	}

	/**
	* Returns a range of all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end) {
		return getPersistence().findByLectureseries(lectureseriesId, start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .findByLectureseries(lectureseriesId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories where lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByLectureseries(
		long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLectureseries(lectureseriesId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category findByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByLectureseries_First(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category fetchByLectureseries_First(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .fetchByLectureseries_First(lectureseriesId,
			orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category findByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category fetchByLectureseries_Last(
		long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .fetchByLectureseries_Last(lectureseriesId, orderByComparator);
	}

	/**
	* Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where lectureseriesId = &#63;.
	*
	* @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	*/
	public static Lectureseries_Category[] findByLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByLectureseries_PrevAndNext(lectureseriesCategoryId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ categories where lectureseriesId = &#63; from the database.
	*
	* @param lectureseriesId the lectureseries ID
	*/
	public static void removeByLectureseries(long lectureseriesId) {
		getPersistence().removeByLectureseries(lectureseriesId);
	}

	/**
	* Returns the number of lectureseries_ categories where lectureseriesId = &#63;.
	*
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ categories
	*/
	public static int countByLectureseries(long lectureseriesId) {
		return getPersistence().countByLectureseries(lectureseriesId);
	}

	/**
	* Returns all the lectureseries_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategory(long categoryId) {
		return getPersistence().findByCategory(categoryId);
	}

	/**
	* Returns a range of all the lectureseries_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end) {
		return getPersistence().findByCategory(categoryId, start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories where categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategory(long categoryId,
		int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCategory(categoryId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category findByCategory_First(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category fetchByCategory_First(
		long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .fetchByCategory_First(categoryId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category findByCategory_Last(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category fetchByCategory_Last(long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .fetchByCategory_Last(categoryId, orderByComparator);
	}

	/**
	* Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63;.
	*
	* @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	*/
	public static Lectureseries_Category[] findByCategory_PrevAndNext(
		long lectureseriesCategoryId, long categoryId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategory_PrevAndNext(lectureseriesCategoryId,
			categoryId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ categories where categoryId = &#63; from the database.
	*
	* @param categoryId the category ID
	*/
	public static void removeByCategory(long categoryId) {
		getPersistence().removeByCategory(categoryId);
	}

	/**
	* Returns the number of lectureseries_ categories where categoryId = &#63;.
	*
	* @param categoryId the category ID
	* @return the number of matching lectureseries_ categories
	*/
	public static int countByCategory(long categoryId) {
		return getPersistence().countByCategory(categoryId);
	}

	/**
	* Returns all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @return the matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId) {
		return getPersistence()
				   .findByCategoryLectureseries(categoryId, lectureseriesId);
	}

	/**
	* Returns a range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end) {
		return getPersistence()
				   .findByCategoryLectureseries(categoryId, lectureseriesId,
			start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .findByCategoryLectureseries(categoryId, lectureseriesId,
			start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findByCategoryLectureseries(
		long categoryId, long lectureseriesId, int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByCategoryLectureseries(categoryId, lectureseriesId,
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category findByCategoryLectureseries_First(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategoryLectureseries_First(categoryId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the first lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category fetchByCategoryLectureseries_First(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .fetchByCategoryLectureseries_First(categoryId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category findByCategoryLectureseries_Last(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategoryLectureseries_Last(categoryId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the last lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lectureseries_ category, or <code>null</code> if a matching lectureseries_ category could not be found
	*/
	public static Lectureseries_Category fetchByCategoryLectureseries_Last(
		long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence()
				   .fetchByCategoryLectureseries_Last(categoryId,
			lectureseriesId, orderByComparator);
	}

	/**
	* Returns the lectureseries_ categories before and after the current lectureseries_ category in the ordered set where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param lectureseriesCategoryId the primary key of the current lectureseries_ category
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	*/
	public static Lectureseries_Category[] findByCategoryLectureseries_PrevAndNext(
		long lectureseriesCategoryId, long categoryId, long lectureseriesId,
		OrderByComparator<Lectureseries_Category> orderByComparator)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence()
				   .findByCategoryLectureseries_PrevAndNext(lectureseriesCategoryId,
			categoryId, lectureseriesId, orderByComparator);
	}

	/**
	* Removes all the lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63; from the database.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	*/
	public static void removeByCategoryLectureseries(long categoryId,
		long lectureseriesId) {
		getPersistence()
			.removeByCategoryLectureseries(categoryId, lectureseriesId);
	}

	/**
	* Returns the number of lectureseries_ categories where categoryId = &#63; and lectureseriesId = &#63;.
	*
	* @param categoryId the category ID
	* @param lectureseriesId the lectureseries ID
	* @return the number of matching lectureseries_ categories
	*/
	public static int countByCategoryLectureseries(long categoryId,
		long lectureseriesId) {
		return getPersistence()
				   .countByCategoryLectureseries(categoryId, lectureseriesId);
	}

	/**
	* Caches the lectureseries_ category in the entity cache if it is enabled.
	*
	* @param lectureseries_Category the lectureseries_ category
	*/
	public static void cacheResult(
		Lectureseries_Category lectureseries_Category) {
		getPersistence().cacheResult(lectureseries_Category);
	}

	/**
	* Caches the lectureseries_ categories in the entity cache if it is enabled.
	*
	* @param lectureseries_Categories the lectureseries_ categories
	*/
	public static void cacheResult(
		List<Lectureseries_Category> lectureseries_Categories) {
		getPersistence().cacheResult(lectureseries_Categories);
	}

	/**
	* Creates a new lectureseries_ category with the primary key. Does not add the lectureseries_ category to the database.
	*
	* @param lectureseriesCategoryId the primary key for the new lectureseries_ category
	* @return the new lectureseries_ category
	*/
	public static Lectureseries_Category create(long lectureseriesCategoryId) {
		return getPersistence().create(lectureseriesCategoryId);
	}

	/**
	* Removes the lectureseries_ category with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category that was removed
	* @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	*/
	public static Lectureseries_Category remove(long lectureseriesCategoryId)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence().remove(lectureseriesCategoryId);
	}

	public static Lectureseries_Category updateImpl(
		Lectureseries_Category lectureseries_Category) {
		return getPersistence().updateImpl(lectureseries_Category);
	}

	/**
	* Returns the lectureseries_ category with the primary key or throws a {@link NoSuchLectureseries_CategoryException} if it could not be found.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category
	* @throws NoSuchLectureseries_CategoryException if a lectureseries_ category with the primary key could not be found
	*/
	public static Lectureseries_Category findByPrimaryKey(
		long lectureseriesCategoryId)
		throws de.uhh.l2g.plugins.exception.NoSuchLectureseries_CategoryException {
		return getPersistence().findByPrimaryKey(lectureseriesCategoryId);
	}

	/**
	* Returns the lectureseries_ category with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param lectureseriesCategoryId the primary key of the lectureseries_ category
	* @return the lectureseries_ category, or <code>null</code> if a lectureseries_ category with the primary key could not be found
	*/
	public static Lectureseries_Category fetchByPrimaryKey(
		long lectureseriesCategoryId) {
		return getPersistence().fetchByPrimaryKey(lectureseriesCategoryId);
	}

	public static java.util.Map<java.io.Serializable, Lectureseries_Category> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lectureseries_ categories.
	*
	* @return the lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lectureseries_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @return the range of lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findAll(int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lectureseries_ categories.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Lectureseries_CategoryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lectureseries_ categories
	* @param end the upper bound of the range of lectureseries_ categories (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lectureseries_ categories
	*/
	public static List<Lectureseries_Category> findAll(int start, int end,
		OrderByComparator<Lectureseries_Category> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lectureseries_ categories from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lectureseries_ categories.
	*
	* @return the number of lectureseries_ categories
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Lectureseries_CategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Lectureseries_CategoryPersistence, Lectureseries_CategoryPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Lectureseries_CategoryPersistence.class);
}