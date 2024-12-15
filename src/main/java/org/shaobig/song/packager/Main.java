package org.shaobig.song.packager;

import org.shaobig.song.packager.writer.PathWriter;
import org.shaobig.song.packager.writer.directory.FacadeReadDirectoryPathWriterEntityFactory;

import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        Path inputPath = Path.of("D:\\Downloads\\.UPUT");
        Path outputPath = Path.of("D:\\Downloads\\.UTPUT");
        PathWriter pathWriter = new FacadeReadDirectoryPathWriterEntityFactory(outputPath).createEntity();
        pathWriter.writePath(inputPath);
    }

}
