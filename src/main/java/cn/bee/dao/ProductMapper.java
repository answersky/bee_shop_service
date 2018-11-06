package cn.bee.dao;

import cn.bee.model.Product;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 小程序查询商品列表
     *
     * @param type
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Product> findWxProductList(@Param("type") String type, @Param("pageSize") int pageSize, @Param("pageNo") int pageNo);

    /**
     * 根据商品编码查询商品信息
     *
     * @param productCode
     * @return
     */
    Product findProductByProductCode(String productCode);

    /**
     * 更新库存
     *
     * @param inventory
     * @param id
     */
    void updateInventory(@Param("inventory") Integer inventory, @Param("id") Integer id);
}
