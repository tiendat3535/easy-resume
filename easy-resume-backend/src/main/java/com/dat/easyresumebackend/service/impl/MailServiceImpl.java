package com.dat.easyresumebackend.service.impl;

import com.dat.easyresumebackend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by Pham Tien Dat on 06/11/2017.
 */
@Service
public class MailServiceImpl implements MailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendPlainTextEMail(String to, String subject, String content) throws MessagingException {
        sendEMail(to, subject, content, false);
    }

    @Override
    public void sendHtmlEMail(String to, String subject, String content) throws MessagingException {
        sendEMail(to, subject, content, true);
    }

    public void sendEMail(String to, String subject, String content, boolean isHtml) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(content, isHtml);
        javaMailSender.send(mimeMessage);

    }

}
