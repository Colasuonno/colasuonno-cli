package it.colasuonno.cli.lib;

import it.colasuonno.cli.logger.CLILogger;
import it.colasuonno.cli.manager.CLIManager;
import it.colasuonno.cli.objects.CLIInput;
import it.colasuonno.cli.objects.CLIObject;
import it.colasuonno.cli.objects.sub.CLIExpectedSubComponent;
import it.colasuonno.cli.utils.CLIUtils;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;

public class FreeSpace extends CLIObject {

    public FreeSpace() {
        super(CLIManager.buildInput("freespace")
                );
    }

    @Override
    public void output(String value, CLIExpectedSubComponent expected) {
        for (Path root : FileSystems.getDefault().getRootDirectories()) {

            System.out.print(root + ": ");
            try {
                FileStore store = Files.getFileStore(root);
                CLILogger.i("free=" + CLIUtils.format(store.getUsableSpace(), 2)
                        + ", total=" + CLIUtils.format(store.getTotalSpace(), 2));
            } catch (IOException e) {
                CLILogger.i("error querying space: " + e.toString());
            }
        }
    }
}
