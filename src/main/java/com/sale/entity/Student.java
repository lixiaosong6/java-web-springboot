package com.sale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * (Student)表实体类
 *
 * @author makejava
 * @since 2023-06-25 13:27:17
 */
@TableName("student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    //学号
    private String sno;
    //姓名
    private String sname;
    //性别
    private String ssex;
    //年龄
    private Integer sage;
    //所在系
    private String dept;

}


