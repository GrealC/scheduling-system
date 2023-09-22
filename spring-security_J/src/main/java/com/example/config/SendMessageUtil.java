package com.example.config;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.example.mapper.UserMapper;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Pattern;

@Component
public class SendMessageUtil {
    @Resource
    private UserMapper usermapper;
    /**
     * 检查密码和重复密码是否一致
     * @param password
     * @param RepeatPassword
     * @return
     */
    public boolean CheckPassword(String password,String RepeatPassword){
        return Objects.equals(password, RepeatPassword);
    }
    /**
     * 判断邮箱格式是否正确
     * @param email
     * @return false或者true
     */
    public  boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        return pattern.matcher(email).matches();
    }

    //验证手机是否符合规定要求
    public boolean isMobile(String mobile){
        String str="^((13[0-9])|(15[^4,\\D])|(14[57])|(17[0-9])|(18[0,0-9]))\\d{8}$";
        boolean falg=false;
        Pattern pattern = Pattern.compile(str);
        falg=pattern.matcher(mobile).matches();
        return falg;
    }
    /**
     * 发送邮件(参数自己根据自己的需求来修改，发送短信验证码可以直接套用这个模板)
     * @param from_email    发送人的邮箱
     * @param pwd			发送人的授权码
     * @param recevices		接收人的邮箱
     * @param code			验证码
     * @param name			收件人的姓名
     * @return
     */
    public String sendQQEmail(String from_email, String pwd, String recevices, String code, String name){
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");		//使用smpt的邮件传输协议
        props.setProperty("mail.smtp.host", "smtp.qq.com");		//主机地址
        props.setProperty("mail.smtp.auth", "true");		//授权通过

        Session session = Session.getInstance(props);		//通过我们的这些配置，得到一个会话程序

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from_email));		//设置发件人
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(recevices,"用户","utf-8"));		//设置收件人
            message.setSubject("注册码","utf-8");		//设置主题
            message.setSentDate(new Date());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String str = "<!DOCTYPE html><html><head><meta charset='UTF-8'></head><body><p style='font-size: 20px;font-weight:bold;'>尊敬的："+name+"，您好！</p>"
                    + "<p style='text-indent:2em; font-size: 20px;'>您本次的验证码是 "
                    + "<span style='font-size:30px;font-weight:bold;color:red'>" + code + "</span>，3分钟之内有效，请尽快使用！</p>"
                    + "<p style='text-align:right; padding-right: 20px;'"
                    + "<a href='http://120.79.29.170' style='font-size: 18px'>餐饮智能劳动力管理系统</a></p>"
                    + "<span style='font-size: 18px; float:right; margin-right: 60px;'>" + sdf.format(new Date()) + "</span></body></html>";

            Multipart mul=new MimeMultipart();  //新建一个MimeMultipart对象来存放多个BodyPart对象
            BodyPart mdp=new MimeBodyPart();  //新建一个存放信件内容的BodyPart对象
            mdp.setContent(str, "text/html;charset=utf-8");
            mul.addBodyPart(mdp);  //将含有信件内容的BodyPart加入到MimeMultipart对象中
            message.setContent(mul); //把mul作为消息内容

            message.saveChanges();

            //创建一个传输对象
            Transport transport=session.getTransport("smtp");

            //建立与服务器的链接  465端口是 SSL传输
            transport.connect("smtp.qq.com", 25, from_email, pwd);

            //发送邮件
            transport.sendMessage(message,message.getAllRecipients());

            //关闭邮件传输
            transport.close();
            return "验证码发送成功";

        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return "邮箱可能不存在，验证码发送失败";
        }
    }

    /**
     * 发送短信
     * @param signName 签名
     * @param templateCode 模板
     * @param phoneNumbers 手机号
     * @param param 参数
     */
    public String sendMobile(String signName, String templateCode,String phoneNumbers,String param) throws ClientException {
        final String accessKeyId = "LTAI5tGyt73wZCU3eegD4z1E";
        final String accessKeySecret = "yG8XaJXKuIgEUsApk8x9xk2q0XFCe8";
        // 产品名称:云通信短信API产品,开发者无需替换
       final String product = "Dysmsapi";
        // 产品域名,开发者无需替换
        final String domain = "dysmsapi.aliyuncs.com";

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        // 组装请求对象-具体描述见控制台-文档部分内容
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);//注意这四行，与官网所展示的方法不同
        request.setVersion("2017-05-25");
        request.setPhoneNumbers(phoneNumbers);
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
        request.setTemplateParam("{\"code\":\""+param+"\"}");
        String message;
        try {
            SendSmsResponse response = acsClient.getAcsResponse(request);
//            message="短信发送成功";
            message=response.getMessage();
        }catch (ClientException e) {
            e.printStackTrace();
           message= "手机号可能不存在，验证码发送失败";
        }
        return message;
    }

    /**生成随机的六位验证码*/
    public StringBuilder CreateCode() {
        String dates = "0123456789";
        StringBuilder code = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int index = r.nextInt(dates.length());
            char c = dates.charAt(index);
            code.append(c);
        }
        return code;
    }
}
