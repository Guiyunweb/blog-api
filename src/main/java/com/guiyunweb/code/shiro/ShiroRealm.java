package com.guiyunweb.code.shiro;


import com.guiyunweb.model.PostsUsers;
import com.guiyunweb.repository.PostUsersRepository;
import com.guiyunweb.utils.JwtUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author Guiyun
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    RedisCache redisCache;

    @Autowired
    PostUsersRepository usersRepository;


    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //判断token 是否为authenticationToken的子类
        return authenticationToken instanceof Token;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        String id = JwtUtils.verifyToken(token);
        if (StringUtils.isEmpty(id)) {
            throw new AuthenticationException("token校验不通过");
        }

        PostsUsers postsUsers = redisCache.getCacheObject(id);
        if (postsUsers == null) {
            throw new AuthenticationException("账户未登录或已过期");
        }
        if (!token.equals(postsUsers.getToken())) {
            throw new AuthenticationException("token校验不通过");
        } else {
            return new SimpleAuthenticationInfo(id, token, getName());
        }
    }
}
