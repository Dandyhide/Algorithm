package com.company.Study.QueueAndStack.Queue;

import java.util.*;

/**
 * 打开转盘锁
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 *
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 *
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 *
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 *
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 *
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * 示例 4:
 *
 * 输入: deadends = ["0000"], target = "8888"
 * 输出：-1
 *  
 *
 * 提示：
 *
 * 1 <= deadends.length <= 500
 * deadends[i].length == 4
 * target.length == 4
 * target 不在 deadends 之中
 * target 和 deadends[i] 仅由若干位数字组成
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/queue-stack/kj48j/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(deadends));
        Set<String> visit = new HashSet<>();
        int result = 0;
        if (target.equals("0000")){
            return 0;
        }
        if (set.contains("0000")){
            return -1;
        }
        queue.add("0000");
        visit.add("0000");
        while (!queue.isEmpty()){
            result++;
            int size = queue.size();
            while (size-- > 0){
                String data = queue.poll();
                for (int i = 0; i < 4; i++){
                    String temp = GetNext(data, i, true);
                    if (!set.contains(temp) && !visit.contains(temp)){
                        if (temp.equals(target)){
                            return result;
                        }
                        visit.add(temp);
                        queue.add(temp);
                    }
                    temp = GetNext(data, i, false);
                    if (!set.contains(temp) && !visit.contains(temp)){
                        if (temp.equals(target)){
                            return result;
                        }
                        visit.add(temp);
                        queue.add(temp);
                    }
                }
            }
        }
        return -1;
    }

    private String GetNext(String target, int i, boolean flag) {
        char temp = target.charAt(i);
        if (flag){
            if (temp == '9'){
                temp = '0';
            }else{
                temp = (char)(temp + 1);
            }
        }else{
            if (temp == '0'){
                temp = '9';
            }else{
                temp = (char)(temp - 1);
            }
        }
        return target.substring(0, i) + (temp+"") + target.substring(i + 1);
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"0009","0201","0101","0102","1212","2002"};
        String target = "0202";
        OpenLock openLock = new OpenLock();
        openLock.openLock(deadends, target);
    }
}
