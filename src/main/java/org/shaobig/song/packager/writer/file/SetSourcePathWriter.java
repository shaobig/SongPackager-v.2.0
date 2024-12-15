package org.shaobig.song.packager.writer.file;

import org.shaobig.song.packager.resolver.PathResolver;
import org.shaobig.song.packager.writer.PathWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class SetSourcePathWriter implements PathWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SetSourcePathWriter.class);

    private PathResolver<Path> pathResolver;
    private FilePathWriter filePathWriter;

    public SetSourcePathWriter(PathResolver<Path> pathResolver, FilePathWriter filePathWriter) {
        this.pathResolver = pathResolver;
        this.filePathWriter = filePathWriter;
    }

    @Override
    public Path writePath(Path path) {
        Path outputPath = getPathResolver().resolvePath(path);
        LOGGER.info("Save to: '{}'", outputPath);
        getFilePathWriter().setSourcePath(outputPath);
        return getFilePathWriter().writePath(path);
    }

    public PathResolver<Path> getPathResolver() {
        return pathResolver;
    }

    public void setPathResolver(PathResolver<Path> pathResolver) {
        this.pathResolver = pathResolver;
    }

    public FilePathWriter getFilePathWriter() {
        return filePathWriter;
    }

    public void setFilePathWriter(FilePathWriter filePathWriter) {
        this.filePathWriter = filePathWriter;
    }

}
