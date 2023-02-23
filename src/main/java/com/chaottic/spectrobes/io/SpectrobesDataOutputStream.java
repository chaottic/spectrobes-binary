package com.chaottic.spectrobes.io;

import com.chaottic.spectrobes.Util;
import com.google.common.io.LittleEndianDataOutputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public final class SpectrobesDataOutputStream extends FilterOutputStream implements DataOutput {

    public SpectrobesDataOutputStream(OutputStream out) {
        super(new DataOutputStream(out));
    }

    @Override
    public void writeBoolean(boolean v) throws IOException {

    }

    @Override
    public void writeByte(int v) throws IOException {
        ((DataOutputStream) out).writeByte(v);
    }

    @Override
    public void writeShort(int v) throws IOException {
        ((DataOutputStream) out).writeShort(Util.swap(v));
    }

    @Override
    public void writeChar(int v) throws IOException {
        writeShort(v);
    }

    @Override
    public void writeInt(int v) throws IOException {

    }

    @Override
    public void writeLong(long v) throws IOException {

    }

    @Override
    public void writeFloat(float v) throws IOException {

    }

    @Override
    public void writeDouble(double v) throws IOException {

    }

    @Override
    public void writeBytes(String s) throws IOException {

    }

    @Override
    public void writeChars(String s) throws IOException {
        for (byte b : s.getBytes(StandardCharsets.US_ASCII)) {
            writeChar(b);
        }
    }

    @Override
    public void writeUTF(String s) throws IOException {

    }
}
