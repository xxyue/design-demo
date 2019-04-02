package com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Description: JDK 代理模拟
 * @ClassName: MyJDKProxy
 * @Author: yuexx
 * @Date: 2019/1/29 17:32
 * @Version: 1.0
 */
public class MyJDKProxy {

    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyJDKClassLoader classLoader, Class<?>[] interfaces, MyJDKInvocationHandler invocationHandler) {
        try {
            //1.第一步动态生成源代码  java 文件
            String src = generateSrc(interfaces);
//        System.out.println("MyJDKProxy  src: " + src);
            //2. java文件保存磁盘
            String filePath = MyJDKProxy.class.getResource("").getPath();
            filePath = filePath + "$Proxy0.java";
            System.out.println(filePath);
//        filePath.replace("target/classes/","main/java/");
            File f = new File(filePath);
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            System.out.println(filePath + " 文件已生成！");
            //3 把生成的java 文件，编译成class 文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();
            //4 把编译后的生成的class 文件加载到JVM中

            Class proxyClazz = classLoader.findClass("$Proxy0");
            Constructor c = proxyClazz.getConstructor(MyJDKInvocationHandler.class);
//            f.delete();


            //5.返回字节码重组后的新代理对象
            return c.newInstance(invocationHandler);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        StringBuilder sb = new StringBuilder();
        //pachage
        sb.append("package com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0;" + ln);
        //导包
        sb.append("import java.lang.reflect.InvocationHandler;" + ln);
        sb.append("import java.lang.reflect.Method;" + ln);
        sb.append("import java.lang.reflect.Proxy;" + ln);
        sb.append("import java.lang.reflect.UndeclaredThrowableException;" + ln);
        sb.append("import com.design.designdemo.structural._1proxy.dynamic.JDK_.theory_0.MyJDKInvocationHandler;" + ln);
        for (Class inter : interfaces) {
            sb.append("import " + inter.getName() + ";" + ln);
        }
        //类的声明
        sb.append("public class $Proxy0 implements ");
        for (Class inter : interfaces) {
            sb.append(inter.getCanonicalName() + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" {" + ln);

        //方法实现
        sb.append("MyJDKInvocationHandler h;" + ln);

        sb.append("public $Proxy0(MyJDKInvocationHandler h) {" + ln);
        sb.append("this.h = h;");
        sb.append(ln + "}" + ln);

        //方法实现
        for (Class inter : interfaces) {
            for (Method m : inter.getMethods()) {
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);

                sb.append("try {" + ln);

                sb.append(" Method mm = " + inter.getName() + ".class.getMethod(\"" + m.getName() + "\", new Class[]{} );" + ln);
                //TODO 参数 没有穿，固定无参
                sb.append("this.h.invoke(this, mm, null);");
                sb.append("} catch (RuntimeException | Error var3) {" + ln);
                sb.append("throw var3;" + ln);
                sb.append("} catch (Throwable var4) {" + ln);
                sb.append("throw new UndeclaredThrowableException(var4);" + ln);
                sb.append("}" + ln);

                sb.append(ln + "}" + ln);
            }
        }

        sb.append(ln + " }");
        return sb.toString();

    }


    public static void main(String[] args) {

//       String a =  new MyJDKProxy().getClass().getName();
////        System.out.println(a);
////        String name = MyJDKProxy.class.getName();
////        System.out.println("name ： " + name);
////        String path = MyJDKProxy.class.getResource("").getPath();
////        System.out.println("path ： " + path);
////        String filePath = MyJDKProxy.class.getResource("/").getPath();
////        System.out.println("filePath" + filePath);
////        String imp = path.replace(filePath, "");
////        System.out.println(imp + name);

        MeipoProxy meipoProxy = new MeipoProxy();
        Son son = new Son();
//        System.out.println(son.getClass());
        Person person = (Person) meipoProxy.getInstance(son);
//        System.out.println(person.getClass());
        person.findLove();
    }
}
