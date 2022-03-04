package com.company.Study.QueueAndStack.Summay;

/**
 * 钥匙和房间
 *
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 *
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 *
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 *
 * 你可以自由地在房间之间来回走动。
 *
 * 如果能进入每个房间返回 true，否则返回 false。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/queue-stack/gle1r/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.*;

public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> deque = new LinkedList<>();
        boolean[] visit = new boolean[rooms.size()];
        for (Integer integer : rooms.get(0)) {
            deque.offer(integer);
        }
        rooms.get(0).clear();
        visit[0] = true;
        while (!deque.isEmpty()){
            int temp = deque.poll();
            visit[temp] = true;
            if (!rooms.get(temp).isEmpty()){
                for (Integer integer : rooms.get(temp)) {
                    deque.offer(integer);
                }
                rooms.get(temp).clear();
            }
        }
        for (boolean b : visit) {
            if (!b){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        list.add(1);
        rooms.add(list);
        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        rooms.add(list2);
        List<Integer> list3 = new LinkedList<>();
        list3.add(3);
        rooms.add(list3);
        List<Integer> list4 = new LinkedList<>();
        rooms.add(list4);
        CanVisitAllRooms canVisitAllRooms = new CanVisitAllRooms();
        canVisitAllRooms.canVisitAllRooms(rooms);
    }
}
