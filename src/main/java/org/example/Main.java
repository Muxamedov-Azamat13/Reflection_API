package org.example;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * Используя Reflection API, напишите программу, которая выводит на экран все методы класса String.
 */

public class Main {
    public static void main(String[] args) {
        Class<?> stringClass = String.class;

        Method[] methods = stringClass.getDeclaredMethods();

        System.out.println("Методы класса String: ");
        for (Method method : methods) {
            String modifier = Modifier.toString(method.getModifiers());
            String name = method.getName();

            Class<?>[] parameterType = method.getParameterTypes();
            StringBuilder paramType = new StringBuilder();
            for (Class<?> param : parameterType){
                paramType.append(param.getSimpleName()).append(", ");
            }

            if (!paramType.isEmpty()){
                paramType.setLength(paramType.length() - 2);
            }

            System.out.printf("\" %s %s(%s)%n", modifier,name,paramType);
        }

    }
}