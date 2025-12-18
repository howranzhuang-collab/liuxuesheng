package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 留学申报：(ApplicationForStudyingAbroad)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ApplicationForStudyingAbroad")
public class ApplicationForStudyingAbroad implements Serializable {

    // ApplicationForStudyingAbroad编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_for_studying_abroad_id")
    private Integer application_for_studying_abroad_id;

    // 院校名称
    @Basic
    private String name_of_institution;
    // 专业名称
    @Basic
    private String major_name;
    // 学费信息
    @Basic
    private String tuition_information;
    // 申报人员
    @Basic
    private Integer declaration_personnel;
    // 学生姓名
    @Basic
    private String student_name;
    // 学生ID
    @Basic
    private Integer student_id;
    // 申报日期
    @Basic
    private Timestamp date_of_declaration;
    // 申报材料
    @Basic
    private String application_materials;
    // 联系方式
    @Basic
    private String contact_information;
    // 邮箱地址
    @Basic
    private String e_mail_address;
    // 备注信息
    @Basic
    private String remarks;



    // 审核状态
    @Basic
    private String examine_state;








    // 审核回复
    @Basic
    private String examine_reply;



    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
