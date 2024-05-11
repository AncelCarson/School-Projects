import java.io.*;
import java.util.*;

public class LetterFreq {
    /**
     * Main driver class
     * @param args  Unused
     * @throws java.io.FileNotFoundException  if file not in correct directory
     */
    public static void main(String[] args) throws FileNotFoundException {
      //Create Scanner for input file
        Scanner fin = null;
        try {
            fin = new Scanner(new File("C:/Users/Ancel Carson/Documents/Letu/Semester 5 FA 18/Data Structures/Text_Files/Proverbs3.txt"));
        } catch(FileNotFoundException e) {
            throw new FileNotFoundException("File not found, please retry.");
        }

        ArrayList<String> fullText = new ArrayList();
        while(fin.hasNext())
            fullText.add(fin.nextLine());

        LetterCount[] list = new LetterCount[27];
        list[26] = new LetterCount(' ');
        for(int i = 0; i < list.length-1; i++)
            list[i] = new LetterCount((char)(i + 'a'));

        for(String line : fullText)
            for(char letter : line.toLowerCase().toCharArray())
                for (LetterCount l : list)
                    if (letter == l.c) l.num++;

        Arrays.sort(list);

        //Create PrintWriter for output file
        PrintWriter fout = new PrintWriter(new File("Output.txt"));
        for(int i = list.length-1; i >= 0 ; i--)
            fout.println(list[i].getChar() + " " + list[i].num);

        fout.close();
    }
}



class LetterCount implements Comparable<LetterCount>{
    char c;
    int num;

    /**
     * Creates a LetterCount object
     * @param c The character this object is keeping track of
     */
    public LetterCount(char c) {
        this.c = c;
        this.num = 0;
    }

    @Override
    public int compareTo(LetterCount t) {
        return Integer.compare(this.num, t.num);
    }

    public String getChar() {
        return c == ' ' ? "Space" : String.valueOf(c);
    }
}