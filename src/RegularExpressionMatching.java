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
        else if(si >= s.length) {
            if (pi + 1 < p.length && p[pi+1] == '*')
                return match(s,si,p,pi+2);
            else
                return 0;
        }
        else if(pi >= p.length)
            return 0;
        if (pi + 1 < p.length) {
            char c = p[pi + 1];
            if (c == '*') {
                if (p[pi] == '.') {
                    int i = pi+2;
                    if (i >= p.length)
                        return 1;
                    else {      //.*
                        int ret = 0;
                        ret += match(s, si, p, pi+2);
                        for (int j = si; j <= s.length; j++) {
                            if (ret > 0)
                                return ret;

                                ret += match(s, j, p, i);

                        }
                        return ret;
                    }
                }
                else {       //*
                    if (s[si] != p[pi]) {
                        return match(s, si, p, pi + 2); //skip to compare
                    } else {
                        if (match(s, si + 1, p, pi)  == 0) // continue matching
                                if (match(s, si, p, pi + 2) == 0)// skip to compare
                                        if (match(s, si + 1, p, pi + 2) == 0)
                                        {
                                            return  0;
                                        }
                        return 1;
                    }

                }
            }
            else {
                if (p[pi] == '.') {
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
            else if(p[pi] == '.')
                return match(s, si+1, p, pi+1);
            else
                return 0;
        }
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("a", "a*"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("aac", "a.*"));
//        System.out.println(isMatch("aa", "a.*c"));
//        System.out.println(isMatch("aabcsde", "a*ab*cs*d*e"));
//        System.out.println(isMatch("aab", "c*a*b"));
//        System.out.println(isMatch("aa", "ab*a*"));
//        System.out.println(isMatch("a", ".*.a"));
//        System.out.println(isMatch("aaaaaaaaaaaaab","a*a*a*a*a*a*a*a*a*a*a*a*b"));
          System.out.println(isMatch("a", ".*d*" ));
    }
}
