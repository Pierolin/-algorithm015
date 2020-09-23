package algorithm015.Week_05;

public class RobotSim {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] position = new int[]{0, 0};
        String directionTo = "North";
        int max = 0;
        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];
            if (command == -1 || command == -2) {
                // 改变方向
                directionTo = turnDirection(directionTo, command);
            } else {
                // 前进并修正最大值
                position = goAhead(directionTo, command, position, obstacles);
                max = Math.max(max, position[0] * position[0] + position[1] * position[1]);
            }
        }
        return max;
    }

    private int[] goAhead(String directionTo, int command, int[] position, int[][] obstacles) {
        int x = position[0];
        int y = position[1];
        switch (directionTo) {
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

    private String turnDirection(String directionTo, int command) {
        if (command == -1) {
            switch (directionTo) {
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
            switch (directionTo) {
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
        return directionTo;
    }
}
