package com.demo.practise.Practise1_2;

import java.lang.reflect.Method;

/**
 * 使用反射机制访问任意类的任意方法
 *
 * @version 1.0.0
 * @auther ZhaoLei
 * @creatTime 2019年08月07日  09:23:13
 */
public class ReflectionMethod {

    public static Object execute(String className, String methodName, Object[] args) throws Exception {
        //加载类
        Class classz = ClassLoader.getSystemClassLoader().loadClass(className);
        //参数类型的数组
        Class[] argsClasses = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            argsClasses[i] = args[i].getClass();
        }
        //获得方法
//        Method method = classz.getDeclaredMethod(methodName,argsClasses);
//        System.out.println(method);
        Method[] methods = classz.getMethods();
        //定义方法的变量
        Method method = null;
        //遍历方法数组
        for (Method temp : methods) {
            //比较方法名是否相同
            if (temp.getName().equals(methodName)) {//方法名相同
                method = temp;
                //获得方法的参数类型数组
                Class[] paramTypes = temp.getParameterTypes();
                //遍历参数类型数组
                for (int i = 0; i < paramTypes.length; i++) {
                    //
                    System.out.println(paramTypes[i]);
                    System.out.println("--");
                    System.out.println(argsClasses[i]);
                    if (paramTypes[i] != argsClasses[i]) {

                        boolean isSuch = false;
                        if (argsClasses[i] == Integer.class && paramTypes[i] == int.class) {
                            isSuch = true;
                        } else if (argsClasses[i] == Long.class && paramTypes[i] == long.class) {
                            isSuch = true;
                        }//……
                        if (!isSuch) {
                            method = null;
                            break;
                        }

                    }
                }
                //判断是否成功匹配到方法
                if(method!=null){
                    break;
                }
            }
        }
        //判断是否未匹配到方法
        if (method==null) {
            throw new  NoSuchMethodException("未匹配到方法");
        }
        //执行方法
        return method.invoke(classz.newInstance(),args);
    }

    public static void main(String[] args)  {
        try {
            execute("com.demo.practise.Practise1_2.Calculator", "sum", new Object[]{3, 6});
            execute("com.demo.practise.Practise1_2.Calculator", "subtrction", new Object[]{13, 6});
//            execute("com.demo.practise.Practise1_2.Calculator", "sum", new Object[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
