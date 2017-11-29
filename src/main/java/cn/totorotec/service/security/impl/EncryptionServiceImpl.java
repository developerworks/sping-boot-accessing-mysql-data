package cn.totorotec.service.security.impl;

import cn.totorotec.service.security.EncryptionService;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;

public class EncryptionServiceImpl implements EncryptionService {
    @Autowired
    StrongPasswordEncryptor strongPasswordEncryptor;

    public StrongPasswordEncryptor getStrongPasswordEncryptor() {
        return strongPasswordEncryptor;
    }

    public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongPasswordEncryptor) {
        this.strongPasswordEncryptor = strongPasswordEncryptor;
    }

    @Override
    public String encryptString(String input) {
        return strongPasswordEncryptor.encryptPassword(input);
    }

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongPasswordEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}
