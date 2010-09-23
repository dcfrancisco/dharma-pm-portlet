/**
 * Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
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

package com.dharma.service;

import com.dharma.model.PMBlockedUserClp;
import com.dharma.model.PMDeletedMessageClp;
import com.dharma.model.PMMessageClp;
import com.dharma.model.PMReadMessageClp;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.BaseModel;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class ClpSerializer {
	public static final String SERVLET_CONTEXT_NAME = "dharma-pm-portlet";

	public static void setClassLoader(ClassLoader classLoader) {
		_classLoader = classLoader;
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(PMMessageClp.class.getName())) {
			PMMessageClp oldCplModel = (PMMessageClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.dharma.model.impl.PMMessageImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setMessageId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getMessageId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setSubject",
							new Class[] { String.class });

					String value1 = oldCplModel.getSubject();

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setBody",
							new Class[] { String.class });

					String value2 = oldCplModel.getBody();

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setParentMessageId",
							new Class[] { Long.TYPE });

					Long value3 = new Long(oldCplModel.getParentMessageId());

					method3.invoke(newModel, value3);

					Method method4 = newModelClass.getMethod("setOwnerId",
							new Class[] { Long.TYPE });

					Long value4 = new Long(oldCplModel.getOwnerId());

					method4.invoke(newModel, value4);

					Method method5 = newModelClass.getMethod("setOwnerName",
							new Class[] { String.class });

					String value5 = oldCplModel.getOwnerName();

					method5.invoke(newModel, value5);

					Method method6 = newModelClass.getMethod("setPostedDate",
							new Class[] { Date.class });

					Date value6 = oldCplModel.getPostedDate();

					method6.invoke(newModel, value6);

					Method method7 = newModelClass.getMethod("setRecepients",
							new Class[] { String.class });

					String value7 = oldCplModel.getRecepients();

					method7.invoke(newModel, value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(PMDeletedMessageClp.class.getName())) {
			PMDeletedMessageClp oldCplModel = (PMDeletedMessageClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.dharma.model.impl.PMDeletedMessageImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setDeletedMessageId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getDeletedMessageId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setMessageId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getMessageId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setOwnerId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getOwnerId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setDeletedDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getDeletedDate();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(PMReadMessageClp.class.getName())) {
			PMReadMessageClp oldCplModel = (PMReadMessageClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.dharma.model.impl.PMReadMessageImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setReadMessageId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getReadMessageId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setMessageId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getMessageId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setReadDate",
							new Class[] { Date.class });

					Date value2 = oldCplModel.getReadDate();

					method2.invoke(newModel, value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(PMBlockedUserClp.class.getName())) {
			PMBlockedUserClp oldCplModel = (PMBlockedUserClp)oldModel;

			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					Class<?> newModelClass = Class.forName("com.dharma.model.impl.PMBlockedUserImpl",
							true, _classLoader);

					Object newModel = newModelClass.newInstance();

					Method method0 = newModelClass.getMethod("setBlockedUserId",
							new Class[] { Long.TYPE });

					Long value0 = new Long(oldCplModel.getBlockedUserId());

					method0.invoke(newModel, value0);

					Method method1 = newModelClass.getMethod("setOwnerId",
							new Class[] { Long.TYPE });

					Long value1 = new Long(oldCplModel.getOwnerId());

					method1.invoke(newModel, value1);

					Method method2 = newModelClass.getMethod("setUserId",
							new Class[] { Long.TYPE });

					Long value2 = new Long(oldCplModel.getUserId());

					method2.invoke(newModel, value2);

					Method method3 = newModelClass.getMethod("setBlockedDate",
							new Class[] { Date.class });

					Date value3 = oldCplModel.getBlockedDate();

					method3.invoke(newModel, value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
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

		if (oldModelClassName.equals("com.dharma.model.impl.PMMessageImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PMMessageClp newModel = new PMMessageClp();

					Method method0 = oldModelClass.getMethod("getMessageId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setMessageId(value0);

					Method method1 = oldModelClass.getMethod("getSubject");

					String value1 = (String)method1.invoke(oldModel,
							(Object[])null);

					newModel.setSubject(value1);

					Method method2 = oldModelClass.getMethod("getBody");

					String value2 = (String)method2.invoke(oldModel,
							(Object[])null);

					newModel.setBody(value2);

					Method method3 = oldModelClass.getMethod(
							"getParentMessageId");

					Long value3 = (Long)method3.invoke(oldModel, (Object[])null);

					newModel.setParentMessageId(value3);

					Method method4 = oldModelClass.getMethod("getOwnerId");

					Long value4 = (Long)method4.invoke(oldModel, (Object[])null);

					newModel.setOwnerId(value4);

					Method method5 = oldModelClass.getMethod("getOwnerName");

					String value5 = (String)method5.invoke(oldModel,
							(Object[])null);

					newModel.setOwnerName(value5);

					Method method6 = oldModelClass.getMethod("getPostedDate");

					Date value6 = (Date)method6.invoke(oldModel, (Object[])null);

					newModel.setPostedDate(value6);

					Method method7 = oldModelClass.getMethod("getRecepients");

					String value7 = (String)method7.invoke(oldModel,
							(Object[])null);

					newModel.setRecepients(value7);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals(
					"com.dharma.model.impl.PMDeletedMessageImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PMDeletedMessageClp newModel = new PMDeletedMessageClp();

					Method method0 = oldModelClass.getMethod(
							"getDeletedMessageId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setDeletedMessageId(value0);

					Method method1 = oldModelClass.getMethod("getMessageId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setMessageId(value1);

					Method method2 = oldModelClass.getMethod("getOwnerId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setOwnerId(value2);

					Method method3 = oldModelClass.getMethod("getDeletedDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setDeletedDate(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("com.dharma.model.impl.PMReadMessageImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PMReadMessageClp newModel = new PMReadMessageClp();

					Method method0 = oldModelClass.getMethod("getReadMessageId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setReadMessageId(value0);

					Method method1 = oldModelClass.getMethod("getMessageId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setMessageId(value1);

					Method method2 = oldModelClass.getMethod("getReadDate");

					Date value2 = (Date)method2.invoke(oldModel, (Object[])null);

					newModel.setReadDate(value2);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
		}

		if (oldModelClassName.equals("com.dharma.model.impl.PMBlockedUserImpl")) {
			ClassLoader contextClassLoader = Thread.currentThread()
												   .getContextClassLoader();

			try {
				Thread.currentThread().setContextClassLoader(_classLoader);

				try {
					PMBlockedUserClp newModel = new PMBlockedUserClp();

					Method method0 = oldModelClass.getMethod("getBlockedUserId");

					Long value0 = (Long)method0.invoke(oldModel, (Object[])null);

					newModel.setBlockedUserId(value0);

					Method method1 = oldModelClass.getMethod("getOwnerId");

					Long value1 = (Long)method1.invoke(oldModel, (Object[])null);

					newModel.setOwnerId(value1);

					Method method2 = oldModelClass.getMethod("getUserId");

					Long value2 = (Long)method2.invoke(oldModel, (Object[])null);

					newModel.setUserId(value2);

					Method method3 = oldModelClass.getMethod("getBlockedDate");

					Date value3 = (Date)method3.invoke(oldModel, (Object[])null);

					newModel.setBlockedDate(value3);

					return newModel;
				}
				catch (Exception e) {
					_log.error(e, e);
				}
			}
			finally {
				Thread.currentThread().setContextClassLoader(contextClassLoader);
			}
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

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static ClassLoader _classLoader;
}