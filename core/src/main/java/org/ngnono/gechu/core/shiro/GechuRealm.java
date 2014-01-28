package org.ngnono.gechu.core.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.ngnono.gechu.core.entity.PermissionEntity;
import org.ngnono.gechu.core.entity.RoleEntity;
import org.ngnono.gechu.core.entity.UserEntity;
import org.ngnono.gechu.core.repository.impl.AccountRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;



/**
 * Created by ngnono on 14-1-27.
 */
public class GechuRealm extends AuthorizingRealm
        implements
        Realm,
        InitializingBean {

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private AccountRepository accountRepository;

    @Override
    public String getName() {
        return getClass().getName();
    }

    /**
     * Retrieves the AuthorizationInfo for the given principals from the underlying data store.  When returning
     * an instance from this method, you might want to consider using an instance of
     * {@link org.apache.shiro.authz.SimpleAuthorizationInfo SimpleAuthorizationInfo}, as it is suitable in most cases.
     *
     * @param principals the primary identifying principals of the AuthorizationInfo that should be retrieved.
     * @return the AuthorizationInfo associated with this principals.
     * @see org.apache.shiro.authz.SimpleAuthorizationInfo
     * <p/>
     * 在给定的 principals在数据中 检索授权信息。在方法中返回一个实例，你可能要考虑使用的一个实例，在大多数时候它是合适的。
     * principals
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)super.getAvailablePrincipal(principals);
        UserEntity user = accountRepository.getByUsername(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();
        Set<String> permissions = new HashSet<String>();

        for (RoleEntity role : user.getRoles()) {
            roles.add(role.getName());
            for (PermissionEntity per : role.getPermissions()) {
                permissions.add(per.getName());
            }
        }

        info.addRoles(roles);
        info.addStringPermissions(permissions);

        return info;
    }

    /**
     * Retrieves authentication data from an implementation-specific datasource (RDBMS, LDAP, etc) for the given
     * authentication token.
     * <p/>
     * For most datasources, this means just 'pulling' authentication data for an associated subject/user and nothing
     * more and letting Shiro do the rest.  But in some systems, this method could actually perform EIS specific
     * log-in logic in addition to just retrieving data - it is up to the Realm implementation.
     * <p/>
     * A {@code null} return value means that no account could be associated with the specified token.
     *
     * @param token the authentication token containing the user's principal and credentials.
     * @return an {@link org.apache.shiro.authc.AuthenticationInfo} object containing account data resulting from the
     * authentication ONLY if the lookup is successful (i.e. account exists and is valid, etc.)
     * @throws org.apache.shiro.authc.AuthenticationException if there is an error acquiring data or performing
     *                                                        realm-specific authentication logic for the specified <tt>token</tt>
     * 检索认证数据
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        SimpleAuthenticationInfo info = null;

        UsernamePasswordToken upt = (UsernamePasswordToken) token;
        String username = upt.getUsername();
        UserEntity user = accountRepository.getByUsername(username);

        if (user == null) {
            throw new AuthenticationException();
        }

        info = new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName());

        return info;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Assert.notNull(accountRepository);
    }
}
