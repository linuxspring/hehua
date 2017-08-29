package myshiro;

import net.plugins.service.UserServiceImpl;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/30.
 * IntelliJ IDEA 2017 of gzcss
 */
public class MyCasRealm  extends CasRealm {
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //authorizationInfo.setRoles(userService.findRoles(username));
        //authorizationInfo.setStringPermissions(userService.findPermissions(username));
        Set<String> roles = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();
        roles.add("admin");
        permissions.add("user:add");
        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(permissions);

        return authorizationInfo;
    }
    public String getCasServerUrlPrefix() {
        System.out.println("======================================getCasServerUrlPrefix");
        return "http://localhost:7080/cas";
    }
    /**
     * 返回 CAS 客户端处理地址，实际使用一般通过参数进行配置
     */
    public String getCasService() {
        System.out.println("======================================getCasService");
        return "http://localhost:7080/wx/index.html";
    }
}
