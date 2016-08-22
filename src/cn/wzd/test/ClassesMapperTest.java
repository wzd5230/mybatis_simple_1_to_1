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
		
		teacher.setTeacher_id(1);
		classes.setClass_name("高一(11)班");
		classes.setClass_teacher(teacher);
		
		//将对象插入到表中
		classesMapper.insertClass(classes);
		
		//提交并关闭会话
		session.commit();
		session.close();
	}

	
	@Test
	public void testFindClassByClassId() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
		
		Classes classes = classesMapper.findClassByClassId(4);
		
		System.out.println(classes);
		
		//关闭会话
		session.close();
	}
	
	//deleteClassByClassId
	@Test
	public void testDeleteClassByClassId() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
		
		classesMapper.deleteClassByClassId( 5 );
				
		//关闭会话
		session.commit();
		session.close();
	}
	
	//updateClass
	@Test
	public void testUpdateClass() throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
		
		Classes classes = new Classes();
		Teacher teacher = new Teacher();
		
		classes.setClass_id( 6 );
		classes.setClass_name("高一（11）班");
		teacher.setTeacher_id(1);
		classes.setClass_teacher(teacher);
		
		classesMapper.updateClass(classes);
				
		//关闭会话
		session.commit();
		session.close();
	}
}
