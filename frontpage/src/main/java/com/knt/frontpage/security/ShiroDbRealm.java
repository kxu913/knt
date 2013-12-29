package com.knt.frontpage.security;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.knt.core.MappForMybatis;
import com.knt.mapping.UserMapper;
import com.knt.model.User;

public class ShiroDbRealm extends AuthorizingRealm {
	@Autowired
	private MappForMybatis businessManager;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		System.out.println("11111111111");
		String username = (String) principals.fromRealm(getName()).iterator()
				.next();

		if (username != null) {
			// 查询用户授权信息
			UserMapper mapper = businessManager.getMapper(UserMapper.class);
			User user = mapper.getUserByName(username);

			if (user != null) {
				Collection<String> pers = new ArrayList<String>();
				pers.add(username);
				SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
				info.addStringPermissions(pers);
				return info;
			}
		}

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		System.out.println("222222222");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 通过表单接收的用户名
		String username = token.getUsername();

		if (username != null && !"".equals(username)) {
			UserMapper mapper = businessManager.getMapper(UserMapper.class);
			User user = mapper.getUserByName(username);

			if (user != null) {
				return new SimpleAuthenticationInfo(user.getUsername(),
						user.getNickname(), getName());
			}
		}

		return null;
	}

}
