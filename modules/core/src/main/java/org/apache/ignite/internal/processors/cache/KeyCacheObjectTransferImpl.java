/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.processors.cache;

import org.apache.ignite.*;
import org.apache.ignite.plugin.extensions.communication.*;
import org.jetbrains.annotations.*;

import java.nio.*;

/**
 *
 */
public class KeyCacheObjectTransferImpl implements KeyCacheObject {
    /** */
    private final byte[] valBytes;

    /**
     * @param valBytes Value bytes.
     */
    public KeyCacheObjectTransferImpl(byte[] valBytes) {
        assert valBytes != null;

        this.valBytes = valBytes;
    }

    /** {@inheritDoc} */
    @Override public boolean internal() {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Nullable @Override public <T> T value(CacheObjectContext ctx, boolean cpy) {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Nullable @Override public <T> T getField(String name) {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Override public void prepareMarshal(CacheObjectContext ctx) throws IgniteCheckedException {
        // No-op.
    }

    /** {@inheritDoc} */
    @Override public boolean byteArray() {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Override public byte[] valueBytes(CacheObjectContext ctx) throws IgniteCheckedException {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Override public void finishUnmarshal(CacheObjectContext ctx, ClassLoader ldr) throws IgniteCheckedException {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Override public CacheObject prepareForCache(CacheObjectContext ctx) {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Override public boolean writeTo(ByteBuffer buf, MessageWriter writer) {
        writer.setBuffer(buf);

        if (!writer.isHeaderWritten()) {
            if (!writer.writeHeader(directType(), fieldsCount()))
                return false;

            writer.onHeaderWritten();
        }

        switch (writer.state()) {
            case 0:
                if (!writer.writeByteArray("valBytes", valBytes))
                    return false;

                writer.incrementState();

        }

        return true;
    }

    /** {@inheritDoc} */
    @Override public boolean readFrom(ByteBuffer buf, MessageReader reader) {
        throw new IllegalStateException();
    }

    /** {@inheritDoc} */
    @Override public byte directType() {
        return KeyCacheObjectImpl.DIRECT_TYPE;
    }

    /** {@inheritDoc} */
    @Override public byte fieldsCount() {
        return 1;
    }
}
