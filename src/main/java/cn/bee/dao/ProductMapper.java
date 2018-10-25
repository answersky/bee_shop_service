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
}
