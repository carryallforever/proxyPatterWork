package com.pattern;

/**
 * @Auther: zhouyao
 * @Date: 2019/3/16 13:54
 * @Description:
 */
public class JDKMeipoTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person)new JDKMeipo().getInstance(new Customer());
            obj.findLove();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
