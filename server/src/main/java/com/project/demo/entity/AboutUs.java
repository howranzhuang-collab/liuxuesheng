package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 关于我们：(AboutUs)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "AboutUs")
public class AboutUs implements Serializable {

    // AboutUs编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "about_us_id")
    private Integer about_us_id;

    // 文章标题
    @Basic
    private String article_title;
    // 文章类型
    @Basic
    private String article_type;
    // 封面图片
    @Basic
    private String cover_photo;
    // 内容详情
    @Basic
    private String content_details;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
