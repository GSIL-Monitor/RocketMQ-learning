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
package org.apache.rocketmq.store.util;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

/**
 * 这里涉及JNA的一些东西，jna是java native access的简称，用他可以调用C、C++代码，特别是windows中强大的库文件（dll，在linux下是so文件），
 * 这样java就可以操控底层的一些东西，比如调用加密机、智能卡之类的
 *
 * 自定义JNA时，必须继承Library库
 *
 * 接口中定义的方法必须和C/C++的函数名称一样才可以
 */
public interface LibC extends Library {
    /**
     * MSVCRT 时windows自带的动态链接库
     *
     * 获得一个实例进行操作
     */
    LibC INSTANCE = (LibC) Native.loadLibrary(Platform.isWindows() ? "msvcrt" : "c", LibC.class);

    int MADV_WILLNEED = 3;
    int MADV_DONTNEED = 4;

    int MCL_CURRENT = 1;
    int MCL_FUTURE = 2;
    int MCL_ONFAULT = 4;

    /* sync memory asynchronously */
    int MS_ASYNC = 0x0001;
    /* invalidate mappings & caches */
    int MS_INVALIDATE = 0x0002;
    /* synchronous memory sync */
    int MS_SYNC = 0x0004;

    /**
     * 系统调用 mlock 家族允许程序在物理内存上锁住它的部分或全部地址空间。这将阻止Linux 将这个内存页调度到交换空间（swap space），即使该程序已有一段时间没有访问这段空间
     * rocketmq 这样做的原因可能时加快访问速度
     * @param var1 锁住的起始地址
     * @param var2 锁住的长度
     * @return
     */
    int mlock(Pointer var1, NativeLong var2);

    int munlock(Pointer var1, NativeLong var2);

    int madvise(Pointer var1, NativeLong var2, int var3);

    Pointer memset(Pointer p, int v, long len);

    int mlockall(int flags);

    int msync(Pointer p, NativeLong length, int flags);
}
