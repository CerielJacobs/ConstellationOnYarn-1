/**
 * Copyright 2013 Netherlands eScience Center
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package nl.esciencecenter.constellation;

import java.io.Serializable;

/**
 * Container for the result of a SHA1Job
 */
public class SHA1Result implements Serializable {

    // Generated
    private static final long serialVersionUID = -1475352090350923307L;

    private final String file;
    private final long size;
    private final long offset;
    private final byte[] SHA1;
    private final long time;
    private final long readTime;
    private final Throwable e;

    private SHA1Result(String file, long size, long offset, byte[] sha1,
            long time, long readTime, Throwable e) {
        this.file = file;
        this.SHA1 = sha1;
        this.time = time;
        this.readTime = readTime;
        this.size = size;
        this.offset = offset;
        this.e = e;

    }

    public SHA1Result(String file, long size, long offset, byte[] sha1,
            long readTime, long time) {
        this(file, size, offset, sha1, time, readTime, null);
    }

    public SHA1Result(String file, long size, long offset, Throwable e) {
        this(file, size, offset, null, 0, 0, e);
    }

    public String getFile() {
        return file;
    }

    public long getOffset() {
        return offset;
    }

    public long getSize() {
        return size;
    }

    public byte[] getSHA1() {
        return SHA1;
    }

    public Throwable getException() {
        return e;
    }

    public boolean hasFailed() {
        return e != null;
    }

    public long getTime() {
        return time;
    }

    public long getReadTime() {
        return readTime;
    }
}
