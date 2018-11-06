package cn.bee.service.impl.wx;

import cn.bee.dao.ProductMapper;
import cn.bee.dao.order.OrderDetailMapper;
import cn.bee.dao.order.OrderMapper;
import cn.bee.model.Order;
import cn.bee.model.OrderDetail;
import cn.bee.model.PlaceOrder;
import cn.bee.model.Product;
import cn.bee.service.wx.WxOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * created by liufeng
 * 2018/10/25
 */
@Service(value = "wxOrderService")
public class WxOrderServiceImpl implements WxOrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderDetailMapper orderDetailMapper;
    @Resource
    private ProductMapper productMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Map<String, Object> createOrder(List<PlaceOrder> list, String username) {
        Map<String, Object> map = new LinkedHashMap<>();
        Date date = new Date();
        //将时间格式化作为订单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderNum = "bee" + sdf.format(date);

        BigDecimal totalPrice = new BigDecimal("0.00");
        List<OrderDetail> orderDetails = new ArrayList<>();
        String receiveAddress = null;
        String receiver = null;
        String phone = null;
        //todo 校验商品库存(此处需要注意同步问题)
        for (PlaceOrder placeOrder : list) {
            receiveAddress = placeOrder.getReceiveAddress();
            receiver = placeOrder.getReceiver();
            phone = placeOrder.getPhone();
            String productCode = placeOrder.getProductCode();
            Product product = productMapper.findProductByProductCode(productCode);
            //判断库存是否足够
            if (placeOrder.getNum() > product.getInventory()) {
                map.put("status", "-1");
                map.put("msg", "下单失败，商品：" + productCode + "的库存不足");
                return map;
            }
            totalPrice = totalPrice.add(product.getPrice().multiply(new BigDecimal(placeOrder.getNum())));
            totalPrice = totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductCode(productCode);
            orderDetail.setOrderNo(orderNum);
            orderDetail.setNum(placeOrder.getNum());
            orderDetails.add(orderDetail);

            //修改商品表库存
            productMapper.updateInventory((product.getInventory() - placeOrder.getNum()), product.getId());
        }

        //插入订单表
        Order order = new Order();
        order.setUsername(username);
        order.setOrderNo(orderNum);
        order.setTotalPrice(totalPrice);
        order.setReceiveAddress(receiveAddress);
        order.setReceiver(receiver);
        order.setReceivePhone(phone);
        orderMapper.save(order);
        orderDetailMapper.batchSave(orderDetails);

        map.put("status", "0");
        map.put("msg", "保存成功");
        return map;
    }


}
