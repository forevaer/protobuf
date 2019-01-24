package com.godme.main;

import com.godme.protobuf.Message;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Message.Person person = Message.Person.newBuilder()
                .setId(1)
                .setName("godme")
                .setEmail("664473032@qq.com")
                .build();
        System.out.println(person.toString());
        String fileName = "person";
        writeToFile(person, fileName);
        Message.Person person2 = readFromFile(fileName);
        System.out.println(person2);
        System.out.println(person.equals(person2));
    }
    public static void writeToFile(Message.Person person, String fileName) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(fileName);
        person.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();
    }
    public static Message.Person readFromFile(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Message.Person person = Message.Person.parseFrom(fileInputStream);
        return person;
    }
}
