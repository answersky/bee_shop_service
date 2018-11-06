package cn.bee.service;

import cn.bee.BaseTest;
import cn.bee.model.PlaceOrder;
import cn.bee.service.wx.WxOrderService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2018/11/6
 */
public class WxOrderServiceTest extends BaseTest {
    @Resource
    private WxOrderService wxOrderService;

    @Test
    public void orderTest() {
        List<PlaceOrder> placeOrders = new ArrayList<>();
        String receiver = "aaa";
        String receiveAddress = "光谷软件园";
        String phone = "18576896785";
        PlaceOrder placeOrder = new PlaceOrder();
        placeOrder.setProductCode("aaabbbcccd");
        placeOrder.setNum(1);
        placeOrder.setReceiveAddress(receiveAddress);
        placeOrder.setReceiver(receiver);
        placeOrder.setPhone(phone);
        PlaceOrder placeOrder1 = new PlaceOrder();
        placeOrder1.setProductCode("c2b5db0efe");
        placeOrder1.setNum(2);
        placeOrder1.setReceiveAddress(receiveAddress);
        placeOrder1.setReceiver(receiver);
        placeOrder1.setPhone(phone);
        placeOrders.add(placeOrder);
        placeOrders.add(placeOrder1);
        String username = "AngelicSky13";
        Map<String, Object> map = wxOrderService.createOrder(placeOrders, username);
        System.out.println(map);
    }
}
