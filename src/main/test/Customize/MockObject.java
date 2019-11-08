package Customize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengyouzu on 2019/10/22.
 * Mock对象
 */
public class MockObject {
    public static List<String> MockList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        return list;
    }

    public static String MockString;

    public static String getMockString() {
        return MockString;
    }

    public static void setMockString(String mockString) {
        MockString = mockString;
    }
}
