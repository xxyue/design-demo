package com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0;

import java.io.*;

/**
 * @Description: ${description}
 * @ClassName: MyJDKClassLoader
 * @Author: yuexx
 * @Date: 2019/1/29 17:34
 * @Version: 1.0
 */
public class MyJDKClassLoader extends ClassLoader {

    private File classPathFiles;

    public MyJDKClassLoader() {
        String classPath = MyJDKClassLoader.class.getResource("").getPath();
        this.classPathFiles = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String className = MyJDKClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFiles != null) {
            File classFile = new File(classPathFiles, name.replaceAll("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream in = null;
                ByteArrayOutputStream out = null;

                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0, len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if(null != in){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (null != out){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        return null;
    }
}
