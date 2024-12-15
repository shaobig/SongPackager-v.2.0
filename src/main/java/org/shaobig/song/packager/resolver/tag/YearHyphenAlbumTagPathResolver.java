package org.shaobig.song.packager.resolver.tag;

import com.mpatric.mp3agic.ID3v2;
import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class YearHyphenAlbumTagPathResolver implements PathResolver<ID3v2> {

    private PathResolver<String> stringPathResolver;

    public YearHyphenAlbumTagPathResolver(PathResolver<String> stringPathResolver) {
        this.stringPathResolver = stringPathResolver;
    }

    @Override
    public Path resolvePath(ID3v2 tag) {
        return getStringPathResolver().resolvePath(String.format("%s - %s", tag.getYear(), tag.getAlbum()));
    }

    public PathResolver<String> getStringPathResolver() {
        return stringPathResolver;
    }

    public void setStringPathResolver(PathResolver<String> stringPathResolver) {
        this.stringPathResolver = stringPathResolver;
    }

}
