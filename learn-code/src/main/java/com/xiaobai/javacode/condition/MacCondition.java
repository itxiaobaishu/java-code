package com.xiaobai.javacode.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author xiaobai
 * @description: mac系统条件类
 * @date 2020/2/11 2:41 下午
 */
public class MacCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name").contains("Mac");
    }
}
