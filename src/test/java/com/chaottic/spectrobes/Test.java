package com.chaottic.spectrobes;

import com.chaottic.spectrobes.io.SpectrobesDataInputStream;
import com.chaottic.spectrobes.io.SpectrobesDataOutputStream;
import com.google.common.io.LittleEndianDataOutputStream;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Test {

    @org.junit.jupiter.api.Test
    public void writeSpectrobes() throws IOException {
        var path = Paths.get("komainu.bin");

        try (SpectrobesDataOutputStream dataOutputStream = new SpectrobesDataOutputStream(Files.newOutputStream(path))) {
            createKomainu().writeSpectrobes(dataOutputStream);
            dataOutputStream.flush();
        }
    }

    @org.junit.jupiter.api.Test
    public void readSpectrobes() throws IOException {
        var path = Paths.get("komainu.bin");

        try (SpectrobesDataInputStream dataInputStream = new SpectrobesDataInputStream(Files.newInputStream(path))) {
            System.out.println(Spectrobe.readSpectrobes(dataInputStream));
        }
    }

    @org.junit.jupiter.api.Test
    public void writeBeyondThePortals() throws IOException {
        var path = Paths.get("komainu_btp.bin");

        try (SpectrobesDataOutputStream dataOutputStream = new SpectrobesDataOutputStream(Files.newOutputStream(path))) {
            createKomainu().writeBeyondThePortal(dataOutputStream);
            dataOutputStream.flush();
        }
    }

    @org.junit.jupiter.api.Test
    public void readBeyondThePortals() throws IOException {
        var path = Paths.get("komainu_btp.bin");

        try (SpectrobesDataInputStream dataInputStream = new SpectrobesDataInputStream(Files.newInputStream(path))) {
            System.out.println(Spectrobe.readBeyondThePortal(dataInputStream));
        }
    }

    @org.junit.jupiter.api.Test
    public void writeOrigins() throws IOException {
        var path = Paths.get("komainu_o.bin");

        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(path))) {
            createKomainu().writeOrigins(dataOutputStream);
            dataOutputStream.flush();
        }
    }

    @org.junit.jupiter.api.Test
    public void readOrigins() throws IOException {
        var path = Paths.get("komainu_o.bin");

        try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(path))) {
            System.out.println(Spectrobe.readOrigins(dataInputStream));
        }
    }

    public static Spectrobe createKomainu() {
        var spectrobe = new Spectrobe();
        spectrobe.setSpecies(Species.KOMAINU);
        spectrobe.setMaxHp(100);
        spectrobe.setHp(100);
        spectrobe.setAtk(100);
        spectrobe.setDef(100);
        spectrobe.setColor(1);
        spectrobe.setLevel(1);
        spectrobe.setNickname("komainu");
        return spectrobe;
    }
}
