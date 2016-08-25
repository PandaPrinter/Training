/** 
Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

Example 1:
Given points = [[1,1],[-1,1]], return true.

Example 2:
Given points = [[1,1],[-1,-1]], return false.

Follow up:
Could you do better than O(n2)?

Hint:

Find the smallest and largest x-value for all points.
If there is a line then it should be at y = (minX + maxX) / 2.
For each point, make sure that it has a reflected point in the opposite side.
**/

public boolean isReflected(int[][] points) {
	int minX = 0, maxX = 0;
	Set<Integer> set = new HashSet<>();
	for (int[] point : points) {
		minX = Math.min(minX, point[0]);
		maxX = Math.max(maxX, point[0]);
		set.add(point[0] + "a" + point[1]);
	}

	int reflectPoint = minX + maxX;
	for (int[] point : points) {
		int x = reflectPoint - point[0];
		if (!set.contains(x + "a" + point[1])) return false;
	}
	return true;
}
