package edu.umb.cs681.hw15;

import java.time.LocalDateTime;
import java.util.LinkedList;


public class FileSystem implements Runnable {

    private LinkedList<Directory> root_directory;
    private static FileSystem instance = null;

    void appendRootDir(Directory RootDirectory) {
    	root_directory = new LinkedList<Directory>();
    	root_directory.add(RootDirectory);
    }
    private FileSystem() {};
    
    public LinkedList<Directory> getRootDirectory() {
        return this.root_directory;
    }

    public static FileSystem getFileSystem() {
        if(instance==null)
            instance = new FileSystem ();
        return instance;
    }

    @Override
    public void run() {

    	   System.out.println("\nThread "+Thread.currentThread().getId()+" is currently running");

    }

    public static void main(String[] args) {

    	LocalDateTime localTime = LocalDateTime.now();
        Directory root = new Directory(null, "root", 0, localTime);
        Directory applications = new Directory(root, "applications", 0, localTime);
        Directory home = new Directory(root, "home", 0, localTime);
        Directory code = new Directory(home, "code", 0, localTime);
        FileSystem fs = new FileSystem();
        File a = new File(applications, "a", 200, localTime);
        File b = new File(applications, "b", 650, localTime);
        File c = new File(home, "c", 800, localTime);
        File d = new File(home, "d", 200, localTime);
        File e = new File(code, "e", 600, localTime);
        File f = new File(code, "f", 320, localTime);
        Thread t1 = new Thread(fs);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("Directory "+root.getName()+" is created");
        System.out.println("File "+a.getName()+" added to the directory "+root.getName());
        System.out.println("File "+b.getName()+" added to the directory "+root.getName());

        Thread t2 = new Thread(fs);
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        System.out.println("Directory "+home.getName()+" is created");
        System.out.println("File "+c.getName()+" added to the directory "+home.getName());
        System.out.println("File "+d.getName()+" added to the directory "+home.getName());

        Thread t3 = new Thread(fs);
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
        System.out.println("Directory "+code.getName()+" is created");
        System.out.println("File "+e.getName()+" added to the directory "+code.getName());
        System.out.println("File "+f.getName()+" added to the directory "+code.getName());
    }

}