package com.yim.config;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.sun.mail.util.MailSSLSocketFactory;

/**
*@author:   yim
*@date:  2018年3月13日上午10:37:18
*@description:   
*/
@Configuration
public class EmailSenderConfig {
	
	@Autowired
	private Environment environment;
	private static EmailConfigProperty emailUtilProperty;
	
	@PostConstruct
	public void initEmailUtilProperty() {
		emailUtilProperty = new EmailConfigProperty(environment.getProperty("mail.smtp.auth"), 
				environment.getProperty("mail.host"), 
				environment.getProperty("mail.transport.protocol"), 
				environment.getProperty("mail.smtp.port", Integer.class), 
				environment.getProperty("mail.auth.name"), 
				environment.getProperty("mail.auth.password"), 
				environment.getProperty("mail.is.ssl", Boolean.class), 
				environment.getProperty("mail.send.charset"), 
				environment.getProperty("mail.smtp.timeout"));
	}
	
	@Bean
	public JavaMailSenderImpl createMailSender() {
		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		javaMailSender.setHost(emailUtilProperty.getHost());
		javaMailSender.setUsername(emailUtilProperty.getAuthName());
        javaMailSender.setPassword(emailUtilProperty.getPassword());
        javaMailSender.setDefaultEncoding(emailUtilProperty.getCharset());
        javaMailSender.setProtocol(emailUtilProperty.getProtocol());
        javaMailSender.setPort(emailUtilProperty.getPort());
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", emailUtilProperty.getAuth());
        properties.setProperty("main.smtp.timeout", emailUtilProperty.getTimeout());
        if (emailUtilProperty.isSSL()) {
			MailSSLSocketFactory socketFactory = null;
			try {
				socketFactory = new MailSSLSocketFactory();
				socketFactory.setTrustAllHosts(true);
				properties.put("mail.smtp.ssl.enable", "false");
				properties.put("mail.smtp.ssl.socketFactory", socketFactory);
			} catch (GeneralSecurityException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
	}

	private class EmailConfigProperty {
		private String auth;
		private String host;
		private String protocol;
		private int port;
		private String authName;
		private String password;
		private boolean isSSL;
		private String charset;
		private String timeout;
		
		public EmailConfigProperty(String auth, String host, String protocol, int port, String authName, String password,
				boolean isSSL, String charset, String timeout) {
			super();
			this.auth = auth;
			this.host = host;
			this.protocol = protocol;
			this.port = port;
			this.authName = authName;
			this.password = password;
			this.isSSL = isSSL;
			this.charset = charset;
			this.timeout = timeout;
		}
		
		public String getAuth() {
			return auth;
		}
		
		public String getHost() {
			return host;
		}
		
		public String getProtocol() {
			return protocol;
		}
		
		public int getPort() {
			return port;
		}
		
		public String getAuthName() {
			return authName;
		}
		
		public String getPassword() {
			return password;
		}
		
		public boolean isSSL() {
			return isSSL;
		}
		
		public String getCharset() {
			return charset;
		}
		
		public String getTimeout() {
			return timeout;
		}
		
	}
}
