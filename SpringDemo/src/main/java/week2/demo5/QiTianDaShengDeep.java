package week2.demo5;

import java.io.*;

public class QiTianDaShengDeep extends Monkey implements Cloneable, Serializable {
    public JinGuBang jinGuBang;
    public QiTianDaShengDeep(){this.jinGuBang=new JinGuBang();}
    protected Object clone(){return this.deepClone();}

    private QiTianDaShengDeep deepClone() {

        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);

            QiTianDaShengDeep qi = (QiTianDaShengDeep) ois.readObject();
            return qi;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
