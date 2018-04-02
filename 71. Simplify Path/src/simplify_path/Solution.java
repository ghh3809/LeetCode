package simplify_path;

import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> paths = new LinkedList<String>();
        if (path.charAt(path.length() - 1) != '/') path += "/";
        int index = 0;
        while (true) {
            while ((index < path.length() - 1) && (path.charAt(index + 1) == '/')) {
                index ++;
            }
            if (index >= path.length() - 1) break;
            int startIndex = index;
            while (path.charAt(++ index) != '/');
            int pathLength = index - startIndex - 1;
            if (path.charAt(startIndex + 1) == '.') {
                if (pathLength == 1) continue;
                if ((path.charAt(startIndex + 2) == '.') && (pathLength == 2)) {
                    if (!paths.isEmpty()) {
                        paths.removeLast();
                    }
                    continue;
                }
            }
            paths.add(path.substring(startIndex + 1, index));
        }
        if (paths.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String p : paths) {
            sb.append('/');
            sb.append(p);
        }
        return sb.toString();
    }
}
