/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2022 Agorapulse.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.agorapulse.worker.job;

import com.agorapulse.worker.JobConfiguration;

import java.util.function.Consumer;

public class SimpleJob extends AbstractJob {

    private final Runnable task;

    public SimpleJob(JobConfiguration configuration, Runnable task) {
        super(configuration);
        this.task = task;
    }

    @Override
    public String getSource() {
        return toString();
    }

    @Override
    protected void doRun(Consumer<Throwable> onError) {
        try {
            task.run();
        } catch (Throwable th) {
            onError.accept(th);
        }
    }
}
