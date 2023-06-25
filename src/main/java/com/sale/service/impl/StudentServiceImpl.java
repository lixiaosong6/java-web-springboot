package com.sale.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sale.mapper.StudentMapper;
import com.sale.entity.Student;
import com.sale.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * (Student)表服务实现类
 *
 * @author makejava
 * @since 2023-06-25 13:27:19
 */
@Service("studentService")
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}



