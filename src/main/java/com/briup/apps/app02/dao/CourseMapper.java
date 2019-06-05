package com.briup.apps.app02.dao;

import com.briup.apps.app02.bean.Course;


import java.util.List;

public interface CourseMapper {

    List<Course> findAll();

    Course selectByPrimaryKey(long id);

    void insert(Course course);

    void update(Course course);

    void deleteByPrimaryKey(long id);
}
