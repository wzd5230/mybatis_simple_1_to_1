
1.工程功能
使用mybatis实现一对一表的查询。

2.mysql数据库结构
两张表相关联：teacher class
class表中的class_teacher_id为外键，对应于teacher表中的主键。

/* teacher表 */
CREATE TABLE teacher(
teacher_id INT NOT NULL AUTO_INCREMENT,
teacher_name VARCHAR(20),
CONSTRAINT constraint_pk PRIMARY KEY(teacher_id)
);


/* classes表 */
CREATE TABLE classes(
class_id INT NOT NULL AUTO_INCREMENT,
class_name VARCHAR(20),
class_teacher_id INT,
CONSTRAINT constraint_pk PRIMARY KEY(class_id),
CONSTRAINT constraint_fk FOREIGN KEY(class_teacher_id) REFERENCES teacher(teacher_id)
);


/* 2016.08.21 V1.2 E420-PC 提交 */