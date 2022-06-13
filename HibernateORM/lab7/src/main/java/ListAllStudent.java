import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;

public class ListAllStudent {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure();
        SessionFactory sf = cfg.buildSessionFactory();
        Session session=sf.openSession();
        try{
            Criteria crit= session.createCriteria(Teacher.class);
            Criterion cond = Restrictions.eq("teacherID",new Integer(101));
            crit.add(cond);
            List results = crit.list();
            for (Iterator iter = results.iterator(); iter.hasNext();)
            {
                Teacher cp = (Teacher) iter.next();
                System.out.println(cp.getTeacherID()+" "+ cp.getTname()+" ");
                System.out.println("该老师所带在校生");
                Iterator s = cp.getStudent().iterator();
                while (s.hasNext()){
                    Student stu=(Student) s.next();
                    System.out.println(stu.getSid()+" "+stu.getSname());
                }
                System.out.println("该老师所带已经毕业学生");
                Iterator gs = cp.getG_student().iterator();
                while(gs.hasNext()){
                    Student stu = (Student) gs.next();
                    System.out.println(stu.getSid()+" "+stu.getSname());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
