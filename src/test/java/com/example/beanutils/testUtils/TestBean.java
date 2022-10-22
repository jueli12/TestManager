package com.example.beanutils.testUtils;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class TestBean {
    private boolean booleanProperty;
    private byte byteProperty;
    private short shortProperty;
    private int intProperty;
    private long longProperty;
    private float floatProperty;
    private double doubleProperty;
    private String stringProperty;
    //    private boolean booleanSecond = true;
    private java.util.Date dateProperty;
    private java.util.Date[] dateArrayProperty;
//    private String[] dupProperty;
    private int[] intArray;
//    private final int[] intIndexed;
    private List<Object> listIndexed;
    private Map<String, Object> mapProperty;
//    private HashMap<String, Object> mappedObjects;
//    private HashMap<String, String> mappedProperty;
//    private HashMap<String, Integer> mappedIntProperty;
    private NestedBean nestedBean;

    public static class MappedTestBean {
        public void setValue(final String key,final String val) { }
        public String getValue(final String key) { return "Mapped Value"; }
    }
    private BeanCase.MappedTestBean mappedNested;

//    private String nullProperty;
    //    private final String readOnlyProperty = "Read Only String Property";
    private String[] stringArray;
//    private final String[] stringIndexed;
    private String[][] string2dArray;
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
//
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
//
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

    public BeanCase.MappedTestBean getMappedNested() {
        if (mappedNested == null)
        {
            mappedNested = new BeanCase.MappedTestBean();
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

    public TestBean() {

    }

}
