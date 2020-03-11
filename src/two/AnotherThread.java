/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package two;

/**
 *
 * @author grupa 1
 */
public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println("Pozdrav iz drugog Threada: " + Thread.currentThread().getName());
    }

    

}
