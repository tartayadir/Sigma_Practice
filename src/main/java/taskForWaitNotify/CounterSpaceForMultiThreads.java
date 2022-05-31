package taskForWaitNotify;

import java.io.IOException;
import java.util.Scanner;

public class CounterSpaceForMultiThreads extends CounterSpace implements Runnable{

    private FileReaderWriter fileReaderWriter;

    public CounterSpaceForMultiThreads(FileReaderWriter fileReaderWriter) {
        this.fileReaderWriter = fileReaderWriter;
        new Thread(this).start();
    }

    @Override
    public void run() {

        String line;

        synchronized (this.fileReaderWriter){

            Scanner scannerFile = new Scanner(this.fileReaderWriter.getFileReader());

            while (scannerFile.hasNext()){

                line = scannerFile.nextLine();
                this.fileReaderWriter.addToCounterSpace(line.length() -
                        line.replaceAll(" ","").length());
            }

            try {
                this.fileReaderWriter.getFileReader().close();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
    }
}
