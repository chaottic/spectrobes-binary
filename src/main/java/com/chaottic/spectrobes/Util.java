package com.chaottic.spectrobes;

public final class Util {
    private static final short BIT_MASK = 0x7FFF;

    private Util() {
    }

    public static short swap(int i) {
        var left = i & BIT_MASK;
        var right = (i >> 8) & BIT_MASK;

        return (short) (((left & BIT_MASK) << 8) | (right & BIT_MASK));
    }
}
