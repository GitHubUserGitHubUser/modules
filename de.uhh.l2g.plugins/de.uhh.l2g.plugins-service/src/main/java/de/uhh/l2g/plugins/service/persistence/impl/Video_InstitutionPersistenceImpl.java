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
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import de.uhh.l2g.plugins.exception.NoSuchVideo_InstitutionException;
import de.uhh.l2g.plugins.model.Video_Institution;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionImpl;
import de.uhh.l2g.plugins.model.impl.Video_InstitutionModelImpl;
import de.uhh.l2g.plugins.service.persistence.Video_InstitutionPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the video_ institution service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_InstitutionPersistence
 * @see de.uhh.l2g.plugins.service.persistence.Video_InstitutionUtil
 * @generated
 */
@ProviderType
public class Video_InstitutionPersistenceImpl extends BasePersistenceImpl<Video_Institution>
	implements Video_InstitutionPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_InstitutionUtil} to access the video_ institution persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_InstitutionImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVideo",
			new String[] { Long.class.getName() },
			Video_InstitutionModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId, int start,
		int end, OrderByComparator<Video_Institution> orderByComparator) {
		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideo(long videoId, int start,
		int end, OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO;
			finderArgs = new Object[] { videoId, start, end, orderByComparator };
		}

		List<Video_Institution> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Institution>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Institution video_Institution : list) {
					if ((videoId != video_Institution.getVideoId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByVideo_First(long videoId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByVideo_First(long videoId,
		OrderByComparator<Video_Institution> orderByComparator) {
		List<Video_Institution> list = findByVideo(videoId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByVideo_Last(long videoId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByVideo_Last(long videoId,
		OrderByComparator<Video_Institution> orderByComparator) {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution[] findByVideo_PrevAndNext(
		long videoInstitutionId, long videoId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Institution,
					videoId, orderByComparator, true);

			array[1] = video_Institution;

			array[2] = getByVideo_PrevAndNext(session, video_Institution,
					videoId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Institution getByVideo_PrevAndNext(Session session,
		Video_Institution video_Institution, long videoId,
		OrderByComparator<Video_Institution> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Video_Institution video_Institution : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ institutions
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Institution.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByInstitution",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByInstitution",
			new String[] { Long.class.getName() },
			Video_InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTION = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByInstitution",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId) {
		return findByInstitution(institutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId,
		int start, int end) {
		return findByInstitution(institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId,
		int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {
		return findByInstitution(institutionId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitution(long institutionId,
		int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] { institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTION;
			finderArgs = new Object[] {
					institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Institution> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Institution>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Institution video_Institution : list) {
					if ((institutionId != video_Institution.getInstitutionId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByInstitution_First(long institutionId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByInstitution_First(institutionId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByInstitution_First(long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {
		List<Video_Institution> list = findByInstitution(institutionId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByInstitution_Last(long institutionId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByInstitution_Last(institutionId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByInstitution_Last(long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {
		int count = countByInstitution(institutionId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByInstitution(institutionId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution[] findByInstitution_PrevAndNext(
		long videoInstitutionId, long institutionId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByInstitution_PrevAndNext(session, video_Institution,
					institutionId, orderByComparator, true);

			array[1] = video_Institution;

			array[2] = getByInstitution_PrevAndNext(session, video_Institution,
					institutionId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Institution getByInstitution_PrevAndNext(Session session,
		Video_Institution video_Institution, long institutionId,
		OrderByComparator<Video_Institution> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where institutionId = &#63; from the database.
	 *
	 * @param institutionId the institution ID
	 */
	@Override
	public void removeByInstitution(long institutionId) {
		for (Video_Institution video_Institution : findByInstitution(
				institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where institutionId = &#63;.
	 *
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 */
	@Override
	public int countByInstitution(long institutionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTION;

		Object[] finderArgs = new Object[] { institutionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INSTITUTION_INSTITUTIONID_2 = "video_Institution.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOINSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVideoInstitution",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideoInstitution",
			new String[] { Long.class.getName(), Long.class.getName() },
			Video_InstitutionModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_InstitutionModelImpl.INSTITUTIONID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOINSTITUTION = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByVideoInstitution",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId) {
		return findByVideoInstitution(videoId, institutionId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId, int start, int end) {
		return findByVideoInstitution(videoId, institutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {
		return findByVideoInstitution(videoId, institutionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByVideoInstitution(long videoId,
		long institutionId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION;
			finderArgs = new Object[] { videoId, institutionId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOINSTITUTION;
			finderArgs = new Object[] {
					videoId, institutionId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Institution> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Institution>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Institution video_Institution : list) {
					if ((videoId != video_Institution.getVideoId()) ||
							(institutionId != video_Institution.getInstitutionId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(institutionId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByVideoInstitution_First(long videoId,
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByVideoInstitution_First(videoId,
				institutionId, orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByVideoInstitution_First(long videoId,
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {
		List<Video_Institution> list = findByVideoInstitution(videoId,
				institutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByVideoInstitution_Last(long videoId,
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByVideoInstitution_Last(videoId,
				institutionId, orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", institutionId=");
		msg.append(institutionId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByVideoInstitution_Last(long videoId,
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator) {
		int count = countByVideoInstitution(videoId, institutionId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByVideoInstitution(videoId,
				institutionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution[] findByVideoInstitution_PrevAndNext(
		long videoInstitutionId, long videoId, long institutionId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByVideoInstitution_PrevAndNext(session,
					video_Institution, videoId, institutionId,
					orderByComparator, true);

			array[1] = video_Institution;

			array[2] = getByVideoInstitution_PrevAndNext(session,
					video_Institution, videoId, institutionId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Institution getByVideoInstitution_PrevAndNext(
		Session session, Video_Institution video_Institution, long videoId,
		long institutionId,
		OrderByComparator<Video_Institution> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(institutionId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where videoId = &#63; and institutionId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 */
	@Override
	public void removeByVideoInstitution(long videoId, long institutionId) {
		for (Video_Institution video_Institution : findByVideoInstitution(
				videoId, institutionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where videoId = &#63; and institutionId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param institutionId the institution ID
	 * @return the number of matching video_ institutions
	 */
	@Override
	public int countByVideoInstitution(long videoId, long institutionId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEOINSTITUTION;

		Object[] finderArgs = new Object[] { videoId, institutionId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(institutionId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_VIDEOINSTITUTION_VIDEOID_2 = "video_Institution.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOINSTITUTION_INSTITUTIONID_2 = "video_Institution.institutionId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONPARENTID =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByInstitutionParentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID =
		new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED,
			Video_InstitutionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByInstitutionParentId", new String[] { Long.class.getName() },
			Video_InstitutionModelImpl.INSTITUTIONPARENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID = new FinderPath(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByInstitutionParentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitutionParentId(
		long institutionParentId) {
		return findByInstitutionParentId(institutionParentId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end) {
		return findByInstitutionParentId(institutionParentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {
		return findByInstitutionParentId(institutionParentId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ institutions where institutionParentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param institutionParentId the institution parent ID
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ institutions
	 */
	@Override
	public List<Video_Institution> findByInstitutionParentId(
		long institutionParentId, int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID;
			finderArgs = new Object[] { institutionParentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_INSTITUTIONPARENTID;
			finderArgs = new Object[] {
					institutionParentId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Institution> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Institution>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Institution video_Institution : list) {
					if ((institutionParentId != video_Institution.getInstitutionParentId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionParentId);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Returns the first video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByInstitutionParentId_First(
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByInstitutionParentId_First(institutionParentId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionParentId=");
		msg.append(institutionParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the first video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByInstitutionParentId_First(
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator) {
		List<Video_Institution> list = findByInstitutionParentId(institutionParentId,
				0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution
	 * @throws NoSuchVideo_InstitutionException if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution findByInstitutionParentId_Last(
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByInstitutionParentId_Last(institutionParentId,
				orderByComparator);

		if (video_Institution != null) {
			return video_Institution;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("institutionParentId=");
		msg.append(institutionParentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_InstitutionException(msg.toString());
	}

	/**
	 * Returns the last video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ institution, or <code>null</code> if a matching video_ institution could not be found
	 */
	@Override
	public Video_Institution fetchByInstitutionParentId_Last(
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator) {
		int count = countByInstitutionParentId(institutionParentId);

		if (count == 0) {
			return null;
		}

		List<Video_Institution> list = findByInstitutionParentId(institutionParentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ institutions before and after the current video_ institution in the ordered set where institutionParentId = &#63;.
	 *
	 * @param videoInstitutionId the primary key of the current video_ institution
	 * @param institutionParentId the institution parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution[] findByInstitutionParentId_PrevAndNext(
		long videoInstitutionId, long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = findByPrimaryKey(videoInstitutionId);

		Session session = null;

		try {
			session = openSession();

			Video_Institution[] array = new Video_InstitutionImpl[3];

			array[0] = getByInstitutionParentId_PrevAndNext(session,
					video_Institution, institutionParentId, orderByComparator,
					true);

			array[1] = video_Institution;

			array[2] = getByInstitutionParentId_PrevAndNext(session,
					video_Institution, institutionParentId, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Institution getByInstitutionParentId_PrevAndNext(
		Session session, Video_Institution video_Institution,
		long institutionParentId,
		OrderByComparator<Video_Institution> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE);

		query.append(_FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Video_InstitutionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(institutionParentId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Institution);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Institution> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ institutions where institutionParentId = &#63; from the database.
	 *
	 * @param institutionParentId the institution parent ID
	 */
	@Override
	public void removeByInstitutionParentId(long institutionParentId) {
		for (Video_Institution video_Institution : findByInstitutionParentId(
				institutionParentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions where institutionParentId = &#63;.
	 *
	 * @param institutionParentId the institution parent ID
	 * @return the number of matching video_ institutions
	 */
	@Override
	public int countByInstitutionParentId(long institutionParentId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID;

		Object[] finderArgs = new Object[] { institutionParentId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_INSTITUTION_WHERE);

			query.append(_FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(institutionParentId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_INSTITUTIONPARENTID_INSTITUTIONPARENTID_2 =
		"video_Institution.institutionParentId = ?";

	public Video_InstitutionPersistenceImpl() {
		setModelClass(Video_Institution.class);
	}

	/**
	 * Caches the video_ institution in the entity cache if it is enabled.
	 *
	 * @param video_Institution the video_ institution
	 */
	@Override
	public void cacheResult(Video_Institution video_Institution) {
		entityCache.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionImpl.class, video_Institution.getPrimaryKey(),
			video_Institution);

		video_Institution.resetOriginalValues();
	}

	/**
	 * Caches the video_ institutions in the entity cache if it is enabled.
	 *
	 * @param video_Institutions the video_ institutions
	 */
	@Override
	public void cacheResult(List<Video_Institution> video_Institutions) {
		for (Video_Institution video_Institution : video_Institutions) {
			if (entityCache.getResult(
						Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						Video_InstitutionImpl.class,
						video_Institution.getPrimaryKey()) == null) {
				cacheResult(video_Institution);
			}
			else {
				video_Institution.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ institutions.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Video_InstitutionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ institution.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Institution video_Institution) {
		entityCache.removeResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionImpl.class, video_Institution.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Institution> video_Institutions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Institution video_Institution : video_Institutions) {
			entityCache.removeResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				Video_InstitutionImpl.class, video_Institution.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ institution with the primary key. Does not add the video_ institution to the database.
	 *
	 * @param videoInstitutionId the primary key for the new video_ institution
	 * @return the new video_ institution
	 */
	@Override
	public Video_Institution create(long videoInstitutionId) {
		Video_Institution video_Institution = new Video_InstitutionImpl();

		video_Institution.setNew(true);
		video_Institution.setPrimaryKey(videoInstitutionId);

		return video_Institution;
	}

	/**
	 * Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution that was removed
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution remove(long videoInstitutionId)
		throws NoSuchVideo_InstitutionException {
		return remove((Serializable)videoInstitutionId);
	}

	/**
	 * Removes the video_ institution with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ institution
	 * @return the video_ institution that was removed
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution remove(Serializable primaryKey)
		throws NoSuchVideo_InstitutionException {
		Session session = null;

		try {
			session = openSession();

			Video_Institution video_Institution = (Video_Institution)session.get(Video_InstitutionImpl.class,
					primaryKey);

			if (video_Institution == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_InstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Institution);
		}
		catch (NoSuchVideo_InstitutionException nsee) {
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
	protected Video_Institution removeImpl(Video_Institution video_Institution) {
		video_Institution = toUnwrappedModel(video_Institution);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Institution)) {
				video_Institution = (Video_Institution)session.get(Video_InstitutionImpl.class,
						video_Institution.getPrimaryKeyObj());
			}

			if (video_Institution != null) {
				session.delete(video_Institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Institution != null) {
			clearCache(video_Institution);
		}

		return video_Institution;
	}

	@Override
	public Video_Institution updateImpl(Video_Institution video_Institution) {
		video_Institution = toUnwrappedModel(video_Institution);

		boolean isNew = video_Institution.isNew();

		Video_InstitutionModelImpl video_InstitutionModelImpl = (Video_InstitutionModelImpl)video_Institution;

		Session session = null;

		try {
			session = openSession();

			if (video_Institution.isNew()) {
				session.save(video_Institution);

				video_Institution.setNew(false);
			}
			else {
				video_Institution = (Video_Institution)session.merge(video_Institution);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Video_InstitutionModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { video_InstitutionModelImpl.getVideoId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
				args);

			args = new Object[] { video_InstitutionModelImpl.getInstitutionId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
				args);

			args = new Object[] {
					video_InstitutionModelImpl.getVideoId(),
					video_InstitutionModelImpl.getInstitutionId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEOINSTITUTION, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION,
				args);

			args = new Object[] {
					video_InstitutionModelImpl.getInstitutionParentId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID,
				args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_InstitutionModelImpl.getVideoId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalInstitutionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);

				args = new Object[] {
						video_InstitutionModelImpl.getInstitutionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTION, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTION,
					args);
			}

			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalVideoId(),
						video_InstitutionModelImpl.getOriginalInstitutionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEOINSTITUTION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION,
					args);

				args = new Object[] {
						video_InstitutionModelImpl.getVideoId(),
						video_InstitutionModelImpl.getInstitutionId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEOINSTITUTION,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOINSTITUTION,
					args);
			}

			if ((video_InstitutionModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_InstitutionModelImpl.getOriginalInstitutionParentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID,
					args);

				args = new Object[] {
						video_InstitutionModelImpl.getInstitutionParentId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_INSTITUTIONPARENTID,
					args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_INSTITUTIONPARENTID,
					args);
			}
		}

		entityCache.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
			Video_InstitutionImpl.class, video_Institution.getPrimaryKey(),
			video_Institution, false);

		video_Institution.resetOriginalValues();

		return video_Institution;
	}

	protected Video_Institution toUnwrappedModel(
		Video_Institution video_Institution) {
		if (video_Institution instanceof Video_InstitutionImpl) {
			return video_Institution;
		}

		Video_InstitutionImpl video_InstitutionImpl = new Video_InstitutionImpl();

		video_InstitutionImpl.setNew(video_Institution.isNew());
		video_InstitutionImpl.setPrimaryKey(video_Institution.getPrimaryKey());

		video_InstitutionImpl.setVideoInstitutionId(video_Institution.getVideoInstitutionId());
		video_InstitutionImpl.setVideoId(video_Institution.getVideoId());
		video_InstitutionImpl.setInstitutionId(video_Institution.getInstitutionId());
		video_InstitutionImpl.setInstitutionParentId(video_Institution.getInstitutionParentId());

		return video_InstitutionImpl;
	}

	/**
	 * Returns the video_ institution with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ institution
	 * @return the video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_InstitutionException {
		Video_Institution video_Institution = fetchByPrimaryKey(primaryKey);

		if (video_Institution == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_InstitutionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Institution;
	}

	/**
	 * Returns the video_ institution with the primary key or throws a {@link NoSuchVideo_InstitutionException} if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution
	 * @throws NoSuchVideo_InstitutionException if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution findByPrimaryKey(long videoInstitutionId)
		throws NoSuchVideo_InstitutionException {
		return findByPrimaryKey((Serializable)videoInstitutionId);
	}

	/**
	 * Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ institution
	 * @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
				Video_InstitutionImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Video_Institution video_Institution = (Video_Institution)serializable;

		if (video_Institution == null) {
			Session session = null;

			try {
				session = openSession();

				video_Institution = (Video_Institution)session.get(Video_InstitutionImpl.class,
						primaryKey);

				if (video_Institution != null) {
					cacheResult(video_Institution);
				}
				else {
					entityCache.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
						Video_InstitutionImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					Video_InstitutionImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Institution;
	}

	/**
	 * Returns the video_ institution with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoInstitutionId the primary key of the video_ institution
	 * @return the video_ institution, or <code>null</code> if a video_ institution with the primary key could not be found
	 */
	@Override
	public Video_Institution fetchByPrimaryKey(long videoInstitutionId) {
		return fetchByPrimaryKey((Serializable)videoInstitutionId);
	}

	@Override
	public Map<Serializable, Video_Institution> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Video_Institution> map = new HashMap<Serializable, Video_Institution>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Video_Institution video_Institution = fetchByPrimaryKey(primaryKey);

			if (video_Institution != null) {
				map.put(primaryKey, video_Institution);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					Video_InstitutionImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Video_Institution)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VIDEO_INSTITUTION_WHERE_PKS_IN);

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

			for (Video_Institution video_Institution : (List<Video_Institution>)q.list()) {
				map.put(video_Institution.getPrimaryKeyObj(), video_Institution);

				cacheResult(video_Institution);

				uncachedPrimaryKeys.remove(video_Institution.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Video_InstitutionModelImpl.ENTITY_CACHE_ENABLED,
					Video_InstitutionImpl.class, primaryKey, nullModel);
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
	 * Returns all the video_ institutions.
	 *
	 * @return the video_ institutions
	 */
	@Override
	public List<Video_Institution> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @return the range of video_ institutions
	 */
	@Override
	public List<Video_Institution> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ institutions
	 */
	@Override
	public List<Video_Institution> findAll(int start, int end,
		OrderByComparator<Video_Institution> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ institutions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_InstitutionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ institutions
	 * @param end the upper bound of the range of video_ institutions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of video_ institutions
	 */
	@Override
	public List<Video_Institution> findAll(int start, int end,
		OrderByComparator<Video_Institution> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Video_Institution> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Institution>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO_INSTITUTION);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_INSTITUTION;

				if (pagination) {
					sql = sql.concat(Video_InstitutionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Institution>)QueryUtil.list(q,
							getDialect(), start, end);
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
	 * Removes all the video_ institutions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video_Institution video_Institution : findAll()) {
			remove(video_Institution);
		}
	}

	/**
	 * Returns the number of video_ institutions.
	 *
	 * @return the number of video_ institutions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO_INSTITUTION);

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
		return Video_InstitutionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video_ institution persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Video_InstitutionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VIDEO_INSTITUTION = "SELECT video_Institution FROM Video_Institution video_Institution";
	private static final String _SQL_SELECT_VIDEO_INSTITUTION_WHERE_PKS_IN = "SELECT video_Institution FROM Video_Institution video_Institution WHERE videoInstitutionId IN (";
	private static final String _SQL_SELECT_VIDEO_INSTITUTION_WHERE = "SELECT video_Institution FROM Video_Institution video_Institution WHERE ";
	private static final String _SQL_COUNT_VIDEO_INSTITUTION = "SELECT COUNT(video_Institution) FROM Video_Institution video_Institution";
	private static final String _SQL_COUNT_VIDEO_INSTITUTION_WHERE = "SELECT COUNT(video_Institution) FROM Video_Institution video_Institution WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Institution.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Institution exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Institution exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Video_InstitutionPersistenceImpl.class);
}