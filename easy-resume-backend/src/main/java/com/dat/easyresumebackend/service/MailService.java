package com.dat.easyresumebackend.service;

import com.dat.easyresumebackend.domain.User;
import org.springframework.mail.MailException;

import javax.mail.MessagingException;

/**
 * Created by Pham Tien Dat on 06/11/2017.
 */
public interface MailService {
    /**
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    void sendPlainTextEMail(String to, String subject, String content) throws MessagingException;

    /**
     *
     * @param to
     * @param subject
     * @param content
     * @throws MessagingException
     */
    void sendHtmlEMail(String to, String subject, String content) throws MessagingException;
}
