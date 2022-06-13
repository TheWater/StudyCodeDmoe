import java.util.Set;

public class Teacher  {
    private int teacherID;
    private String tname;
    private Set g_student;
    private Set student;
    private Teacher(){}

    public Teacher(int teacherID, String tname) {
        this.teacherID = teacherID;
        this.tname = tname;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Set getG_student() {
        return g_student;
    }

    public void setG_student(Set g_student) {
        this.g_student = g_student;
    }

    public Set getStudent() {
        return student;
    }

    public void setStudent(Set student) {
        this.student = student;
    }
}
