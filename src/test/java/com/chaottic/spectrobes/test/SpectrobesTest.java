package com.chaottic.spectrobes.test;

import com.chaottic.spectrobes.Species;
import com.chaottic.spectrobes.Spectrobe;
import com.google.common.io.LittleEndianDataInputStream;
import com.google.common.io.LittleEndianDataOutputStream;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class SpectrobesTest {
    public static final Path PATH = Paths.get("komainu.spec");

    @Test
    public void read() throws IOException {
        try (LittleEndianDataInputStream dataInputStream = new LittleEndianDataInputStream(Files.newInputStream(PATH))) {
            System.out.println(Spectrobe.read(dataInputStream));
        }
    }

    @Test
    public void write() throws IOException {
        try (LittleEndianDataOutputStream dataOutputStream = new LittleEndianDataOutputStream(Files.newOutputStream(PATH))) {
            var spectrobe = new Spectrobe();
            spectrobe.setSpecies(Species.KOMAINU);
            spectrobe.setCurrentHp(1);
            spectrobe.setMaximumHp(1);
            spectrobe.setNickname("Komainu");
            spectrobe.write(dataOutputStream);
            dataOutputStream.flush();
        }
    }
}
