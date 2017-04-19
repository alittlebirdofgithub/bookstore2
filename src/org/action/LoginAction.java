package org.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.dao.LoginDao;
import org.model.Login;

import java.util.Map;

/**
 * Created by 18673 on 2017/4/18 0018.
 */
public class LoginAction extends ActionSupport {
    private Login login;
    private String message;
    public String execute() throws Exception {
        LoginDao loginDao = new LoginDao();
        System.out.print(login.getName() + '\n' + login.getPassword() + '\n');
        Login l = loginDao.checkLogin(login.getName(), login.getPassword());
        if(l != null) {
            Map session = ActionContext.getContext().getSession();
            session.put("login", l);
            if(l.getRole()) {
                return "admin";
            } else {
                return "student";
            }
        } else {
            return ERROR;
        }
    }

    public void validate() {
        if(login.getName() == null || login.getName().equals("")) {
            this.addFieldError("name", "用户名不能为空");
        } else if(login.getPassword() == null || login.getPassword().equals("")) {
            this.addFieldError("password","密码不能为空");
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
