package unam.mx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author miguel
 */
public class RandomizedSet {

    Random r;
    Map<Integer, Integer> dictionary;
    List<Integer> indices;

    public RandomizedSet() {
        dictionary = new HashMap<>();
        r = new Random();
        indices = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (dictionary.containsKey(val)) {
            return false;
        }
        dictionary.put(val, indices.size());
        indices.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!dictionary.containsKey(val)) {
            return false;
        }
        int size = indices.size();
        int pos = dictionary.get(val);
        int last = indices.get(size - 1);
        indices.set(pos, last);
        dictionary.put(last, pos);
        indices.remove(size - 1);
        dictionary.remove(val);
        return true;
    }

    public int getRandom() {
        int size = indices.size();
        int randomPos = r.nextInt(size);
        return indices.get(randomPos);
    }

}
