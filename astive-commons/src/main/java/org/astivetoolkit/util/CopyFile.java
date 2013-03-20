package com.phonytive.astive.util;

import java.io.*;

/**
 * Utility to copy a file from one location to another.
 *
 * @since 1.0.0
 */
public class CopyFile {
  private CopyFile() {
  }

  /**
   * Copy a file from one location to another.
   *
   * @param srFile source file
   * @param dtFile destination file
   *
   * @throws FileNotFoundException if source file is not found.
   * @throws IOException if can't perform a I/O operation.
   */
  public static synchronized void copyfile(String srFile, String dtFile)
                                    throws FileNotFoundException, IOException {
    try {
      File f1 = new File(srFile);
      File f2 = new File(dtFile);
      InputStream in = new FileInputStream(f1);

      OutputStream out = new FileOutputStream(f2);

      byte[] buf = new byte[0x400];
      int len;

      while ((len = in.read(buf)) > 0x0) {
        out.write(buf, 0x0, len);
      }

      in.close();
      out.close();
    } catch (FileNotFoundException ex) {
      throw new FileNotFoundException();
    } catch (IOException e) {
      throw new IOException();
    }
  }
}
