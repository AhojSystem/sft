package core;

import utils.Difference;
import utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Diff {
    private final ArrayList<String> before;
    private final ArrayList<String> current;
    private final Difference difference = new Difference(new HashMap<>());

    public Diff(String fileName1, String fileName2) {
        before = new ArrayList<>(Arrays.asList(Utils.Companion.loadResource(fileName1).split("\n")));
        current = new ArrayList<>(Arrays.asList(Utils.Companion.loadResource(fileName2).split("\n")));
    }

    public Difference diff() {
        int bLen, cLen, diffCount = 0;
        String cString;
        if ((bLen = before.size()) < (cLen = current.size())) {
            for (int i = 0; i < cLen; i++) {
                if (!before.get(i - diffCount).equals((cString = current.get(i)))) {
                    diffCount++;
                    difference.component1().put(i + 1, cString);
                }
            }
        } else {
            for (int i = 0; i < bLen; i++) {
                if (!before.get(i).equals((cString = current.get(i - diffCount)))) {
                    diffCount++;
                    difference.component1().put(i + 1, cString);
                }
            }
        }
        return difference;
    }
}
