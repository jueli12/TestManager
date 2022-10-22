package com.example.beanutils.testUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testCopyProperties {

    protected TestBean testBean = null;

    protected BeanCase beanCase = null;

    /** Test Calendar value */
    protected Calendar testCalendar;

    /** Test java.util.Date value */
    protected java.util.Date testUtilDate;

    @Before
    public void setup() {
        testBean = new TestBean();
        beanCase = new BeanCase();
        testCalendar = Calendar.getInstance();
        testCalendar.set(2002, Calendar.NOVEMBER, 12, 0, 0, 0);
        testCalendar.set(Calendar.MILLISECOND, 0);
        testUtilDate = testCalendar.getTime();
    }

    @Test
    public void testCopyPropertiesBase() {
        try {
            BeanUtils.copyProperties(testBean, beanCase);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        assertTrue(testBean.isBooleanProperty());
        assertEquals((byte)11, testBean.getByteProperty());
        assertEquals( (short)12, testBean.getShortProperty());
        assertEquals(1112, testBean.getIntProperty());
        assertEquals(21112, testBean.getLongProperty());
        assertEquals((float)11.12, testBean.getFloatProperty(), 0.00001);
        assertEquals(1.112, testBean.getDoubleProperty(), 0.00001);
        assertEquals("1112", testBean.getStringProperty());
        assertEquals(2002, testBean.getIntArray()[0]);
        assertEquals(11, testBean.getIntArray()[1]);
        assertEquals(12, testBean.getIntArray()[2]);
        assertEquals(3, testBean.getIntArray().length);
    }

    @Test
    public void testCopyPropertiesMap() {
        TestBean testBean = new TestBean();
        final Map<String, Object> map = new HashMap<String, Object>();
        map.put("booleanProperty", "true");
        map.put("byteProperty", "11");
        map.put("shortProperty", "12");
        map.put("intProperty", "1112");
        map.put("longProperty", "21112");
        map.put("floatProperty", "11.12");
        map.put("doubleProperty", "1.112");
        map.put("stringProperty", "1112");
        map.put("intArray", new int[] { 2002, 11, 12 });

        try {
            BeanUtils.copyProperties(testBean, map);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        assertTrue(testBean.isBooleanProperty());
        assertEquals((byte)11, testBean.getByteProperty());
        assertEquals( (short)12, testBean.getShortProperty());
        assertEquals(1112, testBean.getIntProperty());
        assertEquals(21112, testBean.getLongProperty());
        assertEquals((float)11.12, testBean.getFloatProperty(), 0.00001);
        assertEquals(1.112, testBean.getDoubleProperty(), 0.00001);
        assertEquals("1112", testBean.getStringProperty());
        assertEquals(2002, testBean.getIntArray()[0]);
        assertEquals(11, testBean.getIntArray()[1]);
        assertEquals(12, testBean.getIntArray()[2]);
        assertEquals(3, testBean.getIntArray().length);
    }

//    @Test
//    public void testCopyPropertiesDynaBean() {
//
//        TestBean dist = new TestBean();
//        DynaBean orig = (DynaBean) new TestBean();
//
//        orig.set("booleanProperty", Boolean.TRUE);
//        orig.set("byteProperty", (byte)11);
//        orig.set("shortProperty", (short)12);
//        orig.set("intProperty", 1112);
//        orig.set("longProperty", 21112);
//        orig.set("shortProperty", (float) 11.12);
//        orig.set("doubleProperty", 1.112);
//        orig.set("intArray", new int[] { 100, 200, 300 });
//
//        try {
//            BeanUtils.copyProperties(dist, orig);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        assertTrue(dist.isBooleanProperty());
//        assertEquals((byte)11, dist.getByteProperty());
//        assertEquals( (short)12, dist.getShortProperty());
//        assertEquals(1112, dist.getIntProperty());
//        assertEquals(21112, dist.getLongProperty());
//        assertEquals((float)11.12, dist.getFloatProperty(), 0.00001);
//        assertEquals(1.112, dist.getDoubleProperty(), 0.00001);
//        assertEquals("1112", dist.getStringProperty());
//        assertEquals(2002, dist.getIntArray()[0]);
//        assertEquals(11, dist.getIntArray()[1]);
//        assertEquals(12, dist.getIntArray()[2]);
//        assertEquals(3, dist.getIntArray().length);
//
//    }

    @After
    public void teardown() {
        testBean = null;
        beanCase = null;
    }
}
