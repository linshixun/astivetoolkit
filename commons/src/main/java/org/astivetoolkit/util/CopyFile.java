/* 
 * Copyright (C) 2010-2013 by PhonyTive LLC (http://phonytive.com)
 * http://astivetoolkit.org
 *
 * This file is part of Astive Toolkit(ATK)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.astivetoolkit.util;

import java.io.*;



/**
 * Utility to copy a file from one location to another.
 *
 * @since 1.0.0
 */
public final class CopyFile {
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
    final  File f1 = new File(srFile);
    final  File f2 = new File(dtFile);
    final  InputStream in = new FileInputStream(f1);

    final  OutputStream out = new FileOutputStream(f2);

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
