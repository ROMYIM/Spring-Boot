package com.yim.util;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
*@author:   yim
*@date:  2018年3月12日下午5:06:56
*@description:   邮件工具类
*/
@Component
public class EmailUtil {
	
	private static JavaMailSenderImpl mailSender;
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);
	
	@Autowired
	public void setMailSender(JavaMailSenderImpl mailSender) {
		EmailUtil.mailSender = mailSender;
	}
	
	/**
	 *  发送带附件的邮件
	 * @param subject       邮件主题
	 * @param receivers    收件人
	 * @param ccUsers      抄送
	 * @param content      邮件内容
	 * @param attachFiles   附件列表
	 * @return   发送邮件成功与否
	 */
	public static boolean sendEmail(String subject, String[] receivers, String[] ccUsers, String content, 
			List<Map<String, String>>  attachFiles) {
		boolean flag = true;
		try {
            MimeMessage maileMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(maileMessage, true);
            messageHelper.setTo(receivers);
            if (ccUsers != null && ccUsers.length > 0) {
				messageHelper.setCc(ccUsers);
			}
            messageHelper.setFrom(mailSender.getUsername());
            messageHelper.setSubject(subject);
            messageHelper.setText(content);
            if (attachFiles != null && attachFiles.size() > 0) {
				for (Map<String, String> attachFileMap : attachFiles) {
					String fileName = attachFileMap.get("name");
					File file = new File(attachFileMap.get("file"));
					messageHelper.addAttachment(fileName, file);
				}
			}
            mailSender.send(maileMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			LOGGER.error("发送邮件失败", e);
			flag = false;
		}
		return flag;
	}
	
	
}
