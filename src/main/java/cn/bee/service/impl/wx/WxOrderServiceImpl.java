package cn.bee.service.impl.wx;

import cn.bee.service.wx.WxOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * created by liufeng
 * 2018/10/25
 */
@Service(value = "wxOrderService")
public class WxOrderServiceImpl implements WxOrderService {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createOrder(List<String> list, String username) {
        Date date = new Date();
        //将时间格式化作为订单号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String orderNum = "bee" + sdf.format(date);

        //todo 校验商品库存

        //todo 插入订单表
    }
}
