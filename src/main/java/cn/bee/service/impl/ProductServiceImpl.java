package cn.bee.service.impl;

import cn.bee.dao.ProductAttributeMapper;
import cn.bee.dao.ProductMapper;
import cn.bee.dao.ProductPicMapper;
import cn.bee.model.Product;
import cn.bee.model.ProductAttribute;
import cn.bee.model.ProductPic;
import cn.bee.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * created by liufeng
 * 2018/9/20
 */
@Service(value = "productService")
public class ProductServiceImpl implements IProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductPicMapper productPicMapper;
    @Resource
    private ProductAttributeMapper productAttributeMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int addProduct(Product product) {
        ProductPic productPic = product.getProductPic();
        ProductAttribute productAttribute = product.getProductAttribute();
        productPicMapper.save(productPic);
        productAttributeMapper.save(productAttribute);
        if (productPic != null) {
            product.setPicId(productPic.getId());
        }
        if (productAttribute != null) {
            product.setAttributeId(productAttribute.getId());
        }
        return productMapper.save(product);
    }

    /**
     * 只限查询1000条最新数据
     *
     * @param map
     * @return
     */
    @Override
    public Map<String, Object> queryAll(Map<String, Object> map) {
        Map<String, Object> result = new LinkedHashMap<>();
        List<Product> products = productMapper.findProductByParam(map);
        if (products != null && products.size() > 0) {
            result.put("status", "success");
            result.put("data", products);
        } else {
            result.put("status", "fail");
        }
        return result;
    }
}
