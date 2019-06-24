import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
 * 864. Shortest Path to Get All Keys
 * Hard
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is
 * the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 * <p>
 * We start at the starting point, and one move consists of walking one space in
 * one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into
 * a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless
 * we have the corresponding key.
 * <p>
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter
 * of the first K letters of the English alphabet in the grid.  This means that there
 * is exactly one key for each lock, and one lock for each key; and also that the letters
 * used to represent the keys and locks were chosen in the same order as the English
 * alphabet.
 * <p>
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return
 * -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Example 2:
 * <p>
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly
 * one lock.
 */
public class ShortestPathToGetAllKeys {

    private Set<Character> possibleKeys = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
    private Set<Character> possibleGates = new HashSet<>(Arrays.asList('A', 'B', 'C', 'D', 'E', 'F'));

    private Map<String, Integer> cache = new HashMap<>();

    private int bestPath = Integer.MAX_VALUE;

    /**
     * I'm thinking a bfs
     * Base cases:
     * Are out of bounds
     * are you've previously visited a cell
     * Found a key - this should reset visited cells
     * stumbled upon a door without a key
     * got all keys
     * visited everything but don't have all the keys
     * are at a wall
     */

    //iterative
    public int shortestPathAllKeys(String[] grid) {
        this.possibleKeys = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
        //find starting point
        //find number of keys
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int startingRow = -1;
        int startingCol = -1;
        int numberOfKeys = 0;
        Set<Character> possibleKeys = this.possibleKeys;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char currentChar = grid[i].charAt(j);
                if (currentChar == '@') {
                    startingRow = i;
                    startingCol = j;
                }
                if (possibleKeys.contains(currentChar)) {
                    numberOfKeys++;
                }
            }
        }
        final int keyCount = numberOfKeys;
        if (startingRow == -1 || startingCol == -1) {
            return -1;
        }
        if (numberOfKeys == 0) {
            return 0;
        }
        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(startingRow, startingCol, new HashSet<>(), new HashSet<>(), 0));
        while (!queue.isEmpty()) {
            Data data = queue.remove();

            int row = data.row;
            int col = data.col;
            if (outOfBounds(grid, row, col)) {
                continue;
            }

            char currentChar = grid[row].charAt(col);
            if (isWall(currentChar)) {
                continue;
            }

            String location = data.location;
            Set<String> visitedCells = data.visited;

            if (visitedCells.contains(location)) {
                continue;
            }

            Set<Character> keys = data.keys;
            if (this.possibleGates.contains(currentChar) && isLockedDoor(currentChar, keys)) {
                continue;
            }

            if (isEmptyCell(currentChar) || isStartingCell(currentChar) || isUnlockedDoor(currentChar, keys) || isVisitedKey(currentChar, keys)) {
                visitedCells.add(location);
                //enqueue north south east west
                int distanceTraveled = data.distanceTraveled;
                queue.add(new Data(row - 1, col, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                queue.add(new Data(row + 1, col, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                queue.add(new Data(row, col + 1, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                queue.add(new Data(row, col - 1, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));

            } else if (isKey(currentChar)) {
                //is key
                keys.add(currentChar);
                if (numberOfKeys == keys.size()) {
                    return data.distanceTraveled;
                } else {
                    //more keys remain
                    visitedCells = new HashSet<>();
                    visitedCells.add(location);
                    int distanceTraveled = data.distanceTraveled;
                    queue.add(new Data(row - 1, col, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                    queue.add(new Data(row + 1, col, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                    queue.add(new Data(row, col + 1, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                    queue.add(new Data(row, col - 1, new HashSet<>(visitedCells), new HashSet<>(keys), distanceTraveled + 1));
                }
            }

        }


        return -1;
    }

    static class Data {
        int row;
        int col;
        String location;
        Set<String> visited;
        Set<Character> keys;
        int distanceTraveled;

        public Data(int row, int col, Set<String> visited, Set<Character> keys, int distanceTraveled) {
            this.row = row;
            this.col = col;
            this.location = row + ":" + col;
            this.visited = visited;
            this.keys = keys;
            this.distanceTraveled = distanceTraveled;
        }
    }

    public int shortestPathAllKeysRecursive(String[] grid) {
        this.possibleKeys = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
        //find starting point
        //find number of keys
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int startingRow = -1;
        int startingCol = -1;
        int numberOfKeys = 0;
        Set<Character> possibleKeys = this.possibleKeys;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char currentChar = grid[i].charAt(j);
                if (currentChar == '@') {
                    startingRow = i;
                    startingCol = j;
                }
                if (possibleKeys.contains(currentChar)) {
                    numberOfKeys++;
                }
            }
        }
        if (startingRow == -1 || startingCol == -1) {
            return -1;
        }
        if (numberOfKeys == 0) {
            return 0;
        }
        return shortestPathHelper(grid, startingRow, startingCol, new HashSet<>(), new HashSet<>(), numberOfKeys, 0);
    }

    public int shortestPathHelper(String[] grid, int row, int col, Set<String> visitedCells, Set<Character> keys, int numberOfKeys, int numberOfSteps) {
        if (outOfBounds(grid, row, col)) {
            return -1;
        }

        char currentChar = grid[row].charAt(col);
        if (isWall(currentChar)) {
            return -1;
        }


        if (numberOfSteps > bestPath) {
            return -1;
        }


        String location = row + ":" + col;

        if (cache.containsKey(location)) {
            return cache.get(location);
        }
        if (visitedCells.contains(location)) {
            return -1;
        }
        if (this.possibleGates.contains(currentChar) && isLockedDoor(currentChar, keys)) {
            return -1;
        }

        if (isEmptyCell(currentChar) || isStartingCell(currentChar) || isUnlockedDoor(currentChar, keys) || isVisitedKey(currentChar, keys)) {
            visitedCells.add(location);
            int shortestPath = visitAdjacentCells(grid, row, col, visitedCells, keys, numberOfKeys, numberOfSteps);
            if (shortestPath == -1) {
                return -1;
            }
            return 1 + shortestPath;
        } else if (isKey(currentChar)) {
            //is key
            keys.add(currentChar);
            if (numberOfKeys == keys.size()) {
                return 0;
            } else {
                //more keys remain
                visitedCells = new HashSet<>();
                visitedCells.add(location);
                int shortestPath = visitAdjacentCells(grid, row, col, visitedCells, keys, numberOfKeys, numberOfSteps);
                if (shortestPath == -1) {
                    return -1;
                }
                return 1 + shortestPath;
            }
        }
        return -1;

    }

    private boolean isVisitedKey(char currentChar, Set<Character> keys) {
        return this.possibleKeys.contains(currentChar) && keys.contains(currentChar);
    }


    private boolean isUnlockedDoor(char currentChar, Set<Character> keys) {
        return this.possibleGates.contains(currentChar) && keys.contains(Character.toLowerCase(currentChar));
    }

    private boolean isLockedDoor(char currentChar, Set<Character> keys) {
        return !keys.contains(Character.toLowerCase(currentChar));
    }

    private boolean isStartingCell(char currentChar) {
        return '@' == currentChar;
    }

    private boolean isKey(char currentChar) {
        return this.possibleKeys.contains(currentChar);
    }

    private int visitAdjacentCells(String[] grid, int row, int col, Set<String> visitedCells, Set<Character> keys, int numberOfKeys, int numberOfSteps) {
        int currentBestPath = -1;
        if (numberOfSteps > bestPath) {
            return -1;
        }
        //go north
        int northPath;
        if (outOfBounds(grid, row - 1, col)/* || visitedCells.contains((row - 1) + ":" + col)*/) {
            northPath = -1;
        } else {
            northPath = shortestPathHelper(grid, row - 1, col, new HashSet<>(visitedCells), new HashSet<>(keys), numberOfKeys, numberOfSteps + 1);

        }
        if (northPath != -1) {
            currentBestPath = northPath;
        }

        //go south
        int southPath;
        if (outOfBounds(grid, row + 1, col)/* || visitedCells.contains((row - 1) + ":" + col)*/) {
            southPath = -1;
        } else {
            southPath = shortestPathHelper(grid, row + 1, col, new HashSet<>(visitedCells), new HashSet<>(keys), numberOfKeys, numberOfSteps + 1);
        }
        if (southPath != -1) {
            if (currentBestPath == -1) {
                currentBestPath = southPath;
            } else {
                currentBestPath = Math.min(currentBestPath, southPath);
            }
        }

        //go east
        int eastPath;
        if (outOfBounds(grid, row, col + 1) /*|| visitedCells.contains((row) + ":" + (col + 1))*/) {
            eastPath = -1;
        } else {
            eastPath = shortestPathHelper(grid, row, col + 1, new HashSet<>(visitedCells), new HashSet<>(keys), numberOfKeys, numberOfSteps + 1);
        }
        if (eastPath != -1) {
            if (currentBestPath == -1) {
                currentBestPath = eastPath;
            } else {
                currentBestPath = Math.min(currentBestPath, eastPath);
            }
        }

        // go west
        int westPath;
        if (outOfBounds(grid, row, col - 1) /*|| visitedCells.contains((row) + ":" + (col - 1))*/) {
            westPath = -1;
        } else {
            westPath = shortestPathHelper(grid, row, col - 1, new HashSet<>(visitedCells), new HashSet<>(keys), numberOfKeys, numberOfSteps + 1);
        }
        if (westPath != -1) {
            if (currentBestPath == -1) {
                currentBestPath = westPath;
            } else {
                currentBestPath = Math.min(currentBestPath, westPath);
            }
        }
        if (currentBestPath != -1) {
            this.bestPath = Math.min(currentBestPath + numberOfSteps + 1, bestPath);
        }
        return currentBestPath;
    }

    private boolean isEmptyCell(char currentChar) {
        return '.' == currentChar;
    }

    private boolean isWall(char currentChar) {
        return '#' == currentChar;
    }

    private boolean outOfBounds(String[] grid, int row, int col) {
        if (row < 0 || row >= grid.length) {
            return true;
        }
        return col < 0 || col >= grid[0].length();
    }
}
