CREATE TABLE IF NOT EXISTS company_info 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  name      	VARCHAR(50)  	NOT NULL COMMENT '��˾����',
  slogan    	VARCHAR(200) 	NOT NULL COMMENT '��˾����',
  logo_url  	VARCHAR(200) 	NOT NULL COMMENT 'ͼ��url',
  `domain`  	VARCHAR(200) 	NOT NULL DEFAULT 'http://localhost' COMMENT '������ַ',
  create_user  	VARCHAR(50) 	NULL COMMENT '����������',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '����ʱ��',
  update_user  	VARCHAR(50) 	NULL COMMENT '�޸�������',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id)
)
COMMENT '��˾��Ϣ��'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS address 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  company_id	INTEGER			NOT NULL COMMENT '��˾id',
  province     	VARCHAR(20)  	NOT NULL COMMENT 'ʡ',
  city	    	VARCHAR(20) 	NOT NULL COMMENT '��',
  region	  	VARCHAR(20) 	NOT NULL COMMENT '������',
  street 	  	VARCHAR(20) 	NULL COMMENT '�ֵ�',
  address   	VARCHAR(150) 	NOT NULL COMMENT '��ϸ��ַ',
  create_user  	VARCHAR(50) 	NULL COMMENT '����������',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '����ʱ��',
  update_user  	VARCHAR(50) 	NULL COMMENT '�޸�������',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id),
  INDEX `ix_address_company_id` (`company_id`)
)
COMMENT '��ַ��'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS contact 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  company_id	INTEGER			NOT NULL COMMENT '��˾id',
  `type`     	VARCHAR(10)  	NOT NULL COMMENT 'ͨѶ���ͣ��绰���ֻ���QQ��΢�š�΢����',
  `value`	    VARCHAR(50) 	NOT NULL COMMENT '��ϵ��ʽ',
  `displayOrder`INTEGER		 	NOT NULL DEFAULT 0 COMMENT '����',
  create_user  	VARCHAR(50) 	NULL COMMENT '����������',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '����ʱ��',
  update_user  	VARCHAR(50) 	NULL COMMENT '�޸�������',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id),
  INDEX `ix_contact_company_id` (`company_id`)
)
COMMENT '��ϵ��Ϣ��'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS description 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  `type`     	TINYINT		  	NOT NULL COMMENT '���ͣ�1:����,2:����,3:��̬',
  head			VARCHAR(100)	NOT NULL COMMENT '����',
  subhead     	VARCHAR(200)  	NULL COMMENT '������',
  desc_time   	DATETIME 		NULL COMMENT '������ʱ��',
  location		VARCHAR(200) 	NULL COMMENT '�ص�',
  content		VARCHAR(512) 	NULL COMMENT '��������',
  create_user  	VARCHAR(50) 	NULL COMMENT '����������',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '����ʱ��',
  update_user  	VARCHAR(50) 	NULL COMMENT '�޸�������',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id)
)
COMMENT '��Ϣ������'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS description_item 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  description_id INTEGER		NOT NULL COMMENT '���ͣ�1:����,2:����,3:��̬',
  image_id		INTEGER 	NULL COMMENT 'ͼƬid',
  content		VARCHAR(512) 	NULL COMMENT '��������',
  display_order	INTEGER			NOT NULL DEFAULT 0 COMMENT '��ʾ˳��',
  create_user  	VARCHAR(50) 	NULL COMMENT '����������',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '����ʱ��',
  update_user  	VARCHAR(50) 	NULL COMMENT '�޸�������',
  update_time  	DATETIME    	NOT NULL DEFAULT now(),
  PRIMARY KEY (id),
  INDEX `ix_desc_item_desc_id` (`description_id`)
)
COMMENT '��Ϣ���������'  ENGINE = INNODB  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS image 
(
  id        	INTEGER      	NOT NULL AUTO_INCREMENT,
  url			VARCHAR(250)	NOT NULL COMMENT 'ͼƬurl',
  bytes			VARCHAR(100)	NOT NULL COMMENT 'ͼƬ��С',
  create_user  	VARCHAR(50) 	NULL COMMENT '����������',
  create_time  	DATETIME    	NOT NULL DEFAULT now()  COMMENT '����ʱ��',
  PRIMARY KEY (id)
)
COMMENT '��Ϣ������'  ENGINE = INNODB  DEFAULT CHARSET = utf8;