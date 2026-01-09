package BXH;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class countwin {
private String file="D:\\code\\java\\First_lesson\\src\\TEST\\input.txt";
    
	public countwin() {
	super();
}

	public void increaseWins(String name) {
        try {
            // Đọc dữ liệu từ tập tin vào danh sách
            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            
            // Tìm kiếm người chơi theo tên trong danh sách
            boolean found = false;
            for (int i = 0; i < lines.size(); i++) {
                String[] parts = lines.get(i).split(" ");
                if (parts[0].equals(name)) {
                    // Tăng số trận thắng của người chơi
                    int wins = Integer.parseInt(parts[1]);
                    wins++;
                    lines.set(i, name + " " + wins);
                    found = true;
                    break;
                }
            }
            
            // Nếu không tìm thấy người chơi trong danh sách, thêm thông tin mới với số trận thắng bằng 1
            if (!found) {
                lines.add(name + " 1");
            }
            
            // Ghi lại dữ liệu vào tập tin
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (String newLine : lines) {
                writer.write(newLine + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
