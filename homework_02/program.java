package homework_02;

import java.io.*;

public class program {

    public static double power(int number, int power_number){
        double result = number;

        if (number == 0){
            return 0;
        }
        if (power_number == 0){
            result = 1;
        } else{
            if (power_number > 0){
                for (int i = 1; i < power_number; i++){
                    result *= number;
                }
            }else{

                for (int i = 1; i < power_number * -1; i++){
                    result *= number;
                }
                result = 1 / result;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{

        //Считываем данные из файла input.txt
        BufferedReader br = new BufferedReader(new FileReader("homework_02\\input.txt"));
        String str;
        int a = 0, b = 0;
        while ((str = br.readLine()) != null) {
            String[] words = str.split(" ");
            if (words[0].equals("a")){
                a = Integer.parseInt(words[1]);
            } else{
                b = Integer.parseInt(words[1]);
            }
        }
        br.close();
        
        // Вычисляем ответ
        double result = power(a, b);
        
        // Записываем ответ в файл output.txt
        try (FileWriter fw = new FileWriter("homework_02\\output.txt", false)) {
            fw.write(Double.toString(result));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            }
           

    }
}
