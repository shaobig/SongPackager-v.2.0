package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.writer.PathWriter;

import java.nio.file.Path;

public class DirectoryPathWriter implements PathWriter {

    private PathWriter directoryPathWriter;
    private PathWriter filePathWriter;

    public DirectoryPathWriter(PathWriter directoryPathWriter, PathWriter filePathWriter) {
        this.directoryPathWriter = directoryPathWriter;
        this.filePathWriter = filePathWriter;
    }

    @Override
    public Path writePath(Path path) {;
        getDirectoryPathWriter().writePath(path);
        return getFilePathWriter().writePath(path);
    }

    public PathWriter getDirectoryPathWriter() {
        return directoryPathWriter;
    }

    public void setDirectoryPathWriter(PathWriter directoryPathWriter) {
        this.directoryPathWriter = directoryPathWriter;
    }

    public PathWriter getFilePathWriter() {
        return filePathWriter;
    }

    public void setFilePathWriter(PathWriter filePathWriter) {
        this.filePathWriter = filePathWriter;
    }

}
