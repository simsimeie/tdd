package org.chap08.java.nontestable;


import org.chap08.java.auth.AuthUtil;
import org.chap08.java.auth.Customer;
import org.chap08.java.auth.CustomerRepository;
import org.chap08.java.auth.LoginResult;

public class LoginService {
    private String authKey = "somekey";
    private CustomerRepository customerRepo;

    public LoginService(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public LoginResult login(String id, String pw) {
        int resp = 0;
        boolean authorized = AuthUtil.authorize(authKey);
        if (authorized) {
            resp = AuthUtil.authenticate(id, pw);
        } else {
            resp = -1;
        }
        if (resp == -1) return LoginResult.badAuthKey();

        if (resp == 1) {
            Customer c = customerRepo.findOne(id);
            return LoginResult.authenticated(c);
        } else {
            return LoginResult.fail(resp);
        }
    }

}
