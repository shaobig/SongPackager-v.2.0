package org.shaobig.song.packager.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class AllPathReader implements PathReader {

    @Override
    public List<Path> readPath(Path path) {
        try (Stream<Path> pathStream = Files.list(path)) {
            return pathStream.toList();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
