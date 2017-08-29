package myshiro;

import net.plugins.service.UserServiceImpl;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/28.
 * IntelliJ IDEA 2017 of gzcss
 */
public class UserRealm extends AuthorizingRealm {
    private static Logger logger = Logger.getLogger(UserRealm.class);

//    public void setUserDAO(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    private UserDAO userDAO;



    @Resource
    private UserServiceImpl userService;
    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username=(String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simple = new SimpleAuthorizationInfo();
        //simple.setRoles(this.userDAO.getRoles(username));
        //simple.setStringPermissions(this.userDAO.getPrimary(username));
        Set<String> roles=new HashSet();
        roles.add("admin");
        roles.add("user");
        simple.setRoles(roles);
        String res=userService.getList(1, 10);
        if ("OK".equals(res)) {
            System.out.println("res =GetRoles: " + res);
        }
        return simple;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //CustomUsernamePasswordToken customToken =(CustomUsernamePasswordToken)authenticationToken;
        UsernamePasswordToken customToken=(UsernamePasswordToken)authenticationToken;
       // String validCode = customToken.getValidCode();
        String username = customToken.getUsername();
        System.out.println("username = " + username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username, //用户名
                "4280d89a5a03f812751f504cc10ee8a5", //密码
                getName()  //realm name
        );
        String res=userService.getList(1, 10);
        if ("OK".equals(res)) {
            System.out.println("res = Login:" + res);

        }
        return authenticationInfo;
    }



    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    protected void doClearCache(PrincipalCollection principals) {
        super.doClearCache(principals);
    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }



    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
