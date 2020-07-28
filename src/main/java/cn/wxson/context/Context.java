package cn.wxson.context;

import cn.wxson.service.ContextService;

/**
 * Title 全局上下文
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public interface Context<T> {

    /**
     * 获取服务类
     *
     * @return 服务类
     */
    ContextService<T> service();

    /**
     * 业务逻辑的节点传递
     *
     * @param data 数据
     */
    void transmit(T data);
}
