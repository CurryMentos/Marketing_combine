package Customize;

import org.yaml.snakeyaml.util.UriEncoder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengyouzu on 2019/8/9.
 */
public class FileOperate {
    //    String path = Thread.currentThread().getContextClassLoader().getResource("").getPath();
//    File file = new File(UriEncoder.decode(path),"data.txt");
    private static String path;

    public static List<String> getUserInfo(int i) throws Exception {
        switch (i) {
            case 1://手机号
                String path1 = Thread.currentThread().getContextClassLoader().getResource("UserInfo//phoneNo.txt").getPath();
//                String path1 = Thread.currentThread().getContextClassLoader().getResource("UserInfo//phoneNo(ZC).txt").getPath();
                File file1 = new File(UriEncoder.decode(path1), "phoneNo.txt");
                path = path1;
                break;
            case 2://身份证号
                String path2 = Thread.currentThread().getContextClassLoader().getResource("UserInfo//certificateId.txt").getPath();
                File file2 = new File(UriEncoder.decode(path2), "certificateId.txt");
                path = path2;
                break;
            case 3://商户号
                String path3 = Thread.currentThread().getContextClassLoader().getResource("UserInfo//merchantNo.txt").getPath();
                File file3 = new File(UriEncoder.decode(path3), "merchantNo.txt");
                path = path3;
                break;
        }

        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //按行读取文件
        List<String> list = new ArrayList<String>();
        String str = null;
        try {
            while ((str = bufferedReader.readLine()) != null) {
                if (str.trim().length() > 0) {
                    list.add(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void getBase64Code() throws Exception {
        String path1 = Thread.currentThread().getContextClassLoader().getResource("Background.txt").getPath();
        String path2 = Thread.currentThread().getContextClassLoader().getResource("Button.txt").getPath();
        File file1 = new File(UriEncoder.decode(path1), "Background.txt");
        File file2 = new File(UriEncoder.decode(path2), "Button.txt");

        FileReader fR1 = new FileReader(path1);
        FileReader fR2 = new FileReader(path2);
        BufferedReader bR1 = new BufferedReader(fR1);
        BufferedReader bR2 = new BufferedReader(fR2);
        Long Background = null;
        Long Button = null;
        Background = Long.valueOf(bR1.readLine());
        Button = Long.valueOf(bR2.readLine());

        System.out.println(Background);
        System.out.println(Button);
    }

    public static void main(String[] args) {
        try {
            getBase64Code();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
