package com.cisdi.yard.task;

import com.cisdi.yard.db.entity.SpringScheduledCron;
import com.cisdi.yard.db.repository.SpringScheduledCronRepository;
import com.cisdi.yard.enums.StatusEnum;
import com.cisdi.yard.utils.SpringUtils;

/**
 * @author meisen
 * @since 2021-05-10
 */
public interface ScheduledOfTask extends Runnable {
    /**
     * 定时任务方法
     */
    void execute();
    /**
     * 实现控制定时任务启用或禁用的功能
     */
    @Override
    default void run() {
        SpringScheduledCronRepository repository = SpringUtils.getBean(SpringScheduledCronRepository.class);
        SpringScheduledCron scheduledCron = repository.findByCronKey(this.getClass().getName());
        if (StatusEnum.DISABLED.getCode().equals(scheduledCron.getStatus())) {
            // 任务是禁用状态
            return;
        }
        execute();
    }
}