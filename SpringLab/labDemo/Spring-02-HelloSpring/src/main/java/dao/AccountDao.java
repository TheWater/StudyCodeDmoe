package dao;

import java.util.Map;

public class AccountDao implements IAccountDao{
    private Map<String,Account> accountMap;

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    @Override
    public void getAccount() {
        System.out.println("获取Account数据："+accountMap);
    }
}
