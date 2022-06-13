import java.util.Map;

public class Student {
    private long sid;
    private String sname;
    private Map saddress;
    private Teacher teacher;

    public Student() {}

    public Student(long sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public long getSid() {
        return sid;
    }

    public void setSid(long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Map getSaddress() {
        return saddress;
    }

    public void setSaddress(Map saddress) {
        this.saddress = saddress;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
