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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.uhh.l2g.plugins.model.Category;
import de.uhh.l2g.plugins.model.CategoryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Category service. Represents a row in the &quot;LG_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link CategoryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CategoryImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see CategoryImpl
 * @see Category
 * @see CategoryModel
 * @generated
 */
@ProviderType
public class CategoryModelImpl extends BaseModelImpl<Category>
	implements CategoryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a category model instance should use the {@link Category} interface instead.
	 */
	public static final String TABLE_NAME = "LG_Category";
	public static final Object[][] TABLE_COLUMNS = {
			{ "categoryId", Types.BIGINT },
			{ "parentId", Types.BIGINT },
			{ "languageId", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "translation", Types.VARCHAR },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("categoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("parentId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("languageId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("translation", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table LG_Category (categoryId LONG not null primary key,parentId LONG,languageId VARCHAR(75) null,name VARCHAR(75) null,translation VARCHAR(75) null,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table LG_Category";
	public static final String ORDER_BY_JPQL = " ORDER BY category.categoryId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY LG_Category.categoryId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.de.uhh.l2g.plugins.model.Category"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.de.uhh.l2g.plugins.model.Category"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.de.uhh.l2g.plugins.model.Category"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long GROUPID_COLUMN_BITMASK = 2L;
	public static final long NAME_COLUMN_BITMASK = 4L;
	public static final long CATEGORYID_COLUMN_BITMASK = 8L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(de.uhh.l2g.plugins.service.util.ServiceProps.get(
				"lock.expiration.time.de.uhh.l2g.plugins.model.Category"));

	public CategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _categoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Category.class;
	}

	@Override
	public String getModelClassName() {
		return Category.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("parentId", getParentId());
		attributes.put("languageId", getLanguageId());
		attributes.put("name", getName());
		attributes.put("translation", getTranslation());
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
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String translation = (String)attributes.get("translation");

		if (translation != null) {
			setTranslation(translation);
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
	public long getCategoryId() {
		return _categoryId;
	}

	@Override
	public void setCategoryId(long categoryId) {
		_columnBitmask = -1L;

		_categoryId = categoryId;
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return StringPool.BLANK;
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@Override
	public String getTranslation() {
		if (_translation == null) {
			return StringPool.BLANK;
		}
		else {
			return _translation;
		}
	}

	@Override
	public void setTranslation(String translation) {
		_translation = translation;
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
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Category.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Category toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Category)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CategoryImpl categoryImpl = new CategoryImpl();

		categoryImpl.setCategoryId(getCategoryId());
		categoryImpl.setParentId(getParentId());
		categoryImpl.setLanguageId(getLanguageId());
		categoryImpl.setName(getName());
		categoryImpl.setTranslation(getTranslation());
		categoryImpl.setGroupId(getGroupId());
		categoryImpl.setCompanyId(getCompanyId());
		categoryImpl.setUserId(getUserId());
		categoryImpl.setUserName(getUserName());
		categoryImpl.setCreateDate(getCreateDate());
		categoryImpl.setModifiedDate(getModifiedDate());

		categoryImpl.resetOriginalValues();

		return categoryImpl;
	}

	@Override
	public int compareTo(Category category) {
		int value = 0;

		if (getCategoryId() < category.getCategoryId()) {
			value = -1;
		}
		else if (getCategoryId() > category.getCategoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Category)) {
			return false;
		}

		Category category = (Category)obj;

		long primaryKey = category.getPrimaryKey();

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
		CategoryModelImpl categoryModelImpl = this;

		categoryModelImpl._originalName = categoryModelImpl._name;

		categoryModelImpl._originalGroupId = categoryModelImpl._groupId;

		categoryModelImpl._setOriginalGroupId = false;

		categoryModelImpl._originalCompanyId = categoryModelImpl._companyId;

		categoryModelImpl._setOriginalCompanyId = false;

		categoryModelImpl._setModifiedDate = false;

		categoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Category> toCacheModel() {
		CategoryCacheModel categoryCacheModel = new CategoryCacheModel();

		categoryCacheModel.categoryId = getCategoryId();

		categoryCacheModel.parentId = getParentId();

		categoryCacheModel.languageId = getLanguageId();

		String languageId = categoryCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			categoryCacheModel.languageId = null;
		}

		categoryCacheModel.name = getName();

		String name = categoryCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			categoryCacheModel.name = null;
		}

		categoryCacheModel.translation = getTranslation();

		String translation = categoryCacheModel.translation;

		if ((translation != null) && (translation.length() == 0)) {
			categoryCacheModel.translation = null;
		}

		categoryCacheModel.groupId = getGroupId();

		categoryCacheModel.companyId = getCompanyId();

		categoryCacheModel.userId = getUserId();

		categoryCacheModel.userName = getUserName();

		String userName = categoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			categoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			categoryCacheModel.createDate = createDate.getTime();
		}
		else {
			categoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			categoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			categoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return categoryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{categoryId=");
		sb.append(getCategoryId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", translation=");
		sb.append(getTranslation());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("de.uhh.l2g.plugins.model.Category");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>categoryId</column-name><column-value><![CDATA[");
		sb.append(getCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>translation</column-name><column-value><![CDATA[");
		sb.append(getTranslation());
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

	private static final ClassLoader _classLoader = Category.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Category.class
		};
	private long _categoryId;
	private long _parentId;
	private String _languageId;
	private String _name;
	private String _originalName;
	private String _translation;
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
	private Category _escapedModel;
}