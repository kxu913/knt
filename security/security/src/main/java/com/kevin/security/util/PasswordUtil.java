package com.kevin.security.util;

import java.util.Random;

import com.kevin.security.coder.Digests;
import com.kevin.security.coder.Encodes;

public class PasswordUtil {

	private static final int SALT_SIZE = 8;
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;

	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	public static String entryptPassword(byte[] salt, String passtext) {
		byte[] hashPassword = Digests.sha1(passtext.getBytes(), salt,
				HASH_INTERATIONS);
		return Encodes.encodeHex(hashPassword);
	}

	public static byte[] getSalt() {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		return salt;// ;
	}

	/**
	 * 生成随机密码
	 * 
	 * @param length
	 *            生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int length) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < length) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}
}
