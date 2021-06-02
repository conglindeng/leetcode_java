package leetcode.middle;

import java.util.*;
import java.util.stream.Collectors;

public class WatchedVideosByFriends_1311 {
    static class info{
        int count;
        String video;

        public info(int count, String video) {
            this.count = count;
            this.video = video;
        }
    }

    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<Integer> curFriends=new ArrayList<>();
        Set<Integer> log=new TreeSet<>();
        curFriends.add(id);
        log.add(id);
        while(level!=0){
            List<Integer> nextLevel=new ArrayList<>();
            for (Integer curFriend : curFriends) {
                for (int i : friends[curFriend]) {  
                    if(!log.contains(i))
                        nextLevel.add(i);
                    log.add(i);
                }
            }
            curFriends=nextLevel;
            level--;
        }
        List<info> result=new ArrayList<>();
        Map<String,Integer> count=new HashMap<>();
        for (Integer curFriend : curFriends) {
            for (String video : watchedVideos.get(curFriend)) {
                count.put(video,count.getOrDefault(video,0)+1);
            }
        }
        count.entrySet().forEach(x->result.add(new info(x.getValue(),x.getKey())));
        return result.stream().sorted((x,y)->{
            if(x.count==y.count)
                return x.video.compareTo(y.video);
            return x.count-y.count;
        }).map(info->info.video).collect(Collectors.toList());
    }
}
