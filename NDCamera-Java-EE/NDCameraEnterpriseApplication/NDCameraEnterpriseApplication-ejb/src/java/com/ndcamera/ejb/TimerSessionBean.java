/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package com.ndcamera.ejb;

import com.ndcamera.entity.Product;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.ScheduleExpression;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 *
 * @author NUWAA
 */
@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

    @EJB
    private ProductSessionBeanRemote psbr;

    @Resource
    private SessionContext context;

    @Schedule(dayOfWeek = "*", month = "*", hour = "*", dayOfMonth = "*", year = "*", minute = "*", second = "*/59")
    @Override
    public void scheduler(Timer Timer) {
        System.out.println("Timer event: " + new Date());
        List<Product> products = new ArrayList<>();
        products = psbr.getAllProducts();
        for (Product product : products) {
            System.out.println(product.getId() + " : " + product.getProductName() + " : " + product.getBrand() + " : " + product.getType() + " : " + product.getSensorType());
        }
//        timer.cancel();
    }

    @Override
    public void createTimer(long duration) {
        ScheduleExpression se = new ScheduleExpression();
        se.hour("*");
        se.minute("*");
        se.second("*/" + duration);
        Timer timer = context.getTimerService().createCalendarTimer(se);
        //timer.cancel();
    }

    @Timeout
    public void timeoutHandler() {
        System.out.println("Timeout................");
    }
}
