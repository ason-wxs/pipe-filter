package cn.wxson.test;

import cn.wxson.Pipeline;
import cn.wxson.bean.User;
import cn.wxson.service.ContextService;
import cn.wxson.service.impl.AgeServiceImpl;
import cn.wxson.service.impl.GenderServiceImpl;

/**
 * Title 测试类
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
public class Domain {

    public static void main(String[] arg) {
        // 创建预处理队列
        Pipeline<User> pipeline = new Pipeline<User>();
        ContextService<User> nameService = new GenderServiceImpl();
        ContextService<User> ageService = new AgeServiceImpl();
        pipeline.add(nameService);
        pipeline.add(ageService);
        // 放入人员信息，逐个检查
        pipeline.handler(new User("张三", 18, "男"));
        pipeline.handler(new User("李四", 20, "女"));
        pipeline.handler(new User("王五", 13, "男"));
    }
}