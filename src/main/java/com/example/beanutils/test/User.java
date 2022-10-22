package com.example.beanutils.test;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString(callSuper = true)
public class User extends Parent{
    private Integer id;
    private String name;
    private String[] subject;
    private Map<String, String> contactDetails;
}
