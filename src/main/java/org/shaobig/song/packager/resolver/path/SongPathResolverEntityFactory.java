package org.shaobig.song.packager.resolver.path;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.resolver.PathResolver;
import org.shaobig.song.packager.resolver.string.StringPathResolver;
import org.shaobig.song.packager.resolver.tag.ArtistBigLetterTagPathResolver;
import org.shaobig.song.packager.resolver.tag.ArtistNameTagPathResolver;
import org.shaobig.song.packager.resolver.tag.TagPathResolver;
import org.shaobig.song.packager.resolver.tag.YearHyphenAlbumTagPathResolver;

import java.nio.file.Path;

public class SongPathResolverEntityFactory implements EntityFactory<PathResolver<Path>> {

    private Path outputPath;

    public SongPathResolverEntityFactory(Path outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public PathResolver<Path> createEntity() {
        PathResolver<String> stringPathResolver = new StringPathResolver();
        return new SongPathResolver(new OutputPathResolver(getOutputPath(), new Mp3PathResolver(new Mp3FilePathResolver(new TagPathResolver(new ArtistBigLetterTagPathResolver(stringPathResolver), new ArtistNameTagPathResolver(stringPathResolver), new YearHyphenAlbumTagPathResolver(stringPathResolver))))));
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

}
