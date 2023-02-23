package com.chaottic.spectrobes;

import lombok.Data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
public final class Spectrobe {
    private Species species;
    private int hp;
    private int atk;
    private int def;
    private int color;
    private int level;
    private int part;
    private int slot;
    private String nickname;

    // Specific for Spectrobes
    private int maxhp;
    private int hpexp;
    private int atkexp;
    private int defexp;
    private int id;
    private int partner;

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
        dataOutput.writeChars(nickname);
        dataOutput.writeShort(0xFFFF);
        var size = 16 - nickname.length();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                dataOutput.writeShort(0);
            }
        }
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
        dataInput.readShort();

        return spectrobe;
    }

    public static Spectrobe ofBeyondThePortal(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }

    public static Spectrobe ofOrigins(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }
}
