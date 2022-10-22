package com.example.beanutils.testUtils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
//@Suite.SuiteClasses({testSetProperty.class, testCloneBean.class, testCopyProperties.class, testPopulate.class})
@Suite.SuiteClasses(testBeanUtils.class)
public class SuiteTest {

}
