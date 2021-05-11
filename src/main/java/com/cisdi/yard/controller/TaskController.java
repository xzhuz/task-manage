package com.cisdi.yard.controller;

import com.cisdi.yard.consts.AppConsts;
import com.cisdi.yard.db.repository.SpringScheduledCronRepository;
import com.cisdi.yard.domain.Result;
import com.cisdi.yard.task.ScheduledOfTask;
import com.cisdi.yard.utils.CronUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author meisen
 * @since 2021-05-10
 */
@RestController
@RequestMapping("/scheduled/task")
public class TaskController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private SpringScheduledCronRepository cronRepository;
    /**
     * 查看任务列表
     */
    @RequestMapping("/taskList")
    public String taskList(Model model) {
        model.addAttribute("cronList", cronRepository.findAll());
        return "task-list";
    }
    /**
     * 编辑任务cron表达式
     */
    @ResponseBody
    @RequestMapping("/editTaskCron")
    public Result<Void> editTaskCron(String cronKey, String newCron) {
        if (!CronUtils.isValidExpression(newCron)) {
            throw new IllegalArgumentException("失败,非法表达式:" + newCron);
        }
        cronRepository.updateCronExpressionByCronKey(newCron, cronKey);
        return new Result<>(AppConsts.SUCCESS, "更新成功");
    }
    /**
     * 执行定时任务
     */
    @ResponseBody
    @RequestMapping("/runTaskCron")
    public Result<Void> runTaskCron(String cronKey) throws Exception {
        ((ScheduledOfTask) context.getBean(Class.forName(cronKey))).execute();
        return new Result<>(AppConsts.SUCCESS, "执行成功");
    }
    /**
     * 启用或禁用定时任务
     */
    @ResponseBody
    @RequestMapping("/changeStatusTaskCron")
    public Result<Void> changeStatusTaskCron(Integer status, String cronKey) {
        cronRepository.updateStatusByCronKey(status, cronKey);
        return new Result<>(AppConsts.SUCCESS, "操作成功");
    }
}