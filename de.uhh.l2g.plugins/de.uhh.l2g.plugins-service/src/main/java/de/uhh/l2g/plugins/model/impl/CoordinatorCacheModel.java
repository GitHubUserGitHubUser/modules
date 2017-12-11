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

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import aQute.bnd.annotation.ProviderType;
import de.uhh.l2g.plugins.model.Coordinator;

/**
 * The cache model class for representing Coordinator in entity cache.
 *
 * @author Iavor Sturm
 * @see Coordinator
 * @generated
 */
@ProviderType
public class CoordinatorCacheModel implements CacheModel<Coordinator>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CoordinatorCacheModel)) {
			return false;
		}

		CoordinatorCacheModel coordinatorCacheModel = (CoordinatorCacheModel)obj;

		if (coordinatorId == coordinatorCacheModel.coordinatorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, coordinatorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{coordinatorId=");
		sb.append(coordinatorId);
		sb.append(", institutionId=");
		sb.append(institutionId);
		sb.append(", officeId=");
		sb.append(officeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Coordinator toEntityModel() {
		CoordinatorImpl coordinatorImpl = new CoordinatorImpl();

		coordinatorImpl.setCoordinatorId(coordinatorId);
		coordinatorImpl.setInstitutionId(institutionId);
		coordinatorImpl.setOfficeId(officeId);

		coordinatorImpl.resetOriginalValues();

		return coordinatorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		coordinatorId = objectInput.readLong();

		institutionId = objectInput.readLong();

		officeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(coordinatorId);

		objectOutput.writeLong(institutionId);

		objectOutput.writeLong(officeId);
	}

	public long coordinatorId;
	public long institutionId;
	public long officeId;
}