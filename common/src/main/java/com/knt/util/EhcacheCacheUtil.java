package com.knt.util;

import org.apache.ibatis.cache.CacheException;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * cache util for use
 * 
 * @author kevin
 * 
 */
public class EhcacheCacheUtil {

	public static final String PERSISTENT_CACHE_NAME = "persistentCache";

	public static final String OFTEN_CACHE_NAME = "oftenCache";

	public static final String FIVE_MINUTES_CACHE_NAME = "5minutesCache";

	private static final CacheManager LOCAL_CACHE_MANAGE = CacheManager
			.create();

	private static Cache getCache(final String name) {
		if (name == null) {
			throw new IllegalArgumentException(
					"Cache instances require an name");
		}
		return LOCAL_CACHE_MANAGE.getCache(name);
	}

	public static void clear(String name) {
		getCache(name).removeAll();
	}

	public static Object getObject(String name, Object key) {
		try {
			Element cachedElement = getCache(name).get(key.hashCode());
			if (cachedElement == null) {
				return null;
			}
			return cachedElement.getObjectValue();
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public static int getSize(String name) {
		try {
			return getCache(name).getSize();
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public static void putObject(String name, Object key, Object value) {
		try {
			getCache(name).put(new Element(key.hashCode(), value));
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

	public static Object removeObject(String name, Object key) {
		try {
			Object obj = getObject(name, key);
			getCache(name).remove(key.hashCode());
			return obj;
		} catch (Throwable t) {
			throw new CacheException(t);
		}
	}

}
