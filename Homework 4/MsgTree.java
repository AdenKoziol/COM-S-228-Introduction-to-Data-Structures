import java.util.Stack;

/**
 * @author Aden Koziol
 */
public class MsgTree
{
        public char payloadChar;
        public MsgTree left;
        public MsgTree right;
        /*Can use a static char idx to the tree string for recursive
        solution, but it is not strictly necessary*/
        private static String bin;

        private static int staticCharIdx = 0;
        /**
         * Constructor building the tree from a string
         */
        public MsgTree(String encodingString)
        {
                int i = 0;
                String last = "in";
                Stack<MsgTree> stack = new Stack<>();

                if(encodingString == null)
                        return;

                this.payloadChar = encodingString.charAt(i++);
                stack.push(this);
                MsgTree tree = this;

                while (i < encodingString.length())
                {
                        MsgTree node = new MsgTree(encodingString.charAt(i++));
                        if(last.equals("in"))
                                tree.left = node;
                        else
                                tree.right = node;
                        if(node.payloadChar == '^')
                        {
                            last = "in";
                            tree = stack.push(node);
                        }
                        else
                        {
                            last = "out";
                            if(!stack.empty())
                                    tree = stack.pop();
                        }
                }
        }
        /**
         * Constructor for a single node with null children
         */
        public MsgTree(char payloadChar)
        {
                this.left = null;
                this.right = null;
                this.payloadChar = payloadChar;
        }

        /**
         * method to print characters and their binary codes
         */
        public static void printCodes(MsgTree root, String code)
        {
                System.out.println("character code");
                System.out.println("-------------------------");
                char[] array = code.toCharArray();
                for(int j = 0; j < array.length; j++)
                {
                        code(root, array[j], bin = "");
                        System.out.println("    " + (array[j] == '\n' ? "\\n" : array[j] + " ") + "    " + bin);
                }
        }

        /**
         *
         * @param tree
         * @param a
         * @param path
         * @return
         * sets the characters
         */
        private static boolean code(MsgTree tree, char a, String path)
        {
                if (tree != null)
                {
                        if (a == tree.payloadChar)
                        {
                                bin = path;
                                return true;
                        }
                        return code(tree.left, a, path + "0") || code(tree.right, a, path + "1");
                }
                else
                        return false;
        }

        /**
         *
         * @param codes
         * @param msg
         * prints decoded message to the console
         */
        public void decode(MsgTree codes, String msg)
        {
                StringBuilder str = new StringBuilder();
                System.out.println("MESSAGE:");
                MsgTree tree = codes;

                for (int i = 0; i < msg.length(); i++)
                {
                        char a = msg.charAt(i);
                        tree = (a == '0' ? tree.left : tree.right);

                        if (tree.payloadChar != '^')
                        {
                                code(codes, tree.payloadChar, bin = "");
                                str.append(tree.payloadChar);
                                tree = codes;
                        }
                }
                System.out.println(str.toString());
                statistics(msg, str.toString());
        }

        /**
         *
         * @param encodeStr
         * @param decodeStr
         * prints out the average bits, total characters, and space saved
         */
        private void statistics(String encodeStr, String decodeStr)
        {
                System.out.println("STATISTICS: ");
                System.out.println(String.format("Avg bits/char:\t%.1f", encodeStr.length()/(double)decodeStr.length()));
                System.out.println("Total Characters:\t" + decodeStr.length());
                System.out.println(String.format("Space Saving:\t%.1f%%", (1d - decodeStr.length()/(double)encodeStr.length()) * 100));
        }
}