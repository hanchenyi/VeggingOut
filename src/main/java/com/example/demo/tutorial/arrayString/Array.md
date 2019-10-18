```
int[] a = new int[]{1,2,3,4,5};
List<Integer> b = Arrays.stream(a).boxed().collect(Collectors.toList());
System.out.println(b);
Integer[] c = b.toArray(new Integer[]{});
System.out.println(Arrays.toString(c));
int[] d = b.stream().mapToInt(Integer::intValue).toArray();
System.out.println(Arrays.toString(d));
```

```

Stack<Character> stack = new Stack<>();
Queue<Character> queue = new LinkedList<Character>();

```

