package BXH;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.io.*;


public class view extends JFrame{
	private JTable table;
	   private String file ="D:\\code\\java\\First_lesson\\src\\TEST\\input.txt";
	   
	   public view() {
	      setTitle("Bảng xếp hạng");
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      // Tạo bảng với 2 cột
	      String[] columns = {"Tên", "Số trận thắng"};
	      DefaultTableModel model = new DefaultTableModel(columns, 0);
	      table = new JTable(model);
	      
	      // Đọc dữ liệu từ tập tin và thêm vào bảng
	      try {
	         FileReader fileReader = new FileReader(file);
	         BufferedReader bufferedReader = new BufferedReader(fileReader);
	         String line;
	         while ((line = bufferedReader.readLine()) != null) {
	            String[] parts = line.split("\\s+");
	            String name = parts[0];
	            String wins = parts[1];
	            model.addRow(new Object[]{name, wins});
	         }
	         bufferedReader.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      
	      // Thêm bảng vào JFrame
	      add(new JScrollPane(table));
	      setSize(getPreferredSize());
	      setLocationRelativeTo(null) ;
	      pack();
	      setVisible(true);
	   }
}
