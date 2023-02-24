package com.chaottic.spectrobes;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;

public final class NumberMap {
    public static final NumberMap SPECTROBES = of("species_as_number/spectrobes.json5");
    public static final NumberMap BEYOND_THE_PORTALS = of("species_as_number/beyond_the_portals.json5");
    public static final NumberMap ORIGINS = of("species_as_number/origins.json5");

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

    private static NumberMap of(String path) {
        return null;
    }
}
