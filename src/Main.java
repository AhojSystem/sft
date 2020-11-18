/*coding by CYBAiGNU*/

import core.Diff;

public class Main {
    public static void main(String[] args) {
        Diff diff = new Diff("test01.txt", "test02.txt");
        for (String str : diff.diff().component1().values()) {
            System.out.println(str);
        }
    }
}
