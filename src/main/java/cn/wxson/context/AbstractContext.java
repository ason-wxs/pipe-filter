package cn.wxson.context;

import lombok.Getter;
import lombok.Setter;

/**
 * Title 上下文业务处理抽象类
 * 后面的第一个节点上下文、最后一个节点上下文、普通节点上下文都继承自它
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
@Setter
@Getter
public abstract class AbstractContext<T> implements Context<T> {

    /**
     * 前一个上下文
     */
    private AbstractContext<T> pre;
    /**
     * 后一个上下文
     */
    private AbstractContext<T> next;

    /**
     * 业务逻辑的节点传递
     *
     * @param data 数据
     */
    @Override
    public void transmit(T data) {
        // 直接进行下个节点的业务操作
        this.next.service(data);
    }

    /**
     * 将具体数据业务处理抽象出来，便于节点操作
     *
     * @param data 数据
     */
    public void service(T data) {
        service().execute(this, data);
    }
}