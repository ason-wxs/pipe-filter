package cn.wxson.context.impl;


import cn.wxson.context.AbstractContext;
import cn.wxson.service.ContextService;

/**
 * Title 最后一个节点上下文
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public final class LastContextImpl<T> extends AbstractContext<T> implements ContextService<T> {

    /**
     * 获取服务类
     *
     * @return 最后一个节点返回自身
     */
    @Override
    public ContextService<T> service() {
        return this;
    }

    /**
     * 最后一个节点，不做任何处理
     *
     * @param context 上下文
     * @param data    数据
     */
    @Override
    public void execute(AbstractContext<T> context, T data) {
        // 不做任何业务处理，也不需要再传递下去
        // NOOP
    }
}