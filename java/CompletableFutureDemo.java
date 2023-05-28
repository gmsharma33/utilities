package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {
        List<String> list = List.of("abc", "test", "test123", "faasg", "sag");
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for(String s : list) {
            CompletableFuture<Integer> c = CompletableFuture.supplyAsync(() -> {
                return s.length();
            });
            futures.add(c);
        }
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
