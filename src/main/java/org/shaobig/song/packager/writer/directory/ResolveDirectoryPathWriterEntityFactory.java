package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.resolver.PathResolver;
import org.shaobig.song.packager.writer.PathWriter;

import java.nio.file.Path;

public class ResolveDirectoryPathWriterEntityFactory implements EntityFactory<PathWriter> {

    private EntityFactory<PathWriter> pathWriterEntityFactory;
    private EntityFactory<PathResolver<Path>> pathResolverEntityFactory;

    public ResolveDirectoryPathWriterEntityFactory(EntityFactory<PathWriter> pathWriterEntityFactory, EntityFactory<PathResolver<Path>> pathResolverEntityFactory) {
        this.pathWriterEntityFactory = pathWriterEntityFactory;
        this.pathResolverEntityFactory = pathResolverEntityFactory;
    }

    @Override
    public PathWriter createEntity() {
        return new ResolveDirectoryPathWriter(getPathWriterEntityFactory().createEntity(), getPathResolverEntityFactory().createEntity());
    }

    public EntityFactory<PathWriter> getPathWriterEntityFactory() {
        return pathWriterEntityFactory;
    }

    public void setPathWriterEntityFactory(EntityFactory<PathWriter> pathWriterEntityFactory) {
        this.pathWriterEntityFactory = pathWriterEntityFactory;
    }

    public EntityFactory<PathResolver<Path>> getPathResolverEntityFactory() {
        return pathResolverEntityFactory;
    }

    public void setPathResolverEntityFactory(EntityFactory<PathResolver<Path>> pathResolverEntityFactory) {
        this.pathResolverEntityFactory = pathResolverEntityFactory;
    }

}
