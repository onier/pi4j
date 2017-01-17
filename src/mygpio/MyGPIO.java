package mygpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class MyGPIO {

    public static void main(String[] args) throws InterruptedException {

        // 建立GPIO控制物件
        final GpioController gpio = GpioFactory.getInstance();
        Pin[] pins = RaspiPin.allPins();
        for (Pin pin : pins) {
            System.out.println(pin);

        } // 建立控制GPIO_01輸出的物件
        GpioPinDigitalOutput outputPin = gpio.provisionDigitalOutputPin(
                RaspiPin.GPIO_08);

//        System.out.println("LED ON...");
//
//        // 設定GPIO_01的狀態，設定為true表示這個針腳會輸出3.3V的電壓
//        outputPin.setState(PinState.HIGH);
//        delay(3000);
//
//        System.out.println("LED OFF...");
//
//        // 設定GPIO_01的狀態，設定為fasle表示這個針腳不會輸出電壓
//        outputPin.setState(PinState.LOW);
//
//        System.out.println("Bye...");
        outputPin.blink(50);   //闪烁，间歇性供电。
//        outputPin.pulse(1000);   //发出一个持续性的脉冲电流
        Thread.sleep(100000);

        // 最後記的要關閉GPIO
        gpio.shutdown();
    }

    private static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }

}
