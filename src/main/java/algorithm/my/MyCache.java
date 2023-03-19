package algorithm.my;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyCache {

    private static  final String LIVE_TIME = "liveTime";
    Lock readLock;
    Lock writeLock;
    long liveTime;


    ConcurrentHashMap<Integer, JSONObject> cache;


    public MyCache(long liveTime){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        this.readLock = lock.readLock();
        this.liveTime = liveTime;
        this.writeLock = lock.writeLock();
        cache = new ConcurrentHashMap<>();
    }


    public JSONObject get(Integer key){
        readLock.lock();
        JSONObject result = cache.get(key);
        long currentTme = System.currentTimeMillis();

        if(result != null && currentTme - result.getLong(LIVE_TIME) < liveTime){
            result.put(LIVE_TIME, currentTme);
        }else{
            result = getDb(key);
            result.put(LIVE_TIME, currentTme);
        }
        cache.put(key, result);
        readLock.unlock();
        return result;
    }






    public JSONObject getDb(Integer key){
        return new JSONObject();
    }
}
