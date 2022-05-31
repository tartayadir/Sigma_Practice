package taskForWaitNotify;

public class toUpperCaseFirstOrLastLettersForDuoTreads extends toUpperCaseFirstOrLastLetters implements Runnable{

    private final FileReaderWriter fileReaderWriter;

    public toUpperCaseFirstOrLastLettersForDuoTreads(FileReaderWriter fileReaderWriter) {
        this.fileReaderWriter = fileReaderWriter;
        new Thread(this).start();
    }

    @Override
    public void run() {
        this.fileReaderWriter.toUpperCaseFirstOrLastLetters();
    }
}
