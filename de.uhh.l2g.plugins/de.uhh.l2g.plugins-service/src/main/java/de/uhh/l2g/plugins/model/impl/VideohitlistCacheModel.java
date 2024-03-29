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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import de.uhh.l2g.plugins.model.Videohitlist;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Videohitlist in entity cache.
 *
 * @author Iavor Sturm
 * @see Videohitlist
 * @generated
 */
@ProviderType
public class VideohitlistCacheModel implements CacheModel<Videohitlist>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideohitlistCacheModel)) {
			return false;
		}

		VideohitlistCacheModel videohitlistCacheModel = (VideohitlistCacheModel)obj;

		if (videohitlistId == videohitlistCacheModel.videohitlistId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, videohitlistId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{videohitlistId=");
		sb.append(videohitlistId);
		sb.append(", hitsPerDay=");
		sb.append(hitsPerDay);
		sb.append(", hitsPerWeek=");
		sb.append(hitsPerWeek);
		sb.append(", hitsPerMonth=");
		sb.append(hitsPerMonth);
		sb.append(", hitsPerYear=");
		sb.append(hitsPerYear);
		sb.append(", videoId=");
		sb.append(videoId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Videohitlist toEntityModel() {
		VideohitlistImpl videohitlistImpl = new VideohitlistImpl();

		videohitlistImpl.setVideohitlistId(videohitlistId);
		videohitlistImpl.setHitsPerDay(hitsPerDay);
		videohitlistImpl.setHitsPerWeek(hitsPerWeek);
		videohitlistImpl.setHitsPerMonth(hitsPerMonth);
		videohitlistImpl.setHitsPerYear(hitsPerYear);
		videohitlistImpl.setVideoId(videoId);
		videohitlistImpl.setGroupId(groupId);
		videohitlistImpl.setCompanyId(companyId);
		videohitlistImpl.setUserId(userId);

		if (userName == null) {
			videohitlistImpl.setUserName(StringPool.BLANK);
		}
		else {
			videohitlistImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videohitlistImpl.setCreateDate(null);
		}
		else {
			videohitlistImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videohitlistImpl.setModifiedDate(null);
		}
		else {
			videohitlistImpl.setModifiedDate(new Date(modifiedDate));
		}

		videohitlistImpl.resetOriginalValues();

		return videohitlistImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		videohitlistId = objectInput.readLong();

		hitsPerDay = objectInput.readLong();

		hitsPerWeek = objectInput.readLong();

		hitsPerMonth = objectInput.readLong();

		hitsPerYear = objectInput.readLong();

		videoId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(videohitlistId);

		objectOutput.writeLong(hitsPerDay);

		objectOutput.writeLong(hitsPerWeek);

		objectOutput.writeLong(hitsPerMonth);

		objectOutput.writeLong(hitsPerYear);

		objectOutput.writeLong(videoId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long videohitlistId;
	public long hitsPerDay;
	public long hitsPerWeek;
	public long hitsPerMonth;
	public long hitsPerYear;
	public long videoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}