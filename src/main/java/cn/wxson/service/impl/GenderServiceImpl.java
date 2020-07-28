package cn.wxson.service.impl;

import cn.wxson.bean.User;
import cn.wxson.service.AbstractDefaultContextService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 * Title 姓名说明
 *
 * @author Ason(18078490)
 * @date 2020-07-28
 */
@Slf4j
public class GenderServiceImpl extends AbstractDefaultContextService<User> {

    /**
     * 根据人员性别进行检查
     * 只要男性
     *
     * @param user 数据
     */
    @Override
    public void execute(User user) {
        String rs = StringUtils.equals(user.getGender(), "男") ? "合格" : "不合格";
        log.info("人员姓名：{}，姓名检查结果：{}", user.getName(), rs);
    }
}
