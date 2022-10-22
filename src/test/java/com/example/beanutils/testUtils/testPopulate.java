package com.example.beanutils.testUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class testPopulate {

    protected TestBean testBean = null;

    /** Test Calendar value */
    protected Calendar testCalendar;

    /** Test java.util.Date value */
    protected java.util.Date testUtilDate;

    @Before
    public void setup() {
        testBean = new TestBean();
        testCalendar = Calendar.getInstance();
        testCalendar.set(2002, Calendar.NOVEMBER, 12, 0, 0, 0);
        testCalendar.set(Calendar.MILLISECOND, 0);
        testUtilDate = testCalendar.getTime();
    }

    @Test
    public void testPopulateBase() {
        Map<String, Object> map = new HashMap<String, Object>();
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
            BeanUtils.populate(testBean, map);
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
    public void testPopulateMap() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("mapProperty(First Key)", "New First Value");
        map.put("mapProperty(Third Key)", "New Third Value");

        try {
            BeanUtils.populate(testBean, map);
        } catch (IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

        assertEquals("New First Value", testBean.getMapProperty().get("First Key"));
        assertEquals("Second Value", testBean.getMapProperty().get("Second Key"));
        assertEquals("New Third Value", testBean.getMapProperty().get("Third Key"));
        assertNull(testBean.getMapProperty().get("Fourth Key"));
    }

    @After
    public void teardown() {
        testBean = null;
    }
}
