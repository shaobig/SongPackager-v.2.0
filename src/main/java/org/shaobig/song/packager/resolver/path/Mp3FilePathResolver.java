package org.shaobig.song.packager.resolver.path;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.Mp3File;
import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class Mp3FilePathResolver implements PathResolver<Mp3File> {

    private PathResolver<ID3v2> id3v2PathResolver;

    public Mp3FilePathResolver(PathResolver<ID3v2> id3v2PathResolver) {
        this.id3v2PathResolver = id3v2PathResolver;
    }

    @Override
    public Path resolvePath(Mp3File mp3File) {
        return getId3v2PathResolver().resolvePath(mp3File.getId3v2Tag());
    }

    public PathResolver<ID3v2> getId3v2PathResolver() {
        return id3v2PathResolver;
    }

    public void setId3v2PathResolver(PathResolver<ID3v2> id3v2PathResolver) {
        this.id3v2PathResolver = id3v2PathResolver;
    }

}
