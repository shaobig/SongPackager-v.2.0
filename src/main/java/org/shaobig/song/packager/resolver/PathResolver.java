package org.shaobig.song.packager.resolver;

import java.nio.file.Path;

public interface PathResolver<T> {

    Path resolvePath(T data);

}
