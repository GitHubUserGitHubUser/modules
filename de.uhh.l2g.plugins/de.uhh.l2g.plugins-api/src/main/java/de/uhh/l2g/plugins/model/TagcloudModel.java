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

package de.uhh.l2g.plugins.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Tagcloud service. Represents a row in the &quot;LG_Tagcloud&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link de.uhh.l2g.plugins.model.impl.TagcloudModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link de.uhh.l2g.plugins.model.impl.TagcloudImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Tagcloud
 * @see de.uhh.l2g.plugins.model.impl.TagcloudImpl
 * @see de.uhh.l2g.plugins.model.impl.TagcloudModelImpl
 * @generated
 */
@ProviderType
public interface TagcloudModel extends BaseModel<Tagcloud>, GroupedModel,
	ShardedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tagcloud model instance should use the {@link Tagcloud} interface instead.
	 */

	/**
	 * Returns the primary key of this tagcloud.
	 *
	 * @return the primary key of this tagcloud
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tagcloud.
	 *
	 * @param primaryKey the primary key of this tagcloud
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the tagcloud ID of this tagcloud.
	 *
	 * @return the tagcloud ID of this tagcloud
	 */
	public long getTagcloudId();

	/**
	 * Sets the tagcloud ID of this tagcloud.
	 *
	 * @param tagcloudId the tagcloud ID of this tagcloud
	 */
	public void setTagcloudId(long tagcloudId);

	/**
	 * Returns the object class type of this tagcloud.
	 *
	 * @return the object class type of this tagcloud
	 */
	@AutoEscape
	public String getObjectClassType();

	/**
	 * Sets the object class type of this tagcloud.
	 *
	 * @param objectClassType the object class type of this tagcloud
	 */
	public void setObjectClassType(String objectClassType);

	/**
	 * Returns the object ID of this tagcloud.
	 *
	 * @return the object ID of this tagcloud
	 */
	public long getObjectId();

	/**
	 * Sets the object ID of this tagcloud.
	 *
	 * @param objectId the object ID of this tagcloud
	 */
	public void setObjectId(long objectId);

	/**
	 * Returns the tags of this tagcloud.
	 *
	 * @return the tags of this tagcloud
	 */
	@AutoEscape
	public String getTags();

	/**
	 * Sets the tags of this tagcloud.
	 *
	 * @param tags the tags of this tagcloud
	 */
	public void setTags(String tags);

	/**
	 * Returns the group ID of this tagcloud.
	 *
	 * @return the group ID of this tagcloud
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this tagcloud.
	 *
	 * @param groupId the group ID of this tagcloud
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this tagcloud.
	 *
	 * @return the company ID of this tagcloud
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this tagcloud.
	 *
	 * @param companyId the company ID of this tagcloud
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this tagcloud.
	 *
	 * @return the user ID of this tagcloud
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this tagcloud.
	 *
	 * @param userId the user ID of this tagcloud
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this tagcloud.
	 *
	 * @return the user uuid of this tagcloud
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this tagcloud.
	 *
	 * @param userUuid the user uuid of this tagcloud
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this tagcloud.
	 *
	 * @return the user name of this tagcloud
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this tagcloud.
	 *
	 * @param userName the user name of this tagcloud
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this tagcloud.
	 *
	 * @return the create date of this tagcloud
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this tagcloud.
	 *
	 * @param createDate the create date of this tagcloud
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this tagcloud.
	 *
	 * @return the modified date of this tagcloud
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this tagcloud.
	 *
	 * @param modifiedDate the modified date of this tagcloud
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(de.uhh.l2g.plugins.model.Tagcloud tagcloud);

	@Override
	public int hashCode();

	@Override
	public CacheModel<de.uhh.l2g.plugins.model.Tagcloud> toCacheModel();

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud toEscapedModel();

	@Override
	public de.uhh.l2g.plugins.model.Tagcloud toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}