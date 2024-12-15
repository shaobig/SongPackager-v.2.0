package org.shaobig.song.packager.resolver.path;

import org.shaobig.song.packager.resolver.PathResolver;

import java.nio.file.Path;

public class OutputPathResolver implements PathResolver<Path> {

    private Path outputPath;
    private PathResolver<Path> songPathResolver;

    public OutputPathResolver(Path outputPath, PathResolver<Path> songPathResolver) {
        this.outputPath = outputPath;
        this.songPathResolver = songPathResolver;
    }

    @Override
    public Path resolvePath(Path path) {
        return getOutputPath().resolve(getSongPathResolver().resolvePath(path));
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

    public PathResolver<Path> getSongPathResolver() {
        return songPathResolver;
    }

    public void setSongPathResolver(PathResolver<Path> songPathResolver) {
        this.songPathResolver = songPathResolver;
    }

}
