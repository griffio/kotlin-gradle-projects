package griffio.fizzbuzzes;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Mississippi {

  public static <T, K, A, D> Collector<T, ?, Map<K, D>> inputGroupingBy(Function<? super T, ? extends K> classifier,
                                                                   Collector<? super T, A, D> downstream) {
    return Collectors.groupingBy(classifier, LinkedHashMap::new, downstream);
  }

  public static void main(String[] args) {

    String input = "Mississippi";

    Map<Character, Long> result = input.chars().mapToObj(c -> (char) c).collect(inputGroupingBy(c -> c, Collectors.counting()));

    System.out.println(result);

    HashMultiset<Character> lettersFrequency = HashMultiset.create(Lists.charactersOf(input));
    lettersFrequency.count("s");

  }

}
