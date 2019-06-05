package com.briup.apps.app02.service.impl;

import com.briup.apps.app02.bean.Course;
import com.briup.apps.app02.dao.CourseMapper;
import com.briup.apps.app02.service.ICourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Resource
    private CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return courseMapper.findAll();
    }

    @Override
    public Course findById(long id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrUpdate(Course course) throws Exception {
        if(course.getId() == null){
            // 初始化属性
            courseMapper.insert(course);
        } else {
            courseMapper.update(course);
        }
    }

    @Override
    public void deleteById(long id) throws Exception {
        Course course = courseMapper.selectByPrimaryKey(id);
        if(course == null){
            throw new Exception("要删除的用户不存在");
        } else {
            courseMapper.deleteByPrimaryKey(id);
        }
    }
}
