package com.chaottic.spectrobes;

import lombok.Data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
public final class Spectrobe {
    private Species species;
    private int hp;
    private int maxHp;
    private int atk;
    private int def;
    private int color;
    private int level;
    private int customPart;
    private String nickname;

    // Specific for Spectrobes
    private int hpExp;
    private int atkExp;
    private int defExp;
    private int customPartSlot;
    private int partnerId;
    private int partner;

    // Specific for Spectrobes Beyond the Portals
    private int storageSlot;
    private int bonusHp;
    private int bonusAtk;
    private int bonusDef;
    private int hpGrowth;
    private int atkGrowth;
    private int defGrowth;

    // Specific for Spectrobes Origins

    public void writeSpectrobes(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(Registries.SPECTROBES.get(species));
        dataOutput.writeShort(hp);
        dataOutput.writeShort(maxHp);
        dataOutput.writeShort(hpExp);
        dataOutput.writeShort(atk);
        dataOutput.writeShort(atkExp);
        dataOutput.writeShort(def);
        dataOutput.writeShort(defExp);
        dataOutput.writeByte(color);
        dataOutput.writeByte(level);
        dataOutput.writeByte(customPart);
        dataOutput.writeByte(customPartSlot);
        dataOutput.writeLong(0);
        dataOutput.writeShort(partnerId);
        dataOutput.writeShort(partner);
        dataOutput.writeChars(nickname);
        dataOutput.writeShort(0xFFFF);
        var size = 15 - nickname.length();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                dataOutput.writeShort(0);
            }
        }
    }

    public void writeBeyondThePortal(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(Registries.BEYOND_THE_PORTALS.get(species));
        dataOutput.writeShort(hp);
        dataOutput.writeShort(maxHp);
        dataOutput.writeShort(atk);
        dataOutput.writeShort(def);
        dataOutput.writeShort(bonusHp);
        dataOutput.writeShort(bonusAtk);
        dataOutput.writeShort(bonusDef);
        dataOutput.writeShort(hpGrowth);
        dataOutput.writeShort(atkGrowth);
        dataOutput.writeShort(defGrowth);
        dataOutput.writeByte(color);
        dataOutput.writeByte(level);
        dataOutput.writeByte(storageSlot);
        dataOutput.writeByte(customPart);
    }

    public void writeOrigins(DataOutput dataOutput) throws IOException {
    }

    public static Spectrobe readSpectrobes(DataInput dataInput) throws IOException {
        var spectrobe = new Spectrobe();
        spectrobe.species = Registries.SPECTROBES.get(dataInput.readShort());
        spectrobe.hp = dataInput.readShort();
        spectrobe.maxHp = dataInput.readShort();
        spectrobe.hpExp = dataInput.readShort();
        spectrobe.atk = dataInput.readShort();
        spectrobe.atkExp = dataInput.readShort();
        spectrobe.def = dataInput.readShort();
        spectrobe.defExp = dataInput.readShort();
        spectrobe.color = dataInput.readUnsignedByte();
        spectrobe.level = dataInput.readUnsignedByte();
        spectrobe.customPart = dataInput.readUnsignedByte();
        spectrobe.customPartSlot = dataInput.readUnsignedByte();
        dataInput.readShort();
        dataInput.readShort();
        dataInput.readShort();
        spectrobe.partnerId = dataInput.readShort();
        spectrobe.partner = dataInput.readShort();
        dataInput.readShort();

        return spectrobe;
    }

    public static Spectrobe readBeyondThePortal(DataInput dataInput) throws IOException {
        var spectrobe = new Spectrobe();
        spectrobe.species = Registries.BEYOND_THE_PORTALS.get(dataInput.readShort());
        spectrobe.hp = dataInput.readShort();
        spectrobe.maxHp = dataInput.readShort();
        spectrobe.atk = dataInput.readShort();
        spectrobe.def = dataInput.readShort();
        spectrobe.bonusHp = dataInput.readShort();
        spectrobe.bonusAtk = dataInput.readShort();
        spectrobe.bonusDef = dataInput.readShort();
        spectrobe.hpGrowth = dataInput.readShort();
        spectrobe.atkGrowth = dataInput.readShort();
        spectrobe.defGrowth = dataInput.readShort();
        spectrobe.color = dataInput.readUnsignedByte();
        spectrobe.level = dataInput.readUnsignedByte();
        spectrobe.storageSlot = dataInput.readUnsignedByte();
        spectrobe.customPartSlot = dataInput.readUnsignedByte();

        return new Spectrobe();
    }

    public static Spectrobe readOrigins(DataInput dataInput) throws IOException {
        return new Spectrobe();
    }
}
