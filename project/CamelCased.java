package project;

/**
 * Title:        Database for Industrial Management
 * Description:  The designed system solve all major problems of existing system.
 * Copyright:    Copyright (c) 2014
 * @author Jay Kumar
 * @version 2.0
 */

public class CamelCased {

  public static String camelCase(String s){
    StringBuffer builder = new StringBuffer();
    java.util.StringTokenizer tokens = new java.util.StringTokenizer(s," ");
    while(tokens.hasMoreTokens()){
      String token = tokens.nextToken();
      String lower = token.toLowerCase();
      String str = (token.charAt(0)+lower.substring(1));
      builder.append(str).append(" ");
    }

    return builder.toString();
  }
}