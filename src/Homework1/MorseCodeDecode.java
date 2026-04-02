package Homework1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeDecode {

    public static void main(String[] args) throws FileNotFoundException {
        //从命令行读入需要解码的文件
        if (args.length < 1) {
            System.out.println("Usage: java MorseCodeDecode <inputFile>");
        }
        StringBuilder builder= new StringBuilder();
        Scanner in = new Scanner(new File(args[0]));
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (!builder.isEmpty())
                //行与行之间补一个空格
                builder.append(' ');
            builder.append(line);
        }
        in.close();
        //将文件中的内容存入字符串
        String morseText = builder.toString();
        //构建对应的摩斯编码表
        Map<String, Character> dict = buildMorseDict();
        //解码
        String decoded = decodeMorseText(morseText, dict);
        System.out.println(decoded);
        //提高可读性
        String decodedSentence = toSentenceCase(decoded);
        System.out.println(decodedSentence);
    }

    //构建对应的摩斯编码表
    private static Map<String, Character> buildMorseDict() {
        Map<String, Character> map = new HashMap<>();

        //A-Z
        map.put(".-", 'A');
        map.put("-...", 'B');
        map.put("-.-.", 'C');
        map.put("-..", 'D');
        map.put(".", 'E');
        map.put("..-.", 'F');
        map.put("--.", 'G');
        map.put("....", 'H');
        map.put("..", 'I');
        map.put(".---", 'J');
        map.put("-.-", 'K');
        map.put(".-..", 'L');
        map.put("--", 'M');
        map.put("-.", 'N');
        map.put("---", 'O');
        map.put(".--.", 'P');
        map.put("--.-", 'Q');
        map.put(".-.", 'R');
        map.put("...", 'S');
        map.put("-", 'T');
        map.put("..-", 'U');
        map.put("...-", 'V');
        map.put(".--", 'W');
        map.put("-..-", 'X');
        map.put("-.--", 'Y');
        map.put("--..", 'Z');

        // 0-9
        map.put("-----", '0');
        map.put(".----", '1');
        map.put("..---", '2');
        map.put("...--", '3');
        map.put("....-", '4');
        map.put(".....", '5');
        map.put("-....", '6');
        map.put("--...", '7');
        map.put("---..", '8');
        map.put("----.", '9');

        // 标点（常见集合）
        map.put(".-...", '&');
        map.put(".----.", '\'');
        map.put(".--.-.", '@');
        map.put("-.--.-", ')');
        map.put("-.--.", '(');
        map.put("---...", ':');
        map.put("--..--", ',');
        map.put("-...-", '=');
        map.put("-.-.--", '!');
        map.put(".-.-.-", '.');
        map.put("-....-", '-');
        map.put("-..-", 'x');
        map.put(".-.-.", '+');
        map.put(".-..-.", '"');
        map.put("..--..", '?');
        map.put("-..-.", '/');

        return map;
    }

    // 解码
    public static String decodeMorseText(String morseText, Map<String, Character> dict) {
        if (morseText == null)
            return "";

        if (morseText.isEmpty())
            return "";

        //以单词为单位切割
        String[] words = morseText.split(" {3,}");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i > 0)
                builder.append(' ');
            String word = words[i].trim();
            if (word.isEmpty())
                continue;

            //以字母为单位切割
            String[] tokens = word.split(" {1,}");
            //把数组 tokens 里的每一个元素依次取出来，放到变量 token 里
            for (String token : tokens) {
                if (token.isEmpty())
                    continue;
                Character ch = dict.get(token);
                if (ch == null)
                    builder.append("Error");
                else builder.append(ch);
            }
        }
        return builder.toString();
    }

    //提高可读性，进行符合英语基础语法的改变，鉴于专属名词较多，未进行单独处理，可能出现专属名词未大写的问题
    public static String toSentenceCase(String s) {
        if (s == null)
            return "";
        if (s.isEmpty())
            return s;
        //全部小写
        String lower = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        //句子首字母大写
        boolean capNext = true;
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (capNext && Character.isLetter(c)) {
                builder.append(Character.toUpperCase(c));
                capNext = false;
            } else {
                builder.append(c);
            }
            if (c == '.' || c == '!' || c == '?') {
                capNext = true;
            }
        }
        return builder.toString();
    }
}
