package algorithm.limit;

/**
 * @author: xiongyayun
 * @date: 2022/1/2 15:44
 */
public interface IRateLimiter {

    public boolean tryAcquire();
}
