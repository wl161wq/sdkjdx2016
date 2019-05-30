package com.isoft.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@RestController
@RequestMapping("mail")
public class mail {
    @Autowired
    private JavaMailSender javaMailSender;//在spring中配置的邮件发送的bean

    @RequestMapping("send")
    public Object sendMail03() {
        MimeMessage mMessage = javaMailSender.createMimeMessage();//创建邮件对象
        MimeMessageHelper mMessageHelper;
        Properties prop = new Properties();
        String from;
        try {
            //从配置文件中拿到发件人邮箱地址
            prop.load(this.getClass().getResourceAsStream("/resources/mail.properties"));
            from = prop.get("mail.smtp.username") + "";
            mMessageHelper = new MimeMessageHelper(mMessage, true);
            mMessageHelper.setFrom(from);//发件人邮箱
            mMessageHelper.setTo("2628371870@qq.com");//收件人邮箱
            mMessageHelper.setSubject("Spring的邮件发送");//邮件的主题
            mMessageHelper.setText("<p>这是使用spring的邮件功能发送的一封邮件</p><br/>" +
                    "<a href='https://blog.csdn.net/Mr__Viking'>打开我的博客主页</a><br/>" +
                    "1", true);//邮件的文本内容，true表示文本以html格式打开
            javaMailSender.send(mMessage);//发送邮件
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "chengg ";
    }
}
