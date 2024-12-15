package org.shaobig.song.packager.resolver.path;

import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class SongPathResolver implements PathResolver<Path> {

    private PathResolver<Path> mp3PathResolver;

    public SongPathResolver(PathResolver<Path> mp3PathResolver) {
        this.mp3PathResolver = mp3PathResolver;
    }

    @Override
    public Path resolvePath(Path path) {
        return getMp3PathResolver().resolvePath(path).resolve(path.getFileName());
    }

    public PathResolver<Path> getMp3PathResolver() {
        return mp3PathResolver;
    }

    public void setMp3PathResolver(PathResolver<Path> mp3PathResolver) {
        this.mp3PathResolver = mp3PathResolver;
    }

}
