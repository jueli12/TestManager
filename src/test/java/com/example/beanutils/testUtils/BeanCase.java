package com.example.beanutils.testUtils;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class BeanCase {

    private boolean booleanProperty = true;
    private byte byteProperty = (byte) 11;
    private short shortProperty = (short) 12;
    private int intProperty = 1112;
    private long longProperty = 21112;
    private float floatProperty = (float) 11.12;
    private double doubleProperty = 1.112;
    private String stringProperty = "1112";
//    private boolean booleanSecond = true;
    private java.util.Date dateProperty;
    private java.util.Date[] dateArrayProperty;
//    private String[] dupProperty =
//            { "Dup 0", "Dup 1", "Dup 2", "Dup 3", "Dup 4" };
    private int[] intArray = { 2002, 11, 12 };
//    private final int[] intIndexed = { 0, 10, 20, 30, 40 };
    private List<Object> listIndexed = new ArrayList<>();
    private Map<String, Object> mapProperty = null;
//    private HashMap<String, Object> mappedObjects = null;
//    private HashMap<String, String> mappedProperty = null;
//    private HashMap<String, Integer> mappedIntProperty = null;
    private NestedBean nestedBean = null;

    public static class MappedTestBean {
        public void setValue(final String key,final String val) { }
        public String getValue(final String key) { return "Mapped Value"; }
    }
    private MappedTestBean mappedNested = null;

//    private String nullProperty = null;
//    private final String readOnlyProperty = "Read Only String Property";
    private String[] stringArray =
            { "String 0", "String 1", "String 2", "String 3", "String 4" };
//    private final String[] stringIndexed =
//            { "String 0", "String 1", "String 2", "String 3", "String 4" };
    private String[][] string2dArray = new String[][] {new String[] { "2002", "11", "12" }, new String[] { "2002", "1", "22" }};
//    private String writeOnlyProperty = "Write Only String Property";




//    public String[] getDupProperty() {
//        return (this.dupProperty);
//    }
//
//    public String getDupProperty(final int index) {
//        return (this.dupProperty[index]);
//    }
//
//    public void setDupProperty(final int index, final String value) {
//        this.dupProperty[index] = value;
//    }
//
//    public void setDupProperty(final String[] dupProperty) {
//        this.dupProperty = dupProperty;
//    }
//
//    public int getIntIndexed(final int index) {
//        return (intIndexed[index]);
//    }
//
//    public void setIntIndexed(final int index, final int value) {
//        intIndexed[index] = value;
//    }

    public Map<String, Object> getMapProperty() {
        // Create the map the very first time
        if (mapProperty == null) {
            mapProperty = new HashMap<String, Object>();
            mapProperty.put("First Key", "First Value");
            mapProperty.put("Second Key", "Second Value");
        }
        return (mapProperty);
    }

    public void setMapProperty(Map<String, Object> mapProperty) {
        // Create the map the very first time
        if (mapProperty == null) {
            mapProperty = new HashMap<String, Object>();
            mapProperty.put("First Key", "First Value");
            mapProperty.put("Second Key", "Second Value");
        }
        this.mapProperty = mapProperty;
    }

//    public Object getMappedObjects(final String key) {
//        // Create the map the very first time
//        if (mappedObjects == null) {
//            mappedObjects = new HashMap<String, Object>();
//            mappedObjects.put("First Key", "First Value");
//            mappedObjects.put("Second Key", "Second Value");
//        }
//        return (mappedObjects.get(key));
//    }

//    public void setMappedObjects(final String key, final Object value) {
//        // Create the map the very first time
//        if (mappedObjects == null) {
//            mappedObjects = new HashMap<String, Object>();
//            mappedObjects.put("First Key", "First Value");
//            mappedObjects.put("Second Key", "Second Value");
//        }
//        mappedObjects.put(key, value);
//    }
//
//    public String getMappedProperty(final String key) {
//        // Create the map the very first time
//        if (mappedProperty == null) {
//            mappedProperty = new HashMap<String, String>();
//            mappedProperty.put("First Key", "First Value");
//            mappedProperty.put("Second Key", "Second Value");
//        }
//        return (mappedProperty.get(key));
//    }

//    public void setMappedProperty(final String key, final String value) {
//        // Create the map the very first time
//        if (mappedProperty == null) {
//            mappedProperty = new HashMap<String, String>();
//            mappedProperty.put("First Key", "First Value");
//            mappedProperty.put("Second Key", "Second Value");
//        }
//        mappedProperty.put(key, value);
//    }
//
//    public int getMappedIntProperty(final String key) {
//        // Create the map the very first time
//        if (mappedIntProperty == null) {
//            mappedIntProperty = new HashMap<String, Integer>();
//            mappedIntProperty.put("One", 1);
//            mappedIntProperty.put("Two", 2);
//        }
//        final Integer x = mappedIntProperty.get(key);
//        return ((x == null) ? 0 : x);
//    }
//
//    public void setMappedIntProperty(final String key, final int value) {
//        mappedIntProperty.put(key, value);
//    }

    public MappedTestBean getMappedNested() {
        if (mappedNested == null)
        {
            mappedNested = new MappedTestBean();
        }
        return mappedNested;
    }

//    public String getStringIndexed(final int index) {
//        return (stringIndexed[index]);
//    }
//
//    public void setStringIndexed(final int index, final String value) {
//        stringIndexed[index] = value;
//    }

    public String[] getString2dArray(final int index) {
        return string2dArray[index];
    }

    public BeanCase() {

    }
}
