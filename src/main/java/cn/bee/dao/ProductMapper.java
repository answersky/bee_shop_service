package cn.bee.dao;

import cn.bee.model.Product;

import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2018/9/26
 */
public interface ProductMapper {
    int save(Product product);

    /**
     * 商品查询
     *
     * @param param
     * @return
     */
    List<Product> findProductByParam(Map<String, Object> param);
}
