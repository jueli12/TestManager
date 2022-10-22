package com.example.beanutils.test;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class testBeanUtils {
    /** Test Calendar value */
    protected static Calendar testCalendar;

    /** Test java.util.Date value */
    protected static java.util.Date testUtilDate;

    public static void main(String[] args) {

        testCalendar = Calendar.getInstance();
        testCalendar.set(2002, Calendar.NOVEMBER, 12, 0, 0, 0);
        testCalendar.set(Calendar.MILLISECOND, 0);
        testUtilDate = testCalendar.getTime();

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("sub_key01", "sub_value01");
        map1.put("sub_key02", "sub_value02");
        map1.put("sub_key03", "sub_value03");

        TestBean testBean1 = new TestBean();

        testBean1.getMapProperty().put("mappedMap", map1);

        try {
            BeanUtils.setProperty(testBean1, "booleanProperty", true);
            BeanUtils.setProperty(testBean1, "byteProperty", (byte)11);
            BeanUtils.setProperty(testBean1, "shortProperty", (short)12);
            BeanUtils.setProperty(testBean1, "intProperty", 1112);
            BeanUtils.setProperty(testBean1, "longProperty", 21112);
            BeanUtils.setProperty(testBean1, "floatProperty", (float)11.12);
            BeanUtils.setProperty(testBean1, "doubleProperty", 1.112);
            BeanUtils.setProperty(testBean1, "stringProperty", "1112");
            BeanUtils.setProperty(testBean1, "dateProperty", testCalendar);
            BeanUtils.setProperty(testBean1, "intArray",  "2002, 11, 12" );
            BeanUtils.setProperty(testBean1, "mapProperty(mappedMap)(sub_key03)", "sub_update_value03");
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(testBean1.isBooleanProperty());
        System.out.println(testBean1.getByteProperty());
        System.out.println(testBean1.getShortProperty());
        System.out.println(testBean1.getIntProperty());
        System.out.println(testBean1.getLongProperty());
        System.out.println(testBean1.getFloatProperty());
        System.out.println(testBean1.getDoubleProperty());
        System.out.println(testBean1.getStringProperty());
        System.out.println(testBean1.getDateProperty());
        System.out.println(testBean1.getIntArray()[0]);
        System.out.println(testBean1.getIntArray()[1]);
        System.out.println(testBean1.getIntArray()[2]);
        System.out.println(testBean1.getIntArray().length);
        System.out.println(((Map<?, ?>)testBean1.getMapProperty().get("mappedMap")).get("sub_key03"));

        TestBean orig = new TestBean();
        TestBean dest = new TestBean();

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

        System.out.println(dest.isBooleanProperty());
        System.out.println(dest.getByteProperty());
        System.out.println(dest.getShortProperty());
        System.out.println(dest.getIntProperty());
        System.out.println(dest.getLongProperty());
        System.out.println(dest.getFloatProperty());
        System.out.println(dest.getDoubleProperty());
        System.out.println(dest.getStringProperty());
        System.out.println(dest.getDateProperty());
        System.out.println(dest.getIntArray()[0]);
        System.out.println(dest.getIntArray()[1]);
        System.out.println(dest.getIntArray()[2]);
        System.out.println(dest.getIntArray().length);

        TestBean testBean2 = new TestBean();
        BeanCase beanCase = new BeanCase();
        try {
            BeanUtils.copyProperties(testBean2, beanCase);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(testBean2.isBooleanProperty());
        System.out.println(testBean2.getByteProperty());
        System.out.println(testBean2.getShortProperty());
        System.out.println(testBean2.getIntProperty());
        System.out.println(testBean2.getLongProperty());
        System.out.println(testBean2.getFloatProperty());
        System.out.println(testBean2.getDoubleProperty());
        System.out.println(testBean2.getStringProperty());
        System.out.println(testBean2.getDateProperty());
        System.out.println(testBean2.getIntArray()[0]);
        System.out.println(testBean2.getIntArray()[1]);
        System.out.println(testBean2.getIntArray()[2]);
        System.out.println(testBean2.getIntArray().length);

        TestBean testBean3 = new TestBean();
        final Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("booleanProperty", "true");
        map2.put("byteProperty", "11");
        map2.put("shortProperty", "12");
        map2.put("intProperty", "1112");
        map2.put("longProperty", "21112");
        map2.put("floatProperty", "11.12");
        map2.put("doubleProperty", "1.112");
        map2.put("stringProperty", "1112");
        map2.put("intArray", new int[] { 2002, 11, 12 });

        try {
            BeanUtils.copyProperties(testBean3, map2);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(testBean3.isBooleanProperty());
        System.out.println(testBean3.getByteProperty());
        System.out.println(testBean3.getShortProperty());
        System.out.println(testBean3.getIntProperty());
        System.out.println(testBean3.getLongProperty());
        System.out.println(testBean3.getFloatProperty());
        System.out.println(testBean3.getDoubleProperty());
        System.out.println(testBean3.getStringProperty());
        System.out.println(testBean3.getDateProperty());
        System.out.println(testBean3.getIntArray()[0]);
        System.out.println(testBean3.getIntArray()[1]);
        System.out.println(testBean3.getIntArray()[2]);
        System.out.println(testBean3.getIntArray().length);

    }
}
