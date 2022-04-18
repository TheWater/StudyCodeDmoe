package service;

import dao.IAccountDao;

public class AccountService implements IAcountService{
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void getAccount() {
        accountDao.getAccount();
    }
}
