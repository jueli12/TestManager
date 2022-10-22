package com.example.beanutils.testUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class testSetProperty {

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
    public void testSetPropertyBase() {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sub_key01", "sub_value01");
        map.put("sub_key02", "sub_value02");
        map.put("sub_key03", "sub_value03");

        testBean.getMapProperty().put("mappedMap", map);

        try {
            BeanUtils.setProperty(testBean, "booleanProperty", true);
            BeanUtils.setProperty(testBean, "byteProperty", (byte)11);
            BeanUtils.setProperty(testBean, "shortProperty", (short)12);
            BeanUtils.setProperty(testBean, "intProperty", 1112);
            BeanUtils.setProperty(testBean, "longProperty", 21112);
            BeanUtils.setProperty(testBean, "floatProperty", (float)11.12);
            BeanUtils.setProperty(testBean, "doubleProperty", 1.112);
            BeanUtils.setProperty(testBean, "stringProperty", "1112");
            BeanUtils.setProperty(testBean, "dateProperty", testCalendar);
            BeanUtils.setProperty(testBean, "intArray",  new int[] { 2002, 11, 12 } );
            BeanUtils.setProperty(testBean, "mapProperty(mappedMap)(sub_key03)", "sub_update_value03");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        assertTrue(testBean.isBooleanProperty());
        assertEquals((byte)11, testBean.getByteProperty());
        assertEquals( (short)12, testBean.getShortProperty());
        assertEquals(1112, testBean.getIntProperty());
        assertEquals(21112, testBean.getLongProperty());
        assertEquals((float)11.12, testBean.getFloatProperty(), 0.005);
        assertEquals(1.112, testBean.getDoubleProperty(), 0.005);
        assertEquals("1112", testBean.getStringProperty());
        assertEquals(testUtilDate, testBean.getDateProperty());
        assertEquals(2002, testBean.getIntArray()[0]);
        assertEquals(11, testBean.getIntArray()[1]);
        assertEquals(12, testBean.getIntArray()[2]);
        assertEquals(3, testBean.getIntArray().length);
        assertEquals("sub_update_value03", ((Map<?, ?>)testBean.getMapProperty().get("mappedMap")).get("sub_key03"));

    }

    @Test
    public void testSetPropertyStringToArray() {
        try {
            BeanUtils.setProperty(testBean, "intArray", "2002, 11, 12, 10, 8");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        int[] intArray =  testBean.getIntArray();
        assertEquals(2002, intArray[0]);
        assertEquals(11, intArray[1]);
        assertEquals(12, intArray[2]);
        assertEquals(10, intArray[3]);
        assertEquals( 8, intArray[4]);
        assertEquals(5, intArray.length);
    }

    @After
    public void teardown() {
        testBean = null;
    }

}

