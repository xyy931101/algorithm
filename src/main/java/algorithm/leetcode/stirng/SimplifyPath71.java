package algorithm.leetcode.stirng;

import java.util.LinkedList;

/**
 * 71. 简化路径
 * @author: xiongyayun
 * @date: 2022/1/6 19:42
 */
public class SimplifyPath71 {

    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        LinkedList<String> pathList = new LinkedList();
        for(String pa : pathArr){
            if(pa.length() == 0 || ".".equals(pa)) {
                continue;
            }else if("..".equals(pa)){
                if(!pathList.isEmpty()){
                    pathList.pollLast();
                }else{
                    continue;
                }

            }else {
                pathList.addLast(pa);
            }
        }
        if(pathList.isEmpty()){
            return "/";
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < pathList.size(); i++){
            sb.append("/");
            sb.append(pathList.get(i));
        }
        return sb.toString();
    }
}
