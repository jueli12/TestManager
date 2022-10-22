package com.example.beanutils.testUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testCloneBean {

    protected TestBean orig = null;

    protected TestBean dest = null;

    /** Test Calendar value */
    protected Calendar testCalendar;

    /** Test java.util.Date value */
    protected java.util.Date testUtilDate;

    @Before
    public void setup() {
        orig = new TestBean();
        dest = new TestBean();
        testCalendar = Calendar.getInstance();
        testCalendar.set(2002, Calendar.NOVEMBER, 12, 0, 0, 0);
        testCalendar.set(Calendar.MILLISECOND, 0);
        testUtilDate = testCalendar.getTime();
    }

    @Test
    public void testCloneBeanBase() {

        orig.setBooleanProperty(true);
        orig.setByteProperty((byte)11);
        orig.setShortProperty((short)12);
        orig.setIntProperty(1112);
        orig.setLongProperty(21112);
        orig.setFloatProperty((float) 11.12);
        orig.setDoubleProperty(1.112);
        orig.setStringProperty("1112");
        orig.setIntArray(new int[] { 2002, 11, 12 });

        try {
            dest = (TestBean) BeanUtils.cloneBean(orig);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        assertTrue(dest.isBooleanProperty());
        assertEquals((byte)11, dest.getByteProperty());
        assertEquals( (short)12, dest.getShortProperty());
        assertEquals(1112, dest.getIntProperty());
        assertEquals(21112, dest.getLongProperty());
        assertEquals((float)11.12, dest.getFloatProperty(), 0.00001);
        assertEquals(1.112, dest.getDoubleProperty(), 0.00001);
        assertEquals("1112", dest.getStringProperty());
        assertEquals(2002, dest.getIntArray()[0]);
        assertEquals(11, dest.getIntArray()[1]);
        assertEquals(12, dest.getIntArray()[2]);
        assertEquals(3, dest.getIntArray().length);
    }

    @After
    public void teardown() {
        orig = null;
        dest = null;
    }
}
