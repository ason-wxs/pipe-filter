package cn.wxson.context.impl;


import cn.wxson.context.AbstractContext;
import cn.wxson.service.ContextService;

/**
 * Title 第一个节点上下文
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public final class FirstContextImpl<T> extends AbstractContext<T> implements ContextService<T> {

    /**
     * 获取服务类
     *
     * @return 第一个节点返回自身
     */
    @Override
    public ContextService<T> service() {
        return this;
    }

    /**
     * 第一个节点，直接执行下一个节点数据，不做业务处理
     *
     * @param context 上下文
     * @param data    数据
     */
    @Override
    public void execute(AbstractContext<T> context, T data) {
        // 不做任何自身业务逻辑处理，直接传递给下个节点处理
        context.transmit(data);
    }
}