package org.genug.algorithm.cls;

import org.genug.algorithm.Main;

import java.io.*;
import java.util.*;

public class Class2 {
    public void palindromeNumber() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0"))
                break;
            char[] chars = input.toCharArray();
            boolean flag = false;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != chars[chars.length-1-i]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("no");
                continue;
            }
            System.out.println("yes");
        }
    }

    public void willBeWomenPresident() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        while (testCaseCount > 0) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int[] currentFloor = new int[n];
            int[] downStairs = null;
            for (int i = 0; i <= k; i++) {
                if (i == 0) {
                    for (int j = 0; j < currentFloor.length; j++) {
                        currentFloor[j] = j + 1;
                    }
                } else {
                    downStairs = currentFloor;
                    currentFloor = new int[n];
                    for (int t = 0; t < currentFloor.length; t++) {
                        for (int l = 0; l <= t; l++) {
                            currentFloor[t] += downStairs[l];
                        }
                    }
                }
            }
            System.out.println(currentFloor[currentFloor.length - 1]);
            testCaseCount--;
        }
    }

    public void deliverySugar() {
        Scanner scanner = new Scanner(System.in);
        int sugar = scanner.nextInt();
        int count = 0;
        boolean flag = false;
        while (true) {
            if (sugar == 0) {
                break;
            } else if (sugar >= 5 && !flag) {
                count = sugar/5;
                if ((sugar % 5) == 0) {
                    break;
                } else {
                    while (count > 0) {
                        int temp = sugar;
                        temp -= (count * 5);
                        temp %= 3;
                        if (temp == 0) {
                            count += (sugar - count*5) / 3;
                            sugar = 0;
                            break;
                        }
                        count--;
                    }
                }
                flag = true;
            } else {
                count = sugar/3;
                if ((sugar % 3) > 0) {
                    count = -1;
                }
                break;
            }
        }
        System.out.println(count);
    }

    public void queue() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            int back = 0;
            while(count > 0) {
                String[] commands = br.readLine().split("\\s+");
                switch (commands[0]) {
                    case "push":
                        back = Integer.parseInt(commands[1]);
                        queue.add(back);
                        break;
                    case "pop":
                        if (queue.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(queue.poll() + "\n");
                        break;
                    case "size":
                        bw.write(queue.size() + "\n");
                        break;
                    case "empty":
                        if (queue.isEmpty())
                            bw.write(1 + "\n");
                        else
                            bw.write(0 + "\n");
                        break;
                    case "front":
                        if (queue.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(queue.peek() + "\n");
                        break;
                    case "back":
                        if (queue.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(back + "\n");
                        break;
                }
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch (IOException ioe) {};
            try { bw.close(); } catch (IOException ioe) {};
        }
    }

    public void deque() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            int back = 0;
            while(count > 0) {
                String[] commands = br.readLine().split("\\s+");
                switch (commands[0]) {
                    case "push_front":
                        deque.addFirst(Integer.parseInt(commands[1]));
                        break;
                    case "push_back":
                        deque.addLast(Integer.parseInt(commands[1]));
                        break;
                    case "pop_front":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.removeFirst() + "\n");
                        break;
                    case "pop_back":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.removeLast() + "\n");
                        break;
                    case "size":
                        bw.write(deque.size() + "\n");
                        break;
                    case "empty":
                        if (deque.isEmpty())
                            bw.write(1 + "\n");
                        else
                            bw.write(0 + "\n");
                        break;
                    case "front":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.peekFirst() + "\n");
                        break;
                    case "back":
                        if (deque.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(deque.peekLast() + "\n");
                        break;
                    case "list":
                        bw.write(deque.toString());
                        break;
                }
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch (IOException ioe) {};
            try { bw.close(); } catch (IOException ioe) {};
        }
    }

    public void ex_2869() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] line = br.readLine().split("\\s+");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            int v = Integer.parseInt(line[2]);
            int days = v / (a-b);
            int remain = v % (a-b);
