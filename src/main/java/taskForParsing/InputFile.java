package taskForParsing;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class InputFile {

    private BufferedReader inputFile;
    private String fName;

    InputFile(String fName) throws Exception{

        this.fName = fName;
        try {
            inputFile = new BufferedReader(new FileReader(fName));
        }catch (FileNotFoundException e){

            //e.printStackTrace();
            throw new Exception("Error opening file(" + fName + ")" , e);
        }catch (Exception e){
            try {
                inputFile.close();
            }catch (IIOException ex){
                throw new Exception("Error closing file(" + fName + ")",ex);
            }
        }
    }

    public String readLine() throws Exception {

        String line;
        try {
            line = inputFile.readLine();

        }catch (IIOException e){
            throw new Exception("Error reading a line from a file(" + fName + ")",e);
        }
        return line;
    }

    public void close() throws Exception{
        try {
            inputFile.close();
        }catch (IIOException ex){
            throw new Exception("Error closing file(" + fName + ")",ex);
        }
    }

    public BufferedReader getInputFile() {
        return inputFile;
    }

    public String getFName() {
        return fName;
    }
}

