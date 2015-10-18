package com.lianyu.tech.common;

import com.lianyu.tech.core.platform.DefaultAppContextInitializer;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestEnvironmentConfig.class}, initializers = DefaultAppContextInitializer.class)
@TransactionConfiguration
@ActiveProfiles("test")
@WebAppConfiguration
public abstract class SpringTest {

}
