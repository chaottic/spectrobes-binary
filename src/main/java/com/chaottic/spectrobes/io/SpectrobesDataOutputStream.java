package com.chaottic.spectrobes.io;

import com.chaottic.spectrobes.Spectrobe;
import com.google.common.io.LittleEndianDataOutputStream;

import java.io.*;

public final class SpectrobesDataOutputStream extends FilterOutputStream implements DataOutput {

    public SpectrobesDataOutputStream(OutputStream out) {
        super(new LittleEndianDataOutputStream(out));
    }

    @Override
    public void writeBoolean(boolean v) throws IOException {

    }

    @Override
    public void writeByte(int v) throws IOException {

    }

    @Override
    public void writeShort(int v) throws IOException {
        ((LittleEndianDataOutputStream) out).writeShort(Spectrobe.flip((short) v));
    }

    @Override
    public void writeChar(int v) throws IOException {

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

    }

    @Override
    public void writeUTF(String s) throws IOException {

    }
}
