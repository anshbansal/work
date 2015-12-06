package com.anshbansal.algo.snakesAndLadders;

import com.anshbansal.util.InputUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class Node {
//    Not complete yet
//    Need to implement via graph theory

    private int currentPosition = 0;

    private int minimumStepsToReach = Integer.MAX_VALUE;

    private int ladderEnd = 0;

    private int snakeEnd = 0;

    public void setLadderEnd(int end) {

        ladderEnd = end;
    }

    public void setSnakeEnd(int end) {

        snakeEnd = end;
    }

    public Node(int currentPosition) {

        this.currentPosition = currentPosition;
    }

    public int getCurrentPosition() {
        //TODO Update
        return currentPosition;
    }

    public void setStepNumber(int num) {

        minimumStepsToReach = num;
    }

    public int getStepNumber() {

        return minimumStepsToReach;
    }

    public void visit(List<Node> nodeList, int stepNumber) {

        if (stepNumber < minimumStepsToReach) {
            minimumStepsToReach = stepNumber;
        }

        visit(nodeList, ladderEnd, stepNumber);
        visit(nodeList, snakeEnd, stepNumber);
    }

    private static void visit(List<Node> nodeList, int nodeNumber, int stepNumber) {

        if (nodeNumber < 1) {
            return;
        }
        nodeList.get(nodeNumber).visit(nodeList, stepNumber);
    }

    public List<Node> getNodesToVisit(List<Node> nodeList) {

        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= 6 && currentPosition + i < nodeList.size(); i++) {
            nodes.add(nodeList.get(currentPosition + i));
        }
        return nodes;
    }

    public static void setEnd(List<Node> nodeList, Scanner sc, BiConsumer<Node, Integer> setter) {

        int numbers = InputUtil.getInt(sc);
        for (int i = 0; i < numbers; i++) {
            List<Integer> ladderPoints = InputUtil.getIntegers(sc, 2);

            Node nodeToSet = nodeList.get(ladderPoints.get(0) - 1);

            setter.accept(nodeToSet, ladderPoints.get(1) - 1);
        }
    }


    public static List<Node> getNodeList(Scanner sc, int boardSize) {

        List<Node> nodeList = new ArrayList<>(boardSize);
        for (int i = 0; i < boardSize; i++) {
            nodeList.add(new Node(i));
        }

        setEnd(nodeList, sc, Node::setLadderEnd);
        setEnd(nodeList, sc, Node::setSnakeEnd);

        return nodeList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = InputUtil.getInt(sc);

        for (int testCase = 0; testCase < testCases; testCase++) {

            int BOARD_SIZE = 100;

            List<Node> nodeList = Node.getNodeList(sc, BOARD_SIZE);
            nodeList.get(0).setStepNumber(0);

            int prevMinSize = nodeList.get(BOARD_SIZE - 1).getStepNumber();
            int minSize = prevMinSize - 1;
            while (minSize < prevMinSize) {
                prevMinSize = minSize;
                for (Node node : nodeList) {
                    List<Node> nodesToVisit = node.getNodesToVisit(nodeList);

                    for (Node nodeToVisit : nodesToVisit) {
                        nodeToVisit.visit(nodeList, node.getStepNumber() + 1);
                    }
                }
                minSize = nodeList.get(BOARD_SIZE - 1).getStepNumber();
            }
            System.out.println("" + minSize);
        }
    }

    @Override
    public String toString() {

        return "Node{" +
                "currentPosition=" + currentPosition +
                ", minimumStepsToReach=" + minimumStepsToReach +
                ", ladderEnd=" + ladderEnd +
                ", snakeEnd=" + snakeEnd +
                '}';
    }
}
