package com.chaottic.spectrobes;

import com.chaottic.spectrobes.io.SpectrobesDataInputStream;
import com.chaottic.spectrobes.io.SpectrobesDataOutputStream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Test {

    @org.junit.jupiter.api.Test
    public void write() throws IOException {
        var path = Paths.get("test.spectrobe");

        try (SpectrobesDataOutputStream dataOutputStream = new SpectrobesDataOutputStream(Files.newOutputStream(path))) {
            var spectrobe = new Spectrobe();
            spectrobe.species = Species.VILAR;

            spectrobe.write(dataOutputStream);
            dataOutputStream.flush();
        }
    }

    @org.junit.jupiter.api.Test
    public void read() throws IOException {
        var path = Paths.get("test.spectrobe");

        try (SpectrobesDataInputStream dataInputStream = new SpectrobesDataInputStream(Files.newInputStream(path))) {
            var spectrobe = Spectrobe.of(dataInputStream);

            System.out.println(spectrobe.species);
        }
    }
}
