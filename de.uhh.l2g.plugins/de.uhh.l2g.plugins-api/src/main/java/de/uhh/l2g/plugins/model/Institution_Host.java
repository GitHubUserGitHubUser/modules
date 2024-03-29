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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Institution_Host service. Represents a row in the &quot;LG_Institution_Host&quot; database table, with each column mapped to a property of this class.
 *
 * @author Iavor Sturm
 * @see Institution_HostModel
 * @see de.uhh.l2g.plugins.model.impl.Institution_HostImpl
 * @see de.uhh.l2g.plugins.model.impl.Institution_HostModelImpl
 * @generated
 */
@ImplementationClassName("de.uhh.l2g.plugins.model.impl.Institution_HostImpl")
@ProviderType
public interface Institution_Host extends Institution_HostModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link de.uhh.l2g.plugins.model.impl.Institution_HostImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Institution_Host, Long> INSTITUTION_HOST_ID_ACCESSOR =
		new Accessor<Institution_Host, Long>() {
			@Override
			public Long get(Institution_Host institution_Host) {
				return institution_Host.getInstitutionHostId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Institution_Host> getTypeClass() {
				return Institution_Host.class;
			}
		};
}