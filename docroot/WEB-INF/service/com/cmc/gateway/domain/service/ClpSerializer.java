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

package com.cmc.gateway.domain.service;

import com.cmc.gateway.domain.model.AppDomainClp;
import com.cmc.gateway.domain.model.CommandActionClp;
import com.cmc.gateway.domain.model.CommandEntryClp;
import com.cmc.gateway.domain.model.ProductActionClp;
import com.cmc.gateway.domain.model.ProductCategoryClp;
import com.cmc.gateway.domain.model.ProductEntryClp;
import com.cmc.gateway.domain.model.ProductMessageClp;
import com.cmc.gateway.domain.model.ProductRouteClp;
import com.cmc.gateway.domain.model.ProvisioningActionClp;
import com.cmc.gateway.domain.model.ProvisioningEntryClp;
import com.cmc.gateway.domain.model.ProvisioningMessageClp;
import com.cmc.gateway.domain.model.ProvisioningRouteClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"cmc-gateway-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"cmc-gateway-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "cmc-gateway-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AppDomainClp.class.getName())) {
			return translateInputAppDomain(oldModel);
		}

		if (oldModelClassName.equals(CommandActionClp.class.getName())) {
			return translateInputCommandAction(oldModel);
		}

		if (oldModelClassName.equals(CommandEntryClp.class.getName())) {
			return translateInputCommandEntry(oldModel);
		}

		if (oldModelClassName.equals(ProductActionClp.class.getName())) {
			return translateInputProductAction(oldModel);
		}

		if (oldModelClassName.equals(ProductCategoryClp.class.getName())) {
			return translateInputProductCategory(oldModel);
		}

		if (oldModelClassName.equals(ProductEntryClp.class.getName())) {
			return translateInputProductEntry(oldModel);
		}

		if (oldModelClassName.equals(ProductMessageClp.class.getName())) {
			return translateInputProductMessage(oldModel);
		}

		if (oldModelClassName.equals(ProductRouteClp.class.getName())) {
			return translateInputProductRoute(oldModel);
		}

		if (oldModelClassName.equals(ProvisioningActionClp.class.getName())) {
			return translateInputProvisioningAction(oldModel);
		}

		if (oldModelClassName.equals(ProvisioningEntryClp.class.getName())) {
			return translateInputProvisioningEntry(oldModel);
		}

		if (oldModelClassName.equals(ProvisioningMessageClp.class.getName())) {
			return translateInputProvisioningMessage(oldModel);
		}

		if (oldModelClassName.equals(ProvisioningRouteClp.class.getName())) {
			return translateInputProvisioningRoute(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAppDomain(BaseModel<?> oldModel) {
		AppDomainClp oldClpModel = (AppDomainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAppDomainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCommandAction(BaseModel<?> oldModel) {
		CommandActionClp oldClpModel = (CommandActionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommandActionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCommandEntry(BaseModel<?> oldModel) {
		CommandEntryClp oldClpModel = (CommandEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCommandEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductAction(BaseModel<?> oldModel) {
		ProductActionClp oldClpModel = (ProductActionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductActionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductCategory(BaseModel<?> oldModel) {
		ProductCategoryClp oldClpModel = (ProductCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductEntry(BaseModel<?> oldModel) {
		ProductEntryClp oldClpModel = (ProductEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductMessage(BaseModel<?> oldModel) {
		ProductMessageClp oldClpModel = (ProductMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProductRoute(BaseModel<?> oldModel) {
		ProductRouteClp oldClpModel = (ProductRouteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProductRouteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProvisioningAction(BaseModel<?> oldModel) {
		ProvisioningActionClp oldClpModel = (ProvisioningActionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProvisioningActionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProvisioningEntry(BaseModel<?> oldModel) {
		ProvisioningEntryClp oldClpModel = (ProvisioningEntryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProvisioningEntryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProvisioningMessage(
		BaseModel<?> oldModel) {
		ProvisioningMessageClp oldClpModel = (ProvisioningMessageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProvisioningMessageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputProvisioningRoute(BaseModel<?> oldModel) {
		ProvisioningRouteClp oldClpModel = (ProvisioningRouteClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getProvisioningRouteRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.AppDomainImpl")) {
			return translateOutputAppDomain(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.CommandActionImpl")) {
			return translateOutputCommandAction(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.CommandEntryImpl")) {
			return translateOutputCommandEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProductActionImpl")) {
			return translateOutputProductAction(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProductCategoryImpl")) {
			return translateOutputProductCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProductEntryImpl")) {
			return translateOutputProductEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProductMessageImpl")) {
			return translateOutputProductMessage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProductRouteImpl")) {
			return translateOutputProductRoute(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProvisioningActionImpl")) {
			return translateOutputProvisioningAction(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProvisioningEntryImpl")) {
			return translateOutputProvisioningEntry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProvisioningMessageImpl")) {
			return translateOutputProvisioningMessage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.cmc.gateway.domain.model.impl.ProvisioningRouteImpl")) {
			return translateOutputProvisioningRoute(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals("com.cmc.gateway.domain.NoSuchAppDomainException")) {
			return new com.cmc.gateway.domain.NoSuchAppDomainException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchCommandActionException")) {
			return new com.cmc.gateway.domain.NoSuchCommandActionException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchCommandEntryException")) {
			return new com.cmc.gateway.domain.NoSuchCommandEntryException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProductActionException")) {
			return new com.cmc.gateway.domain.NoSuchProductActionException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProductCategoryException")) {
			return new com.cmc.gateway.domain.NoSuchProductCategoryException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProductEntryException")) {
			return new com.cmc.gateway.domain.NoSuchProductEntryException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProductMessageException")) {
			return new com.cmc.gateway.domain.NoSuchProductMessageException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProductRouteException")) {
			return new com.cmc.gateway.domain.NoSuchProductRouteException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProvisioningActionException")) {
			return new com.cmc.gateway.domain.NoSuchProvisioningActionException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProvisioningEntryException")) {
			return new com.cmc.gateway.domain.NoSuchProvisioningEntryException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProvisioningMessageException")) {
			return new com.cmc.gateway.domain.NoSuchProvisioningMessageException();
		}

		if (className.equals(
					"com.cmc.gateway.domain.NoSuchProvisioningRouteException")) {
			return new com.cmc.gateway.domain.NoSuchProvisioningRouteException();
		}

		return throwable;
	}

	public static Object translateOutputAppDomain(BaseModel<?> oldModel) {
		AppDomainClp newModel = new AppDomainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAppDomainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCommandAction(BaseModel<?> oldModel) {
		CommandActionClp newModel = new CommandActionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommandActionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCommandEntry(BaseModel<?> oldModel) {
		CommandEntryClp newModel = new CommandEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCommandEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductAction(BaseModel<?> oldModel) {
		ProductActionClp newModel = new ProductActionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductActionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductCategory(BaseModel<?> oldModel) {
		ProductCategoryClp newModel = new ProductCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductEntry(BaseModel<?> oldModel) {
		ProductEntryClp newModel = new ProductEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductMessage(BaseModel<?> oldModel) {
		ProductMessageClp newModel = new ProductMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductMessageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProductRoute(BaseModel<?> oldModel) {
		ProductRouteClp newModel = new ProductRouteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProductRouteRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProvisioningAction(
		BaseModel<?> oldModel) {
		ProvisioningActionClp newModel = new ProvisioningActionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProvisioningActionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProvisioningEntry(BaseModel<?> oldModel) {
		ProvisioningEntryClp newModel = new ProvisioningEntryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProvisioningEntryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProvisioningMessage(
		BaseModel<?> oldModel) {
		ProvisioningMessageClp newModel = new ProvisioningMessageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProvisioningMessageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputProvisioningRoute(BaseModel<?> oldModel) {
		ProvisioningRouteClp newModel = new ProvisioningRouteClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setProvisioningRouteRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}