package database.data;

import database.model.*;
import org.apache.ibatis.annotations.Param;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public interface MainMapper {

    /**
     * 获得所有可用套餐
     * @return 所有可用套餐
     */
    List<Plan> getAllPlans();

    /**
     * 获得某个人的套餐
     * @param userId 用户ID
     * @return 正在使用的套餐
     */
    List<Plan> getMyPlans(@Param("userId") int userId);

    /**
     * 订阅套餐
     * @param userId 用户ID
     * @param planId 套餐ID
     * @param activateImmediately 立即生效？若为false，则为下月生效
     * @return 交易ID
     */
    int orderPlan(@Param("userId") int userId,
                   @Param("planId") int planId,
                   @Param("activateImmediately") boolean activateImmediately
    );

    /**
     * 取消套餐
     * @param transactionId 订阅此套餐的交易ID
     * @param activateImmediately 立即生效？若为false，则为下月生效
     */

    void cancelPlan(@Param("transactionId") int transactionId,
                    @Param("activateImmediately") boolean activateImmediately
    );

    void addCallUsage(@Param("userId") int userId,
                      @Param("startTime") Instant startTime,
                      @Param("endTime") Instant endTime,
                      @Param("duration") double duration
    );

    void addDataUsage(@Param("userId") int userId,
                      @Param("startTime") Instant startTime,
                      @Param("endTime") Instant endTime,
                      @Param("amount") double amount,
                      @Param("dataType") DataType dataType
    );

    void addSmsUsage(@Param("userId") int userId,
                     @Param("time") Instant time
    );

    Usage getCallUsage(@Param("userId") int userId, @Param("datetime") LocalDateTime datetime);

    Usage getSmsUsage(@Param("userId") int userId, @Param("datetime") LocalDateTime datetime);

    Usage getLocalDataUsage(@Param("userId") int userId, @Param("datetime") LocalDateTime datetime);

    Usage getDomesticDataUsage(@Param("userId") int userId, @Param("datetime") LocalDateTime datetime);

    BasicCost getBasicCost(@Param("userId") int userId);

    User getUser(@Param("userId") int userId);
}