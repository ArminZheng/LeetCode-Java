package com.armin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 静态变量不会被序列化
 */
public class StaticNoSerializable {

    private static String path = "/home/armin/demo_java";

    public static void main(String[] args) {
        // prepare object
        Demo dataObject = new Demo();
        dataObject.setI(2);
        dataObject.setWord("123");
        // write
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dataObject);
            objectOutputStream.flush();
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // change
        Demo.i = 998;
        // read
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object o = objectInputStream.readObject();
            System.out.println("o = " + o);
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Demo implements Serializable { //  Serializable 接口是自动序列化的，实现 Externalizable 则需要手动序列化, 对 transient 无效
    // 被static修饰的变量是不会被序列化的，因为只有堆内存会被序列化.所以静态变量天生不会被序列化。
    protected static int i = 0;
    private String word = " ";

    public Demo() {
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setI(int i) {
        Demo.i = i;
    }

    public String toString() {
        return "DataObject(i=" + i + "word=" + this.word + ")";
    }
}