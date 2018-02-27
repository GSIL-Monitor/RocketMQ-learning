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

package org.apache.rocketmq.store;

/**
 * DispatchRequest 接收者或则称为处理者实现的接口，每当有新的请求到来时，会通知所有实现类，
 * 当前有两个重要的实现类：
 * 1. {@link org.apache.rocketmq.store.DefaultMessageStore.CommitLogDispatcherBuildConsumeQueue} 负责将commit log放入 consume queue
 * 2. {@link org.apache.rocketmq.store.DefaultMessageStore.CommitLogDispatcherBuildIndex} 负责将commit log建立索引信息
 *
 * Dispatcher of commit log.
 */
public interface CommitLogDispatcher {

    void dispatch(final DispatchRequest request);
}
