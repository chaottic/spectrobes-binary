package com.chaottic.spectrobes;

import lombok.Data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

@Data
public final class Spectrobe {
    private Species species;
    private int currentHp;
    private int maximumHp;
    private int atk;
    private int def;
    private int hpMinergy;
    private int atkMinergy;
    private int defMinergy;
    private int color;
    private int level;
    private int customPart;
    private int prizmodSlot;
    private int bondId;
    private int bondPartner;
    private String nickname;

    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeShort(NumberMap.SPECTROBES.getNumber(species));
        dataOutput.writeShort(currentHp);
        dataOutput.writeShort(maximumHp);
        dataOutput.writeShort(hpMinergy);
        dataOutput.writeShort(atk);
        dataOutput.writeShort(atkMinergy);
        dataOutput.writeShort(def);
        dataOutput.writeShort(defMinergy);
        dataOutput.writeByte(color);
        dataOutput.writeByte(level);
        dataOutput.writeByte(customPart);
        dataOutput.writeByte(prizmodSlot);
        dataOutput.writeLong(0);
        dataOutput.writeShort(bondId);
        dataOutput.writeShort(bondPartner);
        if (nickname.length() > 6) {
            nickname = nickname.substring(0, 6);
        }
        dataOutput.writeChars(nickname);
        dataOutput.writeShort(0xFFFF);
        var length = 15 - nickname.length();
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                dataOutput.writeShort(0);
            }
        }
    }

    public static Spectrobe read(DataInput dataInput) throws IOException {
        var spectrobe = new Spectrobe();

        return spectrobe;
    }
}
