import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Watchdog {

	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream(args[0]);
			FileOutputStream outputStream = new FileOutputStream("output.txt");
			Kattio io = new Kattio(inputStream, outputStream);
			int numOfTestCases = io.getInt();

			for (int i = 0; i < numOfTestCases; i++) {
				int s = io.getInt();
				int maxRadius = s / 2;
				int minRadius = 1;
				int h = io.getInt();
				int[] xCoords = new int[h];
				int[] yCoords = new int[h];
				double xAvg = 0, yAvg = 0;

				for (int j = 0; j < h; j++) {
					xCoords[j] = io.getInt();
					xAvg += xCoords[j];
					yCoords[j] = io.getInt();
					yAvg += yCoords[j];
				}

				xAvg = xAvg / h;
				yAvg = yAvg / h;

				int floorX = (int) Math.floor(xAvg);
				int floorY = (int) Math.floor(yAvg);
				int ceilX = (int) Math.ceil(xAvg);
				int ceilY = (int) Math.ceil(yAvg);

				int minX = ceilX;
				int currentX = floorX;
				int minY = ceilY;

				while (minX > currentX) {
					int radius = maxRadius(s, currentX, minY);
					if (isValidCenter(radius, currentX, minY, xCoords, yCoords)) {
						minX = currentX;
						currentX--;
					}
					// Figure out how to handle initial cases and edge cases
					// else if (isValidCenter(maxRadius(s, minX, minY), minX, minY, xCoords,
					// yCoords)){
					// break;
					// }
					// else {
					//
					// }
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static boolean isValidCenter(int radius, int xVal, int yVal, int[] xCoords, int[] yCoords) {
		return false;
	}

	private static int maxRadius(int s, int x1, int y1) {
		return Math.min(Math.min(x1, s - x1), Math.min(y1, s - y1));
	}

	private static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}

}
