package com.lianyu.tech.common;

import com.lianyu.tech.core.platform.web.filter.PlatformFilter;
import org.junit.Before;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

public abstract class SpringServiceTest extends SpringWithDbTest {

    @Inject
    private WebApplicationContext webApplicationContext;

    protected MockMvc mockMvc;

    @Before
    public void createMockMVC() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).addFilter(new PlatformFilter()).build();
    }

}
