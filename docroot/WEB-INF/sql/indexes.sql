create index IX_66EAA38A on GW_AppDomain (TYPE);
create unique index IX_45697EAB on GW_AppDomain (TYPE, CODE);
create index IX_4B9E8E79 on GW_AppDomain (type_);
create unique index IX_724D1A9 on GW_AppDomain (type_, code_);

create unique index IX_C11336DD on GW_CommandEntry (CODE);
create unique index IX_36886586 on GW_CommandEntry (code_);
create index IX_96C68D37 on GW_CommandEntry (provisioningType);

create unique index IX_814993B9 on GW_ProductEntry (CODE);
create index IX_8A2D9E05 on GW_ProductEntry (categoryId);
create unique index IX_7D1DA42A on GW_ProductEntry (code_);
create index IX_E8BC5EA1 on GW_ProductEntry (productType);
create index IX_A8E8C1FE on GW_ProductEntry (status);

create index IX_79F6AC0D on GW_ProductMessage (productId);
create unique index IX_1346502 on GW_ProductMessage (productId, actionType, channel);

create unique index IX_ACBF753E on GW_ProductRoute (productId, channel, serviceAddress, keyword);

create unique index IX_C54373BD on GW_ProvisioningEntry (CODE);
create unique index IX_B85FC4A6 on GW_ProvisioningEntry (code_);

create unique index IX_32E5D74F on GW_ProvisioningMessage (provisioningId, responseCode);