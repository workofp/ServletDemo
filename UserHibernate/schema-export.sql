
    alter table user 
        drop 
        foreign key FK36EBCB177B6850;

    alter table user_role 
        drop 
        foreign key FK143BF46A6ECCD0F;

    alter table user_role 
        drop 
        foreign key FK143BF46AAC1790EF;

    drop table if exists organization;

    drop table if exists role;

    drop table if exists user;

    drop table if exists user_role;

    create table organization (
        ORGANIZATION_ID bigint not null auto_increment,
        ORGANIZATION_NAME varchar(255),
        ORGANIZATION_DESCRIPTION varchar(255),
        primary key (ORGANIZATION_ID)
    );

    create table role (
        ROLE_ID bigint not null auto_increment,
        ROLE_NAME varchar(255),
        ROLE_DESCRIPTION varchar(255),
        primary key (ROLE_ID)
    );

    create table user (
        USER_ID bigint not null auto_increment,
        USER_NAME varchar(255),
        USER_PASSWORD varchar(255),
        USER_EMAIL varchar(255),
        USER_ORGANIZATION_ID bigint,
        primary key (USER_ID)
    );

    create table user_role (
        USER_ROLE_USER_ID bigint not null,
        USER_ROLE_ROLE_ID bigint not null,
        primary key (USER_ROLE_ROLE_ID, USER_ROLE_USER_ID)
    );

    alter table user 
        add index FK36EBCB177B6850 (USER_ORGANIZATION_ID), 
        add constraint FK36EBCB177B6850 
        foreign key (USER_ORGANIZATION_ID) 
        references organization (ORGANIZATION_ID);

    alter table user_role 
        add index FK143BF46A6ECCD0F (USER_ROLE_ROLE_ID), 
        add constraint FK143BF46A6ECCD0F 
        foreign key (USER_ROLE_ROLE_ID) 
        references role (ROLE_ID);

    alter table user_role 
        add index FK143BF46AAC1790EF (USER_ROLE_USER_ID), 
        add constraint FK143BF46AAC1790EF 
        foreign key (USER_ROLE_USER_ID) 
        references user (USER_ID);
