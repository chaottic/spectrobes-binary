package com.chaottic.spectrobes;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public final class Spectrobe {
    public Species species;
    public int hp;
    public int atk;
    public int def;
    public int color;
    public int level;
    public int part;
    public int slot;
    public String nickname;

    // Specific for Spectrobes
    public int maxhp;
    public int hpexp;
    public int atkexp;
    public int defexp;
    public int id;
    public int partner;

    // Specific for Spectrobes Beyond the Portals

    // Specific for Spectrobes Origins

    public void writeSpectrobes(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(Registries.SPECTROBES.get(species));
        dataOutput.writeShort(hp);
        dataOutput.writeShort(maxhp);
        dataOutput.writeShort(hpexp);
        dataOutput.writeShort(atk);
        dataOutput.writeShort(atkexp);
        dataOutput.writeShort(def);
        dataOutput.writeShort(defexp);
        dataOutput.writeByte(color);
        dataOutput.writeByte(level);
        dataOutput.writeByte(part);
        dataOutput.writeByte(slot);
        dataOutput.writeInt(0);
        dataOutput.writeShort(id);
        dataOutput.writeShort(partner);
    }

    public void writeBeyondThePortal(DataOutput dataOutput) throws IOException {

    }

    public void writeOrigins(DataOutput dataOutput) throws IOException {

    }

    public static Spectrobe ofSpectrobes(DataInput dataInput) throws IOException {
        var spectrobe = new Spectrobe();
        spectrobe.species = Registries.SPECTROBES.get(dataInput.readShort());
        spectrobe.hp = dataInput.readShort();
        spectrobe.maxhp = dataInput.readShort();
        spectrobe.hpexp = dataInput.readShort();
        spectrobe.atk = dataInput.readShort();
        spectrobe.atkexp = dataInput.readShort();
        spectrobe.def = dataInput.readShort();
        spectrobe.defexp = dataInput.readShort();
        spectrobe.color = dataInput.readUnsignedByte();
        spectrobe.level = dataInput.readUnsignedByte();
        spectrobe.part = dataInput.readUnsignedByte();
        spectrobe.slot = dataInput.readUnsignedByte();
        dataInput.readInt();
        spectrobe.id = dataInput.readShort();
        spectrobe.partner = dataInput.readShort();

        return spectrobe;
    }

    public static Spectrobe ofBeyondThePortal(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    public static Spectrobe ofOrigins(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }
}
