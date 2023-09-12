set search_path to appconfig;

insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.datasource.driver-class-name', 'org.postgresql.Driver', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.datasource.url', 'jdbc:postgresql://myBlog/accountservice', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.datasource.hikari.schema', 'myblog', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.datasource.username', 'postgres', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.datasource.password', 'Dakhung0801@', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.jpa.properties.hibernate.dialect', 'org.hibernate.dialect.PostgreSQLDialect', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.jpa.properties.hibernate.default_schema', 'myblog', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.jpa.hibernate.ddl-auto', 'validate', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.jpa.show-sql', 'false', null, now(), now());
insert into ms_properties (application, profile, "label", "key", value, description, createddate, updateddate) values ('account-service', 'default', 'master', 'spring.jpa.open-in-view', 'false', null, now(), now());
