








drop table if exists t_admin_user;

drop table if exists t_coupon;

drop table if exists t_coupon_user;

drop table if exists t_user_coupon;

drop table if exists t_verify_user;

/*==============================================================*/
/* Table: t_admin_user                                          */
/*==============================================================*/
create table t_admin_user
(
   id                   int not null auto_increment comment 'ID',
   account              varchar(20) comment '账号',
   name                 varchar(10) comment '姓名',
   pwd                  varchar(20) comment '密码',
   sso_account          varchar(20) comment '小虫账号',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '更新时间',
   primary key (id)
);

alter table t_admin_user comment '管理用户';

/*==============================================================*/
/* Table: t_coupon                                              */
/*==============================================================*/
create table t_coupon
(
   id                   int not null auto_increment comment 'ID',
   coupon_type          char(1) comment '1：电器年会  2:集团年会',
   title                varchar(30) comment '餐券标题',
   subtitle             varchar(30) comment '餐券副标题',
   valid_date           date comment '有效日期',
   start_time           time comment '开始时间',
   end_time             time comment '结束时间',
   helpline             varchar(16) comment '服务电话',
   `desc`               varchar(200) comment '餐券说明',
   status               char(1) comment '0-正常 1-已投放 2-已删除',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '更新时间',
   location             varchar(200) comment '用餐地点',
   primary key (id)
);

alter table t_coupon comment '餐券';

/*==============================================================*/
/* Table: t_coupon_user                                         */
/*==============================================================*/
create table t_coupon_user
(
   id                   int not null auto_increment comment 'ID',
   name                 varchar(20) comment '姓名',
   phone                varchar(11) comment '手机号',
   user_group           char(1) comment '1：电器年会  2 ：集团年会',
   remark               varchar(50) comment '备注',
   status               char(1) comment '0-未签到 1-已签到 2-已删除',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '更新时间',
   first_sign           tinyint comment '是否第一次签到',
   primary key (id)
);

alter table t_coupon_user comment '餐券用户';


/*==============================================================*/
/* Table: t_user_coupon                                         */
/*==============================================================*/
create table t_user_coupon
(
   id                   varchar(8) not null comment 'ID',
   coupon_user_id       int comment '餐券用户ID',
   coupon_id            int comment '餐券ID',
   serial_no            varchar(16) comment '券号',
   status               char(1) comment '0：正常  1：已领取  2：已核销 3:已删除',
   verify_time          datetime comment '核销时间',
   recieve_time         datetime comment '领取时间',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '更新时间',
   primary key (id)
);

alter table t_user_coupon comment '用户餐券';

/*==============================================================*/
/* Table: t_verify_user                                         */
/*==============================================================*/
create table t_verify_user
(
   id                   int not null auto_increment comment 'ID',
   account              varchar(20) comment '账号',
   pwd                  varchar(20) comment '密码',
   remark               varchar(50) comment '备注',
   create_time          datetime comment '创建时间',
   modify_time          datetime comment '更新时间',
   primary key (id)
);

alter table t_verify_user comment '核销用户';


/*==============================================================*/
/* 更改表结构                                         */
/*==============================================================*/

ALTER table t_coupon ADD (
   color varchar(8),
    verify_type varchar(10)
);


ALTER table t_user_coupon ADD (
   verify_user_id int comment '核销用户id'
);

alter table t_coupon modify column `desc` varchar(500);

/*==============================================================*/
/* 创建索引                                        */
/*==============================================================*/

/* 创建普通索引 */
 alter table t_user_coupon add index index_user (coupon_user_id);

 alter table t_user_coupon add index index_coupon (coupon_id);



/*删除索引 */

DROP INDEX index_name ON table


/*组合索引 */

ALTER TABLE article ADD INDEX index_titme_time (title(50),time(10))





