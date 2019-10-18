```
 int[] firstRange = new int[] {1,2,3,4,5};
        List<Integer> secondRange = Arrays.asList(1,2,3,4,5,6,7);
        ForkJoinPool forkJoinPool = new ForkJoinPool(7);
        forkJoinPool.submit(() -> {
            secondRange.parallelStream().forEach((number) -> {
                try {

                    Thread.sleep(5);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) { }
            });
        });
```