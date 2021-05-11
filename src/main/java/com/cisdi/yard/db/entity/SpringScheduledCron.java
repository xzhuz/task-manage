package com.cisdi.yard.db.entity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
 * @author meisen
 * @since 2021-05-10
 */
@Data
@Entity(name = "spring_scheduled_cron")
public class SpringScheduledCron {
    @Id
    @Column(name = "cron_id")
    private Integer cronId;
    @Column(name = "cron_key", unique = true)
    private String cronKey;
    @Column(name = "cron_expression")
    private String cronExpression;
    @Column(name = "task_explain")
    private String taskExplain;
    private Integer status;
}
