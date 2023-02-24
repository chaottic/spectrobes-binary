package com.chaottic.spectrobes;

import lombok.Data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
public final class Spectrobe {
    private static final short BIT_MASK = 0x7FFF;

    private Species species;
    private int currentHp;
    private int maximumHp;
    private int atk;
    private int def;
    private int hpExperience;
    private int atkExperience;
    private int defExperience;
    private int color;
    private int level;
    private int customPart;
    private int currentSlot;
    private int bond;
    private int bondPartner;
    private String nickname;

    public void writeSpectrobes(DataOutput dataOutput) throws IOException {

    }

    public void writeBeyondThePortals(DataOutput dataOutput) throws IOException {

    }

    public void writeOrigins(DataOutput dataOutput) throws IOException {

    }

    public static Spectrobe readSpectrobes(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    public static Spectrobe readBeyondThePortals(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    public static Spectrobe readOrigins(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    private static int swap(int i) {
        var l = i & BIT_MASK;
        var r = (i >> 8) & BIT_MASK;

        return ((l & BIT_MASK) << 8) | (r & BIT_MASK);
    }
}
