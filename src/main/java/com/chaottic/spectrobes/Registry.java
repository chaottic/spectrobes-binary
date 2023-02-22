package com.chaottic.spectrobes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class Registry {
    private static final Gson GSON = new GsonBuilder().create();

    private final Object2IntMap<Species> map;
    private final Int2ObjectMap<Species> reversed;

    private Registry(Object2IntMap<Species> map, Int2ObjectMap<Species> reversed) {
        this.map = map;
        this.reversed = reversed;
    }

    public Species get(int i) {
        return reversed.get(i);
    }

    public int get(Species species) {
        return map.getInt(species);
    }

    public static <T> Registry of(String path) {
        try {
            var uri = Resources.getResource(path).toURI();

            if (uri.getScheme().contains("jar")) {
                try (FileSystem fileSystem = Resources.getFileSystem()) {
                    return of(fileSystem.getPath(path));
                }
            } else {
                return of(Paths.get(uri));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }

        throw new RuntimeException();
    }

    private static Registry of(Path path) throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            return new Registry(null ,null);
        }
    }
}
