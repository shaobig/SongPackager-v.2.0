package org.shaobig.song.packager.reader.extension;

import java.util.function.Supplier;

public class ExtensionSupplier implements Supplier<String> {

    private static final String DOT_SYMBOL = ".";

    private Extension extension;

    public ExtensionSupplier(Extension extension) {
        this.extension = extension;
    }

    @Override
    public String get() {
        return DOT_SYMBOL.concat(getExtension().name().toLowerCase());
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

}
