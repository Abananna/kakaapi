-- 创建库
create database if not exists kaka;

-- 切换库
use kaka;

-- 用户表
create table user
(
    username     varchar(256)                           null comment '用户昵称',
    id           bigint auto_increment comment 'id'
        primary key,
    userAccount  varchar(256)                           null comment '账号',
    avatarUrl    varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userPassword varchar(512)                           not null comment '密码',
    phone        varchar(128)                           null comment '电话',
    email        varchar(512)                           null comment '邮箱',
    userStatus   int          default 0                 not null comment '状态 0 - 正常',
    createTime   datetime     default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP,
    isDelete     tinyint      default 0                 not null comment '是否删除',
    userRole     varchar(255) default '0'               not null comment '用户角色 0 - 普通用户 1 - 管理员',
    planetCode   varchar(512)                           null comment '星球编号',
    tags         varchar(1024)                          null comment '标签 json 列表',
    accessKey    varchar(255)                           not null comment 'accessKey',
    secretKey    varchar(255)                           not null comment 'secretKey'
)
    comment '用户';

-- 接口信息表
create table IF NOT EXISTS interface_info
(
    id             bigint auto_increment comment '主键'
        primary key,
    name           varchar(256)                       not null comment '名称',
    description    varchar(256)                       null comment '描述',
    url            varchar(512)                       not null comment '接口地址',
    requestHeader  text                               null comment '请求头',
    responseHeader text                               null comment '响应头',
    status         int      default 0                 not null comment '接口状态（0-关闭，1-开启）',
    method         varchar(256)                       not null comment '请求类型',
    userId         bigint                             not null comment '创建人',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)',
    requestParams  varchar(255)                       null comment '请求参数'
) comment '接口信息';
-- 用户调用接口关系表
create table user_interface_info
(
    id              bigint auto_increment comment '主键'
        primary key,
    userId          bigint                             not null comment '调用者id',
    interfaceInfoId bigint                             not null comment '接口id',
    totalNum        int      default 0                 not null comment '总调用次数',
    leftNum         int      default 0                 not null comment '剩余调用次数',
    status          int      default 0                 not null comment '0-正常  1-禁用',
    createTime      datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete        tinyint  default 0                 not null comment '是否删除 0-未删 1-已删'
)
    comment '用户调用接口关系表';

-- 情话表
create table rustic_word(
    wId int primary key auto_increment comment '主键',
    context varchar(255) not null comment '情话内容'
) engine=myisam;

