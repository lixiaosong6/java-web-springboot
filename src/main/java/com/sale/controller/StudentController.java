package com.sale.controller;



import com.sale.entity.Student;
import com.sale.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Student)表控制层
 *
 * @author makejava
 * @since 2023-06-25 13:27:17
 */
@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @RequestMapping("/list")
    public List<Student> list(){
        return studentService.list();
    }
}


