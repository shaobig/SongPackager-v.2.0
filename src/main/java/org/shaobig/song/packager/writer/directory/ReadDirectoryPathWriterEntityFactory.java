package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.reader.PathReader;
import org.shaobig.song.packager.writer.PathWriter;

public class ReadDirectoryPathWriterEntityFactory implements EntityFactory<PathWriter> {

    private EntityFactory<PathReader> pathReaderEntityFactory;
    private EntityFactory<PathWriter> pathWriterEntityFactory;

    public ReadDirectoryPathWriterEntityFactory(EntityFactory<PathReader> pathReaderEntityFactory, EntityFactory<PathWriter> pathWriterEntityFactory) {
        this.pathReaderEntityFactory = pathReaderEntityFactory;
        this.pathWriterEntityFactory = pathWriterEntityFactory;
    }

    @Override
    public PathWriter createEntity() {
        return new ReadDirectoryPathWriter(getPathReaderEntityFactory().createEntity(), getPathWriterEntityFactory().createEntity());
    }

    public EntityFactory<PathReader> getPathReaderEntityFactory() {
        return pathReaderEntityFactory;
    }

    public void setPathReaderEntityFactory(EntityFactory<PathReader> pathReaderEntityFactory) {
        this.pathReaderEntityFactory = pathReaderEntityFactory;
    }

    public EntityFactory<PathWriter> getPathWriterEntityFactory() {
        return pathWriterEntityFactory;
    }

    public void setPathWriterEntityFactory(EntityFactory<PathWriter> pathWriterEntityFactory) {
        this.pathWriterEntityFactory = pathWriterEntityFactory;
    }

}
