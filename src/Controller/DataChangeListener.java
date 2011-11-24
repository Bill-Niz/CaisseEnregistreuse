/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.EventListener;

/**
 *
 * @author kmeleon
 */
public interface DataChangeListener extends EventListener{
    public void dataChanged(DataChangeEvent evt);
     public void dataChanged(DataChangeEvent evt, Object data);
}
