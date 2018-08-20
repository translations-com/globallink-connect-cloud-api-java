package org.gs4tr.gcc.restclient.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class StringUtils {

    public static String toString(InputStream inputStream) throws IOException{
	final int bufferSize = 1024;
	final char[] buffer = new char[bufferSize];
	final StringBuilder out = new StringBuilder();
	Reader in = new InputStreamReader(inputStream, "UTF-8");
	for (; ; ) {
	    int rsz = in.read(buffer, 0, buffer.length);
	    if (rsz < 0)
	        break;
	    out.append(buffer, 0, rsz);
	}
	return out.toString();
    }

    public static Boolean isNullOrEmpty(String value){
	return value == null || value.trim().length()<=0;
    }
    
    public static Boolean IsNullOrWhiteSpace(String value){
	return isNullOrEmpty(value);
    }
    
}
