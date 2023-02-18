package homework_04;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class program {
    public static void main(String[] args) {
        // Создаем карту
        int[][] map = {
            {00, 00, -1, 00, 00, 00, 00, 00, 00, 00},
            {00, 00, -1, 00, -1, -1, -1, 00, -1, 00},
            {00, 00, -1, 00, 00, 00, 00, 00, -1, 00},
            {00, 00, -1, 00, 00, 00, 00, 00, -1, 00},
            {00, 00, 00, 00, 00, -1, -1, -1, -1, 00},
            {00, 00, 00, -1, 00, 00, -1, 00, 00, 00},
            {-1, 00, 00, -1, 00, 00, -1, 00, 00, 00},
            {-1, 00, 00, -1, 00, 00, -1, -1, 00, 00},
            {-1, 00, 00, -1, 00, 00, -1, 00, 00, 00},
            {-1, 00, 00, 00, 00, 00, 00, 00, -1, 00}, };
        printMap(map);

        // Запрашиваем координаты начальной позиции и конечной
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начальную координату x: ");
        int x = scanner.nextInt();
        System.out.print("Введите начальную координату y: ");
        int y = scanner.nextInt();
        System.out.print("Введите конечную координату x: ");
        int x_end = scanner.nextInt();
        System.out.print("Введите конечную координату y: ");
        int y_end = scanner.nextInt();
        scanner.close();
        int[] start_p = {y, x};
        map[y][x] = 1;
        
        // Распространяем волну
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(start_p);
        int[] current;
        int x_cur, y_cur;
        while (queue.size() != 0 && map[y_end][x_end] == 0){

            current = queue.remove();
            x_cur = current[1];   
            y_cur = current[0];

            //Проверяем и присваиваем новые значения соседним клеткам
            if (y_cur + 1 >=0 && y_cur + 1 < 10){

                if(map[y_cur + 1][x_cur] == 0){
                    queue.add(new int[] {y_cur + 1, x_cur});
                    map[y_cur + 1][x_cur] = map[y_cur][x_cur] + 1;
                }
            }
            
            if (y_cur - 1 >=0 && y_cur - 1 < 10){

                if(map[y_cur - 1][x_cur] == 0){
                    queue.add(new int[] {y_cur - 1, x_cur});
                    map[y_cur - 1][x_cur] = map[y_cur][x_cur] + 1;
                }
            }

            if (x_cur + 1 >= 0 && x_cur + 1 < 10){
                if(map[y_cur][x_cur + 1] == 0){
                    queue.add(new int[] {y_cur, x_cur + 1});
                    map[y_cur][x_cur + 1] = map[y_cur][x_cur] + 1;
                }
            }

            if (x_cur - 1 >= 0 && x_cur - 1 < 10){
                
                if(map[y_cur][x_cur - 1] == 0){
                    queue.add(new int[] {y_cur, x_cur - 1});
                    map[y_cur][x_cur - 1] = map[y_cur][x_cur] + 1;
                }
            }
            
        }

        queue.clear();

        System.out.println();
        printMap(map);
        System.out.println("Дистанция: " + (map[y_end][x_end] - 1));
    }



    public static void printMap(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%4d", arr[i][j]);
            }
            System.out.println();
        }
    }

}
