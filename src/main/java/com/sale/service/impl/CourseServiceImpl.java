package com.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sale.mapper.CourseMapper;
import com.sale.entity.Course;
import com.sale.service.CourseService;
import org.springframework.stereotype.Service;

/**
 * (Course)表服务实现类
 *
 * @author makejava
 * @since 2023-06-25 13:27:15
 */
@Service("courseService")
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}



