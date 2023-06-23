/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionRemote.java to edit this template
 */
package com.ndcamera.ejb;

import javax.ejb.Remote;
import javax.ejb.Timer;

/**
 *
 * @author NUWAA
 */
@Remote
public interface TimerSessionBeanRemote {

    void scheduler(Timer Timer);

    void createTimer(long duration);
}
