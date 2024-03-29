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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Iavor Sturm
 * @generated
 */
@ProviderType
public class StatisticSoap implements Serializable {
	public static StatisticSoap toSoapModel(Statistic model) {
		StatisticSoap soapModel = new StatisticSoap();

		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setPublicVideos(model.getPublicVideos());
		soapModel.setPrivateVideos(model.getPrivateVideos());
		soapModel.setAutofillRow(model.getAutofillRow());
		soapModel.setStatisticId(model.getStatisticId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static StatisticSoap[] toSoapModels(Statistic[] models) {
		StatisticSoap[] soapModels = new StatisticSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StatisticSoap[][] toSoapModels(Statistic[][] models) {
		StatisticSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StatisticSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StatisticSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StatisticSoap[] toSoapModels(List<Statistic> models) {
		List<StatisticSoap> soapModels = new ArrayList<StatisticSoap>(models.size());

		for (Statistic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StatisticSoap[soapModels.size()]);
	}

	public StatisticSoap() {
	}

	public long getPrimaryKey() {
		return _statisticId;
	}

	public void setPrimaryKey(long pk) {
		setStatisticId(pk);
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public int getPublicVideos() {
		return _publicVideos;
	}

	public void setPublicVideos(int publicVideos) {
		_publicVideos = publicVideos;
	}

	public int getPrivateVideos() {
		return _privateVideos;
	}

	public void setPrivateVideos(int privateVideos) {
		_privateVideos = privateVideos;
	}

	public int getAutofillRow() {
		return _autofillRow;
	}

	public void setAutofillRow(int autofillRow) {
		_autofillRow = autofillRow;
	}

	public long getStatisticId() {
		return _statisticId;
	}

	public void setStatisticId(long statisticId) {
		_statisticId = statisticId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private Date _createDate;
	private int _publicVideos;
	private int _privateVideos;
	private int _autofillRow;
	private long _statisticId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _modifiedDate;
}