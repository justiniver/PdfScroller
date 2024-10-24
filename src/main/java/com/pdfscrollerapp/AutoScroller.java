package com.pdfscrollerapp;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoScroller {
  private JScrollPane scrollPane;
  private Timer timer;

  public AutoScroller(JScrollPane scrollPane) {
    this.scrollPane = scrollPane;
  }

  public void startScrolling() {
    timer = new Timer(100, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
        int currentValue = verticalBar.getValue();
        int maxValue = verticalBar.getMaximum();

        if (currentValue + 1 < maxValue) {
          verticalBar.setValue(currentValue + 1);
        }
      }
    });
    timer.start();
  }

  public void stopScrolling() {
    if (timer != null) {
      timer.stop();
    }
  }
}
