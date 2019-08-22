# From the longest

https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

函数递归必然会dfs，这里应该是bfs,那就应该是类似Queue

结果这题最终还是用dfs了，用条件控制dfs次数尽可能少，就没了，bfs由于在运行过程中会将短的结果塞到长的之前，因此不能适用