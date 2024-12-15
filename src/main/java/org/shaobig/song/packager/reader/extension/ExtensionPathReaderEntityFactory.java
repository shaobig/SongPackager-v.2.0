package org.shaobig.song.packager.reader.extension;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.reader.AllPathReader;
import org.shaobig.song.packager.reader.PathReader;

import java.util.function.Supplier;

public class ExtensionPathReaderEntityFactory implements EntityFactory<PathReader> {

    private Supplier<String> extensionSupplier;

    public ExtensionPathReaderEntityFactory(Supplier<String> extensionSupplier) {
        this.extensionSupplier = extensionSupplier;
    }

    @Override
    public PathReader createEntity() {
        return new ExtensionPathReader(new AllPathReader(), getExtensionSupplier());
    }

    public Supplier<String> getExtensionSupplier() {
        return extensionSupplier;
    }

    public void setExtensionSupplier(Supplier<String> extensionSupplier) {
        this.extensionSupplier = extensionSupplier;
    }

}
