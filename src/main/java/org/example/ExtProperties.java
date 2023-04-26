package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.BooleanSupplier;
import java.util.stream.Collectors;

/**
 * Created by agulin on 24.04.2017.
 *
 */
@SuppressWarnings("unchecked")
public class ExtProperties implements CommonConsts {

    private Map<String, Object> map;

    public ExtProperties() {
        super();
        map = new HashMap<>();
    }

    public ExtProperties(ExtProperties src) {
        this();
        copyFrom(src);
    }

    public ExtProperties(String name) {
        this();
        addProperty("name", name);
    }

    public ExtProperties addProperty(String key, String value) {
        if (value == null) {
            map.remove(key);
        } else {
            map.put(key, value);
        }
        return this;
    }

    public ExtProperties addLocalDate(String key, LocalDate value) {
        if (value == null) {
            map.remove(key);
        } else {
            map.put(key, value);
        }
        return this;
    }

    public LocalDate getLocalDate(String key) {
        String res = getProperty(key);
        String dateFormat = String.format("%s", res);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateFormat, formatter);
    }

    public ExtProperties addObject(String key, Object o) {
        map.put(key, o);
        return this;
    }

    public String getProperty(String key) {
        Object res = map.get(key);
        if (res instanceof List) {
            //позволяет прочитать как строку массив из 1 строки
            //иногда это может быть удобно там, где обобщенный метод требует массива, но мы знаем, что там только одно значение
            List<String> list = (List<String>) res;
            if (list.size() == 1) {
                res = list.get(0);
            }
        }
        return res != null ? res.toString() : null;
    }

    public String getProperty(String key, String defaultValue) {
        String res = getProperty(key);
        if (res == null) {
            res = defaultValue;
        }
        return res;
    }

    public ExtProperties addBoolean(String key, boolean value) {
        map.put(key, value);
        return this;
    }

    public Boolean isBoolean(String key) {
        Object o = map.get(key);
        if (o == null) {
            return null;
        }
        if (o instanceof Boolean) {
            return (Boolean) o;
        } else {
            return Boolean.valueOf(o.toString());
        }
    }

    public Boolean isBoolean_TrueFalseOnly(String key) {
        return map.get(key) == null ? false : isBoolean(key);
    }

    private static class TwoValuesProperty {
        private final String value1;
        private final String value2;

        public TwoValuesProperty(String value1, String value2) {
            this.value1 = value1;
            this.value2 = value2;
        }

        public String getValue1() {
            return value1;
        }

        public String getValue2() {
            return value2;
        }

        @Override
        public String toString() {
            return "TwoValuesProperty{" + value1 + '=' + value2 + '}';
        }
    }

    public ExtProperties addTwoValuesProperty(String key, String value1, String value2) {
        map.put(key, new TwoValuesProperty(value1, value2));
        return this;
    }

    public String getFirstValue(String key) {
        TwoValuesProperty res = (TwoValuesProperty)map.get(key);
        return res.getValue1();
    }

    public String getSecondValue(String key) {
        TwoValuesProperty res = (TwoValuesProperty) map.get(key);
        if ((key == null)) {
            return null;
        } else {
            return res.getValue2();
        }
    }

    public ExtProperties addArray(String key, String... values) {
        map.put(key, Arrays.asList(values));
        return this;
    }

    public String[] getArray(String key) {
        Object o = map.get(key);
        if (o == null) {
            return null;
        } else {
            if (o instanceof String) {
                String[] res = new String[1];
                res[0] = (String) o;
                return res;
            } else {
                List<String> s = (List<String>) o;
                return s.toArray(new String[0]);
            }
        }
    }

    public ExtProperties addExtProperties(String key, ExtProperties prop) {
        map.put(key, prop);
        return this;
    }

    public ExtProperties getExtProperties(String key) {
        Object o = map.get(key);
        if (o instanceof ExtProperties) {
            return (ExtProperties) o;
        }
        return null;
    }

    public ExtProperties copyFrom(ExtProperties src) {
        map.clear();
        addProperties(src);
        return this;
    }

    public ExtProperties addPropertiesIf(BooleanSupplier supplier,  ExtProperties values) {
        if (supplier.getAsBoolean()) {
            addProperties(values);
        }
        return this;
    }

    public ExtProperties addProperties(ExtProperties values) {
        values.entrySet().forEach(e -> map.put(e.getKey(), e.getValue()));
        return this;
    }

    public String getFullName() {
        if (getProperty("row") != null) {
            return getProperty("row");
        }
        String s1 = getProperty(Имя);
        String s2 = getProperty(Фамилия);
        if ((s1 == null) || (s2 == null)) {
            return getProperty("name");
        }
        return s1 + " " + s2;
    }

    public ExtProperties addPairsArray(String key, String... values) {
        Map<String, String> old = (Map<String, String>)map.get(key);
        Map<String, String> list = new HashMap<>();
        if (old != null) {
            list.putAll(old);
        }
        for (int i = 0; i < values.length; i = i + 2) {
            list.put(values[i], values[i + 1]);
        }
        map.put(key, list);
        return this;

    }

    public String[] getPairsArray(String key) {
        Map<String, String> pairs = (Map<String, String>)map.get(key);
        List<String> res = new ArrayList<>();
        pairs.forEach((key1, value) -> {
            res.add(key1);
            res.add(value);
        });
        return res.toArray(new String[0]);
    }

    public String[] getPairsKeys(String key) {
        Map<String, String> pairs = (Map<String, String>)map.get(key);
        if (pairs == null) {
            return null;
        } else {
            List<String> res = new ArrayList<>();
            pairs.forEach((key1, value) -> res.add(key1));
            return res.toArray(new String[0]);
        }
    }

    public String getPairValue(String key, String pairKey) {
        Map<String, String> pairs = (Map<String, String>) map.get(key);
        return pairs.get(pairKey);
    }

    public LocalDateTime getDate(String key) {
        String value = getProperty(key);
        if (value != null) {
            return LocalDateTime.parse(value, DateTimeFormatter.ofPattern("dd.MM.yyyy HH.mm.ss"));
        } else {
            return null;
        }
    }

    public ExtProperties addArrayOfProperties(String key, ExtProperties... props) {
        if (props.length > 0) {
            List<ExtProperties>  res = new ArrayList<>();
            Collections.addAll(res, props);
            map.put(key, res);
        }
        return this;
    }

    public ExtProperties addPropertyIntoArray(String arrayName, ExtProperties prop) {
        List<ExtProperties>  res = (List<ExtProperties>) map.get(arrayName);
        res.add(prop);
        return this;
    }

    public ExtProperties[] getArrayOfProperties(String key) {
        Object o = map.get(key);
        if (o == null) {
            return null;
        } else {
            List<ExtProperties> s = (List<ExtProperties>) o;
            return s.toArray(new ExtProperties[0]);
        }
    }

    public ExtProperties getFromArray(String key, String name) {
        for (ExtProperties p : getArrayOfProperties(key)) {
            if (p.getFullName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public List<String> getNamesFromArray(String key) {
        return Arrays.stream(getArrayOfProperties(key)).map(ExtProperties::getFullName).collect(Collectors.toList());
    }


    public ExtProperties addEnumEntry(String key, Enum value) {
        addProperty(key, value.getClass().getName() + "=" + value.toString());
        return this;
    }

    @SuppressWarnings("unchecked")
    public Enum getEnumEntry(String key) {
        String s = getProperty(key);
        if (s == null) {
            return null;
        }
        int ind = s.indexOf("=");
        String className = s.substring(0, ind);
        String value = s.substring(ind + 1);
        try {
            Class cl = Class.forName(className);
            return Enum.valueOf(cl, value);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
//        StringBuilder res = new StringBuilder("ExtProperties{");
//        forEach((key, value) -> res.append(key.toString()).append(": ").append(value.toString()).append("; "));
//        res.delete(res.length() - 2, res.length()).append("}");
//        return res.toString();
        return map.toString();
    }

    public Set<Map.Entry<String, Object>> entrySet() {
        return map.entrySet();
    }

    public Set<String> keySet() {
        return map.keySet();
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtProperties that = (ExtProperties) o;
        return map.equals(that.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}