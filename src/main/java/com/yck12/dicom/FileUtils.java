package com.yck12.dicom;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.dcm4che3.util.SafeClose;
import org.dcm4che3.util.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;

public final class FileUtils {
    private static final int CACHE_SIZE = 1024;
    private static final Logger LOG = LoggerFactory.getLogger(FileUtils.class);

    private FileUtils() {
    }

    public static Properties loadProperties(String url) {
        Properties properties = new Properties();
        InputStream in = null;

        try {
            in = StreamUtils.openFileOrURL(url);
            properties.load(in);
        } catch (IOException var7) {
            LOG.error("read properties: {}", url);
            LOG.error(var7.getMessage(), var7);
        } finally {
            SafeClose.close(in);
        }

        return properties;
    }

    public static void createDir(String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists()) {
            if (!dir.isDirectory()) {
                LOG.error("invalid dir path: {} ", dirPath);
                throw new RuntimeException("invalid dir path:" + dirPath);
            }
        } else {
            boolean result = dir.mkdirs();
            LOG.info("create dir >>> path:{}, result:{}", dirPath, result);
        }
    }

    public static void move(File from, File dest) throws IOException {
        if (!from.exists()) {
            LOG.error("source file not found: {}", from.getAbsolutePath());
        }

        if (dest.exists()) {
            dest.delete();
            LOG.info("target file exists, delete {}", dest.getAbsolutePath());
        } else if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }

        if (!from.renameTo(dest)) {
            throw new IOException("Failed to rename " + from + " to " + dest);
        }
    }

    public static void refreshModificationTime(String path) {
        File file = new File(path);
        if (!file.exists()) {
            LOG.warn("update mt error: {} not found", path);
        }

        file.setLastModified(System.currentTimeMillis());
    }

    public static File[] list(String dirPath) {
        File dir = new File(dirPath);
        return dir.exists() && dir.isDirectory() ? dir.listFiles() : new File[0];
    }

    public static List<String> listDirectory(String dirPath) {
        return (List) Arrays.stream(list(dirPath)).filter(File::isDirectory).map(File::getAbsolutePath).collect(Collectors.toList());
    }

    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile() ? file.delete() : false;
    }

    public static boolean deleteEmptyFolder(String dirPath) {
        File file = new File(dirPath);
        if (file.exists() && file.isDirectory()) {
            String[] files = file.list();
            return ObjectUtils.isEmpty(files) ? file.delete() : false;
        } else {
            return false;
        }
    }

    public static void deleteRecursion(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                File[] var3 = subFiles;
                int var4 = subFiles.length;

                for (int var5 = 0; var5 < var4; ++var5) {
                    File subFile = var3[var5];
                    if (subFile.isDirectory()) {
                        deleteRecursion(subFile.getAbsolutePath());
                    } else {
                        subFile.delete();
                    }
                }
            }

            file.delete();
        }

    }

    public static boolean moveFile(String srcFilePath, String destFolder) {
        File srcFile = new File(srcFilePath);
        if (srcFile.exists() && srcFile.isFile()) {
            File destDir = new File(destFolder);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            File destFile = new File(destDir, srcFile.getName());
            if (destFile.exists()) {
                deleteFile(destFile.getAbsolutePath());
            }

            return srcFile.renameTo(destFile);
        } else {
            return false;
        }
    }

    public static void moveFolder(String srcFolder, String destFolder) {
        File srcDir = new File(srcFolder);
        if (srcDir.exists() && srcDir.isDirectory()) {
            File destDir = new File(destFolder);
            if (!destDir.exists()) {
                destDir.mkdirs();
            }

            File[] sourceFiles = srcDir.listFiles();
            File[] var5 = sourceFiles;
            int var6 = sourceFiles.length;

            for (int var7 = 0; var7 < var6; ++var7) {
                File sourceFile = var5[var7];
                if (sourceFile.isFile()) {
                    moveFile(sourceFile.getAbsolutePath(), destDir.getAbsolutePath());
                } else {
                    moveFolder(sourceFile.getAbsolutePath(), destDir.getAbsolutePath() + File.separator + sourceFile.getName());
                }
            }

            srcDir.delete();
        }
    }

    public static byte[] fileToByte(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                FileInputStream in = new FileInputStream(file);
                Throwable var3 = null;

                try {
                    ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
                    Throwable var5 = null;

                    try {
                        byte[] cache = new byte[1024];
                        boolean var7 = false;

                        int nRead;
                        while ((nRead = in.read(cache)) != -1) {
                            out.write(cache, 0, nRead);
                            out.flush();
                        }

                        byte[] var8 = out.toByteArray();
                        return var8;
                    } catch (Throwable var33) {
                        var5 = var33;
                        throw var33;
                    } finally {
                        if (out != null) {
                            if (var5 != null) {
                                try {
                                    out.close();
                                } catch (Throwable var32) {
                                    var5.addSuppressed(var32);
                                }
                            } else {
                                out.close();
                            }
                        }

                    }
                } catch (Throwable var35) {
                    var3 = var35;
                    throw var35;
                } finally {
                    if (in != null) {
                        if (var3 != null) {
                            try {
                                in.close();
                            } catch (Throwable var31) {
                                var3.addSuppressed(var31);
                            }
                        } else {
                            in.close();
                        }
                    }

                }
            } catch (IOException var37) {
                LOG.error(var37.getMessage(), var37);
            }
        }

        return null;
    }
}
