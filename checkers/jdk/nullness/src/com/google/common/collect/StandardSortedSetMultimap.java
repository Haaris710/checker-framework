/*
 * Copyright (C) 2007 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

import java.util.Collection;
import java.util.Map;
import java.util.SortedSet;

import checkers.nullness.quals.Nullable;
//import javax.annotation.Nullable;

/**
 * Basic implementation of the {@link SortedSetMultimap} interface. It's a
 * wrapper around {@link StandardMultimap} that converts the returned
 * collections into sorted sets. The {@link #createCollection} method
 * must return a {@code SortedSet}.
 *
 * @author Jared Levy
 */
@SuppressWarnings("nullness:generic.argument")
@GwtCompatible
    abstract class StandardSortedSetMultimap<K extends /*@Nullable*/ Object,
					     V extends /*@Nullable*/ Object>
    extends StandardSetMultimap<K, V> implements SortedSetMultimap<K, V> {
  /**
   * Creates a new multimap that uses the provided map.
   *
   * @param map place to store the mapping from each key to its corresponding
   *     values
   */
  protected StandardSortedSetMultimap(Map<K, Collection<V>> map) {
    super(map);
  }

  @Override abstract SortedSet<V> createCollection();

  @Override public SortedSet<V> get(K key) {
    return (SortedSet<V>) super.get(key);
  }

  @Override public SortedSet<V> removeAll(@Nullable Object key) {
    return (SortedSet<V>) super.removeAll(key);
  }

  @Override public SortedSet<V> replaceValues(
      K key, Iterable<? extends V> values) {
    return (SortedSet<V>) super.replaceValues(key, values);
  }

  /**
   * {@inheritDoc}
   *
   * Consequently, the values do not follow their natural ordering or the
   * ordering of the value comparator.
   */
  @Override public Collection<V> values() {
    return super.values();
  }
}
