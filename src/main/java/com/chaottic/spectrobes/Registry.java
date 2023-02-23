package com.chaottic.spectrobes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

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
            var entries = GSON.fromJson(reader, JsonElement.class).getAsJsonObject().entrySet();

            var size = entries.size();
            var map = new Object2IntOpenHashMap<Species>(size);
            var reversed = new Int2ObjectOpenHashMap<Species>(size);

            for (Map.Entry<String, JsonElement> entry : entries) {
                var species = Species.NAMES.inverse().get(entry.getKey());
                var val = entry.getValue().getAsInt();

                map.put(species, val);
                reversed.put(val, species);
            }

            return new Registry(Object2IntMaps.unmodifiable(map), Int2ObjectMaps.unmodifiable(reversed));
        }
    }
}
