/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.cmc.gateway.domain.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the CommandAction service. Represents a row in the &quot;GW_CommandAction&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.cmc.gateway.domain.model.impl.CommandActionModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.cmc.gateway.domain.model.impl.CommandActionImpl}.
 * </p>
 *
 * @author Richard Nguyen
 * @see CommandAction
 * @see com.cmc.gateway.domain.model.impl.CommandActionImpl
 * @see com.cmc.gateway.domain.model.impl.CommandActionModelImpl
 * @generated
 */
public interface CommandActionModel extends BaseModel<CommandAction> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a command action model instance should use the {@link CommandAction} interface instead.
	 */

	/**
	 * Returns the primary key of this command action.
	 *
	 * @return the primary key of this command action
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this command action.
	 *
	 * @param primaryKey the primary key of this command action
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the action ID of this command action.
	 *
	 * @return the action ID of this command action
	 */
	public long getActionId();

	/**
	 * Sets the action ID of this command action.
	 *
	 * @param actionId the action ID of this command action
	 */
	public void setActionId(long actionId);

	/**
	 * Returns the group ID of this command action.
	 *
	 * @return the group ID of this command action
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this command action.
	 *
	 * @param groupId the group ID of this command action
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this command action.
	 *
	 * @return the company ID of this command action
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this command action.
	 *
	 * @param companyId the company ID of this command action
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this command action.
	 *
	 * @return the user ID of this command action
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this command action.
	 *
	 * @param userId the user ID of this command action
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this command action.
	 *
	 * @return the user uuid of this command action
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this command action.
	 *
	 * @param userUuid the user uuid of this command action
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this command action.
	 *
	 * @return the create date of this command action
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this command action.
	 *
	 * @param createDate the create date of this command action
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this command action.
	 *
	 * @return the modified date of this command action
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this command action.
	 *
	 * @param modifiedDate the modified date of this command action
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the command ID of this command action.
	 *
	 * @return the command ID of this command action
	 */
	public long getCommandId();

	/**
	 * Sets the command ID of this command action.
	 *
	 * @param commandId the command ID of this command action
	 */
	public void setCommandId(long commandId);

	/**
	 * Returns the product ID of this command action.
	 *
	 * @return the product ID of this command action
	 */
	public long getProductId();

	/**
	 * Sets the product ID of this command action.
	 *
	 * @param productId the product ID of this command action
	 */
	public void setProductId(long productId);

	/**
	 * Returns the action type of this command action.
	 *
	 * @return the action type of this command action
	 */
	@AutoEscape
	public String getActionType();

	/**
	 * Sets the action type of this command action.
	 *
	 * @param actionType the action type of this command action
	 */
	public void setActionType(String actionType);

	/**
	 * Returns the subscriber type of this command action.
	 *
	 * @return the subscriber type of this command action
	 */
	public int getSubscriberType();

	/**
	 * Sets the subscriber type of this command action.
	 *
	 * @param subscriberType the subscriber type of this command action
	 */
	public void setSubscriberType(int subscriberType);

	/**
	 * Returns the action name of this command action.
	 *
	 * @return the action name of this command action
	 */
	@AutoEscape
	public String getActionName();

	/**
	 * Sets the action name of this command action.
	 *
	 * @param actionName the action name of this command action
	 */
	public void setActionName(String actionName);

	/**
	 * Returns the next action type of this command action.
	 *
	 * @return the next action type of this command action
	 */
	@AutoEscape
	public String getNextActionType();

	/**
	 * Sets the next action type of this command action.
	 *
	 * @param nextActionType the next action type of this command action
	 */
	public void setNextActionType(String nextActionType);

	/**
	 * Returns the next command ID of this command action.
	 *
	 * @return the next command ID of this command action
	 */
	public long getNextCommandId();

	/**
	 * Sets the next command ID of this command action.
	 *
	 * @param nextCommandId the next command ID of this command action
	 */
	public void setNextCommandId(long nextCommandId);

	/**
	 * Returns the process class of this command action.
	 *
	 * @return the process class of this command action
	 */
	@AutoEscape
	public String getProcessClass();

	/**
	 * Sets the process class of this command action.
	 *
	 * @param processClass the process class of this command action
	 */
	public void setProcessClass(String processClass);

	/**
	 * Returns the process method of this command action.
	 *
	 * @return the process method of this command action
	 */
	@AutoEscape
	public String getProcessMethod();

	/**
	 * Sets the process method of this command action.
	 *
	 * @param processMethod the process method of this command action
	 */
	public void setProcessMethod(String processMethod);

	/**
	 * Returns the properties of this command action.
	 *
	 * @return the properties of this command action
	 */
	@AutoEscape
	public String getProperties();

	/**
	 * Sets the properties of this command action.
	 *
	 * @param properties the properties of this command action
	 */
	public void setProperties(String properties);

	/**
	 * Returns the description of this command action.
	 *
	 * @return the description of this command action
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this command action.
	 *
	 * @param description the description of this command action
	 */
	public void setDescription(String description);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(CommandAction commandAction);

	public int hashCode();

	public CacheModel<CommandAction> toCacheModel();

	public CommandAction toEscapedModel();

	public String toString();

	public String toXmlString();
}