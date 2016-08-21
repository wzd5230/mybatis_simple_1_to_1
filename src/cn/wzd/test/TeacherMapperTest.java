package cn.wzd.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.wzd.mapper.TeacherMapper;
import cn.wzd.po.Teacher;

public class TeacherMapperTest {

	@Test
	public void testInsertTeacher() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		
		Teacher teacher = new Teacher();
		teacher.setTeacher_name("王斌");
		
		try {
			teacherMapper.insertTeacher(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//insert、update、delete需要进行提交
		session.commit();
		
		session.close();
	}

}
