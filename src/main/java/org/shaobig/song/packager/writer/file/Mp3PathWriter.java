package org.shaobig.song.packager.writer.file;

import org.shaobig.song.packager.resolver.PathResolver;
import org.shaobig.song.packager.writer.PathWriter;

import java.nio.file.Path;

public class Mp3PathWriter implements PathWriter {

    private FilePathWriter filePathWriter;
    private PathResolver<Path> pathResolver;

    public Mp3PathWriter(FilePathWriter filePathWriter, PathResolver<Path> pathResolver) {
        this.filePathWriter = filePathWriter;
        this.pathResolver = pathResolver;
    }

    @Override
    public Path writePath(Path path) {
        getFilePathWriter().setSourcePath(getPathResolver().resolvePath(path));
        return getFilePathWriter().writePath(path);
    }

    public FilePathWriter getFilePathWriter() {
        return filePathWriter;
    }

    public void setFilePathWriter(FilePathWriter filePathWriter) {
        this.filePathWriter = filePathWriter;
    }

    public PathResolver<Path> getPathResolver() {
        return pathResolver;
    }

    public void setPathResolver(PathResolver<Path> pathResolver) {
        this.pathResolver = pathResolver;
    }

}
