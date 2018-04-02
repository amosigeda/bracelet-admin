package com.jadmin.util;

import java.io.Closeable;
import java.io.IOException;

public class CloseableUtil {

  public static void close(Closeable stream) {
    if (stream != null) {
      try {
        stream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}