package algorithm015.Week_05;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RobotSim {
    public int robotSim_2(int[] commands, int[][] obstacles) {
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int d = 0;

        int x = 0;
        int y = 0;

        int max = 0;

        for (int command : commands) {
            if (command == -1) {
                d = (d + 1) % 4;
            } else if (command == -2) {
                d = (d + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    if (!obstacleSet.contains((x + directions[d][0]) + "," + (y + directions[d][1]))) {
                        x = x + directions[d][0];
                        y = y + directions[d][1];
                    }
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

    /*

     */
    public int robotSim_1(int[] commands, int[][] obstacles) {
        // 创建 hash 表便于检测障碍
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + "," + obs[1]);
        }
        // 创建 hash 表便于获取当前方向
        Map<String, String> directionMap = createDirectionMap();
        // 定义当前位置坐标
        int[] position = new int[]{0, 0};
        // 定义当前方向
        String direction = "North";
        // 存储最大值
        int max = 0;

        for (int command : commands) {
            if (command == -1 || command == -2) {
                // 改变方向
                // direction = turnDirection(direction, command);
                direction = directionMap.get(direction + command);
            } else {
                // 前进并修正最大值
                //position = goAhead(direction, command, position, obstacles);
                position = goTo(direction, command, position, set);
                max = Math.max(max, position[0] * position[0] + position[1] * position[1]);
            }
        }
        return max;
    }

    private Map<String, String> createDirectionMap() {
        Map<String, String> map = new HashMap<>();
        // 向左转
        map.put("North-1", "East");
        map.put("East-1", "South");
        map.put("South-1", "West");
        map.put("West-1", "North");
        // 向右转
        map.put("North-2", "West");
        map.put("West-2", "South");
        map.put("South-2", "East");
        map.put("East-2", "North");
        return map;
    }

    private int[] goTo(String direction, int command, int[] position, Set<String> set) {
        int x = position[0];
        int y = position[1];
        switch (direction) {
            case "North":
                for (int i = 0; i < command; i++) {
                    if (set.contains(x + "," + (y + 1))) {
                        break;
                    }
                    y++;
                }
                break;
            case "South":
                for (int i = 0; i < command; i++) {
                    if (set.contains(x + "," + (y - 1))) {
                        break;
                    }
                    y--;
                }
                break;
            case "East":
                for (int i = 0; i < command; i++) {
                    if (set.contains((x + 1) + "," + y)) {
                        break;
                    }
                    x++;
                }
                break;
            case "West":
                for (int i = 0; i < command; i++) {
                    if (set.contains((x - 1) + "," + y)) {
                        break;
                    }
                    x--;
                }
                break;
        }
        position[0] = x;
        position[1] = y;
        return position;
    }

    private String turnDirection(String direction, int command) {
        if (command == -1) {
            switch (direction) {
                case "North":
                    return "East";
                case "East":
                    return "South";
                case "South":
                    return "West";
                case "West":
                    return "North";
            }
        }

        if (command == -2) {
            switch (direction) {
                case "North":
                    return "West";
                case "West":
                    return "South";
                case "South":
                    return "East";
                case "East":
                    return "North";
            }
        }
        return direction;
    }

    private int[] goAhead(String direction, int command, int[] position, int[][] obstacles) {
        int x = position[0];
        int y = position[1];
        switch (direction) {
            case "North":
                for (int[] obstacle : obstacles) {
                    if (obstacle[0] == x && y < obstacle[1] && y + command >= obstacle[1]) {
                        y = obstacle[1] - 1;
                        return new int[]{x, y};
                    }
                }
                y += command;
                break;
            case "East":
                for (int[] obstacle : obstacles) {
                    if (obstacle[1] == y && x < obstacle[0] && x + command >= obstacle[0]) {
                        x = obstacle[0] - 1;
                        return new int[]{x, y};
                    }
                }
                x += command;
                break;
            case "South":
                for (int[] obstacle : obstacles) {
                    if (obstacle[0] == x && y > obstacle[1] && y - command <= obstacle[1]) {
                        y = obstacle[1] + 1;
                        return new int[]{x, y};
                    }
                }
                y -= command;
                break;
            case "West":
                for (int[] obstacle : obstacles) {
                    if (obstacle[1] == y && x > obstacle[0] && x - command <= obstacle[0]) {
                        x = obstacle[0] + 1;
                        return new int[]{x, y};
                    }
                }
                x -= command;
                break;
        }
        return new int[]{x, y};
    }


}
