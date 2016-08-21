package cn.wzd.mapper;

import cn.wzd.po.Classes;

public interface ClassesMapper {

	//向classes表中插入一个教室条目
	public void insertClass( Classes classes ) throws Exception;
	
	//通过classes的class_id查询该class的信息
	public Classes findClassByClassId( int class_id ) throws Exception;
}
