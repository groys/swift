/**
 * Copyright 2012 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.swift.service.puma.swift;

import com.facebook.swift.service.ThriftException;
import com.facebook.swift.service.ThriftMethod;
import com.facebook.swift.service.ThriftService;
import org.apache.thrift.TException;

import java.io.Closeable;
import java.util.List;

@ThriftService
public interface PumaReadService extends Closeable
{
    @ThriftMethod
    List<ReadResultQueryInfo> getResult(List<ReadQueryInfoTimeString> reader)
            throws ReadSemanticException;

    @ThriftMethod
    List<ReadResultQueryInfoTimeString> getResultTimeString(List<ReadQueryInfoTimeString> reader)
            throws ReadSemanticException;

    @ThriftMethod
    List<ReadResultQueryInfo> mergeQueryAggregation(
            MergeAggregationQueryInfo mergeAggregationQueryInfo
    )
            throws ReadSemanticException;

    @ThriftMethod
    long latestQueryableTime(String category, String appName, List<Integer> bucketNumbers)
            throws ReadSemanticException;

    @ThriftMethod
    List<Long> latestQueryableTimes(String category, String appName, List<Integer> bucketNumbers)
            throws ReadSemanticException;

    @Override
    void close();
}
