create table PersonalList (
	uuid_ VARCHAR(75) null,
	personalItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	description VARCHAR(75) null,
	fileShort VARCHAR(75) null,
	launch BOOLEAN,
	instancePk LONG,
	title VARCHAR(75) null
);