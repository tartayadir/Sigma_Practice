package taskForParsing;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Controller {

    public final static String NAME_OUTPUT_FILE = "C://Users//Ярослав//IdeaProjects//Sigma_Practice" +
            "//src//main//java//taskForParsing//resultFile";

    public static void deleteConsonantLetter(InputFile inputFile)throws Exception{

        OutputFile outputFile = new OutputFile(NAME_OUTPUT_FILE);
        Scanner input = new Scanner(inputFile.getInputFile());
        int lengthOfWord = 5;

        System.out.print("Введите длину слов которые нужно удолить : ");
        Scanner in = new Scanner(System.in);
        lengthOfWord = in.nextInt();

        String patternString = "[^aioeu0-9][a-z]{" + (lengthOfWord-1) + "}";
        Pattern pattern = Pattern.compile(patternString);

        while(input.hasNextLine()){

            String temp = input.nextLine();
            Scanner scanner = new Scanner(temp);

            while(scanner.hasNext()){

                if (scanner.hasNext(pattern)){
                    //System.out.println(scanner.next(pattern));
                    scanner.next(pattern);
                }else{

                    outputFile.write(scanner.next() + " ");
                }
            }

            outputFile.write("\n");
        }


        inputFile.close();
        input.close();
        outputFile.close();
    }

    public static void deleteConsonantLetter(InputFile inputFile , String nameOutputFile)throws Exception{

        OutputFile outputFile = new OutputFile(nameOutputFile);
        Scanner input = new Scanner(inputFile.getInputFile());
        int lengthOfWord = 5;

        //System.out.print("Введите длину слов которые нужно удолить : ");
        //Scanner in = new Scanner(System.in);
        //lengthOfWord = in.nextInt();

        String patternString = "[^aioeu0-9][a-z]{" + (lengthOfWord-1) + "}";
        Pattern pattern = Pattern.compile(patternString);

        while(input.hasNextLine()){

            String temp = input.nextLine();
            Scanner scanner = new Scanner(temp);

            while(scanner.hasNext()){

                if (scanner.hasNext(pattern)){
                    //System.out.println(scanner.next(pattern));
                    scanner.next(pattern);
                }else{

                    outputFile.write(scanner.next() + " ");
                }
            }

            outputFile.write("\n");
        }


        inputFile.close();
        input.close();
        outputFile.close();
    }
}
