- Method 1 : Singleton with public static final field
```
public class Singleton
    public static final Singleton INSTANCE = new Singleton();
    private Singleton() {
    }
```

- Method 2 : Singleton with public static factory method
```
public class Singleton
    public static final Singleton INSTANCE = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        return INSTANCE
    }
```

- Method 3 : Singleton with lazy initialization, normally static field are initialized at class loading time,
lazy initialization of singleton object avoid this problem
```
public class Singleton {
    private static volatile Singleton obj;
    private Singleton() {
    }
    public static Singleton getInstance() {
        if (obj == null) {
            synchronized (Singleton.class) {
                if (obj == null) {
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }
}
```

* All methods work fine until you are not doing serialization and deserialization with a sinleton class or refection.

- Method 4 : Singleton with Enuermation

```
public Enum Singleton {
    INSTANCE
    int value;
    public
}
```
