package cn.bee.service.impl;

import cn.bee.dao.ProductOperateLogMapper;
import cn.bee.model.ProductOperateLog;
import cn.bee.service.log.IProductOperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * created by liufeng
 * 2018/10/23
 */
@Service(value = "productOperateLogService")
public class ProductOperateLogServiceImpl implements IProductOperateLogService {
    @Resource
    private ProductOperateLogMapper productOperateLogMapper;

    @Override
    public void saveLog(ProductOperateLog productOperateLog) {
        productOperateLogMapper.save(productOperateLog);
    }

    @Override
    public List<ProductOperateLog> findOperateLogsByTime(Date date, Date date1) {
        return productOperateLogMapper.findLogs(date, date1);
    }
}
