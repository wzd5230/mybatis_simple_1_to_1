package cn.wzd.mapper;

import cn.wzd.po.Classes;

public interface ClassesMapper {

	//向classes表中插入一个教室条目
	public void insertClass( Classes classes ) throws Exception;
	
}
