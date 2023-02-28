package com.chaottic.spectrobes;

import de.marhali.json5.Json5;
import de.marhali.json5.Json5Element;
import de.marhali.json5.Json5OptionsBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public final class NumberMap {
    public static final NumberMap SPECTROBES;
    public static final NumberMap BEYOND_THE_PORTALS;
    public static final NumberMap ORIGINS;

    // TODO:: Cleanup
    static {
        try {
            SPECTROBES = of("species_as_number/spectrobes.json5");
            BEYOND_THE_PORTALS = of("species_as_number/beyond_the_portals.json5");
            ORIGINS = of("species_as_number/origins.json5");
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final Object2IntMap<Species> map;
    private final Int2ObjectMap<Species> inverse;

    private NumberMap(Object2IntMap<Species> map, Int2ObjectMap<Species> inverse) {
        this.map = map;
        this.inverse = inverse;
    }

    public Species getSpecies(int i) {
        return inverse.getOrDefault(i, Species.KOMAINU);
    }

    public int getNumber(Species species) {
        return map.getOrDefault(species, 0x01);
    }

    private static NumberMap of(String path) throws URISyntaxException, IOException {
        var json5 = Json5.builder(Json5OptionsBuilder::build);

        var uri = Resources.getResource(path).toURI();

        if (uri.getScheme().contains("jar")) {
            try (FileSystem fileSystem = Resources.getFileSystem(); InputStream inputStream = Files.newInputStream(fileSystem.getPath(path))) {
                return of(json5.parse(inputStream));
            }
        }

        try (InputStream inputStream = Files.newInputStream(Paths.get(uri))) {
            return of(json5.parse(inputStream));
        }
    }

    private static NumberMap of(Json5Element element) {
        var entries = element.getAsJson5Object().entrySet();

        var size = entries.size();

        var map = new Object2IntOpenHashMap<Species>(size);
        var inverse = new Int2ObjectOpenHashMap<Species>(size);

        for (Map.Entry<String, Json5Element> entry : entries) {
            var species = Species.BI_MAP.get(Namespace.fromString(entry.getKey()));
            var number = entry.getValue().getAsInt();

            map.put(species, number);
            inverse.put(number, species);
        }

        return new NumberMap(Object2IntMaps.unmodifiable(map), Int2ObjectMaps.unmodifiable(inverse));
    }
}
