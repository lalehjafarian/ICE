import java.io.*;
import java.util.Scanner;
public class MergeFiles {


        public static void main(String[] args) throws IOException
        {
            String curString1, curString2, writeString1, writeString2;

            Scanner fileReader1 = new Scanner(new File("/Users/mpourhoma/IdeaProjects/untitled1/src/file1.txt"));
            Scanner fileReader2 = new Scanner(new File("/Users/mpourhoma/IdeaProjects/untitled1/src/file2.txt"));

            FileWriter fw = new FileWriter("/Users/mpourhoma/IdeaProjects/untitled1/src/file3.txt");

            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            while (fileReader1.hasNext() && fileReader2.hasNext())
            {
                curString1 = fileReader1.next();
                curString2 = fileReader2.next();

                if (curString1.compareTo(curString2) < 0)
                {
                    out.println(curString1);
                    out.println(curString2);
                }
                else if (curString1.compareTo(curString2) > 0)
                {
                    out.println(curString2);
                    out.println(curString1);
                }
            }

            if (fileReader1.hasNext())
            {
                while (fileReader1.hasNext())
                {
                    out.println(fileReader1.next());
                }
            }
            else if (fileReader2.hasNext())
            {
                while (fileReader2.hasNext())
                {
                    out.println(fileReader2.next());
                }
            }
            out.close();
        }
    }


