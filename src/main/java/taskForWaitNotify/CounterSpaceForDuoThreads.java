package taskForWaitNotify;

public class CounterSpaceForDuoThreads extends CounterSpace implements Runnable{

    private FileReaderWriter fileReaderWriter;

    public CounterSpaceForDuoThreads(FileReaderWriter fileReaderWriter) {
        this.fileReaderWriter = fileReaderWriter;
        new Thread(this).start();
    }

    @Override
    public void run() {
        this.fileReaderWriter.countSpace();
    }
}
