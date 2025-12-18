package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 留学生管理：(InternationalStudentManagement)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "InternationalStudentManagement")
public class InternationalStudentManagement implements Serializable {

    // InternationalStudentManagement编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "international_student_management_id")
    private Integer international_student_management_id;

    // 学生姓名
    @Basic
    private String student_name;
    // 学生性别
    @Basic
    private String student_gender;
    // 学生国籍
    @Basic
    private String student_nationality;
    // 留学院校
    @Basic
    private String overseas_universities;
    // 专业名称
    @Basic
    private String major_name;
    // 留学时间
    @Basic
    private Timestamp study_time;
    // 学生学籍
    @Basic
    private String student_status;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
