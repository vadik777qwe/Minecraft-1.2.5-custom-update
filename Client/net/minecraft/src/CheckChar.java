package net.minecraft.src;

public class CheckChar
{
  public static final char[] a = { '/', '\n', '\r', '\t', '\000', '\f', '`', '?', '*', '\\', '<', '>', '|', '"', ':' };

  public static boolean a(char paramChar)
  {
    return (paramChar != '§') && (paramChar >= ' ') && (paramChar != '');
  }

  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();

    for (char c : paramString.toCharArray()) {
      if (a(c)) {
        localStringBuilder.append(c);
      }
    }

    return localStringBuilder.toString();
  }
}