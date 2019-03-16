package com.pattern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: zhouyao
 * @Date: 2019/3/16 13:32
 * @Description:
 */
public class OrderServiceStaticProxy implements IOrderService {

    private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");

    private IOrderService orderService;

    public OrderServiceStaticProxy(IOrderService orderService){
        this.orderService = orderService;
    }

    @Override
    public int createOrder(Order order) {
        before();
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.valueOf(yearFormat.format(new Date(time)));
        System.out.println("静态代理类自动分配到【DB_"+dbRouter+"】数据源处理数据。");
        DynamicDataSourceEntry.set(dbRouter);
        orderService.createOrder(order);
        after();
        return 0;
    }

    private void after() {
        System.out.println("Proxy after method.");
    }

    private void before() {
        System.out.println("Proxy before method.");
    }
}
