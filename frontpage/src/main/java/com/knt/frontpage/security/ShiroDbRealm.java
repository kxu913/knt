package com.knt.frontpage.security;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.knt.core.MappForMybatis;
import com.knt.frontpage.exception.IncorrectCaptchaException;
import com.knt.mapping.PermissionMapper;
import com.knt.mapping.RoleMapper;
import com.knt.mapping.UserForTestMapper;
import com.knt.model.Permission;
import com.knt.model.Role;
import com.knt.model.UserForTest;

public class ShiroDbRealm extends AuthorizingRealm {
	@Autowired
	private MappForMybatis businessManager;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.fromRealm(getName()).iterator()
				.next();

		if (username != null) {
			// 查询用户授权信息
			UserForTestMapper mapper = businessManager
					.getMapper(UserForTestMapper.class);
			UserForTest user = mapper.selectByUserName(username);

			if (user != null) {
				RoleMapper roleMapper = businessManager
						.getMapper(RoleMapper.class);
				Role role = roleMapper.getRoleByUserName(username);
				PermissionMapper permissionMapper = businessManager
						.getMapper(PermissionMapper.class);
				List<Permission> pers = permissionMapper
						.getPemissionByUserName(username);
				if (role != null) {
					SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
					info.addRole(role.getPermission());
					for (Permission per : pers) {
						System.out.println(role.getPermission() + ":" + per.getName());
//						list.add(role.getPermission() + ":" + per.getName());
						info.addStringPermission(role.getPermission() + ":" + per.getName());
					}
					
					return info;
				}
			}
		}

		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		CaptchaUsernamePasswordToken token = (CaptchaUsernamePasswordToken) authcToken;
		// 通过表单接收的用户名
		String username = token.getUsername();
		String captcha = token.getCaptcha();
		System.out.println(token.getCaptcha());
		String _captcha = (String) SecurityUtils.getSubject().getSession()
				.getAttribute(
						com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		System.out.println(captcha + "  " + _captcha);
		if (null == captcha || !captcha.equalsIgnoreCase(_captcha)) {
			throw new IncorrectCaptchaException("验证码错误！");
		}

		// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
		// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
		// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
		if (username != null && !"".equals(username)) {
			UserForTestMapper mapper = businessManager
					.getMapper(UserForTestMapper.class);
			UserForTest user = mapper.selectByUserName(username);

			if (user != null) {
				return new SimpleAuthenticationInfo(user.getUsername(), user
						.getPassword(), getName());
			}
		}

		return null;
	}

}
