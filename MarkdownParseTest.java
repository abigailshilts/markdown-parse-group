import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testFile1() throws IOException {
        String contents= Files.readString(Path.of("./test-file.md"));
        List<String> expect = List.of("https://something.com", "some-page.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile5() throws IOException {
        String contents= Files.readString(Path.of("./test-file5.md"));
        List<String> expect = List.of();
        assertEquals(expect, MarkdownParse.getLinks(contents)); 
    }

    @Test
    public void subtraction(){
        assertEquals(7, 9-2);
    }

    /*@Test
    public void testCodeSnippet1() throws IOException{
        String contents = Files.readString(Path.of("/Users/abigailshilts/Documents/GitHub/markdown-parse-group/test-file-labReport1.md"));
        List<String> expect = List.of("google.com", "google.com", "ucsd.edu");
        assertEquals(expect, MarkdownParse.getLinks(contents)); 
    }*/
    
   /* @Test
    public void testCodeSnippet2() throws IOException{
        String contents = Files.readString(Path.of("/Users/abigailshilts/Documents/GitHub/markdown-parse-group/test-file-labReport2.md"));
        List<String> expect = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expect, MarkdownParse.getLinks(contents)); 
    } */

    @Test
    public void testCodeSnippet3() throws IOException{
        String contents = Files.readString(Path.of("/Users/abigailshilts/Documents/GitHub/markdown-parse-group/test-file-labReport3.md"));
        List<String> expect = List.of("twitter.com", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/");
        assertEquals(expect, MarkdownParse.getLinks(contents)); 
    }
}
