package com.xenoamess.metasploit.java_external_module.loader;

import java.io.File;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MsfPluginLoaderTest {

    @Test
    public void test() throws Exception {
        File testTempFile = new File("_temp_test_file_for_MsfPluginLoaderTest.log");
        if (testTempFile.exists()) {
            testTempFile.delete();
        }
        URL testClassFileUrl = this.getClass().getClassLoader().getResource("TestResourceClassA.java");
        MsfPluginLoader.main(new String[]{testClassFileUrl.getPath()});
        String testTempFileContent = FileUtils.readFileToString(testTempFile, StandardCharsets.UTF_8);
        assertEquals(
                "0123456789",
                testTempFileContent
        );
    }
}
