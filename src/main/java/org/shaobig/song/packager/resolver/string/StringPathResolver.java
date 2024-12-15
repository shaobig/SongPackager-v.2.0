package org.shaobig.song.packager.resolver.string;

import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class StringPathResolver implements PathResolver<String> {

    @Override
    public Path resolvePath(String string) {
        return Path.of(string);
    }

}