//            if ((a-b) > v)
//                remain *= -1;
            int x = 0;
            if(a >= v) {
                x = 1;
            } else {
                System.out.println(days + " " + remain);
                int temp;
                x = v + remain + b;
                System.out.println(x + " = " + v + " + " + remain + " + " + b);
                temp = x;
                x = x - v;
                System.out.println(x + " = " + temp + " - " + v);
                temp = x;
                x = v - x;
                System.out.println(x + " = " + v + " - " + temp);
                System.out.println((x < a) + " = x < a");
                if (x < a)
                    x--;
            }
            System.out.println(x);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch(IOException ioe) {}
        }
    }

    // 18111 (?????????)
    public void minecraft() {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        int m = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);
        int inven = Integer.parseInt(line[2]);

        Map<Integer, Integer> map = new TreeMap<>();
        // Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            String[] blocks = scanner.nextLine().split("\\s+"); // ????????? ??? ????????????
            for (int j = 0; j < n; j++) {
                int height = Integer.parseInt(blocks[j]);
                if (map.containsKey(height)) {
                    map.replace(height, map.get(height) + 1);
                } else {
                    map.put(height, 1);
                }
            }
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            int blockAmount = inven;
            Map.Entry<Integer, Integer> entry = iterator.next();
            while (iterator.hasNext()) {
                entry.getValue();
            }
        }
        System.out.println(map.toString());
    }

    // 1181 - ????????????
    public void sortWords() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Map<Integer, List<String>> map = new TreeMap<>();
        while (count > 0) {
            String word = scanner.next();
            List<String> list = null;
            if (map.containsKey(word.length())) {
                list = map.get(word.length());
                if (!list.contains(word))
                    list.add(word);
            } else {
                list = new ArrayList<>();
                list.add(word);
                map.put(word.length(), list);
            }
            count--;
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            List<String> list = entry.getValue();
            Collections.sort(list);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    // 2164 - ??????2
    public void card2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }

    // 1874 - ?????? ??????
    public void stackSequence() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> push = new Stack<>();
        Queue<Integer> queue = new LinkedList<>();
        while (n > 0) {
            queue.add(scanner.nextInt());
            n--;
        }
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (!queue.isEmpty()) {
            int m = queue.poll();
            int i = m - p;
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    push.push(++p);
                    sb.append("+").append("\n");
                }
            }
            int t = push.pop();
            if (t == m) {
                sb.append("-");
            } else {
                sb.setLength(0);
                sb.append("NO");
                break;
            }
            if (!queue.isEmpty())
                sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public void unknownEx() {
        Scanner scanner = new Scanner(System.in);
        String[] lines = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(lines[0]);
        int m = Integer.parseInt(lines[1]);

        lines = scanner.nextLine().split("\\s+");
        List<Integer> list = new ArrayList<>();
        for (String num : lines) {
            list.add(Integer.parseInt(num));
        }
        List<Integer> totals = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                for (int t = j; t < list.size(); t++) {
                    if (i != j && t != j) {
                        int total = list.get(i) + list.get(j) + list.get(t);
                        if (total <= m) {
                            // System.out.println(i + " " + j + " " + t);
                            totals.add(total);
                        }
                    }
                }
            }
        }
        totals.sort(Collections.reverseOrder());
        System.out.println(totals.get(0));
    }

    // 1966 - ????????? ???
    public void printerQueue() {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = Integer.parseInt(scanner.nextLine());
        while (testCaseCount > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            line = scanner.nextLine().split("\\s+");
            Queue<Document> queue = new LinkedList<>();
            Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                int p = Integer.parseInt(line[i]);
                queue.add(new Document(p, i == m));
                priorityQueue.add(p);
            }

            int result = 0;
            while (!priorityQueue.isEmpty()) {
                int i = priorityQueue.peek(); // ??????????????? ??? ?????? ?????????
                Document document = queue.poll();
                if (document.importance == i) {
                    priorityQueue.poll();
                    result++;
                    if (document.flag)
                        break;
                } else {
                    queue.add(document);
                }
            }

            System.out.println(result);
            testCaseCount--;
        }

    }

    class Document {
        int importance;
        boolean flag;
        public Document (int importance, boolean flag) {
            this.importance = importance;
            this.flag = flag;
        }
    }

    // 2609 - ??????????????? ???????????????
    public void ex_2609() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int max = 0;
        int min = 0;
        if (n > m) {
            max = n;
            min = m;
        } else {
            max = m;
            min = n;
        }
        for (int i = min; i > 0; i--) {
            if (min % i == 0) {
                int t = min / i;
                if (max % i == 0) {
                    System.out.println("??????????????? : " + i);
                    break;
                }
            }
        }

        int count = 1;
        while (true) {
            int multiple = count * max;
            if (multiple % min == 0) {
                System.out.println("??????????????? : " + multiple);
                break;
            }
            count++;
        }

    }

    // 2805 - ?????? ?????????
    // ????????? ????????? ????????? ?????? ????????? ???????????? ?????? ?????? ???????????? ?????? ???????????????.
    public void cutTrees() {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long max = 0;
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long input = scanner.nextLong();
            max = Math.max(input, max);
            list.add(input);
        }
        list.sort(Collections.reverseOrder());

        long temp = 0;
        List<Long> ranges = new ArrayList<>();
        for (Long i : list) {
            if (temp > 0)
                ranges.add(temp - i);
            temp = i;
        }
        ranges.add(temp);

        long multiple = 0;
        for (Long range : ranges) {
            multiple++;
            long treesCount = multiple * range;
            if(treesCount > m) {
                long t = m/multiple;
                if (m%multiple > 0) {
                    t++;
                }
                max -= t;
                break;
            } else {
                m -= treesCount;
                max -= range;
            }
        }
        System.out.println(max);
    }

    // 10773 - ??????
    public void zero() {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        while (k > 0) {
            int n = scanner.nextInt();
            if ( n > 0)
                stack.push(n);
            else
                stack.pop();
            k--;
        }
        // System.out.println(stack.toString());
        int result = 0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        System.out.println(result);
    }

    // 11866 - ???????????? ?????? 0
    public void josephus() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int count = 0;
        List<Integer> josephus = new ArrayList<>();
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (++count < k) {
                queue.add(i);
            } else {
                count = 0;
                josephus.add(i);
            }
        }

        System.out.print("<");
        for (int i = 0; i < josephus.size(); i++) {
            System.out.print(josephus.get(i));
            if (i < josephus.size()-1) {
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }

    // 10828 - ??????
    public void stack() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int count = Integer.parseInt(br.readLine());
            Stack<Integer> stack = new Stack<>();
            while(count > 0) {
                String[] commands = br.readLine().split("\\s+");
                switch (commands[0]) {
                    case "push":
                        stack.push(Integer.parseInt(commands[1]));
                        break;
                    case "pop":
                        if (stack.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(stack.pop() + "\n");
                        break;
                    case "size":
                        bw.write(stack.size() + "\n");
                        break;
                    case "empty":
                        if (stack.isEmpty())
                            bw.write(1 + "\n");
                        else
                            bw.write(0 + "\n");
                        break;
                    case "top":
                        if (stack.isEmpty())
                            bw.write(-1 + "\n");
                        else
                            bw.write(stack.peek() + "\n");
                        break;
                }
                count--;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { br.close(); } catch (IOException ioe) {};
            try { bw.close(); } catch (IOException ioe) {};
        }
    }

    // 10989 - ??? ???????????? 3
    public void sortNumber3() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());
            boolean[] arr = new boolean[100000001];
            Map<Integer, Integer> map = new HashMap<>();
            while (n > 0) {
                int i = Integer.parseInt(br.readLine());
                if (!arr[i]) {
                    arr[i] = true;
                } else {
                    if (map.containsKey(i))
                        map.replace(i, map.get(i) + 1);
                    else
                        map.put(i, 2);
                }
                n--;
            }
            for (int i = 1; i < arr.length; i++) {
                if (arr[i])
                    if (map.containsKey(i)) {
                        for (int j = 0; j < map.get(i); j++) {
                            bw.write(i + "\n");
                        }
                    } else
                        bw.write(i + "\n");
            }
            bw.flush();
        } catch (IOException e) {
        } finally {
            try { br.close(); } catch (IOException e) {}
            try { bw.close(); } catch (IOException e) {}
        }
    }

    // 10816 - ?????? ?????? 2
    public void numberCard2() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            int n = Integer.parseInt(br.readLine());

            Map<Integer, Integer> map = new HashMap<>();
            String[] line = br.readLine().split("\\s+");
            for (String s : line) {
                int i = Integer.parseInt(s);
                if (!map.containsKey(i)) {
                    map.put(i, 0);
                }
                map.replace(i, map.get(i) + 1);
            }
            int m = Integer.parseInt(br.readLine());
            line = br.readLine().split("\\s+");
            for (String s : line) {
                int i = Integer.parseInt(s);
                int j = map.get(i) == null ? 0 : map.get(i);
                bw.write(j + " ");
                m--;
            }
            bw.flush();
        } catch (IOException e) {
        } finally {
            try { br.close(); } catch (IOException e) {}
            try { bw.close(); } catch (IOException e) {}
        }
    }

    // 1920 - ??? ??????
    public void findNumber() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            br.readLine();
            Map<Integer, Integer> map = new HashMap<>();
            String[] line = br.readLine().split("\\s+");
            for (String s : line) {
                map.put(Integer.parseInt(s),1);
            }
            br.readLine();
            line = br.readLine().split("\\s+");
            for (String s : line) {
                int i = Integer.parseInt(s);
                int j = map.get(i) == null ? 0 : map.get(i);
                bw.write(j + "\n");
            }
            bw.flush();
        } catch (IOException e) {
        } finally {
            try { br.close(); } catch (IOException e) {}
            try { bw.close(); } catch (IOException e) {}
        }
    }

    // 4949 - ???????????? ??????
    public void balancedWorld() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            while (true) {
                String input = br.readLine();
                if (input.equals("."))
                    break;
                char[] chars = input.toCharArray();
                Stack<Character> stack = new Stack<>();
                boolean flag = true;
                for (char c : chars) {
                    try {
                        switch (c) {
                            case '[':
                            case '(':
                                stack.push(c);
                                break;
                            case ']':
                                char ch = stack.pop();
                                if (ch != '[')
                                    throw new EmptyStackException();
                                break;
                            case ')':
                                ch = stack.pop();
                                if (ch != '(')
                                    throw new EmptyStackException();
                                break;
                        }
                    } catch (EmptyStackException e) {
                        flag = false;
                        break;
                    }
                }
                if (flag && stack.isEmpty())
                    bw.write("yes" + "\n");
                else
                    bw.write("no" + "\n");
                bw.flush();
            }
        } catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
            try { bw.close(); } catch (IOException ignored) {}
        }
    }


    // 1654 - ?????? ????????? (????????? - ?????????) ????????????
    public int cableCount;
    public void cutLanCable() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String[] input = br.readLine().split("\\s+");
            int k = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            int totalLength = 0;
            List<Integer> cables = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                int cable = Integer.parseInt(br.readLine());
                totalLength += cable;
                cables.add(cable);
            }

            int min = 0;
            int max = 0;
            int cableLength = totalLength / n;
            while (true) {
                // System.out.println("?????? ??????(" + max + ", " + min + ") : " + cableLength + "(cm)");
                cableCount = 0;
                for (int length : cables) {
                    // System.out.println(length + " : " + length / cableLength + " ");
                    cableCount += length / cableLength;
                }
                // System.out.println(cableLength + "(cm) ??? ?????? ??? ?????? ?????? ??? :" + cableCount);
                if (cableCount < n) {
                    max = cableLength;
                    cableLength -= (max-min)/2;
                } else if (cableCount > n) {
                    min = cableLength;
                    cableLength += (max-min)/2;
                } else {
                    // System.out.println("??????");
                    int tempCableLength = cableLength;
                    int tempMax;
                    while (true) {
                        tempMax = tempCableLength;
                        tempCableLength -= (tempMax-min)/2;
                        int tempCableCount = 0;
                        for (int length : cables) {
                            // System.out.println(length + " : " + length / tempCableLength + " ");
                            tempCableCount += length / tempCableLength;
                        }
                        // System.out.println(tempCableLength + "(cm) ??? ?????? ??? ?????? ?????? ??? :" + tempCableCount);
                        if (cableCount == tempCableCount) {
                            if (cableLength < tempCableLength)
                                cableLength = tempCableLength;
                        } else {
                            break;
                        }
                    }
                    tempCableLength = cableLength;
                    int tempMin;
                    while (true) {
                        tempMin = tempCableLength;
                        tempCableLength += (max-tempMin)/2;
                        int tempCableCount = 0;
                        for (int length : cables) {
                            // System.out.println(length + " : " + length / tempCableLength + " ");
                            tempCableCount += length / tempCableLength;
                        }
                        // System.out.println(tempCableLength + "(cm) ??? ?????? ??? ?????? ?????? ??? :" + tempCableCount);
                        if (cableCount == tempCableCount) {
                            if (cableLength < tempCableLength)
                                cableLength = tempCableLength;
                        } else {
                            break;
                        }
                    }
                    break;
                }
                // System.out.println(cableCount);
                // System.out.println();
            }
            bw.write(cableLength);
            bw.flush();
        } catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
            try { bw.close(); } catch (IOException ignored) {}
        }
    }
