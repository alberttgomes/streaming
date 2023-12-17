create unique index IX_2898B72D on STGCarouselItemsDashboard (externalReferenceCode[$COLUMN_LENGTH:75$], groupId);
create index IX_B9614577 on STGCarouselItemsDashboard (groupId, categoryId);
create index IX_639F1514 on STGCarouselItemsDashboard (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_EA51D096 on STGCarouselItemsDashboard (uuid_[$COLUMN_LENGTH:75$], groupId);