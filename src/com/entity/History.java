package com.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class History {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "hid",nullable = false,unique = true)
    private Integer hid;

    @OneToOne(targetEntity=Employee.class, cascade={CascadeType.REFRESH})
    @JoinColumn(name = "operator",referencedColumnName = "eid")
    private Employee operator;

    @Column(name = "operate_date", nullable = true)
    private Date operateDate;

    @Column(name = "operate", nullable = true)
    private String operate;

    @Column(name = "fileId", nullable = true)
    private Integer fileId;

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public Date getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(Date operateDate) {
        this.operateDate = operateDate;
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate;
    }

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
}
