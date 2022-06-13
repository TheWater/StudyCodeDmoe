package org.example.pojo;

public class Teacher {
    private int id;// 唯一标识ID
    private String tname;// 姓名
    private String tno;// 工号
    private String dept;// 部门
    private String hireDate;// 入职时间
    private String introduce;// 个人简历

    public Teacher() {
    }

    public Teacher(int id, String tname, String tno, String dept, String hireDate, String introduce) {
        this.id = id;
        this.tname = tname;
        this.tno = tno;
        this.dept = dept;
        this.hireDate = hireDate;
        this.introduce = introduce;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", tno='" + tno + '\'' +
                ", dept='" + dept + '\'' +
                ", hireDate='" + hireDate + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

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

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
