package com.ziwu.activiti.connector;

import org.activiti.api.process.model.IntegrationContext;
import org.activiti.api.process.runtime.connector.Connector;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service(value = "serviceTask1Impl")
public class ServiceTask1Connector implements Connector {

    @Override
    public IntegrationContext apply(IntegrationContext integrationContext) {
        return integrationContext;
    }

    @Override
    public <V> Function<V, IntegrationContext> compose(Function<? super V, ? extends IntegrationContext> before) {
        return Connector.super.compose(before);
    }

    @Override
    public <V> Function<IntegrationContext, V> andThen(Function<? super IntegrationContext, ? extends V> after) {
        return Connector.super.andThen(after);
    }
}
