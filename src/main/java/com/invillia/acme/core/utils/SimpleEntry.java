package com.invillia.acme.core.utils;

import lombok.*;

/**
 * Basic simple entry class that contains a key and value.
 *
 * @author José Roberto <roberto.jrnj@gmail.com>
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleEntry<K, V> {

    private K key;
    private V value;

}
