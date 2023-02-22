package com.chaottic.spectrobes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class Spectrobe {
    private static final short BIT_MASK = 0x7FFF;

    public Species species;
    private int hp;
    private int atk;
    private int def;
    private int color;
    private int level;
    private int custompart;
    private String nickname;

    // Specific for Spectrobes
    private int maxhp;
    private int hpexp;
    private int atkexp;
    private int defexp;

    // Specific for Spectrobes Beyond the Portals

    // Specific for Spectrobes Origins


    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(species.to());
        dataOutput.writeShort(hp);
        dataOutput.writeShort(maxhp);
        dataOutput.writeShort(hpexp);
        dataOutput.writeShort(atk);
        dataOutput.writeShort(atkexp);
        dataOutput.writeShort(def);
        dataOutput.writeShort(defexp);
    }

    public void writeBeyondThePortal(DataOutput dataOutput) throws IOException {

    }

    public void writeOrigins(DataOutput dataOutput) throws IOException {

    }

    public static Spectrobe of(DataInput dataInput) throws IOException {
        var spectrobe = new Spectrobe();
        spectrobe.species = Species.from(dataInput.readShort());
        spectrobe.hp = dataInput.readShort();
        spectrobe.maxhp = dataInput.readShort();
        spectrobe.hpexp = dataInput.readShort();
        spectrobe.atk = dataInput.readShort();
        spectrobe.atkexp = dataInput.readShort();
        spectrobe.def = dataInput.readShort();
        spectrobe.defexp = dataInput.readShort();

        return spectrobe;
    }

    public static Spectrobe ofBeyondThePortal(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    public static Spectrobe ofOrigins(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    public static short flip(short s) {
        var left = s & BIT_MASK;
        var right = (s >> 8) & BIT_MASK;

        return (short) (((left & BIT_MASK) << 8) | (right & BIT_MASK));
    }
}
