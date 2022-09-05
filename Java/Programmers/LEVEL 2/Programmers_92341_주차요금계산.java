import java.util.ArrayList;
import java.util.Collections;

class Solution {
	public static class Car implements Comparable<Car> {
		int carNum, inTime, total;
		boolean isIn;

		public Car(int carNum, int inTime) {
			this.carNum = carNum;
			this.inTime = inTime;
			this.total = 0;
			this.isIn = true;
		}

		@Override
		public int compareTo(Car c) {
			return this.carNum - c.carNum;
		}
	}
    
    public int[] solution(int[] fees, String[] records) {
        int baseTime = fees[0];
		int baseFee = fees[1];
		int addTime = fees[2];
		int addFee = fees[3];

		ArrayList<Car> cars = new ArrayList<>();
		for (String record : records) {
			String[] cur = record.split(" ");
			String[] hm = cur[0].split(":");
			int time = Integer.parseInt(hm[0]) * 60 + Integer.parseInt(hm[1]);
			int carNum = Integer.parseInt(cur[1]);
			String cmd = cur[2];

			boolean isCar = false;
			for (Car car : cars) {
				if (car.carNum == carNum) {
					if (cmd.equals("OUT")) {
						car.total += time - car.inTime;
						car.isIn = false;
					} else {
						car.inTime = time;
						car.isIn = true;
					}
					isCar = true;
					break;
				}
			}
			if (!isCar) {
				cars.add(new Car(carNum, time));
			}
		}

		for (Car car : cars) {
			if (car.isIn) {
				car.total += 23 * 60 + 59 - car.inTime;
			}
		}

		Collections.sort(cars);
		int[] answer = new int[cars.size()];
		for (int i = 0, size = cars.size(); i < size; i++) {
			int tempTotal = cars.get(i).total;
			tempTotal = tempTotal - baseTime > 0 ? tempTotal - baseTime : 0;
			int tempTime = tempTotal % addTime == 0 ? tempTotal / addTime : tempTotal / addTime + 1;
			answer[i] = baseFee + tempTime * addFee;
		}
        
        return answer;
    }
}