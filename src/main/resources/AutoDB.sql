-- 用户表
CREATE TABLE user (
id BIGINT(20) ,
create_at  DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
update_at DATETIME  NOT NULL ,
delete_at DATETIME ,
is_delete BOOLEAN DEFAULT FALSE COMMENT '是否已经删除 true-已经删除   false-没有删除',
account VARCHAR(20) NOT NULL,
pwd VARCHAR(40) NOT NULL,
salt VARCHAR(40) NOT NULL,
NAME  VARCHAR(20) ,
PRIMARY KEY(id),
UNIQUE KEY(account)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户表';


-- 角色表
CREATE TABLE role(
id BIGINT(20) ,
create_at  DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
update_at DATETIME  NOT NULL ,
role_name VARCHAR(100) NOT NULL,
PRIMARY KEY(id),
UNIQUE KEY(role_name)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '角色表';

-- 菜单表
CREATE TABLE menu(
id BIGINT(20) ,
create_at  DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
update_at DATETIME  NOT NULL ,
TYPE VARCHAR(50) NOT NULL COMMENT '菜单的类型  URL-指向页面的功能型菜单  MENU-用于显示的父菜单',
parent_id BIGINT(20) DEFAULT -1 COMMENT '父菜单的id   如果时根菜单则使用 -1',
url VARCHAR(200),
menu_name  VARCHAR(100) NOT NULL,
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '菜单表';


-- 资源表
CREATE TABLE resource(
id BIGINT(20) ,
create_at  DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '创建时间',
update_at DATETIME  NOT NULL ,
resource_name  VARCHAR(100) NOT NULL COMMENT '资源名称 如果这个资源是特属于某个页面的则在命名的时候用:菜单名称(url类型菜单)---资源名称  如果这个资源是公共的接口,例如:所有城市的{id:,name:,},命名的时候用 zcommon---资源名称',
TYPE VARCHAR(50) NOT NULL COMMENT '资源的类型 BTN-按钮类型对应flag_name  URL-接口地址类型对应url',
flag_name VARCHAR(100) ,
url VARCHAR(200),
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '资源表';


-- 用户-角色关系表
CREATE TABLE user_and_role(
id BIGINT(20),
user_id BIGINT(20) NOT NULL,
role_id BIGINT(20) NOT NULL,
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户-角色关系表';

-- 用户-菜单关系表
CREATE TABLE user_and_menu(
id BIGINT(20),
user_id BIGINT(20) NOT NULL,
menu_id BIGINT(20) NOT NULL,
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '用户-菜单关系表';

-- 菜单-资源关系表
CREATE TABLE menu_and_resource(
id BIGINT(20),
menu_id BIGINT(20) NOT NULL,
resource_id BIGINT(20) NOT NULL,
PRIMARY KEY(id)
)ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT '菜单-资源关系表';