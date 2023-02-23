package com.chaottic.spectrobes;

import com.chaottic.spectrobes.io.SpectrobesDataInputStream;
import com.chaottic.spectrobes.io.SpectrobesDataOutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Test {

    @org.junit.jupiter.api.Test
    public void write() throws IOException {

        var path = Paths.get("komainu.bin");

        try (SpectrobesDataOutputStream dataOutputStream = new SpectrobesDataOutputStream(Files.newOutputStream(path))) {
            var spectrobe = new Spectrobe();
            spectrobe.setSpecies(Species.KOMAINU);
            spectrobe.setHp(100);
            spectrobe.setMaxhp(100);
            spectrobe.setHpexp(1);
            spectrobe.setAtk(100);
            spectrobe.setAtkexp(1);
            spectrobe.setDef(100);
            spectrobe.setDefexp(1);
            spectrobe.setColor(1);
            spectrobe.setLevel(1);
            spectrobe.setPart(0);
            spectrobe.setSlot(1);
            spectrobe.setNickname("debug");

            spectrobe.writeSpectrobes(dataOutputStream);
            dataOutputStream.flush();
        }
    }

    @org.junit.jupiter.api.Test
    public void read() throws IOException {
        var path = Paths.get("komainu.bin");

        try (SpectrobesDataInputStream dataInputStream = new SpectrobesDataInputStream(Files.newInputStream(path))) {
            System.out.println(Spectrobe.ofSpectrobes(dataInputStream));
        }
    }
}
