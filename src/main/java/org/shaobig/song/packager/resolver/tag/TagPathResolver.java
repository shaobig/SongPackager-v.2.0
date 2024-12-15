package org.shaobig.song.packager.resolver.tag;

import com.mpatric.mp3agic.ID3v2;
import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class TagPathResolver implements PathResolver<ID3v2> {

    private PathResolver<ID3v2> artistBigLetterPathResolver;
    private PathResolver<ID3v2> artistNamePathResolver;
    private PathResolver<ID3v2> yearHyphenAlbumPathResolver;

    public TagPathResolver(PathResolver<ID3v2> artistBigLetterPathResolver, PathResolver<ID3v2> artistNamePathResolver, PathResolver<ID3v2> yearHyphenAlbumPathResolver) {
        this.artistBigLetterPathResolver = artistBigLetterPathResolver;
        this.artistNamePathResolver = artistNamePathResolver;
        this.yearHyphenAlbumPathResolver = yearHyphenAlbumPathResolver;
    }

    @Override
    public Path resolvePath(ID3v2 tag) {
        return getArtistBigLetterPathResolver().resolvePath(tag)
                .resolve(getArtistNamePathResolver().resolvePath(tag))
                .resolve(getYearHyphenAlbumPathResolver().resolvePath(tag));
    }

    public PathResolver<ID3v2> getArtistBigLetterPathResolver() {
        return artistBigLetterPathResolver;
    }

    public void setArtistBigLetterPathResolver(PathResolver<ID3v2> artistBigLetterPathResolver) {
        this.artistBigLetterPathResolver = artistBigLetterPathResolver;
    }

    public PathResolver<ID3v2> getArtistNamePathResolver() {
        return artistNamePathResolver;
    }

    public void setArtistNamePathResolver(PathResolver<ID3v2> artistNamePathResolver) {
        this.artistNamePathResolver = artistNamePathResolver;
    }

    public PathResolver<ID3v2> getYearHyphenAlbumPathResolver() {
        return yearHyphenAlbumPathResolver;
    }

    public void setYearHyphenAlbumPathResolver(PathResolver<ID3v2> yearHyphenAlbumPathResolver) {
        this.yearHyphenAlbumPathResolver = yearHyphenAlbumPathResolver;
    }

}
