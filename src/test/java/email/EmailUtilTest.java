package email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.yim.Application;
import com.yim.util.EmailUtil;

/**
*@author:   yim
*@date:  2018年3月13日上午11:34:10
*@description:   
*/

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmailUtilTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilTest.class);
	
	@Test
	public void maileSenderTest() {
		if (EmailUtil.sendEmail("邮件测试", new String[] {"1500975523@qq.com"}, null, "邮件测试", null)) {
			LOGGER.info("邮件测试成功");
		} else {
			LOGGER.error("邮件测试失败");
		}
	}
}
