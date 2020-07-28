package cn.wxson.service;

import cn.wxson.context.AbstractContext;

/**
 * Title 上下文业务服务类
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public interface ContextService<T> {

    /**
     * 业务逻辑处理
     *
     * @param context 上下文
     * @param data    数据
     */
    void execute(AbstractContext<T> context, T data);
}
