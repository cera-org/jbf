import java.util.Arrays;
import java.util.ArrayList;

public class JBF {
    public static String interpretBrainfuck(String line, String stdin) {
        StringBuilder output = new StringBuilder();

        int[] memoryCells = new int[32];
        int memoryPointer = 0;
        int stdinPointer = 0;
        Arrays.fill(memoryCells, 0);

        ArrayList<Integer> loopStack = new ArrayList<Integer>();

        int pointer;
        char instruction;
        for (pointer = 0; pointer < line.length(); pointer++) {
            instruction = line.charAt(pointer);
            switch (instruction) {
                case '+':
                    memoryCells[memoryPointer] = (memoryCells[memoryPointer] + 1) % 256;
                    break;
                case '-':
                    memoryCells[memoryPointer] = (memoryCells[memoryPointer] + 255) % 256;
                    break;
                case '<':
                    memoryPointer = (memoryPointer + 31) % 32;
                    break;
                case '>':
                    memoryPointer = (memoryPointer + 1) % 32;
                    break;
                case '.':
                    output.append((char) memoryCells[memoryPointer]);
                    break;
                case ',':
                    if (stdinPointer < stdin.length()) {
                        memoryCells[memoryPointer] = (int) stdin.charAt(stdinPointer);
                        stdinPointer++;
                    } else {
                        memoryCells[memoryPointer] = 0;
                    }
                    break;
                case '[':
                    if (memoryCells[memoryPointer] > 0) {
                        loopStack.add(pointer);
                    } else {
                        int brackets = 1;
                        while (brackets > 0 && pointer < line.length() - 1) {
                            char c = line.charAt(pointer);
                            if (c == '[') {
                                brackets++;
                            }
                            if (c == ']') {
                                brackets--;
                            }
                        }
                    }
                    break;
                case ']':
                    if (memoryCells[memoryPointer] > 0) {
                        pointer = loopStack.get(loopStack.size() - 1);
                    } else {
                        loopStack.remove(loopStack.size() - 1);
                    }
                    break;
            }
        }
        return output.toString();
        // return "Test Return";
    }
}