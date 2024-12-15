package org.shaobig.song.packager.writer.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFilePathWriter extends FilePathWriter {

    public NewFilePathWriter(Path sourcePath) {
        super(sourcePath);
    }

    @Override
    public Path writePath(Path path) {
        try {
            return Files.write(getSourcePath(), Files.readAllBytes(path));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
