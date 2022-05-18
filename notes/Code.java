class Solution {

  public static void main(String[] args) {
    List<Integer> li = List.of(1, 2, 3, 4, 5, 6, 7);

    // print all
    li.forEach(ele -> System.out::println);

    // Stream filter
    List<Integer> filter = li
      .stream()
      .filter(ele -> ele > 2)
      .collect(Collectors.toList());

    // Stream Sort
    List<Integer> sort = li
      .stream()
      .sorted(Comparator.comparing(ele))
      .collect(Collectors.toList());

    // Stream all match, any match, none match
    boolean match = li.stream().allMatch(ele -> ele == 2);

    // max, min
    Optional<Integer> max = li.stream().max(Comparator.comparing(ele));
  }
}
