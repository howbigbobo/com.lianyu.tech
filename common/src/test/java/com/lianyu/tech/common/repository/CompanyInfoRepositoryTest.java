package com.lianyu.tech.common.repository;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.lianyu.tech.common.SpringWithDbTest;
import com.lianyu.tech.common.domain.CompanyInfo;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 * @author bowen.zhang
 */
@Ignore
@DatabaseSetup("CompanyInfo.xml")
public class CompanyInfoRepositoryTest extends SpringWithDbTest {
    @Inject
    private CompanyInfoRepository companyInfoRepository;

    @Test
    public void testGet() {
        CompanyInfo companyInfo = companyInfoRepository.get();
        Assert.assertNotNull(companyInfo);
    }

    @Test
    @Transactional
    public void testSave() {
        CompanyInfo companyInfo = new CompanyInfo();
        companyInfo.setName("a1");
        companyInfo.setSlogan("b1");
        companyInfo.setDomain("c1");
        companyInfo.setLogoUrl("u1");
        companyInfoRepository.create(companyInfo);
    }

    @Test
    @Transactional
    public void testUpdate() {
        CompanyInfo companyInfo = companyInfoRepository.get();
        Assert.assertNotNull(companyInfo);
        companyInfo.setName("a2");
        companyInfoRepository.update(companyInfo);
        companyInfo = companyInfoRepository.get();
        Assert.assertNotNull(companyInfo);
        Assert.assertEquals(companyInfo.getName(), "a2");
    }
}
