create index IX_7C4D82EA on STG-CarouselItemsDashboard (companyId, groupId, streamingId);
create unique index IX_33765D0E on STG-CarouselItemsDashboard (externalReferenceCode[$COLUMN_LENGTH:75$], groupId);
create index IX_F15C28B5 on STG-CarouselItemsDashboard (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_59D15877 on STG-CarouselItemsDashboard (uuid_[$COLUMN_LENGTH:75$], groupId);