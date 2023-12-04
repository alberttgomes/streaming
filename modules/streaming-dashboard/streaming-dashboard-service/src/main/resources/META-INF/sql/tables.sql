create table STG-CarouselItemsDashboard (
	mvccVersion LONG default 0 not null,
	uuid_ VARCHAR(75) null,
	externalReferenceCode VARCHAR(75) null,
	streamingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	category VARCHAR(75) null,
	colorTheme VARCHAR(75) null,
	priority VARCHAR(75) null,
	title VARCHAR(75) null,
	user VARCHAR(75) null
);