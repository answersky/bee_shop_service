package cn.bee.service;

import cn.bee.BaseTest;
import cn.bee.enumClass.ProductType;
import cn.bee.model.Product;
import cn.bee.model.ProductAttribute;
import cn.bee.model.ProductPic;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created by liufeng
 * 2018/9/26
 */
public class ProductServiceTest extends BaseTest {
    @Resource
    private IProductService productService;

    @Test
    public void saveProduct() throws ParseException {
        Product product = new Product();
        ProductPic productPic = new ProductPic();
        ProductAttribute productAttribute = new ProductAttribute();
        product.setProductCode("aaabbbccc");
        product.setProductName("北京方便面");
        product.setProductType(String.valueOf(ProductType.FOOD.getType()));
        product.setPrice(new BigDecimal(1.0));
        product.setInventory(200);
        product.setSort(1);
        product.setOperator("admin");
        product.setCreateTime(new Date());
        String picUrl = "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1537411867&di=e401d45f7a8a7944579b9e193595f0b6&src=http://upload.00007.com/upload/images/3870901bf29908a1.jpg";
        productPic.setMainUrl(picUrl);
        product.setProductPic(productPic);
        productAttribute.setLength("5");
        productAttribute.setWidth("6");
        productAttribute.setArea("30");
        productAttribute.setDes("北京方便面");
        productAttribute.setProducer("河南食品生产厂");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date produceTime = sdf.parse("2018-06-01");
        Date expireTime = sdf.parse("2019-06-01");
        productAttribute.setProduceTime(produceTime);
        productAttribute.setExpireTime(expireTime);
        productAttribute.setOriginPlace("河南");
        productAttribute.setUnit("包");
        product.setProductAttribute(productAttribute);
        productService.addProduct(product);
    }

    @Test
    public void fingProduct() {
        Map<String, Object> param = new LinkedHashMap<>();
        param.put("id", 1);
        Map<String, Object> result = productService.queryAll(param);
        System.out.println(result);
    }
}
