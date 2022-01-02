package algorithm.limit;

/**
 * @author: xiongyayun
 * @date: 2022/1/2 16:13
 */
public class StringBrotherLimiter implements IRateLimiter{

    private final double qps;
    // 生成一个令牌需要的纳秒数
    private final double nanoSecondsPerToken;
    private double tokenBucket;
    // 开始创建令牌的纳秒时间戳
    private long timeBeginToCreateToken;

    /**
     * 构造方法
     * @param qps 每秒钟请求数量
     */
    public StringBrotherLimiter(double qps) {
        this.qps =  qps;
        this.tokenBucket = qps;
        // 生成一个令牌需要的微妙数
        this.nanoSecondsPerToken = 1 * 1000 * 1000 * 1000 / qps;
        this.timeBeginToCreateToken = System.nanoTime();
    }

    @Override
    public boolean tryAcquire() {
        synchronized (this) {
            long now = System.nanoTime();
            // 创建令牌
            double newToken = (now - timeBeginToCreateToken) / nanoSecondsPerToken;
            // 更新令牌桶中的令牌数
            tokenBucket = Math.min(qps, newToken + tokenBucket);
            // 更新开始创建令牌的时间
            timeBeginToCreateToken = now;

            if (tokenBucket > 0) {
                tokenBucket = tokenBucket - 1;
                return true;
            } else {
                return false;
            }
        }
    }
}
