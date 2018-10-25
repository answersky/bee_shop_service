package cn.bee.service.impl.wx;

import cn.bee.dao.ProductMapper;
import cn.bee.model.Product;
import cn.bee.service.wx.WxProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * created by liufeng
 * 2018/10/25
 */
@Service(value = "wxProductService")
public class WxProductServiceImpl implements WxProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public List<Product> productList(String s, int pageSize, int pageNo) {
        int page = (pageNo - 1) * pageSize;
        return productMapper.findWxProductList(s, pageSize, page);
    }
}
