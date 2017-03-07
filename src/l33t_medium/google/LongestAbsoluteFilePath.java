package l33t_medium.google;
/**
 * https://leetcode.com/problems/longest-absolute-file-path
 * 
 * #388
 * 
 * @author qiaozhizhao
 */

import java.util.Stack;


public class LongestAbsoluteFilePath {

	class Dir {
		int depth = 0;
		int length = 0;

		Dir(int depth, int length) {
			this.depth = depth;
			this.length = length;
		}
	}

	public int lengthLongestPath(String input) {
		String[] dirs = input.split("\n");
		Stack<Dir> stack = new Stack<Dir>();
		int cur = 0;
		int max = 0;
		for (String s : dirs) {
			int depth = numOfIndent(s);
			int length = s.length() - depth;
			while (!stack.empty() && stack.peek().depth >= depth) {
				cur = cur - stack.peek().length - 1;
				stack.pop();
			}
			if (s.contains(".")) {
				// cur += length; BUG: do not add file length
				max = Math.max(max, cur + length);
			} else {
				stack.push(new Dir(depth, length));
				cur = cur + length + 1;
			}
		}
		return max;
	}

	static int numOfIndent(String s) {
		int ret = 0;
		while (s.startsWith("\t")) {
			s = s.substring(1);
			ret++;
		}
		return ret;
	}

}
