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

package de.uhh.l2g.plugins.model.impl;

import java.io.Serializable;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.model.Video_Lectureseries;
import de.uhh.l2g.plugins.model.Video_LectureseriesModel;

/**
 * The base model implementation for the Video_Lectureseries service. Represents a row in the &quot;LG_Video_Lectureseries&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link Video_LectureseriesModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Video_LectureseriesImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Video_LectureseriesImpl
 * @see Video_Lectureseries
 * @see Video_LectureseriesModel
 * @generated
 */
@ProviderType
public class Video_LectureseriesModelImpl extends BaseModelImpl<Video_Lectureseries>
	implements Video_LectureseriesModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video_ lectureseries model instance should use the {@link Video_Lectureseries} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Video_Lectureseries";
	public static final Object[][] TABLE_COLUMNS = {
			{ "videoLectureseriesId", Types.BIGINT },
			{ "videoId", Types.BIGINT },
			{ "lectureseriesId", Types.BIGINT },
			{ "openAccess", Types.INTEGER }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("videoLectureseriesId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("videoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("lectureseriesId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("openAccess", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE = "create table LG_Video_Lectureseries (videoLectureseriesId LONG not null primary key,videoId LONG,lectureseriesId LONG,openAccess INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table LG_Video_Lectureseries";
	public static final String ORDER_BY_JPQL = " ORDER BY video_Lectureseries.videoLectureseriesId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Video_Lectureseries.videoLectureseriesId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Video_Lectureseries"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Video_Lectureseries"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Video_Lectureseries"),
			true);
	public static final long LECTURESERIESID_COLUMN_BITMASK = 1L;
	public static final long OPENACCESS_COLUMN_BITMASK = 2L;
	public static final long VIDEOID_COLUMN_BITMASK = 4L;
	public static final long VIDEOLECTURESERIESID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Video_Lectureseries"));

	public Video_LectureseriesModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _videoLectureseriesId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setVideoLectureseriesId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _videoLectureseriesId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Video_Lectureseries.class;
	}

	@Override
	public String getModelClassName() {
		return Video_Lectureseries.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("videoLectureseriesId", getVideoLectureseriesId());
		attributes.put("videoId", getVideoId());
		attributes.put("lectureseriesId", getLectureseriesId());
		attributes.put("openAccess", getOpenAccess());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long videoLectureseriesId = (Long)attributes.get("videoLectureseriesId");

		if (videoLectureseriesId != null) {
			setVideoLectureseriesId(videoLectureseriesId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long lectureseriesId = (Long)attributes.get("lectureseriesId");

		if (lectureseriesId != null) {
			setLectureseriesId(lectureseriesId);
		}

		Integer openAccess = (Integer)attributes.get("openAccess");

		if (openAccess != null) {
			setOpenAccess(openAccess);
		}
	}

	@Override
	public long getVideoLectureseriesId() {
		return _videoLectureseriesId;
	}

	@Override
	public void setVideoLectureseriesId(long videoLectureseriesId) {
		_videoLectureseriesId = videoLectureseriesId;
	}

	@Override
	public long getVideoId() {
		return _videoId;
	}

	@Override
	public void setVideoId(long videoId) {
		_columnBitmask |= VIDEOID_COLUMN_BITMASK;

		if (!_setOriginalVideoId) {
			_setOriginalVideoId = true;

			_originalVideoId = _videoId;
		}

		_videoId = videoId;
	}

	public long getOriginalVideoId() {
		return _originalVideoId;
	}

	@Override
	public long getLectureseriesId() {
		return _lectureseriesId;
	}

	@Override
	public void setLectureseriesId(long lectureseriesId) {
		_columnBitmask |= LECTURESERIESID_COLUMN_BITMASK;

		if (!_setOriginalLectureseriesId) {
			_setOriginalLectureseriesId = true;

			_originalLectureseriesId = _lectureseriesId;
		}

		_lectureseriesId = lectureseriesId;
	}

	public long getOriginalLectureseriesId() {
		return _originalLectureseriesId;
	}

	@Override
	public int getOpenAccess() {
		return _openAccess;
	}

	@Override
	public void setOpenAccess(int openAccess) {
		_columnBitmask |= OPENACCESS_COLUMN_BITMASK;

		if (!_setOriginalOpenAccess) {
			_setOriginalOpenAccess = true;

			_originalOpenAccess = _openAccess;
		}

		_openAccess = openAccess;
	}

	public int getOriginalOpenAccess() {
		return _originalOpenAccess;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Video_Lectureseries.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Video_Lectureseries toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Video_Lectureseries)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		Video_LectureseriesImpl video_LectureseriesImpl = new Video_LectureseriesImpl();

		video_LectureseriesImpl.setVideoLectureseriesId(getVideoLectureseriesId());
		video_LectureseriesImpl.setVideoId(getVideoId());
		video_LectureseriesImpl.setLectureseriesId(getLectureseriesId());
		video_LectureseriesImpl.setOpenAccess(getOpenAccess());

		video_LectureseriesImpl.resetOriginalValues();

		return video_LectureseriesImpl;
	}

	@Override
	public int compareTo(Video_Lectureseries video_Lectureseries) {
		long primaryKey = video_Lectureseries.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Video_Lectureseries)) {
			return false;
		}

		Video_Lectureseries video_Lectureseries = (Video_Lectureseries)obj;

		long primaryKey = video_Lectureseries.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		Video_LectureseriesModelImpl video_LectureseriesModelImpl = this;

		video_LectureseriesModelImpl._originalVideoId = video_LectureseriesModelImpl._videoId;

		video_LectureseriesModelImpl._setOriginalVideoId = false;

		video_LectureseriesModelImpl._originalLectureseriesId = video_LectureseriesModelImpl._lectureseriesId;

		video_LectureseriesModelImpl._setOriginalLectureseriesId = false;

		video_LectureseriesModelImpl._originalOpenAccess = video_LectureseriesModelImpl._openAccess;

		video_LectureseriesModelImpl._setOriginalOpenAccess = false;

		video_LectureseriesModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Video_Lectureseries> toCacheModel() {
		Video_LectureseriesCacheModel video_LectureseriesCacheModel = new Video_LectureseriesCacheModel();

		video_LectureseriesCacheModel.videoLectureseriesId = getVideoLectureseriesId();

		video_LectureseriesCacheModel.videoId = getVideoId();

		video_LectureseriesCacheModel.lectureseriesId = getLectureseriesId();

		video_LectureseriesCacheModel.openAccess = getOpenAccess();

		return video_LectureseriesCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{videoLectureseriesId=");
		sb.append(getVideoLectureseriesId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", lectureseriesId=");
		sb.append(getLectureseriesId());
		sb.append(", openAccess=");
		sb.append(getOpenAccess());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Video_Lectureseries");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>videoLectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getVideoLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lectureseriesId</column-name><column-value><![CDATA[");
		sb.append(getLectureseriesId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openAccess</column-name><column-value><![CDATA[");
		sb.append(getOpenAccess());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Video_Lectureseries.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Video_Lectureseries.class
		};
	private long _videoLectureseriesId;
	private long _videoId;
	private long _originalVideoId;
	private boolean _setOriginalVideoId;
	private long _lectureseriesId;
	private long _originalLectureseriesId;
	private boolean _setOriginalLectureseriesId;
	private int _openAccess;
	private int _originalOpenAccess;
	private boolean _setOriginalOpenAccess;
	private long _columnBitmask;
	private Video_Lectureseries _escapedModel;
}