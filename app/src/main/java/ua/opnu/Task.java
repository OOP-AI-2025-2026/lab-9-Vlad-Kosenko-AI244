package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.*;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        int i = 0;
        while (i < list.size() - 1) {
            String first = list.get(i);
            String second = list.get(i + 1);
            if (first.length() <= second.length()) {
                list.remove(i);
            } else {
                list.remove(i + 1);
            }
            i++;
        }
    }

    public void stutter(List<String> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            String value = list.get(i);
            list.add(i, value);
            i += 2;
        }
    }

    public void switchPairs(List<String> list) {
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size() - 1; i += 2) {
            String tmp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, tmp);
        }
    }

    public void removeDuplicates(List<String> list) {
        if (list == null || list.size() < 2) {
            return;
        }
        int i = 1;
        while (i < list.size()) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
            } else {
                i++;
            }
        }
    }

    public void markLength4(List<String> list) {
        if (list == null) {
            return;
        }
        int i = 0;
        while (i < list.size()) {
            String value = list.get(i);
            if (value.length() == 4) {
                list.add(i, "****");
                i += 2; // пропускаємо маркер і оригінальне слово
            } else {
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue == null) {
            return true;
        }
        int size = queue.size();
        if (size <= 1) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // 1-й прохід: копіюємо в стек, обертаючи чергу
        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            queue.add(value);
            stack.push(value);
        }

        boolean isPal = true;
        // 2-й прохід: порівнюємо зі стеком і відновлюємо чергу
        for (int i = 0; i < size; i++) {
            int fromQueue = queue.remove();
            int fromStack = stack.pop();
            if (fromQueue != fromStack) {
                isPal = false;
            }
            queue.add(fromQueue);
        }

        return isPal;
    }

    public void reorder(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();
        int nonNegativeCount = 0;

        for (int i = 0; i < size; i++) {
            int value = queue.remove();
            if (value < 0) {
                stack.push(value);
            } else {
                queue.add(value);
                nonNegativeCount++;
            }
        }

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        for (int i = 0; i < nonNegativeCount; i++) {
            queue.add(queue.remove());
        }
    }

    public void rearrange(Queue<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }
        List<Integer> temp = new ArrayList<>();
        while (!queue.isEmpty()) {
            temp.add(queue.remove());
        }
        for (Integer value : temp) {
            if (value % 2 == 0) {
                queue.add(value);
            }
        }
        for (Integer value : temp) {
            if (value % 2 != 0) {
                queue.add(value);
            }
        }
    }

    public int maxLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return 0;
        }
        int max = 0;
        for (String s : set) {
            if (s != null) {
                max = Math.max(max, s.length());
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        if (set == null || set.isEmpty()) {
            return;
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s != null && s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null) {
            return 0;
        }
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return true;
        }
        Set<String> seen = new HashSet<>();
        for (String value : map.values()) {
            if (!seen.add(value)) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();
        if (map1 == null || map2 == null) {
            return result;
        }
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key) && Objects.equals(map2.get(key), value)) {
                result.put(key, value);
            }
        }
        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();
        if (map == null || map.isEmpty()) {
            return result;
        }
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                continue;
            }
            Integer current = result.get(value);
            if (current == null || key > current) {
                result.put(value, key);
            }
        }
        return result;
    }

    public int rarest(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (Integer value : map.values()) {
            if (value == null) {
                continue;
            }
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        int bestValue = 0;
        int bestCount = Integer.MAX_VALUE;
        boolean first = true;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();
            if (first || count < bestCount || (count == bestCount && value < bestValue)) {
                bestValue = value;
                bestCount = count;
                first = false;
            }
        }
        return bestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int max = 0;
        for (Integer value : list) {
            if (value == null) {
                continue;
            }
            int count = freq.getOrDefault(value, 0) + 1;
            freq.put(value, count);
            if (count > max) {
                max = count;
            }
        }
        return max;
    }
}
