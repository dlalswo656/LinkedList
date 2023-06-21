package com.alswo.List;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNumbersFile {
    public static void main(String[] args) {
        String filePath = "numbers.txt"; // 파일 경로 및 이름
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            bw.write("10"); // 숫자를 파일에 기록 (예시)
            bw.newLine();   // 다음 줄로 이동
            bw.write("20");
            bw.newLine();
            bw.write("30");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("파일 생성이 완료되었습니다.");
    }
}
