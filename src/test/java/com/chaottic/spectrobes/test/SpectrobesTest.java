package com.chaottic.spectrobes.test;

import com.chaottic.spectrobes.Species;
import com.chaottic.spectrobes.Spectrobe;
import org.junit.jupiter.api.Test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class SpectrobesTest {
    public static final Path PATH = Paths.get("komainu.spec");

    @Test
    public void read() throws IOException {
        try (DataInputStream dataInputStream = new DataInputStream(Files.newInputStream(PATH))) {
            System.out.println(Spectrobe.readSpectrobes(dataInputStream));
        }
    }

    @Test
    public void write() throws IOException {
        try (DataOutputStream dataOutputStream = new DataOutputStream(Files.newOutputStream(PATH))) {
            var spectrobe = new Spectrobe();
            spectrobe.setSpecies(Species.KOMAINU);
            spectrobe.setCurrentHp(1);
            spectrobe.setMaximumHp(1);
            spectrobe.writeSpectrobes(dataOutputStream);
            dataOutputStream.flush();
        }
    }
}
