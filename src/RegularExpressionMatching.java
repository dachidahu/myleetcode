public class RegularExpressionMatching {
    public static boolean  isMatch(String s, String p) {

        if (match(s.toCharArray(),0, p.toCharArray(), 0) > 0)
            return true;
        return false;
    }


    static  int match(char[] s, int si, char[] p, int pi) {
        if (si == s.length && pi == p.length) {
            return 1;
        }
        else if(si >= s.length)
            return 0;
        else if(pi >= p.length)
            return 0;
        if (pi + 1 < p.length) {
            char c = p[pi + 1];
            if (c == '*') {
                if (p[pi] == '.') {
                    int i = pi+2;
                    for (; i < p.length; i++) {
                        if (p[i] != '.')
                            break;
                    }
                    if (i >= p.length)
                        return 1;
                    else {
                        int ret = 0;
                        ret += match(s, si, p, pi+2);
                        for (int j = si; j < s.length; j++) {
                            if (s[j] == p[i]) {
                                ret += match(s, j, p, i);
                            }
                        }
                        return ret;
                    }
                }
                else {
                    if (s[si] != p[pi]) {
                        return match(s, si, p, pi + 2);
                    } else
                        return match(s, si + 1, p, pi) + match(s, si, p, pi+2);

                }

            }
            else {
                if (pi == '.') {
                    return match(s, si+1, p, pi+1);
                }
                else {
                    if (s[si] == p[pi]) {
                        return match(s, si+1, p, pi+1);
                    }
                    else
                        return 0;
                }
            }
        }
        else {
            if (s[si] == p[pi])
                return match(s, si+1, p, pi+1);
            else
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(isMatch("", ".*ad*c"));
    }
}
