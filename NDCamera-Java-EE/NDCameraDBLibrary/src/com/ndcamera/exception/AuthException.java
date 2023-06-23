/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ndcamera.exception;

import javax.ejb.ApplicationException;

/**
 *
 * @author NUWAA
 */
@ApplicationException(rollback = true)
public class AuthException extends RuntimeException {

}
