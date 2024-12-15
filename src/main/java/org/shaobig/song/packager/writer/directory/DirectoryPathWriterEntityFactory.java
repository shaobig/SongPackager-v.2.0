package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.writer.PathWriter;

public class DirectoryPathWriterEntityFactory implements EntityFactory<PathWriter> {

    private EntityFactory<PathWriter> directoryPathWriterEntityFactory;
    private EntityFactory<PathWriter> filePathWriterEntityFactory;

    public DirectoryPathWriterEntityFactory(EntityFactory<PathWriter> directoryPathWriterEntityFactory, EntityFactory<PathWriter> filePathWriterEntityFactory) {
        this.directoryPathWriterEntityFactory = directoryPathWriterEntityFactory;
        this.filePathWriterEntityFactory = filePathWriterEntityFactory;
    }

    @Override
    public PathWriter createEntity() {
        return new DirectoryPathWriter(getDirectoryPathWriterEntityFactory().createEntity(), getFilePathWriterEntityFactory().createEntity());
    }

    public EntityFactory<PathWriter> getDirectoryPathWriterEntityFactory() {
        return directoryPathWriterEntityFactory;
    }

    public void setDirectoryPathWriterEntityFactory(EntityFactory<PathWriter> directoryPathWriterEntityFactory) {
        this.directoryPathWriterEntityFactory = directoryPathWriterEntityFactory;
    }

    public EntityFactory<PathWriter> getFilePathWriterEntityFactory() {
        return filePathWriterEntityFactory;
    }

    public void setFilePathWriterEntityFactory(EntityFactory<PathWriter> filePathWriterEntityFactory) {
        this.filePathWriterEntityFactory = filePathWriterEntityFactory;
    }

}
