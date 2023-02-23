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
    private int hpGrowth;
    private int atkGrowth;
    private int defGrowth;

    // Shared with Spectrobes Origins
    private int bonusHp;
    private int bonusAtk;
    private int bonusDef;

    // Specific for Spectrobes Origins
    private int form;
    private int experience;
    private boolean autoAttack;
    private int commandAttack;
    private int comboStrongAttack;
    private int specialAttack;
    private int ability;
    private int lockOnStrongAttack;
    private int currentCharge;
    private int index;
    private int storagePosition;


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
        if (nickname.length() > 6) {
            nickname = nickname.substring(0, 6);
        }
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
        dataOutput.writeInt(Registries.ORIGINS.get(species));
        dataOutput.writeInt(form);
        dataOutput.writeInt(experience);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0);
        dataOutput.writeInt(autoAttack ? 0xFFFFFFFF : 0);
        dataOutput.writeInt(commandAttack);
        dataOutput.writeInt(comboStrongAttack);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(specialAttack);
        dataOutput.writeInt(ability);
        dataOutput.writeInt(lockOnStrongAttack);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(0xFFFFFFFF);
        dataOutput.writeInt(level);
        dataOutput.writeInt(hp);
        dataOutput.writeInt(currentCharge);
        dataOutput.writeInt(bonusHp);
        dataOutput.writeInt(bonusAtk);
        dataOutput.writeInt(bonusDef);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0);
        if (nickname.length() > 6) {
            nickname = nickname.substring(0, 6);
        }
        for (char c : nickname.toCharArray()) {
            dataOutput.writeByte(c);
        }
        var size = 10 - nickname.length();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                dataOutput.writeInt(0);
            }
        }
        dataOutput.writeByte(0);
        dataOutput.writeByte(0);
        dataOutput.writeInt(0);
        dataOutput.writeInt(0);
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
        var spectrobe = new Spectrobe();
        spectrobe.species = Registries.ORIGINS.get(dataInput.readInt());
        spectrobe.form = dataInput.readInt();
        spectrobe.experience = dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        spectrobe.autoAttack = dataInput.readInt() > 0;
        spectrobe.commandAttack = dataInput.readInt();
        spectrobe.comboStrongAttack = dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        spectrobe.specialAttack = dataInput.readInt();
        spectrobe.ability = dataInput.readInt();
        spectrobe.lockOnStrongAttack = dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        spectrobe.level = dataInput.readInt();
        spectrobe.hp = dataInput.readInt();
        spectrobe.currentCharge = dataInput.readInt();
        spectrobe.bonusHp = dataInput.readInt();
        spectrobe.bonusAtk = dataInput.readInt();
        spectrobe.bonusDef = dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        dataInput.readInt();
        var chars = new char[6];
        for (int i = 0; i < 6; i++) {
            chars[i] = (char) dataInput.readUnsignedByte();
        }
        spectrobe.nickname = new String(chars);

        return spectrobe;
    }
}
