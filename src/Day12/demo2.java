package Day12;

import java.io.*;


class Student implements Serializable {
 int id;
 String name;

 Student(int id, String name) {
     this.id = id;
     this.name = name;
 }

 void display() {
     System.out.println("ID: " + id);
     System.out.println("Name: " + name);
 }
}

public class demo2 {

 public static void main(String[] args) {

     
     try {
         Student s1 = new Student(101, "Teja");

         FileOutputStream fos = new FileOutputStream("student.ser");

         ObjectOutputStream oos =  new ObjectOutputStream(fos);

         oos.writeObject(s1);

         oos.close();
         fos.close();

         System.out.println("Object Serialized Successfully");

     } 
     catch (Exception e) {
         e.printStackTrace();
     }

     
     try {

         FileInputStream fis = new FileInputStream("student.ser");

         ObjectInputStream ois = new ObjectInputStream(fis);

         Student s2 = (Student) ois.readObject();

         ois.close();
         fis.close();

         System.out.println("\nObject Deserialized Successfully");
         s2.display();

     } catch (Exception e) {
         e.printStackTrace();
     }
 }
}