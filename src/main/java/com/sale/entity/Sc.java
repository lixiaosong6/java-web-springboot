package com.sale.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableName;


/**
 * (Sc)表实体类
 *
 * @author makejava
 * @since 2023-06-25 13:27:15
 */
@TableName("sc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sc implements Serializable {
    //学号
    private String sno;
    //课程号
    private String cno;
    //成绩
    private Integer grade;

}


