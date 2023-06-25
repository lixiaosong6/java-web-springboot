package com.sale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * (Course)表实体类
 *
 * @author makejava
 * @since 2023-06-25 13:27:13
 */
@TableName("course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    //课程号
    private String cno;
    //课程名
    private String cname;
    //学分
    private Integer credit;
    //开课学期
    private Integer semester;

}


