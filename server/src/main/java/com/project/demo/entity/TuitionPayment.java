package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 学费缴纳：(TuitionPayment)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "TuitionPayment")
public class TuitionPayment implements Serializable {

    // TuitionPayment编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tuition_payment_id")
    private Integer tuition_payment_id;

    // 院校名称
    @Basic
    private String name_of_institution;
    // 专业名称
    @Basic
    private String major_name;
    // 申报人员
    @Basic
    private Integer declaration_personnel;
    // 学生姓名
    @Basic
    private String student_name;
    // 学费金额
    @Basic
    private String tuition_fee_amount;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;










    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
