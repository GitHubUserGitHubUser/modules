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
import de.uhh.l2g.plugins.model.Lectureseries_Category;
import de.uhh.l2g.plugins.service.Lectureseries_CategoryLocalServiceUtil;

/**
 * The extended model base implementation for the Lectureseries_Category service. Represents a row in the &quot;LG_Lectureseries_Category&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Lectureseries_CategoryImpl}.
 * </p>
 *
 * @author Iavor Sturm
 * @see Lectureseries_CategoryImpl
 * @see Lectureseries_Category
 * @generated
 */
@ProviderType
public abstract class Lectureseries_CategoryBaseImpl
	extends Lectureseries_CategoryModelImpl implements Lectureseries_Category {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lectureseries_ category model instance should use the {@link Lectureseries_Category} interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			Lectureseries_CategoryLocalServiceUtil.addLectureseries_Category(this);
		}
		else {
			Lectureseries_CategoryLocalServiceUtil.updateLectureseries_Category(this);
		}
	}
}