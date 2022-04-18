package week2.demo5;

import java.io.Serializable;

public class QiTianDaShengShallow extends Monkey implements Cloneable, Serializable {
    public JinGuBang jinGuBang;
    public QiTianDaShengShallow(){
        this.jinGuBang = new JinGuBang();
    }
    protected Object clone(){
        return this.shallowClone();
    }

    private  QiTianDaShengShallow shallowClone(){
        QiTianDaShengShallow qi = new QiTianDaShengShallow();
        qi.height = this.height;
        qi.weight = this.weight;
        qi.jinGuBang = this.jinGuBang;
        return qi;
    }
}
