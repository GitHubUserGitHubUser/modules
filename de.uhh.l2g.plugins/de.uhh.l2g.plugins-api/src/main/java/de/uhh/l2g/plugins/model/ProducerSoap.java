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
public class ProducerSoap implements Serializable {
	public static ProducerSoap toSoapModel(Producer model) {
		ProducerSoap soapModel = new ProducerSoap();

		soapModel.setProducerId(model.getProducerId());
		soapModel.setIdNum(model.getIdNum());
		soapModel.setHomeDir(model.getHomeDir());
		soapModel.setHostId(model.getHostId());
		soapModel.setInstitutionId(model.getInstitutionId());
		soapModel.setNumberOfProductions(model.getNumberOfProductions());
		soapModel.setApproved(model.getApproved());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static ProducerSoap[] toSoapModels(Producer[] models) {
		ProducerSoap[] soapModels = new ProducerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProducerSoap[][] toSoapModels(Producer[][] models) {
		ProducerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProducerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProducerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProducerSoap[] toSoapModels(List<Producer> models) {
		List<ProducerSoap> soapModels = new ArrayList<ProducerSoap>(models.size());

		for (Producer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProducerSoap[soapModels.size()]);
	}

	public ProducerSoap() {
	}

	public long getPrimaryKey() {
		return _producerId;
	}

	public void setPrimaryKey(long pk) {
		setProducerId(pk);
	}

	public long getProducerId() {
		return _producerId;
	}

	public void setProducerId(long producerId) {
		_producerId = producerId;
	}

	public String getIdNum() {
		return _idNum;
	}

	public void setIdNum(String idNum) {
		_idNum = idNum;
	}

	public String getHomeDir() {
		return _homeDir;
	}

	public void setHomeDir(String homeDir) {
		_homeDir = homeDir;
	}

	public long getHostId() {
		return _hostId;
	}

	public void setHostId(long hostId) {
		_hostId = hostId;
	}

	public long getInstitutionId() {
		return _institutionId;
	}

	public void setInstitutionId(long institutionId) {
		_institutionId = institutionId;
	}

	public long getNumberOfProductions() {
		return _numberOfProductions;
	}

	public void setNumberOfProductions(long numberOfProductions) {
		_numberOfProductions = numberOfProductions;
	}

	public int getApproved() {
		return _approved;
	}

	public void setApproved(int approved) {
		_approved = approved;
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

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private long _producerId;
	private String _idNum;
	private String _homeDir;
	private long _hostId;
	private long _institutionId;
	private long _numberOfProductions;
	private int _approved;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}