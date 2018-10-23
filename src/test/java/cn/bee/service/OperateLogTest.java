package cn.bee.service;

import cn.bee.BaseTest;
import cn.bee.model.ProductOperateLog;
import cn.bee.service.log.IProductOperateLogService;
import org.junit.Test;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * created by liufeng
 * 2018/10/23
 */
public class OperateLogTest extends BaseTest {
    @Resource
    private IProductOperateLogService productOperateLogService;

    @Test
    public void addLog() {
        ProductOperateLog productOperateLog = new ProductOperateLog();
        productOperateLog.setOperator("admin");
        productOperateLog.setProductCode("c2b5db0efe");
        productOperateLog.setRemark("账户：admin 新建了一个商品 product_code:c2b5db0efe 状态：0");
        productOperateLogService.saveLog(productOperateLog);
    }

    @Test
    public void fingLogs() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String sDay = "10/09/2018";
        String eDay = "10/23/2018";
        Date sTime = sdf.parse(sDay);
        Date eTime = sdf.parse(eDay);
        List<ProductOperateLog> logs = productOperateLogService.findOperateLogsByTime(sTime, eTime);
        System.out.println(logs);
    }
}
