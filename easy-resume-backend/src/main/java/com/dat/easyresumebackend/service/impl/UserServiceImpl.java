package com.dat.easyresumebackend.service.impl;

import com.dat.easyresumebackend.domain.User;
import com.dat.easyresumebackend.domain.VerificationToken;
import com.dat.easyresumebackend.dto.VerificationAccountEmailDto;
import com.dat.easyresumebackend.exception.UserAlreadyExistsException;
import com.dat.easyresumebackend.repository.UserRepository;
import com.dat.easyresumebackend.service.MailService;
import com.dat.easyresumebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Created by Pham Tien Dat on 05/11/2017.
 */
@Service
@Transactional(rollbackFor = Throwable.class)
public class UserServiceImpl implements UserService {

    @Value("${app.easy.resume.verification}")
    private String verificationPath;

    @Value("${app.easy.resume.expired.date}")
    private int expiredDate;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MailService mailService;

    @Override
    public void checkUserNotExistsByUsername(String username) throws UserAlreadyExistsException {
        long numberOfUser = userRepository.countByUsername(username);
        if(numberOfUser >= 1) {
            throw new UserAlreadyExistsException(username);
        }
    }

    @Override
    public User registerUser(User user) throws MessagingException {
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setExpiredDate(LocalDate.now().plusDays(expiredDate));
        verificationToken.setToken(UUID.randomUUID().toString());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        user.setVerificationToken(verificationToken);
        User savedUser = userRepository.save(user);

        mailService.sendHtmlEMail(user.getUsername(), "Verification Account Email from Easy Resume", buildTemplateEmail(user, verificationToken));
        return savedUser;
    }

    private String buildTemplateEmail(User user, VerificationToken verificationToken) {
        VerificationAccountEmailDto verAccountEmailDto = new VerificationAccountEmailDto();
        verAccountEmailDto.setUserName(user.getUsername());
        verAccountEmailDto.setVerificationPath(verificationPath + "/" + verificationToken.getToken());

        Context context = new Context();
        context.setVariable("verAccountEmailDto", verAccountEmailDto);

        return templateEngine.process("verification-account-email", context);
    }
}
