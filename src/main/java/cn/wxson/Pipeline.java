package cn.wxson;

import cn.wxson.context.AbstractContext;
import cn.wxson.context.impl.CommonContextImpl;
import cn.wxson.context.impl.FirstContextImpl;
import cn.wxson.context.impl.LastContextImpl;
import cn.wxson.service.ContextService;

/**
 * Title 上下文队列
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public class Pipeline<T> {

    /**
     * 第一个上下文
     */
    private final AbstractContext<T> first;
    /**
     * 最后一个上下文
     */
    private final AbstractContext<T> last;

    /**
     * 初始化队列第一个上下文与最后一个上下文，并将它们连起来
     */
    public Pipeline() {
        this.first = new FirstContextImpl<T>();
        this.last = new LastContextImpl<T>();
        this.first.setNext(this.last);
        this.last.setPre(this.first);
    }

    /**
     * 新增服务类作为普通上下文节点包装
     * 并把它排到最后一个上下文前面，即：普通节点的队尾
     *
     * @param service 服务类
     */
    public void add(ContextService<T> service) {
        AbstractContext<T> context = new CommonContextImpl<T>(service);
        AbstractContext<T> backwardsSecond = this.last.getPre();
        context.setPre(backwardsSecond);
        context.setNext(this.last);
        backwardsSecond.setNext(context);
        this.last.setPre(context);
    }

    /**
     * 新增服务类作为普通上下文节点包装
     * 并把它排到第一个上下文后面，即：普通节点的队首
     *
     * @param service 服务类
     */
    public void addFirst(ContextService<T> service) {
        AbstractContext<T> context = new CommonContextImpl<T>(service);
        AbstractContext<T> forwardsSecond = this.first.getNext();
        this.first.setNext(context);
        forwardsSecond.setPre(context);
        context.setPre(this.first);
        context.setNext(forwardsSecond);
    }

    /**
     * 从队列第一个上下文节点开始处理数据
     *
     * @param data 数据
     */
    public void handler(T data) {
        this.first.transmit(data);
    }
}