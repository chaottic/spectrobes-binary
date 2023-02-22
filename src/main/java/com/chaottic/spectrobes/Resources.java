package com.chaottic.spectrobes;

import java.io.IOException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.Objects;

public final class Resources {

    private Resources() {
    }

    public static FileSystem getFileSystem() throws IOException {
        var location = Resources.class.getProtectionDomain().getCodeSource().getLocation().toString();

        return FileSystems.newFileSystem(Paths.get(location.substring(location.lastIndexOf(':'))), Resources.class.getClassLoader());
    }

    public static URL getResource(String path) {
        return Objects.requireNonNull(Resources.class.getClassLoader().getResource(path));
    }
}
