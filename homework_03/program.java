// Дана прямоугольная карта размера MxN (N, M меньше 20)
// На карте стоит фигура в точке(Х, Y), которая может ходить на одну клеточку вправо или вниз за один ход
// Посчитать количество маршрутов, которым фигура может попасть в нижнюю правую клетку


package homework_03;

public class program {

    public static int solver(int x, int y, int N, int M){

        if (x > N - 1 || y > M - 1){
            return 0;
        }

        if (x == N - 1 && y == M - 1){
            return 1;
        }

        return solver(x + 1, y, N, M) + solver(x, y + 1, N, M);

    }

    public static void main(String[] args) {

        //Начальное положение фигуры
        int x = 0;
        int y = 0;

        //Размер карты
        int M = 4;
        int N = 4;
        System.out.println(solver(x, y, M, N));
    }
}
