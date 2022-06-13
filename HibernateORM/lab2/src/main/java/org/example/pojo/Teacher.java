package org.example.pojo;

import javax.persistence.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @package:org.example.pojo
 * @class:Teacher
 * @description:// TODO
 * @author: zzw
 * @date:2022/5/4 17:37
 */
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Type(type = "int")
    private int id;

    @Column(name="tname")
    @Type(type = "string")
    private String tname;

    @Column(name="tno")
    @Type(type = "string")
    private String tno;

    @Column(name="dept")
    @Type(type = "string")
    private String dept;

    @Column(name="hireDate")
    @Type(type = "date")
    private Date hireDate;

    @Column(name="introduction")
    @Type(type = "text")
    private String introduction;

    // 无参构造
    public Teacher() {
    }

    // 有参构造
    public Teacher(int id, String tname, String tno, String dept, Date hireDate, String introduction) {
        this.id = id;
        this.tname = tname;
        this.tno = tno;
        this.dept = dept;
        this.hireDate = hireDate;
        this.introduction = introduction;
    }

    // setter和getter方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", tno='" + tno + '\'' +
                ", dept='" + dept + '\'' +
                ", hireDate=" + hireDate +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
