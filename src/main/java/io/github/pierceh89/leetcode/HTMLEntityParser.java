package io.github.pierceh89.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 5382. HTML Entity Parser
 */
public class HTMLEntityParser {
    Pattern p = Pattern.compile("&(quot|apos|amp|gt|lt|frasl);");

    public String entityParser(String text) {
        Matcher matcher = p.matcher(text);
        StringBuilder sb = new StringBuilder();
        int lastIndex=0;
        while(matcher.find()) {
            sb.append(text.substring(lastIndex, matcher.start()));
            sb.append(convert(matcher.group(1)));
            lastIndex = matcher.end();
        }
        sb.append(text.substring(lastIndex));
        return sb.toString();
    }

    public String convert(String encoded) {
        switch (encoded) {
            case "quot":
                return "\"";
            case "apos":
                return "'";
            case "amp":
                return "&";
            case "gt":
                return ">";
            case "lt":
                return "<";
        }
        return "/";
    }
}
