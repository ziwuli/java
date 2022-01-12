package com.ziwu.thread.threadpool.reference.phantom;

import org.apache.commons.io.FileCleaningTracker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * use PhantomReference
 */
public class FileCleaningTrackerTest extends AbstractTempDirTest {
    private File testFile;

    private FileCleaningTracker theInstance;

    RandomAccessFile createRandomAccessFile() throws FileNotFoundException {
        return new RandomAccessFile(testFile, "rwd");
    }

    protected FileCleaningTracker newInstance() {
        return new FileCleaningTracker();
    }

    private void pauseForDeleteToComplete(File file) throws InterruptedException {
        int count = 0;
        while (file.exists() && count++ < 40) {
            Thread.sleep(500L);
            file = new File(file.getPath());
        }
    }

    @BeforeEach
    public void setUp() {
        testFile = new File(tempDirFile, "file-test.txt");
        theInstance = newInstance();
    }

    private String showFailures() {
        if (theInstance.getDeleteFailures().size() == 1) {
            return "[Delete Failed: " + theInstance.getDeleteFailures().get(0) + "]";
        }
        return "[Delete Failures: " + theInstance.getDeleteFailures().size() + "]";
    }

    @Test
    public void testFileCleanerFile() throws Exception {
        final String path = testFile.getPath();

        assertFalse(testFile.exists());
        RandomAccessFile r = createRandomAccessFile();
        assertTrue(testFile.exists());

        assertEquals(0, theInstance.getTrackCount());
        theInstance.track(path, r);
        assertEquals(1, theInstance.getTrackCount());

        r.close();
        testFile = null;
        r = null;

        waitUntilTrackCount();
        pauseForDeleteToComplete(new File(path));

        assertEquals(0, theInstance.getTrackCount());
        assertFalse(new File(path).exists(), showFailures());
    }

    private void waitUntilTrackCount() throws Exception {
        System.gc();
        Thread.sleep(500L);
        int count = 0;
        while (theInstance.getTrackCount() != 0 && count++ < 5) {
            List<String> list = new ArrayList<>();
            try {
                long i = 0;
                while (theInstance.getTrackCount() != 0) {
                    list.add(
                            "A Big String A Big String A Big String A Big String A Big String A Big String A Big String A Big String A Big String A Big String "
                                    + (i++));
                }
            } catch (final Throwable ignored) {
            }
            list = null;
            System.gc();
            Thread.sleep(500L);
        }
        if (theInstance.getTrackCount() != 0) {
            throw new IllegalStateException("Your JVM is not releasing References, try running the testcase with less memory (-Xmx)");
        }

    }

}
