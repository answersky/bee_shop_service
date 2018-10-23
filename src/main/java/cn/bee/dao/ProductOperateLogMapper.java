package cn.bee.dao;

import cn.bee.model.ProductOperateLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * created by liufeng
 * 2018/10/23
 */
public interface ProductOperateLogMapper {
    /**
     * 保存商品操作日志
     *
     * @param productOperateLog
     */
    void save(ProductOperateLog productOperateLog);

    /**
     * 查询商品操作日志
     *
     * @param sTime
     * @param eTime
     * @return
     */
    List<ProductOperateLog> findLogs(@Param("sTime") Date sTime, @Param("eTime") Date eTime);
}
