package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.writer.PathWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewDirectoryPathWriter implements PathWriter {

    @Override
    public Path writePath(Path path) {
        try {
            return Files.createDirectories(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
