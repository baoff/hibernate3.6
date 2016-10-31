package cn.foot.day02.manyToMany.entity;

import java.util.Set;

public class Teacher {
	
	 private Long id;
	 private String name;
	 private Set<Student> students;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	 
}
