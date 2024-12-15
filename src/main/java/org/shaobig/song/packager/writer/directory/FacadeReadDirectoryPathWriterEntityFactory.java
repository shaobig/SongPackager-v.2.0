package org.shaobig.song.packager.writer.directory;

import org.shaobig.song.packager.EntityFactory;
import org.shaobig.song.packager.reader.extension.Extension;
import org.shaobig.song.packager.reader.extension.ExtensionPathReaderEntityFactory;
import org.shaobig.song.packager.reader.extension.ExtensionSupplier;
import org.shaobig.song.packager.resolver.path.SongPathResolverEntityFactory;
import org.shaobig.song.packager.writer.PathWriter;
import org.shaobig.song.packager.writer.file.SetSourcePathWriterEntityFactory;

import java.nio.file.Path;

public class FacadeReadDirectoryPathWriterEntityFactory implements EntityFactory<PathWriter> {

    private Path outputPath;

    public FacadeReadDirectoryPathWriterEntityFactory(Path outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public PathWriter createEntity() {
        return new ReadDirectoryPathWriterEntityFactory(new ExtensionPathReaderEntityFactory(new ExtensionSupplier(Extension.MP3)), new DirectoryPathWriterEntityFactory(new ResolveDirectoryPathWriterEntityFactory(new NewDirectoryPathWriterEntityFactory(), new SongPathResolverEntityFactory(getOutputPath())), new SetSourcePathWriterEntityFactory(getOutputPath()))).createEntity();
    }

    public Path getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(Path outputPath) {
        this.outputPath = outputPath;
    }

}
