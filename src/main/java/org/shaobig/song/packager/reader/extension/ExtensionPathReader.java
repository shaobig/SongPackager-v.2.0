package org.shaobig.song.packager.reader.extension;

import org.shaobig.song.packager.reader.PathReader;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

public class ExtensionPathReader implements PathReader {

    private PathReader pathReader;
    private Supplier<String> extensionSupplier;

    public ExtensionPathReader(PathReader pathReader, Supplier<String> extensionSupplier) {
        this.pathReader = pathReader;
        this.extensionSupplier = extensionSupplier;
    }

    @Override
    public List<Path> readPath(Path path) {
        return getPathReader().readPath(path).stream()
                .filter(filePath -> filePath.toString().endsWith(getExtensionSupplier().get()))
                .toList();
    }

    public PathReader getPathReader() {
        return pathReader;
    }

    public void setPathReader(PathReader pathReader) {
        this.pathReader = pathReader;
    }

    public Supplier<String> getExtensionSupplier() {
        return extensionSupplier;
    }

    public void setExtensionSupplier(Supplier<String> extensionSupplier) {
        this.extensionSupplier = extensionSupplier;
    }

}
