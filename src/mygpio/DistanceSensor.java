/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinAnalogInput;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListener;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;

/**
 *
 * @author zhenhai
 */
public class DistanceSensor {

    public static void main(String[] args) throws InterruptedException {
        GpioController gpioController = GpioFactory.getInstance();
        GpioPinDigitalInput gpdo = gpioController.provisionDigitalInputPin(RaspiPin.GPIO_08);//08作为输出针脚
        gpdo.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent gpdsce) {
                System.out.println(" --> GPIO PIN STATE CHANGE: " + gpdsce.getPin() + " = " + gpdsce.getState());
            }
        });

        while (true) {
            Thread.sleep(500);
        }
    }
}
