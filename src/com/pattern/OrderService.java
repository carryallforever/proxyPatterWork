package com.pattern;

/**
 * @Auther: zhouyao
 * @Date: 2019/3/16 13:06
 * @Description:
 */
public class OrderService implements IOrderService {

    private OrderDao orderDao;

    public OrderService(){
        //如果使用spring应该是自动注入
//        我们为了方便，在构造方法中注入orderdao直接出示化了
        orderDao = new OrderDao();

    }

    @Override
    public int createOrder(Order order) {
        System.out.println("OrderService 调用OrderDao创建订单");

        return orderDao.insert(order);
    }
}
