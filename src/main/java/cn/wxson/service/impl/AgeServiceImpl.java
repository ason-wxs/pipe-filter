package cn.wxson.service.impl;

import cn.wxson.bean.User;
import cn.wxson.service.AbstractDefaultContextService;
import lombok.extern.slf4j.Slf4j;

/**
 * Title 年龄说明
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
@Slf4j
public class AgeServiceImpl extends AbstractDefaultContextService<User> {

    /**
     * 根据人员年龄进行检查
     * 必须成年，大于等于18岁
     *
     * @param user 数据
     */
    @Override
    public void execute(User user) {
        String rs = user.getAge() >= 18 ? "合格" : "不合格";
        log.info("人员姓名：{}，年龄检查结果：{}", user.getName(), rs);
    }
}
