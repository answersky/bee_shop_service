package cn.bee.service;

import cn.bee.BaseTest;
import cn.bee.model.Product;
import cn.bee.service.wx.WxProductService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by liufeng
 * 2018/9/26
 */
public class WxProductServiceTest extends BaseTest {
    @Resource
    private WxProductService wxProductService;

    @Test
    public void findWxProducts() {
        List<Product> products = wxProductService.productList("2", 10, 1);
        System.out.println(products);
    }
}
