package com.kevin.notification.sms.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.auth.BasicSchemeFactory;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultSchemePortResolver;

import com.kevin.notification.exception.DefindeHttpException;

/**
 * create a SMS Server, need username and password, host and so on
 * 
 * @author kxu
 * 
 */
public class SMSServer {
	private final String host;
	private final String userName;
	private final String password;
	private final static String ENCODE = "UTF-8";

	private SMSServer(String host, boolean isHttps, HttpRequest request, String userName, String password)
			throws AuthenticationException {
		this.host = host;
		this.userName = userName;
		this.password = password;

	}

	private HttpClientContext createContext() {
		CredentialsProvider credsProvider = this.getCredsProvider(host, userName, password);
		RegistryBuilder<AuthSchemeProvider> registryBuilder = RegistryBuilder.create();
		Registry<AuthSchemeProvider> authRegistry = registryBuilder.build();
		AuthCache authCache = new BasicAuthCache(DefaultSchemePortResolver.INSTANCE);
		HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);
		context.setAuthSchemeRegistry(authRegistry);
		context.setAuthCache(authCache);
		return context;
	}

	public String getResponse(String url) {
		try {
			CloseableHttpClient httpclient = HttpClients.custom().build();
			HttpGet get = new HttpGet(url);
			CloseableHttpResponse response = httpclient.execute(get, this.createContext());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream is = entity.getContent();
				BufferedReader in = new BufferedReader(new InputStreamReader(is));
				StringBuffer buffer = new StringBuffer();
				String line = "";
				while ((line = in.readLine()) != null) {
					buffer.append(line);
				}
				return buffer.toString();
			}
			return response.getEntity().toString();
		} catch (DefindeHttpException e) {

		} finally {

		}
	}

	private AuthSchemeProvider getAuthSchemeProvider() {
		AuthSchemeProvider provder = new BasicSchemeFactory(Charset.forName(ENCODE));

		return null;
	}

	private CredentialsProvider getCredsProvider(String host, String userName, String password) {
		Credentials creds = new UsernamePasswordCredentials(userName, password);
		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(new AuthScope(host, -1), creds);
		return provider;

	}
}
