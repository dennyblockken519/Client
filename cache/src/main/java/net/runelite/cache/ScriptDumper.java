package net.runelite.cache;

import com.google.common.io.Files;
import net.runelite.cache.definitions.ScriptDefinition;
import net.runelite.cache.definitions.loaders.ScriptLoader;
import net.runelite.cache.fs.Archive;
import net.runelite.cache.fs.Index;
import net.runelite.cache.fs.Storage;
import net.runelite.cache.fs.Store;
import net.runelite.cache.script.disassembler.Disassembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class ScriptDumper {

    private static final Logger logger = LoggerFactory.getLogger(ScriptDumper.class);

    private final Store store;

    public ScriptDumper(Store store) {
        this.store = store;
    }

    public void dump(File rootDir, int id) throws IOException {
        Storage storage = store.getStorage();
        Index index = store.getIndex(IndexType.CLIENTSCRIPT);
        Archive archive = index.getArchive(id);
        byte[] data = archive.decompress(storage.loadArchive(archive));
        if (data == null) {
            throw new RuntimeException("Script contents is missing or not valid.");
        }

        ScriptLoader loader = new ScriptLoader();
        ScriptDefinition script = loader.load(archive.getArchiveId(), data);
        Disassembler disassembler = new Disassembler();
        String output = disassembler.disassemble(script);
        File dumpFile = new File(rootDir, script.getId() +".rs2asm");
        Files.write(output.getBytes(), dumpFile);

        logger.info("Dumped script {} to directory {}", id, dumpFile);
    }
}
