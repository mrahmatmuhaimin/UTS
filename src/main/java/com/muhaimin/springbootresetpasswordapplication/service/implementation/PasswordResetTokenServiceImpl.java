package com.muhaimin.springbootresetpasswordapplication.service.implementation;

import com.muhaimin.springbootresetpasswordapplication.repository.PasswordResetTokenRepository;
import com.muhaimin.springbootresetpasswordapplication.service.framework.PasswordResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {
    private final PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    public PasswordResetTokenServiceImpl(PasswordResetTokenRepository passwordResetTokenRepository) {
        this.passwordResetTokenRepository = passwordResetTokenRepository;
    }
}