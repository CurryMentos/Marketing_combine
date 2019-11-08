package Customize;

import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * Created by zengyouzu on 2019/10/22.
 * Mock实例
 */
public class MockTest {
    @Mock
    private MockObject mockService;

    @Test
    public void test() throws Exception {

        List<String> list = mock(MockObject.MockList().getClass());
        //预期结果
        when(list.get(0)).thenReturn("SUCCESS");
        when(list.get(1)).thenReturn("FAIL");
        when(list.get(2)).thenReturn("");

        String result = list.get(0);

        //实际结果
        String actualResult = "SUCCESS";

        boolean b = result.equals(actualResult);
        System.out.println(b);
    }

    @Test
    public void test1() {
        List<String> list = mock(List.class);
        //预期结果
        when(list.get(0)).thenReturn("SUCCESS");//桩

        String resultA = list.get(0);
        String resultB = list.get(1);
        //实际结果
        String actualResult = "SUCCESS";

        boolean b1 = resultA.equals(actualResult);
//        boolean b2 = resultB.equals(null);
        Assert.assertEquals(null, resultB);
        System.out.println(b1);
//        System.out.println(b2);
    }

    @Test
    public void when_thenReturn(){
        //mock一个Iterator类
        Iterator iterator = mock(Iterator.class);
        //预设当iterator调用next()时第一次返回hello，第n次都返回world
        when(iterator.next()).thenReturn("hello").thenReturn("world");
        //使用mock的对象
        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();
        //验证结果
        assertEquals("hello world world",result);
    }
}
