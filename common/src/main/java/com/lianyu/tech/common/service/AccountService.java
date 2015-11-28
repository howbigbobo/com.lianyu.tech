package com.lianyu.tech.common.service;

import com.lianyu.tech.common.domain.Account;
import com.lianyu.tech.common.repository.AccountRepository;
import com.lianyu.tech.common.utils.ByteUtils;
import com.lianyu.tech.core.crypto.HMAC;
import com.lianyu.tech.core.platform.exception.InvalidRequestException;
import com.lianyu.tech.core.platform.exception.UserAuthorizationException;
import com.lianyu.tech.core.util.StringUtils;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author bowen
 */
@Service
public class AccountService {
    private static final String PASSWORD_SALT = "aa27744203671ba1561b29195087afa5";

    @Inject
    private AccountRepository accountRepository;

    public String encrypt(String pwd) {
        if (!StringUtils.hasText(pwd)) return "";
        HMAC hmac = new HMAC();
        hmac.setHash(HMAC.Hash.SHA512);
        hmac.setSecretKey(PASSWORD_SALT.getBytes());
        byte[] encryptedBytes = hmac.digest(pwd);
        return ByteUtils.bytesToHex(encryptedBytes);
    }

    @Transactional
    public void add(Account account) {
        String name = account.getName();
        Account existAccount = accountRepository.getByName(name);
        if (existAccount != null) {
            throw new InvalidRequestException("用户名已存在.");
        }
        assertPwdNotEmpty(account.getPwd());

        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());
        account.setCreateUser("");
        account.setUpdateUser("");
        account.setPwd(encrypt(account.getPwd()));
        account.setStatus(Account.Status.active);
        accountRepository.create(account);
    }

    @Transactional
    public void updatePwd(String name, String oldPwd, String newPwd) {
        assertPwdNotEmpty(newPwd);
        Account existAccount = getValidAccount(name, oldPwd);
        existAccount.setUpdateTime(new Date());
        existAccount.setUpdateUser("");
        existAccount.setPwd(encrypt(newPwd));
        accountRepository.update(existAccount);
    }

    @Transactional
    public Account login(String name, String pwd) {
        Account existAccount = getValidAccount(name, pwd);
        existAccount.setLastLogin(new Date());
        accountRepository.update(existAccount);
        return existAccount;
    }

    private Account getValidAccount(String name, String pwd) {
        Account existAccount = accountRepository.getByName(name);
        if (!StringUtils.hasText(pwd)) {
            throw new UserAuthorizationException("密码不能为空.");
        }
        if (existAccount == null) {
            throw new UserAuthorizationException("用户名不存在.");
        }
        String encryptPwd = encrypt(pwd);
        if (!encryptPwd.equals(existAccount.getPwd())) {
            throw new UserAuthorizationException("密码不正确.");
        }
        if (!Account.Status.active.equals(existAccount.getStatus())) {
            throw new UserAuthorizationException("用户未激活或已锁定.");
        }
        return existAccount;
    }

    private void assertPwdNotEmpty(String pwd) {
        if (!StringUtils.hasText(pwd)) {
            throw new InvalidRequestException("密码不能为空.");
        }
    }
}
