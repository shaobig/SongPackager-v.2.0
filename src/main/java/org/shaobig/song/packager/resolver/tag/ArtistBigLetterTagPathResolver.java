package org.shaobig.song.packager.resolver.tag;

import com.mpatric.mp3agic.ID3v2;
import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class ArtistBigLetterTagPathResolver implements PathResolver<ID3v2> {

    private PathResolver<String> stringPathResolver;

    public ArtistBigLetterTagPathResolver(PathResolver<String> stringPathResolver) {
        this.stringPathResolver = stringPathResolver;
    }

    @Override
    public Path resolvePath(ID3v2 data) {
        return getStringPathResolver().resolvePath(String.valueOf(data.getArtist().charAt(0)).toUpperCase());
    }

    public PathResolver<String> getStringPathResolver() {
        return stringPathResolver;
    }

    public void setStringPathResolver(PathResolver<String> stringPathResolver) {
        this.stringPathResolver = stringPathResolver;
    }

}