/*
    public int getLength(List<Integer> cables, int cableLength) {
        int tempCableCount = 0;
        for (int length : cables) {
            cableCount += length / cableLength;
        }
        // System.out.println(cableLength + "(cm) ??? ?????? ??? ?????? ?????? ??? :" + cableCount);
        if (cableCount == tempCableCount) {
            if (cableLength < tempCableLength)
                cableLength = tempCableLength;
        } else {
            break;
        }
    }

 */

    // ?????? ??????
    public void findPrimeNumber() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        try {
            String[] line = br.readLine().split("\\s+");
            int m = Integer.parseInt(line[0]);
            int n = Integer.parseInt(line[1]);
            for (; m <= n; m++) {
                boolean flag = true;
                if (m == 1) continue;
                for (int i = 2; i*i <= m; i++) {
                    if (m%i == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    bw.write(m + "\n");
                bw.flush();
            }
        } catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
            try { bw.close(); } catch (IOException ignored) {}
        }
    }

    // 10814 - ????????? ??????
    public void sortByAge() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Queue<String>> map = new TreeMap<>();
            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split("\\s+");
                int age = Integer.parseInt(input[0]);
                String name = input[1];
                if (!map.containsKey(age))
                    map.put(age, new LinkedList<>());
                map.get(age).add(name);
            }
            for (Map.Entry<Integer, Queue<String>> entry : map.entrySet()) {
                Queue<String> names = entry.getValue();
                while (!names.isEmpty()) {
                    System.out.println(entry.getKey() + " " + names.poll());
                }
            }
        }catch (IOException ignored) {
        } finally {
            try { br.close(); } catch (IOException ignored) {}
        }
    }
}
