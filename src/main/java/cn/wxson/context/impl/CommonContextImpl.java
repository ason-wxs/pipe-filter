package cn.wxson.context.impl;


import cn.wxson.context.AbstractContext;
import cn.wxson.service.ContextService;

/**
 * Title 普通节点的上下文
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public class CommonContextImpl<T> extends AbstractContext<T> {

    /**
     * 具体业务实现服务类
     */
    private ContextService<T> service;

    /**
     * 无参构造
     */
    public CommonContextImpl() {
        super();
    }

    /**
     * 带参构造
     *
     * @param service 服务类
     */
    public CommonContextImpl(ContextService<T> service) {
        this.service = service;
    }

    /**
     * 获取服务类
     *
     * @return 返回传进来的服务类
     */
    @Override
    public ContextService<T> service() {
        return this.service;
    }
}