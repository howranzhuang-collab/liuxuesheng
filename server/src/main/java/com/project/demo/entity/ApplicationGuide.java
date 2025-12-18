package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 申请指南：(ApplicationGuide)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ApplicationGuide")
public class ApplicationGuide implements Serializable {

    // ApplicationGuide编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "application_guide_id")
    private Integer application_guide_id;

    // 指南标题
    @Basic
    private String guide_title;
    // 指南类型
    @Basic
    private String guide_type;
    // 封面图片
    @Basic
    private String cover_photo;
    // 材料附件
    @Basic
    private String material_accessories;
    // 详情信息
    @Basic
    private String details;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
