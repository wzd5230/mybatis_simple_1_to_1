package cn.wzd.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.wzd.mapper.ClassesMapper;
import cn.wzd.po.Classes;
import cn.wzd.po.Teacher;

public class ClassesMapperTest {

	@Test
	public void testInsertClass() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
		
		//创建需要插入到表中的对象
		Classes classes = new Classes();
		Teacher teacher = new Teacher();
		
		teacher.setTeacher_id(2);
		classes.setClass_name("高一(11)班");
		classes.setClass_teacher(teacher);
		
		//将对象插入到表中
		classesMapper.insertClass(classes);
		
		//提交并关闭会话
		session.commit();
		session.close();
	}

}
