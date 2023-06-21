package com.alswo.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNumbersFile {
    public static void main(String[] args) {
        String filePath = "numbers.txt"; // ���� ��� �� �̸�
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("10"); // ���ڸ� ���Ͽ� ��� (����)
            bw.newLine();   // ���� �ٷ� �̵�
            bw.write("20");
            bw.newLine();
            bw.write("30");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("���� ������ �Ϸ�Ǿ����ϴ�.");
    }
}
