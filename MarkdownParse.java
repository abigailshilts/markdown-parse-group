// File reading code from https://howtodoinjava.com/java/io/java-read-file-to-string-examples/
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int nextOpenBracket = markdown.indexOf("[", currentIndex);
            int nextCloseBracket = markdown.indexOf("]", nextOpenBracket);
            int openParen = markdown.indexOf("(", nextCloseBracket);
            int closeParen = markdown.indexOf(")", openParen);

            /*boolean noMore = false;
            int currOpenParen = openParen;
            while(!noMore){
                System.out.println("in currOpenWhile");
                if(markdown.substring(currOpenParen +1, closeParen).contains("(")){
                    closeParen = markdown.indexOf(")", closeParen +1);
                    currOpenParen = markdown.indexOf("(", currOpenParen +1);
                }
                else{
                    noMore = true;
                }
            }*/
            if (openParen != -1 && closeParen > openParen && closeParen != -1 && 
                markdown.substring(openParen -1, openParen).equals("]")) {
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            } else {
                currentIndex = nextCloseBracket + 1;
            }
            if (markdown.indexOf("[", currentIndex) == -1 || markdown.length() < 4) {
                currentIndex = markdown.length() + 1;
            }
        }
        return toReturn;
    }
    public static void main(String[] args) throws IOException {
		Path fileName = Path.of(args[0]);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = getLinks(contents);
        System.out.println(links);
    }
}