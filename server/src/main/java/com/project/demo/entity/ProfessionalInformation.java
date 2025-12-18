package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 专业信息：(ProfessionalInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ProfessionalInformation")
public class ProfessionalInformation implements Serializable {

    // ProfessionalInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "professional_information_id")
    private Integer professional_information_id;

    // 院校名称
    @Basic
    private String name_of_institution;
    // 专业名称
    @Basic
    private String major_name;
    // 封面图片
    @Basic
    private String cover_photo;
    // 学费信息
    @Basic
    private String tuition_information;
    // 申请要求
    @Basic
    private String application_requirements;
    // 学位介绍
    @Basic
    private String degree_introduction;
    // 就业情况
    @Basic
    private String employment_situation;
    // 专业介绍
    @Basic
    private String professional_introduction;

    // 点击数
    @Basic
    private Integer hits;













    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
