package cn.wzd.po;

public class Classes {
	
	private int class_id;
	private String class_name;
	private Teacher class_teacher;
	
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Teacher getClass_teacher() {
		return class_teacher;
	}
	public void setClass_teacher(Teacher class_teacher) {
		this.class_teacher = class_teacher;
	}
	@Override
	public String toString() {
		return "Classes [class_id=" + class_id + ", class_name=" + class_name + ", class_teacher=" + class_teacher
				+ "]";
	}
	
	

}
