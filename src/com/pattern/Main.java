package com.pattern;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //只能帮儿子找对象
        //不能帮陌生人
//        Father father = new Father(new Son());
//        father.findLove();
//        try {
//            Order order = new Order();
//// Date today = new Date();
//// order.setCreateTime(today.getTime());
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
//            Date date = sdf.parse("2017/02/01");
//            order.setCreateTime(date.getTime());
//            IOrderService orderService = new OrderServiceStaticProxy(new OrderService());
//            orderService.createOrder(order);
//        }catch (Exception e){
//            e.printStackTrace();;
//        }

        try {
            Order order = new Order();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = sdf.parse("2018/02/01");
            order.setCreateTime(date.getTime());
            IOrderService orderService = (IOrderService)new OrderServiceDynamicProxy().getInstance(new
                    OrderService());
            orderService.createOrder(order);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
