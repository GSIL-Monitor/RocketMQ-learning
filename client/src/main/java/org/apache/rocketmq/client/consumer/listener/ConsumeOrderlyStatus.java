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
package org.apache.rocketmq.client.consumer.listener;

public enum ConsumeOrderlyStatus {
    /**
     * Success consumption
     */
    SUCCESS,
    /**
     * 虑到 ROLLBACK 、COMMIT 暂时只使用在 MySQL binlog 场景，官方将这两状态标记为 @Deprecated。当然，相应的实现逻辑依然保留
     * Rollback consumption(only for binlog consumption)
     */
    @Deprecated
    ROLLBACK,
    /**
     * Commit offset(only for binlog consumption)
     */
    @Deprecated
    COMMIT,
    /**
     * 在并发消费场景时，如果消费失败，Consumer 会将消费失败消息发回到 Broker 重试队列，跳过当前消息，等待下次拉取该消息再进行消费。

     但是在完全严格顺序消费消费时，这样做显然不行。也因此，消费失败的消息，会挂起队列一会会，稍后继续消费。

     不过消费失败的消息一直失败，也不可能一直消费。当超过消费重试上限时，Consumer 会将消费失败超过上限的消息发回到 Broker 死信队列。
     * Suspend current queue a moment
     */
    SUSPEND_CURRENT_QUEUE_A_MOMENT;
}
