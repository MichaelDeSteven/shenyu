/*
 *   Licensed to the Apache Software Foundation (ASF) under one or more
 *   contributor license agreements.  See the NOTICE file distributed with
 *   this work for additional information regarding copyright ownership.
 *   The ASF licenses this file to You under the Apache License, Version 2.0
 *   (the "License"); you may not use this file except in compliance with
 *   the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package org.apache.shenyu.springboot.starter.plugin.brpc;

import org.apache.shenyu.plugin.api.ShenyuPlugin;
import org.apache.shenyu.plugin.api.context.ShenyuContextDecorator;
import org.apache.shenyu.plugin.base.handler.PluginDataHandler;
import org.apache.shenyu.plugin.brpc.BrpcPlugin;
import org.apache.shenyu.plugin.brpc.context.BrpcShenyuContextDecorator;
import org.apache.shenyu.plugin.brpc.handler.BrpcPluginDataHandler;
import org.apache.shenyu.plugin.brpc.subscriber.BrpcMetaDataSubscriber;
import org.apache.shenyu.sync.data.api.MetaDataSubscriber;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type brpc plugin configuration.
 */
@Configuration
@ConditionalOnClass(BrpcPlugin.class)
@ConditionalOnProperty(value = {"shenyu.plugins.brpc.enabled"}, havingValue = "true", matchIfMissing = true)
public class BrpcPluginConfiguration {

    /**
     * Brpc plugin.
     *
     * @return the brpc plugin
     */
    @Bean
    public ShenyuPlugin brpcPlugin() {
        return new BrpcPlugin();
    }

    /**
     * Brpc meta data subscriber.
     *
     * @return the meta data subscriber
     */
    @Bean
    public MetaDataSubscriber brpcMetaDataSubscriber() {
        return new BrpcMetaDataSubscriber();
    }

    /**
     * Brpc plugin data handler.
     *
     * @return the plugin data handler
     */
    @Bean
    public PluginDataHandler brpcPluginDataHandler() {
        return new BrpcPluginDataHandler();
    }
    
    /**
     * Brpc shenyu context decorator.
     *
     * @return the shenyu context decorator
     */
    @Bean
    public ShenyuContextDecorator brpcShenyuContextDecorator() {
        return new BrpcShenyuContextDecorator();
    }
}
