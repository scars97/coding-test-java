package spartacodingclub.mission.week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DiceYutnori {

    static final int DICE_COUNT = 10;
    static final int HORSE_COUNT = 4;

    static int[] dice, placementOrder; // 주사위, 배치 순서
    static Node[] horse; // 4개의 말
    static Node start; // 시작지점
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        dice = new int[DICE_COUNT + 1];
        placementOrder = new int[DICE_COUNT + 1];
        horse = new Node[HORSE_COUNT + 1];
        for (int i = 1; i <= DICE_COUNT ; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        init(); // 윷놀이판 생성
        permutation(1); // 10개의 주사위 결과를 말에게 할당
        System.out.println(answer);
    }

    private static void permutation(int depth) {
        if (DICE_COUNT < depth) {
            answer = Math.max(answer, gameStart());
            return;
        }

        for (int i = 1; i <= HORSE_COUNT ; i++) {
            placementOrder[depth] = i;
            permutation(depth + 1);
        }
    }

    private static int gameStart() {

        Arrays.fill(horse, start); // 말들을 시작 지점으로 배치
        int score = 0;

        for (int i = 1; i <= DICE_COUNT ; i++) {
            Node current = horse[placementOrder[i]]; // 순열에 할당된 순서대로 말 선택
            current.isEmpty = true; // 현재 칸 비우기
            // 주사위에 나온 수치만큼 이동
            for (int j = 1; j <= dice[i]; j++) {
                if (j == 1 && current.fastPath != null) {
                    current = current.fastPath; // 지름길 이동
                } else {
                    current = current.next; // 둘레길 이동
                }
            }
            horse[placementOrder[i]] = current; // 이동 후, 말 위치 설정

            // 도착하지 않았으며 이미 말이 있는 노드라면 무효처리
            if (!current.isEmpty && !current.isFinish) {
                score = 0;
                break;
            } else {
                current.isEmpty = false;
                score += current.val;
            }
        }

        // 다음 게임을 위해 말 위치 초기화
        for (int i = 1; i <= HORSE_COUNT ; i++) {
            horse[i].isEmpty = true;
        }

        return score;
    }

    private static void init() {
        start = new Node(0); // 시작위치와 점수

        Node temp = start;
        for (int i = 2; i <= 40 ; i+=2) { // 둘레길 경로 설정
            temp = temp.addNext(i);
        }

        // 도착 지점
        Node end = temp.addNext(0);
        end.isFinish = true;
        end.next = end; // 자기 자신 포인트 -> NPE 방지

        // 가운데 교차점 (val = 25)
        Node crossroad = new Node(25);
        // 교차점(25) -> 30 -> 35 -> 40
        temp = crossroad.addNext(30);
        temp = temp.addNext(35);
        temp.next = Node.getNode(start, 40);

        // 10 -> 13 -> 16 -> 19 -> 25(교차점)
        temp = Node.getNode(start, 10);
        temp = temp.fastPath = new Node(13);
        temp = temp.addNext(16);
        temp = temp.addNext(19);
        temp.next = crossroad;

        // 20 -> 22 -> 24 -> 25(교차점)
        temp = Node.getNode(start, 20);
        temp = temp.fastPath = new Node(22);
        temp = temp.addNext(24);
        temp.next = crossroad;

        // 30 -> 28 -> 27 -> 26 -> 25(교차점)
        temp = Node.getNode(start, 30);
        temp = temp.fastPath = new Node(28);
        temp = temp.addNext(27);
        temp = temp.addNext(26);
        temp.next = crossroad;
    }

    static class Node {
        int val;
        boolean isEmpty, isFinish;
        Node next, fastPath;

        Node(int val) {
            this.val = val;
            this.isEmpty = true;
        }

        // 노드 연결
        Node addNext(int value) {
            Node nextNode = new Node(value);
            this.next = nextNode;
            return nextNode;
        }

        // 시작지점부터 탐색해가며 특정 노드를 찾는 메서드
        static Node getNode(Node start, int target) {
            Node temp = start;
            while (true) {
                if (temp == null) {
                    return null;
                }
                if (temp.val == target) {
                    return temp;
                }
                temp = temp.next;
            }
        }
    }
}
