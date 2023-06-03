import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public static <T> List<T> sortObjects(List<T> objects, Comparator<? super T> comparator) {
    List<T> sortedObjects = new ArrayList<>(objects);
    Collections.sort(sortedObjects, comparator);
    return sortedObjects;
}


List<String> strings = Arrays.asList("foo", "bar", "baz");
Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s2.length(), s1.length());
List<String> sortedStrings = sortObjects(strings, lengthComparator);
System.out.println(sortedStrings);