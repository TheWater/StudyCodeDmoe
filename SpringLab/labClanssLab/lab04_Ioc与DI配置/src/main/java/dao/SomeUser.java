package dao;

import java.util.List;
import java.util.Map;

public class SomeUser {
    private User[] someUserArray;
    private List somList;
    private Map someMap;

    public User[] getSomeUserArray() {
        return someUserArray;
    }

    public void setSomeUserArray(User[] someUserArray) {
        this.someUserArray = someUserArray;
    }

    public List getSomList() {
        return somList;
    }

    public void setSomList(List somList) {
        this.somList = somList;
    }

    public Map getSomeMap() {
        return someMap;
    }

    public void setSomeMap(Map someMap) {
        this.someMap = someMap;
    }
}
