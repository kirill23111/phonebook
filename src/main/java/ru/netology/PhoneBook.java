package ru.netology;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {
    private final Map<String, String> nameToNumber = new TreeMap<>();
    private final Map<String, String> numberToName = new HashMap<>();

    public int add(String name, String number) {
        nameToNumber.put(name, number);
        numberToName.put(number, name);
        return nameToNumber.size();
    }
}
