CREATE TABLE IF NOT EXISTS company_info 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  name      	VARCHAR(50)  	NOT NULL COMMENT '公司名称',
  slogan    	VARCHAR(200) 	NOT NULL COMMENT '公司理念',
  logo_url  	VARCHAR(200) 	NOT NULL COMMENT '图标url',
  `domain`  	VARCHAR(200) 	NOT NULL DEFAULT 'http://localhost' COMMENT '域名地址',
  create_user  	VARCHAR(50) 	NULL COMMENT '创建者名称',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_user  	VARCHAR(50) 	NULL COMMENT '修改者名称',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id)
)
COMMENT '公司信息表'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS address 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  company_id	INTEGER			NOT NULL COMMENT '公司id',
  province     	VARCHAR(20)  	NOT NULL COMMENT '省',
  city	    	VARCHAR(20) 	NOT NULL COMMENT '市',
  region	  	VARCHAR(20) 	NOT NULL COMMENT '区、县',
  street 	  	VARCHAR(20) 	NULL COMMENT '街道',
  address   	VARCHAR(150) 	NOT NULL COMMENT '详细地址',
  create_user  	VARCHAR(50) 	NULL COMMENT '创建者名称',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_user  	VARCHAR(50) 	NULL COMMENT '修改者名称',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id),
  INDEX `ix_address_company_id` (`company_id`)
)
COMMENT '地址表'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS contact 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  company_id	INTEGER			NOT NULL COMMENT '公司id',
  `type`     	VARCHAR(10)  	NOT NULL COMMENT '通讯类型：电话、手机、QQ、微信、微博等',
  `value`	    VARCHAR(50) 	NOT NULL COMMENT '联系方式',
  `displayOrder`INTEGER		 	NOT NULL DEFAULT 0 COMMENT '排序',
  create_user  	VARCHAR(50) 	NULL COMMENT '创建者名称',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '创建时间',
  update_user  	VARCHAR(50) 	NULL COMMENT '修改者名称',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id),
  INDEX `ix_contact_company_id` (`company_id`)
)
COMMENT '联系信息表'  ENGINE = INNODB  DEFAULT CHARSET = utf8;
