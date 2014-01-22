package com.ny6design.web.security;


import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kevin.security.exception.EmailValidationException;
import com.kevin.security.token.EmailPasswordToken;
import com.kevin.security.util.PasswordUtil;
import com.ny6design.model.User;
import com.ny6design.service.UserService;

/**
 * 
 * @author kevin
 * 
 */
public class ShiroDbRealm extends AuthorizingRealm {
	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String emailAddress = (String) principals.fromRealm(getName())
				.iterator().next();

		if (emailAddress != null) {
			// 查询用户授权信息
			User user = userService.findUserByEmail(emailAddress);
			if (user != null) {
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				return info;
			}
		}

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		EmailPasswordToken token = (EmailPasswordToken) authcToken;
		// 通过表单接收的用户名
		String emailAddress = token.getEmail();
		if (StringUtils.isEmpty(emailAddress)) {
			throw new EmailValidationException("Email is empty！");
		}

		User user = userService.findUserByEmail(emailAddress);

		if (user != null) {
			if (log.isDebugEnabled()) {
				log.debug("Realm : " + user.getPassword());
			}
			return new SimpleAuthenticationInfo(user.getEmailaddress(),
					user.getPassword(), ByteSource.Util.bytes(user.getSalt()),
					getName());
		}

		return null;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		setAuthenticationTokenClass(EmailPasswordToken.class);
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(
				PasswordUtil.HASH_ALGORITHM);
		matcher.setHashIterations(PasswordUtil.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);

	}

}
