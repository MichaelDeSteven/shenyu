/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shenyu.examples.brpc.service.impl;

import org.apache.shenyu.client.brpc.common.annotation.ShenyuBrpcClient;
import org.apache.shenyu.examples.brpc.api.entity.BrpcSimpleTypeBean;
import org.apache.shenyu.examples.brpc.api.service.BrpcSingleParamService;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Brpc single param service.
 */
//@Service("brpcSingleParamService")
public class BrpcSingleParamServiceImpl implements BrpcSingleParamService {

    @Override
    @ShenyuBrpcClient(path = "/findById", desc = "Find by Id")
    public BrpcSimpleTypeBean findById(final String id) {
        return new BrpcSimpleTypeBean(id, "hello world shenyu Brpc, findById");
    }

    @Override
    @ShenyuBrpcClient(path = "/findAll", desc = "Get all data")
    public BrpcSimpleTypeBean findAll() {
        return new BrpcSimpleTypeBean(String.valueOf(new Random().nextInt()), "hello world shenyu Brpc , findAll");
    }

    @Override
    @ShenyuBrpcClient(path = "/insert", desc = "Insert a row of data")
    public BrpcSimpleTypeBean insert(final BrpcSimpleTypeBean brpcSimpleTypeBean) {
        brpcSimpleTypeBean.setName("hello world shenyu Brpc: " + brpcSimpleTypeBean.getName());
        return brpcSimpleTypeBean;
    }
}
