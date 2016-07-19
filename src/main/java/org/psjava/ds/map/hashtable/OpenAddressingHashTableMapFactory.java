package org.psjava.ds.map.hashtable;

import org.psjava.ds.map.MutableMap;
import org.psjava.ds.map.MutableMapFactory;

public class OpenAddressingHashTableMapFactory {

    private static final HashProber PROBING = LinearProbing.create();

    private static final MutableMapFactory INSTANCE = new MutableMapFactory() {
        @Override
        public <K, V> MutableMap<K, V> create() {
            return new OpenAddressingHashTableMap<K, V>(PROBING, 1);
        }
    };

    public static MutableMapFactory getInstance() {
        return INSTANCE;
    }

    private OpenAddressingHashTableMapFactory() {
    }

}
