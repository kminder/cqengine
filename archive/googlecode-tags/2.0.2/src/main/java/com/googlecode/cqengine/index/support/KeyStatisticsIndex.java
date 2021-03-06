/**
 * Copyright 2012-2015 Niall Gallagher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.googlecode.cqengine.index.support;

import com.googlecode.cqengine.index.Index;
import com.googlecode.cqengine.query.option.QueryOptions;

/**
 * An index which allows the set of distinct keys to be queried, and which can return statistics on the number of
 * objects stored in the buckets for each key.
 * <p/>
 * Note that this interface reads statistics about keys and NOT about attribute values from the index.
 * Often those statistics will be the same, however if a {@link com.googlecode.cqengine.quantizer.Quantizer} is
 * configured for an index, then often objects for several attribute values may have the same key and may be stored
 * in the same bucket.
 *
 * Created by niall.gallagher on 09/01/2015.
 */
public interface KeyStatisticsIndex<A, O> extends Index<O> {

    /**
     * @return The distinct keys in the index
     * @param queryOptions Optional parameters for the query
     */
    public CloseableIterable<A> getDistinctKeys(QueryOptions queryOptions);

    /**
     * @param key A key which may be contained in the index
     * @param queryOptions Optional parameters for the query
     * @return The number of objects stored in the bucket in the index with the given key
     */
    public Integer getCountForKey(A key, QueryOptions queryOptions);
}
