import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Aden Koziol
 */

public class Testing
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("Please enter filename to decode:");
        Scanner scan = new Scanner(System.in);
        String file = scan.nextLine();
        scan.close();
        String str = new String(Files.readAllBytes(Paths.get(file))).trim();
        int i = str.lastIndexOf('\n');
        String str1 = str.substring(0, i);
        String bin = str.substring(i).trim();
        Set<Character> chars = new HashSet<>();
        char[] array = str1.toCharArray();
        for(int j = 0; j < array.length; j++)
        {
            if (array[j] != '^')
                chars.add(array[j]);
        }
        String chars1 = chars.stream().map(String::valueOf).collect(Collectors.joining());
        MsgTree root = new MsgTree(str1);
        MsgTree.printCodes(root, chars1);
        root.decode(root, bin);
    }
}
