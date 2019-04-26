package com.example.redisasyncmassage.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nowcoder on 2016/7/13.
 */
public class RedisKeyUtil {
    private static String SPLIT = ":";
    private static String BIZ_MAIL = "MAIL";
    private static String BIZ_EVENT = "EVENT";

    public static String getEventQueueKey() {
        return BIZ_EVENT;
    }

    public static String getSendMailKey(int userId) {
        return BIZ_MAIL + SPLIT + String.valueOf(userId);
    }
}
