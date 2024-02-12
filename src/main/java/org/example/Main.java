import java.util.Scanner;

public class Main {
    // Радиус Земли в километрах
    private static final double EARTH_RADIUS_KM = 6371.0;

    // Метод для перевода градусов в радианы
    private static double degreesToRadians(double degrees) {
        return degrees * Math.PI / 180.0;
    }

    // Метод для вычисления расстояния: формула гаверсинусов
    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dLat = degreesToRadians(lat2 - lat1);
        double dLon = degreesToRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(degreesToRadians(lat1)) * Math.cos(degreesToRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS_KM * c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод координат первой точки
        System.out.println("Введите широту первой точки (в градусах):");
        double lat1 = scanner.nextDouble();
        System.out.println("Введите долготу первой точки (в градусах):");
        double lon1 = scanner.nextDouble();

        // Ввод координат второй точки
        System.out.println("Введите широту второй точки (в градусах):");
        double lat2 = scanner.nextDouble();
        System.out.println("Введите долготу второй точки (в градусах):");
        double lon2 = scanner.nextDouble();

        // Вычисление расстояния
        double distance = calculateDistance(lat1, lon1, lat2, lon2);
        System.out.println("Расстояние между точками: " + distance + " км");

        scanner.close();
    }
}
