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

import de.uhh.l2g.plugins.exception.NoSuchVideo_CreatorException;
import de.uhh.l2g.plugins.model.Video_Creator;
import de.uhh.l2g.plugins.model.impl.Video_CreatorImpl;
import de.uhh.l2g.plugins.model.impl.Video_CreatorModelImpl;
import de.uhh.l2g.plugins.service.persistence.Video_CreatorPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the video_ creator service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_CreatorPersistence
 * @see de.uhh.l2g.plugins.service.persistence.Video_CreatorUtil
 * @generated
 */
@ProviderType
public class Video_CreatorPersistenceImpl extends BasePersistenceImpl<Video_Creator>
	implements Video_CreatorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Video_CreatorUtil} to access the video_ creator persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Video_CreatorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideo",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideo", new String[] { Long.class.getName() },
			Video_CreatorModelImpl.VIDEOID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEO = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideo",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId) {
		return findByVideo(videoId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId, int start, int end) {
		return findByVideo(videoId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {
		return findByVideo(videoId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideo(long videoId, int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
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

		List<Video_Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Creator>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Creator video_Creator : list) {
					if ((videoId != video_Creator.getVideoId())) {
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

			query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_VIDEO_VIDEOID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideo_First(long videoId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByVideo_First(videoId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideo_First(long videoId,
		OrderByComparator<Video_Creator> orderByComparator) {
		List<Video_Creator> list = findByVideo(videoId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideo_Last(long videoId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByVideo_Last(videoId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideo_Last(long videoId,
		OrderByComparator<Video_Creator> orderByComparator) {
		int count = countByVideo(videoId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByVideo(videoId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator[] findByVideo_PrevAndNext(long videoCreatorId,
		long videoId, OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByVideo_PrevAndNext(session, video_Creator, videoId,
					orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByVideo_PrevAndNext(session, video_Creator, videoId,
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

	protected Video_Creator getByVideo_PrevAndNext(Session session,
		Video_Creator video_Creator, long videoId,
		OrderByComparator<Video_Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

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
			query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 */
	@Override
	public void removeByVideo(long videoId) {
		for (Video_Creator video_Creator : findByVideo(videoId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63;.
	 *
	 * @param videoId the video ID
	 * @return the number of matching video_ creators
	 */
	@Override
	public int countByVideo(long videoId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEO;

		Object[] finderArgs = new Object[] { videoId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

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

	private static final String _FINDER_COLUMN_VIDEO_VIDEOID_2 = "video_Creator.videoId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCreator",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR =
		new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByCreator", new String[] { Long.class.getName() },
			Video_CreatorModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CREATOR = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCreator",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId) {
		return findByCreator(creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId, int start, int end) {
		return findByCreator(creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId, int start,
		int end, OrderByComparator<Video_Creator> orderByComparator) {
		return findByCreator(creatorId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators where creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByCreator(long creatorId, int start,
		int end, OrderByComparator<Video_Creator> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR;
			finderArgs = new Object[] { creatorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CREATOR;
			finderArgs = new Object[] { creatorId, start, end, orderByComparator };
		}

		List<Video_Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Creator>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Creator video_Creator : list) {
					if ((creatorId != video_Creator.getCreatorId())) {
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

			query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByCreator_First(long creatorId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByCreator_First(creatorId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByCreator_First(long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {
		List<Video_Creator> list = findByCreator(creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByCreator_Last(long creatorId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByCreator_Last(creatorId,
				orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByCreator_Last(long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {
		int count = countByCreator(creatorId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByCreator(creatorId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator[] findByCreator_PrevAndNext(long videoCreatorId,
		long creatorId, OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByCreator_PrevAndNext(session, video_Creator,
					creatorId, orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByCreator_PrevAndNext(session, video_Creator,
					creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByCreator_PrevAndNext(Session session,
		Video_Creator video_Creator, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

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
			query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(creatorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where creatorId = &#63; from the database.
	 *
	 * @param creatorId the creator ID
	 */
	@Override
	public void removeByCreator(long creatorId) {
		for (Video_Creator video_Creator : findByCreator(creatorId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where creatorId = &#63;.
	 *
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	@Override
	public int countByCreator(long creatorId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CREATOR;

		Object[] finderArgs = new Object[] { creatorId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_CREATOR_CREATORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_CREATOR_CREATORID_2 = "video_Creator.creatorId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOCREATOR =
		new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByVideoCreator",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR =
		new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED,
			Video_CreatorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByVideoCreator",
			new String[] { Long.class.getName(), Long.class.getName() },
			Video_CreatorModelImpl.VIDEOID_COLUMN_BITMASK |
			Video_CreatorModelImpl.CREATORID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_VIDEOCREATOR = new FinderPath(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVideoCreator",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId) {
		return findByVideoCreator(videoId, creatorId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId,
		int start, int end) {
		return findByVideoCreator(videoId, creatorId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId,
		int start, int end, OrderByComparator<Video_Creator> orderByComparator) {
		return findByVideoCreator(videoId, creatorId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching video_ creators
	 */
	@Override
	public List<Video_Creator> findByVideoCreator(long videoId, long creatorId,
		int start, int end, OrderByComparator<Video_Creator> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR;
			finderArgs = new Object[] { videoId, creatorId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_VIDEOCREATOR;
			finderArgs = new Object[] {
					videoId, creatorId,
					
					start, end, orderByComparator
				};
		}

		List<Video_Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Creator>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Video_Creator video_Creator : list) {
					if ((videoId != video_Creator.getVideoId()) ||
							(creatorId != video_Creator.getCreatorId())) {
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

			query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(creatorId);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideoCreator_First(long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByVideoCreator_First(videoId,
				creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the first video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideoCreator_First(long videoId,
		long creatorId, OrderByComparator<Video_Creator> orderByComparator) {
		List<Video_Creator> list = findByVideoCreator(videoId, creatorId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator
	 * @throws NoSuchVideo_CreatorException if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator findByVideoCreator_Last(long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByVideoCreator_Last(videoId,
				creatorId, orderByComparator);

		if (video_Creator != null) {
			return video_Creator;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("videoId=");
		msg.append(videoId);

		msg.append(", creatorId=");
		msg.append(creatorId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchVideo_CreatorException(msg.toString());
	}

	/**
	 * Returns the last video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching video_ creator, or <code>null</code> if a matching video_ creator could not be found
	 */
	@Override
	public Video_Creator fetchByVideoCreator_Last(long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator) {
		int count = countByVideoCreator(videoId, creatorId);

		if (count == 0) {
			return null;
		}

		List<Video_Creator> list = findByVideoCreator(videoId, creatorId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the video_ creators before and after the current video_ creator in the ordered set where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoCreatorId the primary key of the current video_ creator
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator[] findByVideoCreator_PrevAndNext(long videoCreatorId,
		long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = findByPrimaryKey(videoCreatorId);

		Session session = null;

		try {
			session = openSession();

			Video_Creator[] array = new Video_CreatorImpl[3];

			array[0] = getByVideoCreator_PrevAndNext(session, video_Creator,
					videoId, creatorId, orderByComparator, true);

			array[1] = video_Creator;

			array[2] = getByVideoCreator_PrevAndNext(session, video_Creator,
					videoId, creatorId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Video_Creator getByVideoCreator_PrevAndNext(Session session,
		Video_Creator video_Creator, long videoId, long creatorId,
		OrderByComparator<Video_Creator> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE);

		query.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

		query.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

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
			query.append(Video_CreatorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(videoId);

		qPos.add(creatorId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(video_Creator);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Video_Creator> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the video_ creators where videoId = &#63; and creatorId = &#63; from the database.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 */
	@Override
	public void removeByVideoCreator(long videoId, long creatorId) {
		for (Video_Creator video_Creator : findByVideoCreator(videoId,
				creatorId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators where videoId = &#63; and creatorId = &#63;.
	 *
	 * @param videoId the video ID
	 * @param creatorId the creator ID
	 * @return the number of matching video_ creators
	 */
	@Override
	public int countByVideoCreator(long videoId, long creatorId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_VIDEOCREATOR;

		Object[] finderArgs = new Object[] { videoId, creatorId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_VIDEO_CREATOR_WHERE);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2);

			query.append(_FINDER_COLUMN_VIDEOCREATOR_CREATORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(videoId);

				qPos.add(creatorId);

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

	private static final String _FINDER_COLUMN_VIDEOCREATOR_VIDEOID_2 = "video_Creator.videoId = ? AND ";
	private static final String _FINDER_COLUMN_VIDEOCREATOR_CREATORID_2 = "video_Creator.creatorId = ?";

	public Video_CreatorPersistenceImpl() {
		setModelClass(Video_Creator.class);
	}

	/**
	 * Caches the video_ creator in the entity cache if it is enabled.
	 *
	 * @param video_Creator the video_ creator
	 */
	@Override
	public void cacheResult(Video_Creator video_Creator) {
		entityCache.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator);

		video_Creator.resetOriginalValues();
	}

	/**
	 * Caches the video_ creators in the entity cache if it is enabled.
	 *
	 * @param video_Creators the video_ creators
	 */
	@Override
	public void cacheResult(List<Video_Creator> video_Creators) {
		for (Video_Creator video_Creator : video_Creators) {
			if (entityCache.getResult(
						Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Video_CreatorImpl.class, video_Creator.getPrimaryKey()) == null) {
				cacheResult(video_Creator);
			}
			else {
				video_Creator.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all video_ creators.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Video_CreatorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the video_ creator.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Video_Creator video_Creator) {
		entityCache.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Video_Creator> video_Creators) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Video_Creator video_Creator : video_Creators) {
			entityCache.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, video_Creator.getPrimaryKey());
		}
	}

	/**
	 * Creates a new video_ creator with the primary key. Does not add the video_ creator to the database.
	 *
	 * @param videoCreatorId the primary key for the new video_ creator
	 * @return the new video_ creator
	 */
	@Override
	public Video_Creator create(long videoCreatorId) {
		Video_Creator video_Creator = new Video_CreatorImpl();

		video_Creator.setNew(true);
		video_Creator.setPrimaryKey(videoCreatorId);

		return video_Creator;
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator remove(long videoCreatorId)
		throws NoSuchVideo_CreatorException {
		return remove((Serializable)videoCreatorId);
	}

	/**
	 * Removes the video_ creator with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator that was removed
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator remove(Serializable primaryKey)
		throws NoSuchVideo_CreatorException {
		Session session = null;

		try {
			session = openSession();

			Video_Creator video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
					primaryKey);

			if (video_Creator == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchVideo_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(video_Creator);
		}
		catch (NoSuchVideo_CreatorException nsee) {
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
	protected Video_Creator removeImpl(Video_Creator video_Creator) {
		video_Creator = toUnwrappedModel(video_Creator);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(video_Creator)) {
				video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
						video_Creator.getPrimaryKeyObj());
			}

			if (video_Creator != null) {
				session.delete(video_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (video_Creator != null) {
			clearCache(video_Creator);
		}

		return video_Creator;
	}

	@Override
	public Video_Creator updateImpl(Video_Creator video_Creator) {
		video_Creator = toUnwrappedModel(video_Creator);

		boolean isNew = video_Creator.isNew();

		Video_CreatorModelImpl video_CreatorModelImpl = (Video_CreatorModelImpl)video_Creator;

		Session session = null;

		try {
			session = openSession();

			if (video_Creator.isNew()) {
				session.save(video_Creator);

				video_Creator.setNew(false);
			}
			else {
				video_Creator = (Video_Creator)session.merge(video_Creator);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Video_CreatorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { video_CreatorModelImpl.getVideoId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
				args);

			args = new Object[] { video_CreatorModelImpl.getCreatorId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
				args);

			args = new Object[] {
					video_CreatorModelImpl.getVideoId(),
					video_CreatorModelImpl.getCreatorId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEOCREATOR, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((video_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CreatorModelImpl.getOriginalVideoId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);

				args = new Object[] { video_CreatorModelImpl.getVideoId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEO, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEO,
					args);
			}

			if ((video_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CreatorModelImpl.getOriginalCreatorId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);

				args = new Object[] { video_CreatorModelImpl.getCreatorId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_CREATOR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CREATOR,
					args);
			}

			if ((video_CreatorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						video_CreatorModelImpl.getOriginalVideoId(),
						video_CreatorModelImpl.getOriginalCreatorId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEOCREATOR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR,
					args);

				args = new Object[] {
						video_CreatorModelImpl.getVideoId(),
						video_CreatorModelImpl.getCreatorId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_VIDEOCREATOR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_VIDEOCREATOR,
					args);
			}
		}

		entityCache.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
			Video_CreatorImpl.class, video_Creator.getPrimaryKey(),
			video_Creator, false);

		video_Creator.resetOriginalValues();

		return video_Creator;
	}

	protected Video_Creator toUnwrappedModel(Video_Creator video_Creator) {
		if (video_Creator instanceof Video_CreatorImpl) {
			return video_Creator;
		}

		Video_CreatorImpl video_CreatorImpl = new Video_CreatorImpl();

		video_CreatorImpl.setNew(video_Creator.isNew());
		video_CreatorImpl.setPrimaryKey(video_Creator.getPrimaryKey());

		video_CreatorImpl.setVideoCreatorId(video_Creator.getVideoCreatorId());
		video_CreatorImpl.setCreatorId(video_Creator.getCreatorId());
		video_CreatorImpl.setVideoId(video_Creator.getVideoId());

		return video_CreatorImpl;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator findByPrimaryKey(Serializable primaryKey)
		throws NoSuchVideo_CreatorException {
		Video_Creator video_Creator = fetchByPrimaryKey(primaryKey);

		if (video_Creator == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchVideo_CreatorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or throws a {@link NoSuchVideo_CreatorException} if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator
	 * @throws NoSuchVideo_CreatorException if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator findByPrimaryKey(long videoCreatorId)
		throws NoSuchVideo_CreatorException {
		return findByPrimaryKey((Serializable)videoCreatorId);
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
				Video_CreatorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Video_Creator video_Creator = (Video_Creator)serializable;

		if (video_Creator == null) {
			Session session = null;

			try {
				session = openSession();

				video_Creator = (Video_Creator)session.get(Video_CreatorImpl.class,
						primaryKey);

				if (video_Creator != null) {
					cacheResult(video_Creator);
				}
				else {
					entityCache.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
						Video_CreatorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Video_CreatorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return video_Creator;
	}

	/**
	 * Returns the video_ creator with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param videoCreatorId the primary key of the video_ creator
	 * @return the video_ creator, or <code>null</code> if a video_ creator with the primary key could not be found
	 */
	@Override
	public Video_Creator fetchByPrimaryKey(long videoCreatorId) {
		return fetchByPrimaryKey((Serializable)videoCreatorId);
	}

	@Override
	public Map<Serializable, Video_Creator> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Video_Creator> map = new HashMap<Serializable, Video_Creator>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Video_Creator video_Creator = fetchByPrimaryKey(primaryKey);

			if (video_Creator != null) {
				map.put(primaryKey, video_Creator);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Video_CreatorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Video_Creator)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_VIDEO_CREATOR_WHERE_PKS_IN);

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

			for (Video_Creator video_Creator : (List<Video_Creator>)q.list()) {
				map.put(video_Creator.getPrimaryKeyObj(), video_Creator);

				cacheResult(video_Creator);

				uncachedPrimaryKeys.remove(video_Creator.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Video_CreatorModelImpl.ENTITY_CACHE_ENABLED,
					Video_CreatorImpl.class, primaryKey, nullModel);
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
	 * Returns all the video_ creators.
	 *
	 * @return the video_ creators
	 */
	@Override
	public List<Video_Creator> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @return the range of video_ creators
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of video_ creators
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end,
		OrderByComparator<Video_Creator> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the video_ creators.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Video_CreatorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of video_ creators
	 * @param end the upper bound of the range of video_ creators (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of video_ creators
	 */
	@Override
	public List<Video_Creator> findAll(int start, int end,
		OrderByComparator<Video_Creator> orderByComparator,
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

		List<Video_Creator> list = null;

		if (retrieveFromCache) {
			list = (List<Video_Creator>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_VIDEO_CREATOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_VIDEO_CREATOR;

				if (pagination) {
					sql = sql.concat(Video_CreatorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Video_Creator>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the video_ creators from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Video_Creator video_Creator : findAll()) {
			remove(video_Creator);
		}
	}

	/**
	 * Returns the number of video_ creators.
	 *
	 * @return the number of video_ creators
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_VIDEO_CREATOR);

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
		return Video_CreatorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the video_ creator persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Video_CreatorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_VIDEO_CREATOR = "SELECT video_Creator FROM Video_Creator video_Creator";
	private static final String _SQL_SELECT_VIDEO_CREATOR_WHERE_PKS_IN = "SELECT video_Creator FROM Video_Creator video_Creator WHERE videoCreatorId IN (";
	private static final String _SQL_SELECT_VIDEO_CREATOR_WHERE = "SELECT video_Creator FROM Video_Creator video_Creator WHERE ";
	private static final String _SQL_COUNT_VIDEO_CREATOR = "SELECT COUNT(video_Creator) FROM Video_Creator video_Creator";
	private static final String _SQL_COUNT_VIDEO_CREATOR_WHERE = "SELECT COUNT(video_Creator) FROM Video_Creator video_Creator WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "video_Creator.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Video_Creator exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Video_Creator exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Video_CreatorPersistenceImpl.class);
}