package com.muhaimin.springbootresetpasswordapplication.controller;

import com.muhaimin.springbootresetpasswordapplication.service.framework.EmailService;
import com.muhaimin.springbootresetpasswordapplication.service.framework.PasswordResetTokenService;
import com.muhaimin.springbootresetpasswordapplication.service.framework.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {
    private final UserService userService;
    private final MessageSource messageSource;
    private final PasswordResetTokenService passwordResetTokenService;
    private final EmailService emailService;

    @Autowired
    public ForgotPasswordController(UserService userService, MessageSource messageSource,
                                    PasswordResetTokenService passwordResetTokenService, EmailService emailService) {
        this.userService = userService;
        this.messageSource = messageSource;
        this.passwordResetTokenService = passwordResetTokenService;
        this.emailService = emailService;
    }
}