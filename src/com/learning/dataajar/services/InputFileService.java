/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.learning.dataajar.services;

import java.io.RandomAccessFile;
import java.util.List;

/**
 *
 * @author hendri
 */
public class InputFileService {

    static private List<String> list;

    public static void setList(List<String> list) {
        InputFileService.list = list;
    }

    public static List<String> getList() {
        return list;
    }

    public static void printToFile(String fileName, List<String> list) {
        RandomAccessFile file;
        try {
            file = new RandomAccessFile(fileName, "rw");
            for (String teks : list) {
                file.write(teks.getBytes());
            }

            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            file = null;
        }
    }
}
