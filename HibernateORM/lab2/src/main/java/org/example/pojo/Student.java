package org.example.pojo;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @package:org.example.pojo
 * @class:Student
 * @description://
 * 在Hibernate项目中使用Hibernate核心API持久化Student实体,
 * Student实体包含属性：
 * id(Integer，OID),
 * sno(String，长10个字符，不能为空),
 * name(String，长20个字符，不能为空),
 * age(int)。
 * @author: zzw
 * @date:2022/4/22 19:52
 */
@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Type(type = "int")
    private Integer id;

    @Column(name="sno")
    @Type(type = "string")
    private String sno;

    @Column(name="name")
    @Type(type = "string")
    private String name;

    @Column(name="age")
    @Type(type = "int")
    private int age;

    // 无参构造
    public Student() {
    }

    // 有参构造
    public Student(Integer id, String sno, String name, int age) {
        this.id = id;
        this.sno = sno;
        this.name = name;
        this.age = age;
    }

    // setter和getter方法
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString()
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sno='" + sno + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
