package taskForFiles;

import javax.imageio.IIOException;
import java.io.*;

public class OutputFile {

    private BufferedWriter outputFile;
    private String fName;

    OutputFile(String fName) throws Exception{

        this.fName = fName;
        try {
            outputFile = new BufferedWriter(new FileWriter(fName));
        }catch (FileNotFoundException e){

            //e.printStackTrace();
            throw new Exception("Error opening file(" + fName + ")" , e);
        }catch (Exception e){
            try {
                outputFile.flush();
                outputFile.close();
            }catch (IIOException ex){
                throw new Exception("Error closing file(" + fName + ")",ex);
            }
        }
    }

    public void write(String s) throws Exception{

        try {
            outputFile.write(s);
            outputFile.newLine();
        }catch (IOException e){
            throw new Exception("Error writing line in file(" + fName + ")",e);
        }
    }

    public void write(int c) throws Exception{

        try {
            outputFile.write((char)c);
        }catch (IOException e){
            throw new Exception("Error writing line in file(" + fName + ")",e);
        }
    }

    public void close() throws Exception{
        try {
            outputFile.flush();
            outputFile.close();
        }catch (IIOException ex){
            throw new Exception("Error closing file(" + fName + ")",ex);
        }
    }
}
