package org.shaobig.song.packager.reader;

import java.nio.file.Path;
import java.util.List;

public interface PathReader {

    List<Path> readPath(Path path);

}
