package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.resolver.PathResolver;
import org.shaobig.song.packager.writer.PathWriter;

import java.nio.file.Path;

public class ResolveDirectoryPathWriter implements PathWriter {

    private PathWriter directoryPathWriter;
    private PathResolver<Path> songPathResolver;

    public ResolveDirectoryPathWriter(PathWriter directoryPathWriter, PathResolver<Path> songPathResolver) {
        this.directoryPathWriter = directoryPathWriter;
        this.songPathResolver = songPathResolver;
    }

    @Override
    public Path writePath(Path path) {
        return getDirectoryPathWriter().writePath(getSongPathResolver().resolvePath(path).getParent());
    }

    public PathWriter getDirectoryPathWriter() {
        return directoryPathWriter;
    }

    public void setDirectoryPathWriter(PathWriter directoryPathWriter) {
        this.directoryPathWriter = directoryPathWriter;
    }

    public PathResolver<Path> getSongPathResolver() {
        return songPathResolver;
    }

    public void setSongPathResolver(PathResolver<Path> songPathResolver) {
        this.songPathResolver = songPathResolver;
    }

}
