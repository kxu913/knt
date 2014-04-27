package com.kevin.notification.sms.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthSchemeProvider;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultSchemePortResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * create a SMS Server, need username and password, host and so on
 * 
 * @author kxu
 * 
 */
public class SMSServer {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private final String host;
	private final String userName;
	private final String password;
	// default is any port
	private int port = -1;

	public SMSServer(String host, String userName, String password) {
		this.host = host;
		this.userName = userName;
		this.password = password;

	}

	public SMSServer(String host, int port, String userName, String password) {
		this.host = host;
		this.port = port;
		this.userName = userName;
		this.password = password;

	}

	private HttpClientContext createContext() {
		CredentialsProvider credsProvider = this.getCredsProvider();
		RegistryBuilder<AuthSchemeProvider> registryBuilder = RegistryBuilder.create();
		Registry<AuthSchemeProvider> authRegistry = registryBuilder.build();
		AuthCache authCache = new BasicAuthCache(DefaultSchemePortResolver.INSTANCE);
		HttpClientContext context = HttpClientContext.create();
		context.setCredentialsProvider(credsProvider);
		context.setAuthSchemeRegistry(authRegistry);
		context.setAuthCache(authCache);
		return context;
	}

	public String basicGetResponse(String url) {
		DefaultHttpClient httpClient = null;
		HttpGet getMethod = null;
		try {
			httpClient = new DefaultHttpClient();
			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(userName, password);
			httpClient.getCredentialsProvider().setCredentials(new AuthScope(host, port), creds);
			getMethod = new HttpGet(url);
			HttpResponse response = httpClient.execute(getMethod);
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
		} catch (Exception e) {
			log.error("Call " + url + " falied!" + e);
		}
		return null;
	}

	public String getResponse(String url) {
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
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
		} catch (Exception e) {
			log.error("Call " + url + " falied!" + e);
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				log.error("Close Httpclient failed!" + e);
			}
		}
		return null;
	}

	private CredentialsProvider getCredsProvider() {
		Credentials creds = new UsernamePasswordCredentials(userName, password);
		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(new AuthScope(host, port), creds);
		return provider;

	}
}
