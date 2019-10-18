
- key: LinkedHashMap
- key: comparingByValue
```
Map<String, Integer> unsortMap = new HashMap<>();
unsortMap.put("z", 10);
unsortMap.put("b", 5);
unsortMap.put("a", 6);
unsortMap.put("c", 20);
unsortMap.put("d", 1);
unsortMap.put("e", 7);
unsortMap.put("y", 8);
unsortMap.put("n", 99);
unsortMap.put("g", 50);
unsortMap.put("m", 2);
unsortMap.put("f", 9);

System.out.println("Original...");
System.out.println(unsortMap);

//sort by values, and reserve it, 10,9,8,7,6...
Map<String, Integer> result = unsortMap.entrySet().stream()
        .sorted(Map.Entry.comparingByValue())
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));


//Alternative way
Map<String, Integer> result2 = new LinkedHashMap<>();
unsortMap.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

System.out.println("Sorted...");
System.out.println(result);
System.out.println(result2);
```

```
DecimalFormat df = new DecimalFormat("0.00");
Map<String, Integer> map = new HashMap<>();
map.put("lamb", 2);
map.put("test", 3);
map.put("the", 2);
map.put("apple", 5);
System.out.println(map);

Integer sum = map.values().stream().reduce(0, Integer::sum);
System.out.println(sum);
Map<String, String> smap = new LinkedHashMap<>();
map.entrySet().stream()
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEachOrdered(x -> smap.put(x.getKey(), df.format((double) x.getValue() / sum)));
System.out.println(smap);
```