package com.chaottic.spectrobes;

public record Namespace(String namespace, String path) {

    public static Namespace fromString(String s) {
        var split = s.split(":", 2);

        return new Namespace(split[0], split[1]);
    }
}
