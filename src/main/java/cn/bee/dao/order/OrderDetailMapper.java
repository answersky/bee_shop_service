package cn.bee.dao.order;

import cn.bee.model.OrderDetail;

import java.util.List;

/**
 * created by liufeng
 * 2018/11/6
 */
public interface OrderDetailMapper {
    void batchSave(List<OrderDetail> list);
}
