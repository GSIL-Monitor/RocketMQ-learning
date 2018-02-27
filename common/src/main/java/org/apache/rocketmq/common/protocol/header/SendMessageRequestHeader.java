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

/**
 * $Id: SendMessageRequestHeader.java 1835 2013-05-16 02:00:50Z vintagewang@apache.org $
 */
package org.apache.rocketmq.common.protocol.header;

import org.apache.rocketmq.remoting.CommandCustomHeader;
import org.apache.rocketmq.remoting.annotation.CFNotNull;
import org.apache.rocketmq.remoting.annotation.CFNullable;
import org.apache.rocketmq.remoting.exception.RemotingCommandException;

public class SendMessageRequestHeader implements CommandCustomHeader {
    /**
     * 所在的生产组
     */
    @CFNotNull
    private String producerGroup;
    /**
     * topic名称
     */
    @CFNotNull
    private String topic;
    /**
     * 默认的topic名称, 发送消息需要带上默认topic的目的在于：可能该消息要发送的topic还没有创建，在broker创建新topic的时候，需要依据默认的topic来创建,
     * 这是因为，当向新topic发送第一条消息查找路由时，肯定会失败，这是会使用默认的topic的路由信息作为该topic的路由，所以发送时也要带上该topic，以此来保证一致性
     */
    @CFNotNull
    private String defaultTopic;
    /**
     * 默认topic队列数量
     */
    @CFNotNull
    private Integer defaultTopicQueueNums;
    /**
     * 消息要发送到的队列的ID
     */
    @CFNotNull
    private Integer queueId;
    /**
     * 标记消息的种类，例如表示消息是否压缩，是否是多tag，是否设置事务相关的属性
     */
    @CFNotNull
    private Integer sysFlag;
    /**
     * 消息发送的时间戳
     */
    @CFNotNull
    private Long bornTimestamp;
    /**
     * Message类中的flag字段，TODO
     */
    @CFNotNull
    private Integer flag;
    /**
     * Message类中的配置信息发送时会转换成字符串
     */
    @CFNullable
    private String properties;
    /**
     * todo 与重试相关
     */
    @CFNullable
    private Integer reconsumeTimes;
    /**
     * TODO
     */
    @CFNullable
    private boolean unitMode = false;
    /**
     * 此消息是否是批量消息发送的
     */
    @CFNullable
    private boolean batch = false;
    /**
     * 该消息最大能重新消费的次数, todo 与重试相关
     */
    private Integer maxReconsumeTimes;

    @Override
    public void checkFields() throws RemotingCommandException {
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDefaultTopic() {
        return defaultTopic;
    }

    public void setDefaultTopic(String defaultTopic) {
        this.defaultTopic = defaultTopic;
    }

    public Integer getDefaultTopicQueueNums() {
        return defaultTopicQueueNums;
    }

    public void setDefaultTopicQueueNums(Integer defaultTopicQueueNums) {
        this.defaultTopicQueueNums = defaultTopicQueueNums;
    }

    public Integer getQueueId() {
        return queueId;
    }

    public void setQueueId(Integer queueId) {
        this.queueId = queueId;
    }

    public Integer getSysFlag() {
        return sysFlag;
    }

    public void setSysFlag(Integer sysFlag) {
        this.sysFlag = sysFlag;
    }

    public Long getBornTimestamp() {
        return bornTimestamp;
    }

    public void setBornTimestamp(Long bornTimestamp) {
        this.bornTimestamp = bornTimestamp;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public Integer getReconsumeTimes() {
        return reconsumeTimes;
    }

    public void setReconsumeTimes(Integer reconsumeTimes) {
        this.reconsumeTimes = reconsumeTimes;
    }

    public boolean isUnitMode() {
        return unitMode;
    }

    public void setUnitMode(boolean isUnitMode) {
        this.unitMode = isUnitMode;
    }

    public Integer getMaxReconsumeTimes() {
        return maxReconsumeTimes;
    }

    public void setMaxReconsumeTimes(final Integer maxReconsumeTimes) {
        this.maxReconsumeTimes = maxReconsumeTimes;
    }

    public boolean isBatch() {
        return batch;
    }

    public void setBatch(boolean batch) {
        this.batch = batch;
    }
}
