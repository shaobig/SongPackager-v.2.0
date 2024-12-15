package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.reader.PathReader;
import org.shaobig.song.packager.writer.PathWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class ReadDirectoryPathWriter implements PathWriter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadDirectoryPathWriter.class);

    private PathReader pathReader;
    private PathWriter pathWriter;

    public ReadDirectoryPathWriter(PathReader pathReader, PathWriter pathWriter) {
        this.pathReader = pathReader;
        this.pathWriter = pathWriter;
    }

    @Override
    public Path writePath(Path path) {
        LOGGER.info("Read a directory: '{}'", path);
        getPathReader().readPath(path).forEach(filePath -> {
            LOGGER.info("Read a file: '{}'", filePath);
            getPathWriter().writePath(filePath);
        });
        return path;
    }

    public PathReader getPathReader() {
        return pathReader;
    }

    public void setPathReader(PathReader pathReader) {
        this.pathReader = pathReader;
    }

    public PathWriter getPathWriter() {
        return pathWriter;
    }

    public void setPathWriter(PathWriter pathWriter) {
        this.pathWriter = pathWriter;
    }

}
