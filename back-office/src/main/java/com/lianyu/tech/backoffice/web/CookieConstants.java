package com.lianyu.tech.backoffice.web;

import com.lianyu.tech.core.collection.Key;
import com.lianyu.tech.core.platform.web.site.cookie.CookieSpec;
import com.lianyu.tech.core.util.TimeLength;


public class CookieConstants {
      //  private static final String SHARE_COOKIE_DOMAIN = ".jia.com";
    public static final CookieSpec<String> ADMIN_NAME = CookieSpec.spec(Key.stringKey("admin_name")).path("/").maxAge(TimeLength.days(1));
    public static final CookieSpec<String> ADMIN_PWD = CookieSpec.spec(Key.stringKey("admin_pwd")).path("/").maxAge(TimeLength.days(1));

    public static final CookieSpec<String> ERROR_REFER = CookieSpec.spec(Key.stringKey("error_refer")).path("/").maxAge(TimeLength.days(1));
    public static final CookieSpec<String> ERROR_MSG = CookieSpec.spec(Key.stringKey("error_msg")).path("/").maxAge(TimeLength.days(1));
}
