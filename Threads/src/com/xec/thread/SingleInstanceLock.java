package com.xec.thread;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
public class SingleInstanceLock {
    private String appName;
    private File lockFile;
    private FileLock fileLock;
    private FileChannel fileChannel;
    public SingleInstanceLock(String appName) {
        this.appName = appName;
        isAppActive();
    }
    public boolean isAppActive() {
        try {
            lockFile = new File(System.getProperty("user.home"), appName + ".tmp");
            fileChannel = new RandomAccessFile(lockFile, "rw").getChannel();
            try {
                fileLock = fileChannel.tryLock();
            } catch (OverlappingFileLockException e) {
                System.out.println("Already Locked");
                closeLock();
                return true;
            }
            if (fileLock == null) {
                System.out.println("Could not obtain lock");
                closeLock();
                return true;
            }
            lockFile.deleteOnExit();
            return false;
        } catch (Exception e) {
            closeLock();
            return true;
        }
    }
    private void closeLock() {
        try { fileLock.release();} catch (Exception e) {}
        try { fileChannel.close();} catch (Exception e) {}
    }
}

class test{
    public static void main(String[] args) {
        SingleInstanceLock singleInstanceLock=new SingleInstanceLock("imran");
        SingleInstanceLock singleInstanceLock1=new SingleInstanceLock("imran");
    }
}