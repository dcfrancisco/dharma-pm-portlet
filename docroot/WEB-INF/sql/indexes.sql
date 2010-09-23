create index IX_C45F48DA on blocked_user (ownerId);
create index IX_A09B2714 on blocked_user (ownerId, userId);

create index IX_26BE9EEB on deleted_message (messageId);
create index IX_C5B89D57 on deleted_message (ownerId);

create index IX_344E4BAD on private_message (ownerId);
create index IX_E5E6E2F7 on private_message (parentMessageId);

create index IX_7A03358E on read_message (messageId);