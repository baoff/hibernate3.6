package cn.foot.day02.manyToMany.entity;

import java.util.Set;

public class Student {
	
	private Long id;
	private String name;
	private Set<Teacher> teachers;
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
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}

}
