package org.shaobig.song.packager.writer.file;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.resolver.path.SongPathResolverEntityFactory;
import org.shaobig.song.packager.writer.PathWriter;

import java.nio.file.Path;

public class SetSourcePathWriterEntityFactory implements EntityFactory<PathWriter> {

    private Path outputPath;

    public SetSourcePathWriterEntityFactory(Path outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public PathWriter createEntity() {
        return new SetSourcePathWriter(new SongPathResolverEntityFactory(getOutputPath()).createEntity(), new NewFilePathWriter(getOutputPath()));
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

}
