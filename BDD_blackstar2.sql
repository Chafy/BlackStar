/*==============================================================*/
/* Nom de SGBD :  PostgreSQL 8                                  */
/* Date de création :  1/3/2016 1:41:04 PM                      */
/*==============================================================*/


drop index CONTIENT_FK;

drop index IMAGE_PK;

drop table IMAGE;

drop index GERE_FK;

drop index TAG_PK;

drop table TAG;

drop index USERLOGIN_PK;

drop table USERLOGIN;

/*==============================================================*/
/* Table : IMAGE                                                */
/*==============================================================*/
create table IMAGE (
   IMG_ID               SERIAL               not null,
   TAG_ID               INT4                 not null,
   IMG_BYTES            BYTEA                not null,
   constraint PK_IMAGE primary key (IMG_ID)
);

/*==============================================================*/
/* Index : IMAGE_PK                                             */
/*==============================================================*/
create unique index IMAGE_PK on IMAGE (
IMG_ID
);

/*==============================================================*/
/* Index : CONTIENT_FK                                          */
/*==============================================================*/
create  index CONTIENT_FK on IMAGE (
TAG_ID
);

/*==============================================================*/
/* Table : TAG                                                  */
/*==============================================================*/
create table TAG (
   TAG_ID               SERIAL               not null,
   USER_ID              INT4                 not null,
   TAG_NAME             VARCHAR(1024)        not null,
   TAG_REGISTRATIONDATE DATE                 not null,
   TAG_SUPPORT          VARCHAR(1024)        not null,
   TAG_SUPPORTSPECIFICITY VARCHAR(1024)        null,
   TAG_PLACE            VARCHAR(1024)        not null,
   TAG_SIZE             VARCHAR(1024)        null,
   TAG_AUTHORFIRSTNAME  VARCHAR(1024)        null,
   TAG_AUTHORLASTNAME   VARCHAR(1024)        null,
   TAG_IDVERIFIED       BOOL                 null,
   TAG_USEDTECHNIQUE    VARCHAR(1024)        null,
   TAG_TRASHLEFT        VARCHAR(1024)        null,
   TAG_COMMENT          VARCHAR(1024)        null,
   constraint PK_TAG primary key (TAG_ID)
);

/*==============================================================*/
/* Index : TAG_PK                                               */
/*==============================================================*/
create unique index TAG_PK on TAG (
TAG_ID
);

/*==============================================================*/
/* Index : GERE_FK                                              */
/*==============================================================*/
create  index GERE_FK on TAG (
USER_ID
);

/*==============================================================*/
/* Table : USERLOGIN                                            */
/*==============================================================*/
create table USERLOGIN (
   USER_ID              SERIAL               not null,
   USER_LOGIN           VARCHAR(1024)        not null,
   USER_PASSWORD        VARCHAR(1024)        not null,
   USER_TYPE            VARCHAR(1024)        not null,
   constraint PK_USERLOGIN primary key (USER_ID)
);

/*==============================================================*/
/* Index : USERLOGIN_PK                                         */
/*==============================================================*/
create unique index USERLOGIN_PK on USERLOGIN (
USER_ID
);

alter table IMAGE
   add constraint FK_IMAGE_CONTIENT_TAG foreign key (TAG_ID)
      references TAG (TAG_ID)
      on delete restrict on update restrict;

alter table TAG
   add constraint FK_TAG_GERE_USERLOGI foreign key (USER_ID)
      references USERLOGIN (USER_ID)
      on delete restrict on update restrict;

