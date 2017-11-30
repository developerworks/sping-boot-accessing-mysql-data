package cn.totorotec.service.security;

import org.springframework.stereotype.Service;

@Service
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
