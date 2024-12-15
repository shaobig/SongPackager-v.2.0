package org.shaobig.song.packager.resolver.path;

import com.mpatric.mp3agic.Mp3File;
import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class Mp3PathResolver implements PathResolver<Path> {

    private PathResolver<Mp3File> mp3FilePathResolver;

    public Mp3PathResolver(PathResolver<Mp3File> mp3FilePathResolver) {
        this.mp3FilePathResolver = mp3FilePathResolver;
    }

    @Override
    public Path resolvePath(Path path) {
        try {
            return getMp3FilePathResolver().resolvePath(new Mp3File(path));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PathResolver<Mp3File> getMp3FilePathResolver() {
        return mp3FilePathResolver;
    }

    public void setMp3FilePathResolver(PathResolver<Mp3File> mp3FilePathResolver) {
        this.mp3FilePathResolver = mp3FilePathResolver;
    }

}
