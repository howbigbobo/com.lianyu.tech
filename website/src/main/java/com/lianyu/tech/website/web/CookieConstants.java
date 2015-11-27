package com.lianyu.tech.website.web;

import com.lianyu.tech.core.collection.Key;
import com.lianyu.tech.core.platform.web.site.cookie.CookieSpec;
import com.lianyu.tech.core.util.TimeLength;


public class CookieConstants {
    public static final CookieSpec<String> ERROR_MSG = CookieSpec.spec(Key.stringKey("error_msg")).path("/").maxAge(TimeLength.days(1));
}
