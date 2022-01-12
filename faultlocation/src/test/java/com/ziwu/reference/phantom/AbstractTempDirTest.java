package com.ziwu.thread.threadpool.reference.phantom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AbstractTempDirTest {
    /**
     * A temporary directory managed by JUnit.
     */
    @TempDir
    public Path managedTempDirPath;

    /**
     * A temporary directory managed by each test so we can optionally fiddle with its permissions independently.
     */
    public Path tempDirPath;

    /**
     * A File version of this test's Path object.
     */
    public File tempDirFile;

    @BeforeEach
    public void beforeEachCreateTempDirs() throws IOException {
        tempDirPath = Files.createTempDirectory(managedTempDirPath, getClass().getSimpleName());
        System.out.println("tempDirPath:" + tempDirPath);
        tempDirFile = tempDirPath.toFile();
    }
}
