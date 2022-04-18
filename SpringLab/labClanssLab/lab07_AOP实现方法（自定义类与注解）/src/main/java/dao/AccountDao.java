package dao;

import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDao implements IAccountDao{
    @Override
    public void insertAccount() {
        System.out.println("插入");
    }

    @Override
    public void deteleAccount() {
        System.out.println("删除");
    }

    @Override
    public void upadtaAccont() {
        System.out.println("更新");
    }

    @Override
    public void searchAccount() throws Exception {
        System.out.println("查询");
        throw new Exception("查询账户失败");
    }
}
