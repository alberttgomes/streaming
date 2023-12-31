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

package com.streaming.service.base;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import com.streaming.model.CarouselItemsDashboard;
import com.streaming.service.CarouselItemsDashboardLocalService;
import com.streaming.service.CarouselItemsDashboardLocalServiceUtil;
import com.streaming.service.persistence.CarouselItemsDashboardPersistence;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the carousel items dashboard local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.streaming.service.impl.CarouselItemsDashboardLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.streaming.service.impl.CarouselItemsDashboardLocalServiceImpl
 * @generated
 */
public abstract class CarouselItemsDashboardLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CarouselItemsDashboardLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CarouselItemsDashboardLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CarouselItemsDashboardLocalServiceUtil</code>.
	 */

	/**
	 * Adds the carousel items dashboard to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 * @return the carousel items dashboard that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CarouselItemsDashboard addCarouselItemsDashboard(
		CarouselItemsDashboard carouselItemsDashboard) {

		carouselItemsDashboard.setNew(true);

		return carouselItemsDashboardPersistence.update(carouselItemsDashboard);
	}

	/**
	 * Creates a new carousel items dashboard with the primary key. Does not add the carousel items dashboard to the database.
	 *
	 * @param categoryId the primary key for the new carousel items dashboard
	 * @return the new carousel items dashboard
	 */
	@Override
	@Transactional(enabled = false)
	public CarouselItemsDashboard createCarouselItemsDashboard(
		long categoryId) {

		return carouselItemsDashboardPersistence.create(categoryId);
	}

	/**
	 * Deletes the carousel items dashboard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 * @throws PortalException if a carousel items dashboard with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CarouselItemsDashboard deleteCarouselItemsDashboard(long categoryId)
		throws PortalException {

		return carouselItemsDashboardPersistence.remove(categoryId);
	}

	/**
	 * Deletes the carousel items dashboard from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 * @return the carousel items dashboard that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CarouselItemsDashboard deleteCarouselItemsDashboard(
		CarouselItemsDashboard carouselItemsDashboard) {

		return carouselItemsDashboardPersistence.remove(carouselItemsDashboard);
	}

	@Override
	public <T> T dslQuery(DSLQuery dslQuery) {
		return carouselItemsDashboardPersistence.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(DSLQuery dslQuery) {
		Long count = dslQuery(dslQuery);

		return count.intValue();
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			CarouselItemsDashboard.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return carouselItemsDashboardPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.model.impl.CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return carouselItemsDashboardPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.model.impl.CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return carouselItemsDashboardPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return carouselItemsDashboardPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return carouselItemsDashboardPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public CarouselItemsDashboard fetchCarouselItemsDashboard(long categoryId) {
		return carouselItemsDashboardPersistence.fetchByPrimaryKey(categoryId);
	}

	/**
	 * Returns the carousel items dashboard matching the UUID and group.
	 *
	 * @param uuid the carousel items dashboard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching carousel items dashboard, or <code>null</code> if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard fetchCarouselItemsDashboardByUuidAndGroupId(
		String uuid, long groupId) {

		return carouselItemsDashboardPersistence.fetchByUUID_G(uuid, groupId);
	}

	@Override
	public CarouselItemsDashboard
		fetchCarouselItemsDashboardByExternalReferenceCode(
			String externalReferenceCode, long groupId) {

		return carouselItemsDashboardPersistence.fetchByERC_G(
			externalReferenceCode, groupId);
	}

	@Override
	public CarouselItemsDashboard
			getCarouselItemsDashboardByExternalReferenceCode(
				String externalReferenceCode, long groupId)
		throws PortalException {

		return carouselItemsDashboardPersistence.findByERC_G(
			externalReferenceCode, groupId);
	}

	/**
	 * Returns the carousel items dashboard with the primary key.
	 *
	 * @param categoryId the primary key of the carousel items dashboard
	 * @return the carousel items dashboard
	 * @throws PortalException if a carousel items dashboard with the primary key could not be found
	 */
	@Override
	public CarouselItemsDashboard getCarouselItemsDashboard(long categoryId)
		throws PortalException {

		return carouselItemsDashboardPersistence.findByPrimaryKey(categoryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			carouselItemsDashboardLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CarouselItemsDashboard.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("categoryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			carouselItemsDashboardLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			CarouselItemsDashboard.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("categoryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			carouselItemsDashboardLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(CarouselItemsDashboard.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("categoryId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<CarouselItemsDashboard>() {

				@Override
				public void performAction(
						CarouselItemsDashboard carouselItemsDashboard)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, carouselItemsDashboard);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(
					CarouselItemsDashboard.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return carouselItemsDashboardPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		if (_log.isWarnEnabled()) {
			_log.warn(
				"Implement CarouselItemsDashboardLocalServiceImpl#deleteCarouselItemsDashboard(CarouselItemsDashboard) to avoid orphaned data");
		}

		return carouselItemsDashboardLocalService.deleteCarouselItemsDashboard(
			(CarouselItemsDashboard)persistedModel);
	}

	@Override
	public BasePersistence<CarouselItemsDashboard> getBasePersistence() {
		return carouselItemsDashboardPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return carouselItemsDashboardPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns all the carousel items dashboards matching the UUID and company.
	 *
	 * @param uuid the UUID of the carousel items dashboards
	 * @param companyId the primary key of the company
	 * @return the matching carousel items dashboards, or an empty list if no matches were found
	 */
	@Override
	public List<CarouselItemsDashboard>
		getCarouselItemsDashboardsByUuidAndCompanyId(
			String uuid, long companyId) {

		return carouselItemsDashboardPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of carousel items dashboards matching the UUID and company.
	 *
	 * @param uuid the UUID of the carousel items dashboards
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching carousel items dashboards, or an empty list if no matches were found
	 */
	@Override
	public List<CarouselItemsDashboard>
		getCarouselItemsDashboardsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<CarouselItemsDashboard> orderByComparator) {

		return carouselItemsDashboardPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the carousel items dashboard matching the UUID and group.
	 *
	 * @param uuid the carousel items dashboard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching carousel items dashboard
	 * @throws PortalException if a matching carousel items dashboard could not be found
	 */
	@Override
	public CarouselItemsDashboard getCarouselItemsDashboardByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return carouselItemsDashboardPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the carousel items dashboards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.streaming.model.impl.CarouselItemsDashboardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of carousel items dashboards
	 * @param end the upper bound of the range of carousel items dashboards (not inclusive)
	 * @return the range of carousel items dashboards
	 */
	@Override
	public List<CarouselItemsDashboard> getCarouselItemsDashboards(
		int start, int end) {

		return carouselItemsDashboardPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of carousel items dashboards.
	 *
	 * @return the number of carousel items dashboards
	 */
	@Override
	public int getCarouselItemsDashboardsCount() {
		return carouselItemsDashboardPersistence.countAll();
	}

	/**
	 * Updates the carousel items dashboard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CarouselItemsDashboardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param carouselItemsDashboard the carousel items dashboard
	 * @return the carousel items dashboard that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CarouselItemsDashboard updateCarouselItemsDashboard(
		CarouselItemsDashboard carouselItemsDashboard) {

		return carouselItemsDashboardPersistence.update(carouselItemsDashboard);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CarouselItemsDashboardLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		carouselItemsDashboardLocalService =
			(CarouselItemsDashboardLocalService)aopProxy;

		_setLocalServiceUtilService(carouselItemsDashboardLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CarouselItemsDashboardLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return CarouselItemsDashboard.class;
	}

	protected String getModelClassName() {
		return CarouselItemsDashboard.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				carouselItemsDashboardPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		CarouselItemsDashboardLocalService carouselItemsDashboardLocalService) {

		try {
			Field field =
				CarouselItemsDashboardLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, carouselItemsDashboardLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected CarouselItemsDashboardLocalService
		carouselItemsDashboardLocalService;

	@Reference
	protected CarouselItemsDashboardPersistence
		carouselItemsDashboardPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(
		CarouselItemsDashboardLocalServiceBaseImpl.class);

}