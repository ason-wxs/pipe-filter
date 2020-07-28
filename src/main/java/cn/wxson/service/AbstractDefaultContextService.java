package cn.wxson.service;

import cn.wxson.context.AbstractContext;

/**
 * Title 默认上下文业务服务类
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public abstract class AbstractDefaultContextService<T> implements ContextService<T> {

    /**
     * 业务逻辑处理
     *
     * @param context 上下文
     * @param data    数据
     */
    @Override
    public void execute(AbstractContext<T> context, T data) {
        // 1.本节点的业务逻辑处理
        this.execute(data);
        // 2.传递逻辑到下个节点
        context.transmit(data);
    }

    /**
     * 本节点的业务逻辑处理
     *
     * @param data 数据
     */
    public abstract void execute(T data);
}
