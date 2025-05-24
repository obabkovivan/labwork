package org.example.labwork3.timus;

import java.util.*;

public class Task1002 {
    private static final Map<Character, Character> letterToDigit = new HashMap<>();

    static {
        String[] mappings = {
                "ij",
                "abc",
                "def",
                "gh",
                "kl",
                "mn",
                "prs",
                "tuv",
                "wxy",
                "oqz"
        };
        for (int i = 0; i < mappings.length; i++) {
            for (char ch : mappings[i].toCharArray()) {
                letterToDigit.put(ch, (char) ('0' + i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String phoneNumber = scanner.nextLine();
            if (phoneNumber.equals("-1")) break;

            int n = Integer.parseInt(scanner.nextLine());
            Map<String, List<String>> digitToWords = new HashMap<>();
            List<String> dictionary = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String word = scanner.nextLine();
                StringBuilder digitForm = new StringBuilder();
                for (char ch : word.toCharArray()) {
                    digitForm.append(letterToDigit.get(ch));
                }
                digitToWords.computeIfAbsent(digitForm.toString(), k -> new ArrayList<>()).add(word);
                dictionary.add(word);
            }

            int len = phoneNumber.length();
            String[] dpWords = new String[len + 1];
            int[] dp = new int[len + 1];
            int[] prev = new int[len + 1];

            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;

            for (int i = 0; i < len; i++) {
                if (dp[i] == Integer.MAX_VALUE) continue;
                for (int j = i + 1; j <= len && j - i <= 50; j++) {
                    String segment = phoneNumber.substring(i, j);
                    if (digitToWords.containsKey(segment)) {
                        for (String word : digitToWords.get(segment)) {
                            if (dp[j] > dp[i] + 1) {
                                dp[j] = dp[i] + 1;
                                dpWords[j] = word;
                                prev[j] = i;
                            }
                        }
                    }
                }
            }

            if (dp[len] == Integer.MAX_VALUE) {
                System.out.println("No solution.");
            } else {
                List<String> result = new ArrayList<>();
                for (int i = len; i > 0; i = prev[i]) {
                    result.add(dpWords[i]);
                }
                Collections.reverse(result);
                System.out.println(String.join(" ", result));
            }
        }
    }
}
