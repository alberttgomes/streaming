create table STGCarouselItemsDashboard (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	categoryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	category VARCHAR(75) null,
	colorTheme VARCHAR(75) null,
	instanceCategoryFk LONG,
	priority VARCHAR(75) null,
	title VARCHAR(75) null
);