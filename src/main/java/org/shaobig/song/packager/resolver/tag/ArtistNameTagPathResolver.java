package org.shaobig.song.packager.resolver.tag;

import com.mpatric.mp3agic.ID3v2;
import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class ArtistNameTagPathResolver implements PathResolver<ID3v2> {

    private PathResolver<String> stringPathResolver;

    public ArtistNameTagPathResolver(PathResolver<String> stringPathResolver) {
        this.stringPathResolver = stringPathResolver;
    }

    @Override
    public Path resolvePath(ID3v2 tag) {
        return getStringPathResolver().resolvePath(tag.getArtist().toUpperCase());
    }

    public PathResolver<String> getStringPathResolver() {
        return stringPathResolver;
    }

    public void setStringPathResolver(PathResolver<String> stringPathResolver) {
        this.stringPathResolver = stringPathResolver;
    }

}
