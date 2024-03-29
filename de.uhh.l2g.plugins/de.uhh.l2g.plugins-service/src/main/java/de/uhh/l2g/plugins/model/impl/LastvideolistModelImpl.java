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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.uhh.l2g.plugins.model.Lastvideolist;
import de.uhh.l2g.plugins.model.LastvideolistModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Lastvideolist service. Represents a row in the &quot;LG_Lastvideolist&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link LastvideolistModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LastvideolistImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see LastvideolistImpl
 * @see Lastvideolist
 * @see LastvideolistModel
 * @generated
 */
@ProviderType
public class LastvideolistModelImpl extends BaseModelImpl<Lastvideolist>
	implements LastvideolistModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lastvideolist model instance should use the {@link Lastvideolist} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Lastvideolist";
	public static final Object[][] TABLE_COLUMNS = {
			{ "lastvideolistId", Types.INTEGER },
			{ "videoId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("lastvideolistId", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("videoId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table LG_Lastvideolist (lastvideolistId INTEGER not null primary key,videoId LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table LG_Lastvideolist";
	public static final String ORDER_BY_JPQL = " ORDER BY lastvideolist.lastvideolistId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Lastvideolist.lastvideolistId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Lastvideolist"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Lastvideolist"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Lastvideolist"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long VIDEOID_COLUMN_BITMASK = 4L;
	public static final long LASTVIDEOLISTID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Lastvideolist"));

	public LastvideolistModelImpl() {
	}

	@Override
	public int getPrimaryKey() {
		return _lastvideolistId;
	}

	@Override
	public void setPrimaryKey(int primaryKey) {
		setLastvideolistId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _lastvideolistId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Lastvideolist.class;
	}

	@Override
	public String getModelClassName() {
		return Lastvideolist.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("lastvideolistId", getLastvideolistId());
		attributes.put("videoId", getVideoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer lastvideolistId = (Integer)attributes.get("lastvideolistId");

		if (lastvideolistId != null) {
			setLastvideolistId(lastvideolistId);
		}

		Long videoId = (Long)attributes.get("videoId");

		if (videoId != null) {
			setVideoId(videoId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public int getLastvideolistId() {
		return _lastvideolistId;
	}

	@Override
	public void setLastvideolistId(int lastvideolistId) {
		_lastvideolistId = lastvideolistId;
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Lastvideolist toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Lastvideolist)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		LastvideolistImpl lastvideolistImpl = new LastvideolistImpl();

		lastvideolistImpl.setLastvideolistId(getLastvideolistId());
		lastvideolistImpl.setVideoId(getVideoId());
		lastvideolistImpl.setGroupId(getGroupId());
		lastvideolistImpl.setCompanyId(getCompanyId());
		lastvideolistImpl.setUserId(getUserId());
		lastvideolistImpl.setUserName(getUserName());
		lastvideolistImpl.setCreateDate(getCreateDate());
		lastvideolistImpl.setModifiedDate(getModifiedDate());

		lastvideolistImpl.resetOriginalValues();

		return lastvideolistImpl;
	}

	@Override
	public int compareTo(Lastvideolist lastvideolist) {
		int primaryKey = lastvideolist.getPrimaryKey();

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

		if (!(obj instanceof Lastvideolist)) {
			return false;
		}

		Lastvideolist lastvideolist = (Lastvideolist)obj;

		int primaryKey = lastvideolist.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
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
		LastvideolistModelImpl lastvideolistModelImpl = this;

		lastvideolistModelImpl._originalVideoId = lastvideolistModelImpl._videoId;

		lastvideolistModelImpl._setOriginalVideoId = false;

		lastvideolistModelImpl._originalGroupId = lastvideolistModelImpl._groupId;

		lastvideolistModelImpl._setOriginalGroupId = false;

		lastvideolistModelImpl._originalCompanyId = lastvideolistModelImpl._companyId;

		lastvideolistModelImpl._setOriginalCompanyId = false;

		lastvideolistModelImpl._setModifiedDate = false;

		lastvideolistModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Lastvideolist> toCacheModel() {
		LastvideolistCacheModel lastvideolistCacheModel = new LastvideolistCacheModel();

		lastvideolistCacheModel.lastvideolistId = getLastvideolistId();

		lastvideolistCacheModel.videoId = getVideoId();

		lastvideolistCacheModel.groupId = getGroupId();

		lastvideolistCacheModel.companyId = getCompanyId();

		lastvideolistCacheModel.userId = getUserId();

		lastvideolistCacheModel.userName = getUserName();

		String userName = lastvideolistCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			lastvideolistCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			lastvideolistCacheModel.createDate = createDate.getTime();
		}
		else {
			lastvideolistCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			lastvideolistCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			lastvideolistCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return lastvideolistCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{lastvideolistId=");
		sb.append(getLastvideolistId());
		sb.append(", videoId=");
		sb.append(getVideoId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Lastvideolist");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>lastvideolistId</column-name><column-value><![CDATA[");
		sb.append(getLastvideolistId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoId</column-name><column-value><![CDATA[");
		sb.append(getVideoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Lastvideolist.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Lastvideolist.class
		};
	private int _lastvideolistId;
	private long _videoId;
	private long _originalVideoId;
	private boolean _setOriginalVideoId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _columnBitmask;
	private Lastvideolist _escapedModel;
}