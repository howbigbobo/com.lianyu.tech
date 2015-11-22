package com.lianyu.tech.backoffice.web;

import com.lianyu.tech.core.collection.Key;


public final class SessionConstants {
    public static final Key<String> ACCOUNT_LOGIN = Key.stringKey("account-login");
    public static final Key<Boolean> ACCOUNT_IS_LOGIN = Key.booleanKey("account-is-login");
    public static final Key<String> VERIFY_CODE_IMG = Key.stringKey("verify-code-image");
}
