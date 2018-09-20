package cn.bee.service.impl;

import cn.bee.model.Product;
import cn.bee.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * created by liufeng
 * 2018/9/20
 */
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {
    @Override
    public int addProduct(Product product) {
        return 0;
    }

    @Override
    public Map<String, Object> queryAll(Map<String, Object> map) {
        return null;
    }
}
