package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.writer.PathWriter;

public class NewDirectoryPathWriterEntityFactory implements EntityFactory<PathWriter> {

    @Override
    public PathWriter createEntity() {
        return new NewDirectoryPathWriter();
    }

}
