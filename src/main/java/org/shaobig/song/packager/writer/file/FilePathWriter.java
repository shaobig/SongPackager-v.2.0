package org.shaobig.song.packager.writer.file;

import org.shaobig.song.packager.writer.PathWriter;

import java.nio.file.Path;

public abstract class FilePathWriter implements PathWriter {

    private Path sourcePath;

    public FilePathWriter(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

    public Path getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(Path sourcePath) {
        this.sourcePath = sourcePath;
    }

}
