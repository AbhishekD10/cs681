package edu.umb.cs681.hw15;


import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Directory extends FSElement {

    private ConcurrentLinkedQueue<FSElement> child;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        if(parent != null)
            parent.appendChild(this);
    }

    public ConcurrentLinkedQueue<FSElement> getChildren() {
        return this.child;
    }

    public void appendChild(FSElement child) {
        if(this.child == null) {
            this.child = new ConcurrentLinkedQueue<FSElement>();
        }
        this.child.add(child);
    }

    public int countChildren() {
        return getChildren().size();

    }

    public LinkedList<Directory> getSubDirectories() {
        lock.lock();
        try {
            LinkedList<Directory> list_directories = new LinkedList<Directory>();
            for (FSElement f : getChildren()) {
                if (f instanceof Directory)
                	list_directories.add((Directory) f);
            }
            return list_directories;
        } finally {
            lock.unlock();
        }
    }

    public LinkedList<File> getFiles() {
        lock.lock();
        try {
            LinkedList<File> list_files = new LinkedList<File>();
            for (FSElement f : getChildren()) {
                if (f instanceof File)
                	list_files.add((File) f);
            }
            return list_files;
        } finally {
            lock.unlock();
        }

    }

    public int getTotalSize() {
        lock.lock();
        try {
            int size_total = 0;
            for(FSElement f : getChildren()) {
                if(f instanceof Directory)
                	size_total += ((Directory) f).getTotalSize();
                else
                	size_total += f.getSize();
            }
            return size_total;
        }finally {
            lock.unlock();
        }

    }

    @Override
    public boolean isDirectory() {
        lock.lock();
        try {
            return true;
        } finally {
            lock.unlock();
        }

    }

}